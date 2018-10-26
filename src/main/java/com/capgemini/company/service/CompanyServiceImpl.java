package com.capgemini.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.company.domain.Company;
import com.capgemini.company.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService {

	private CompanyRepository companyRepo;

	@Autowired
	public CompanyServiceImpl(CompanyRepository companyRepo) {
		super();
		this.companyRepo = companyRepo;
	}

	@Override
	public Company saveCompany(Company company) {
		return companyRepo.save(company);
	}

}
