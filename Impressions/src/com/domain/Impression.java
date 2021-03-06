package com.domain;

/*import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;*/
import java.sql.Timestamp;
//import java.util.Iterator;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*import org.hibernate.annotations.Entity;*/

import com.fasterxml.jackson.annotation.JsonFormat;


@XmlRootElement(name = "impression")
@XmlAccessorType(XmlAccessType.NONE)
public class Impression  {
	
	@XmlAttribute(name = "id")
	private int id;
	
	@XmlElement(name = "employee_id")
	private int eid;
	@XmlElement(name = "employee_name")
	private String employee_name;
	@XmlElement(name = "comment")
	private String comment;
	

	@XmlElement(name = "created_by")
	private String created_by;
	@XmlElement(name = "created_by_employee_id")
	@Column(nullable=true)
	private int created_by_empid;
	
	@XmlElement(name = "impression_time")
	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss a")
	@Column(name = "impression_time", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp impression_time;
	
	//public SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a Z");
	
	
	
	public Impression(){}
	
	public Impression(int id,String Employee_Name,int eid, String Comment,Timestamp Impression_time,String Created_by,int Created_by_empid)
	{
		
		this.id=id;
		this.employee_name=Employee_Name;
		this.comment=Comment;
		this.eid = eid;
		//this.impression_time=Impression_time;
		//sdf.setTimeZone(TimeZone.getTimeZone("IST")); 
		this.impression_time=Impression_time;
		this.created_by=Created_by;
		this.created_by_empid=Created_by_empid;
		
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public int getCreated_by_empid() {
		return created_by_empid;
	}

	public void setCreated_by_empid(int created_by_empid) {
		this.created_by_empid = created_by_empid;
	}

	public Timestamp getImpression_time() {
		return impression_time;
	}

	public void setImpression_time(Timestamp impression_time) {
		this.impression_time = impression_time;
	}

	@Override
	public String toString() {
		return "Impression [id=" + id + " , employee_id = "+ eid +", employee_name=" + employee_name + ", comment=" + comment + ", created_by="
				+ created_by + ", created_by_empid=" + created_by_empid + ", impression_time=" + impression_time + "]";
	}

	/*@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}*/
	
}
