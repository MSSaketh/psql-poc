package com.capgemini.company.service;

import java.util.List;

import com.capgemini.company.domain.Company;

public interface CompanyService {

	public Company saveCompany(Company company);
	
	public String delCompany(int id);
	
	public Company getCompany(String companyName);
	
	public List<Company> getAllCompanies();

}
