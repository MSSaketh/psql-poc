package com.capgemini.company.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.capgemini.company.domain.Company;

public interface CompanyService {

	public Company saveCompany(Company company, MultipartFile file)throws Exception;
	
	public String delCompany(int id);
	
	public Company getCompany(String companyName);
	
	public List<Company> getAllCompanies();
	
	public File getFile(int id)throws IOException;

}
