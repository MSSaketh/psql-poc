package com.capgemini.company.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.company.domain.Company;
import com.capgemini.company.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService {

	Logger log = LoggerFactory.getLogger(CompanyServiceImpl.class);

	private CompanyRepository companyRepo;

	@Autowired
	public CompanyServiceImpl(CompanyRepository companyRepo) {
		super();
		this.companyRepo = companyRepo;
	}

	@Override
	public Company saveCompany(Company company) {
		log.info("Entered into saveCompany method");
		return companyRepo.save(company);
	}

	@Override
	public String delCompany(int id) {
		String info;
		log.info("Entered into delCompany method");
		if (companyRepo.existsById(id)) {
			log.info("company with id " + id + " exists");
			companyRepo.deleteById(id);
			info = "company with id " + id + " deleted";
			log.info(info);
		} else {
			info = "company with id " + id + " does not exists";
			log.error(info);
		}
		return info;
	}

	@Override
	public Company getCompany(String companyName) {
		log.info("Entered into getCompany method");
		return companyRepo.getByCompanyName(companyName);
	}

	@Override
	public List<Company> getAllCompanies() {
		log.info("Entered into getAllCompanies method");
		return (List<Company>) companyRepo.findAll();
	}

}
