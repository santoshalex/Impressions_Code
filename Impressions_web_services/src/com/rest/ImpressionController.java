package com.rest;

//import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.service.EmployeeService;
import com.service.ImpressionService;
import com.domain.Impression;
@Controller
@RequestMapping("/impressions")
public class ImpressionController {
	@Autowired
	private ImpressionService impressionService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(method = RequestMethod.POST,
			consumes = { "application/json", "application/xml" })
	@ResponseStatus(value = HttpStatus.CREATED)
	public void createImpression(@RequestBody Impression impression) {
		impressionService.insert(impression);
		//employeeService.insertOrUpdate(impression.getEmployee());
	}
}