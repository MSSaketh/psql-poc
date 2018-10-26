package com.capgemini.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	public CompanyController(CompanyService companyService) {
		super();
		this.companyService = companyService;
	}
	
	@PostMapping("/save")
	public Company registerUser(@RequestBody Company user) {
		return companyService.saveCompany(user);
	}

}
