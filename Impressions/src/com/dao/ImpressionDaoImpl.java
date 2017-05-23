package com.dao;

import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.List;

//import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
//import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//import com.domain.Employee;
/*import com.domain.Employee;*/
import com.domain.Impression;
import com.domain.ImpressionCount;

@Repository("impressionDao")
@Transactional(propagation = Propagation.REQUIRED)
public class ImpressionDaoImpl implements ImpressionDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void save(Impression impression) {
		hibernateTemplate.save(impression);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ImpressionCount> getImpressionCount() {
		
		@SuppressWarnings("rawtypes")
		List<ImpressionCount> resultList = (List<ImpressionCount>) hibernateTemplate.execute(new HibernateCallback(){
			
			@Override
			public Object doInHibernate(org.hibernate.Session session) throws HibernateException, SQLException {
				Query query = session.createSQLQuery("select 1 Eid,lower(employee_name) Ename,count(impression_id) iCount from impressions group by lower(employee_name) order by iCount desc").addScalar("Eid",new IntegerType()).addScalar("Ename",new StringType())
						.addScalar("iCount", new IntegerType());
				return (List<ImpressionCount>) query.setResultTransformer(Transformers.aliasToBean(com.domain.ImpressionCount.class)).list();
			}
		});
		
		return resultList;
		/*ImpressionCount x = new ImpressionCount();
		x.setEid(1);
		x.setEname("Santosh");
		x.setCount(15);
		List<ImpressionCount> l = new ArrayList<ImpressionCount>();
		l.add(x);
		return l;*/
	}
	
	@Override
	public List<Impression> getImpressionByEmpId(int eid) {
		@SuppressWarnings("unchecked")
		List<Impression> imp=  hibernateTemplate.find("from Impression i where i.eid = '"+eid+"'");
		return imp;
	}

//	@Override
//	public void saveEmployee(Employee employee) {
//		hibernateTemplate.saveOrUpdate(employee);
//		
//	}

}
