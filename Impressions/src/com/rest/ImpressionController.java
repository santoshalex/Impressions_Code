package com.rest;

import java.util.List;
import com.domain.ImpressionCount;
import com.domain.ImpressionList;
import com.domain.ImpressionsCountList;

//import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/*import com.service.EmployeeService;*/
import com.service.ImpressionService;
//import com.domain.Employee;
import com.domain.Impression;
@Controller
@RequestMapping("/impressions")
public class ImpressionController {
	@Autowired
	private ImpressionService impressionService;
	
	@RequestMapping(method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	@ResponseBody
	public ImpressionsCountList getAllImpressions() {
		List<ImpressionCount> Impressions = impressionService.getImpressionsCount();
		ImpressionsCountList I = new ImpressionsCountList();
		I.setImpressions(Impressions);
		return I;
	}
	
	@RequestMapping(value = "{id}", 
			method = RequestMethod.GET, 
			produces = { "application/json", "application/xml" })
	@ResponseBody
	public ImpressionList getImpressionByEmpId(@PathVariable("id") int eid) {
		ImpressionList imp = new ImpressionList();
		imp.setImpressions(impressionService.getImpressionByEmpid(eid));
		return imp;
	}
	
	/*@Autowired
	private EmployeeService employeeService;*/
	
	@RequestMapping(method = RequestMethod.POST,
			consumes = { "application/json", "application/xml" })
	@ResponseStatus(value = HttpStatus.CREATED)
	public void createImpression(@RequestBody Impression impression) {
		impressionService.insert(impression);
		//employeeService.insertOrUpdate(impression.getEmployee());
	}
}
