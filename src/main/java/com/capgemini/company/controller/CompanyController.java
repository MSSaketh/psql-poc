package com.capgemini.company.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.company.domain.Company;
import com.capgemini.company.service.CompanyService;

@RestController
@RequestMapping("/api/v1")
public class CompanyController {

	private CompanyService companyService;
	
	Logger log = LoggerFactory.getLogger(CompanyController.class);

	@Autowired
	public CompanyController(CompanyService companyService) {
		super();
		this.companyService = companyService;
	}

	@PostMapping("/save")
	public Company registerUser(@RequestBody Company user) {
		Company company = companyService.saveCompany(user);
		log.info(user.getCompanyName()+" saved");
		return company;
		
	}

	@GetMapping("/get")
	public ResponseEntity<?> getCompanies() {
		List<Company> companies = companyService.getAllCompanies();
		return new ResponseEntity<>(companies, HttpStatus.OK);

	}

	@DeleteMapping("/remove/{companyId}")
	public ResponseEntity<?> deleteCompany(@PathVariable int comapnyId) {
		return new ResponseEntity<String>(companyService.delCompany(comapnyId), HttpStatus.OK);
	}
	
	
}
