package com.capgemini.company.controller;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	public Company registerUser(@RequestBody Company user, @RequestParam MultipartFile file) throws Exception {
		Company company = companyService.saveCompany(user, file);
		log.info(user.getCompanyName() + " saved");
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

	@PostMapping(value = "/downloadFile", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public void downloadFileFromUI(@RequestParam int id, HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
//		model.put("fileName", fileName);
		File response = companyService.getFile(id);
		System.out.println(response.getAbsolutePath());
		byte[] fileByte = Files.readAllBytes(response.toPath());
		resp.setHeader("Content-length", Integer.toString(fileByte.length));
		resp.setHeader("Content-Disposition", "attachment;" + " filename=" + response.getAbsolutePath());
		resp.getOutputStream().write(fileByte, 0, fileByte.length);
	}

}
