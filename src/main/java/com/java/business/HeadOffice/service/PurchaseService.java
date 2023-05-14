package com.java.business.HeadOffice.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.business.HeadOffice.entity.Purchase;
import com.java.business.HeadOffice.repository.PurchaseRepository;





@Service
public class PurchaseService {

	@Autowired
	private PurchaseRepository repo;

	public Iterable<Purchase> listAll() {

		return this.repo.findAll();

	}

	public void Saveorupdate(Purchase purchase) {

		repo.save(purchase);

	}

	public Purchase getDetailByPurchaseId(long id) {

		return repo.findById(id).get();

	}

	public void save(Purchase existingPurchase) {

		repo.save(existingPurchase);

	}

	public Purchase findById(Long id) {

		return repo.findById(id).get();

	}

	public void deletePurchaseById(Long id) {

		repo.deleteById(id);

	}
	
	public List<Map<String, Object>> findAllPurchase(){
		return repo.getAllPurchase();
	}
	
	public long getPurchaseCount() {
	    return repo.count();
	}

	public List<Map<String, Object>> getAllOutsource(long purchase_id){

		return repo.getAllOutsource(purchase_id);

	}

	public List<Map<String, Object>> getAllSalesInvoices() {
	return repo.getAllOutsource();
	}

}
