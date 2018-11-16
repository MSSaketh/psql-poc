package com.capgemini.company.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.company.domain.Company;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Integer> {
	
	public Company getByCompanyName(String companyName);

}
