package com.java.business.HeadOffice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.business.HeadOffice.entity.SalesList;
import com.java.business.HeadOffice.repository.SalesListRepository;



@Service
public class SalesListService {

	@Autowired
	private SalesListRepository repo;

	public Iterable<SalesList> listAll() {

		return this.repo.findAll();

	}

	public void Saveorupdate(SalesList salesList) {

		repo.save(salesList);

	}

	public SalesList getDetailBySalesListId(long id) {

		return repo.findById(id).get();

	}

	public void save(SalesList existingSalesList) {

		repo.save(existingSalesList);

	}

	public SalesList findById(Long id) {

		return repo.findById(id).get();

	}
//
//	public void deleteMyCompanyById(Long id) {
//
//		repo.deleteById(id);

//	}

	public void deletePurchaseById(Long id) {
		repo.deleteById(id);
	}
}
