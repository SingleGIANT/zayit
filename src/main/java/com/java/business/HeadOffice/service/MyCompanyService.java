package com.java.business.HeadOffice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.java.business.HeadOffice.entity.MyCompany;

import com.java.business.HeadOffice.repository.MyCompanyRepository;

@Service
public class MyCompanyService {

	@Autowired
	private MyCompanyRepository repo;
	
	public Iterable<MyCompany> listAll() {

		return this.repo.findAll();

		}

		public void Saveorupdate(MyCompany mycompany) {

		repo.save(mycompany);

		}

		public MyCompany getDetailById(long id) {

		return repo.findById(id).get();

		}

		public void save(MyCompany existingmycompany) {

		repo.save(existingmycompany);

		}

		public MyCompany findById(Long id) {

		return repo.findById(id).get();

		}

		public void deleteMyCompanyById(Long id) {

		repo.deleteById(id);

		}
}
