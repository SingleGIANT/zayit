package com.java.business.HeadOffice.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.business.HeadOffice.entity.Sales;
import com.java.business.HeadOffice.repository.SalesRepository;


@Service
public class SalesService {

	@Autowired
	private SalesRepository repo;

	public Iterable<Sales> listAll() {

		return this.repo.findAll();

	}

	public void Saveorupdate(Sales sales) {

		repo.save(sales);

	}

	public Sales getDetailBySalesId(long id) {

		return repo.findById(id).get();

	}

	public void save(Sales existingSales) {

		repo.save(existingSales);

	}

	public Sales findById(Long id) {

		return repo.findById(id).get();

	}

	public void deletePurchaseById(Long id) {

		repo.deleteById(id);

	}

	public List<Map<String, Object>> findAllSales() {
		return repo.getAllSales();
	}

	public List<Map<String, Object>> getAllGst(Long distributorid){
		return repo.getAllGst(distributorid);

}
	
	
	public long getSalesCount() {
	    return repo.count();
	}

	public List<Map<String, Object>> getAllDistributorDetail(long sales_id){

		return repo.getAllDistributorDetails(sales_id);

	}

	public List<Map<String, Object>> getAllSalesInvoices() {
		return repo.getAllDistributorDetails();
	}

	public List<Map<String, Object>> getAllSalesInvoices(long sales_id) {
		return repo.getAllDistributorDetails(sales_id);
	}


}
