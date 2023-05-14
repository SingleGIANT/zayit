package com.java.business.HeadOffice.service;


import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.business.HeadOffice.entity.Product;
import com.java.business.HeadOffice.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;

	public Iterable<Product> listAll(){
		return this.repo.findAll();	}
	
	public void Save(Product product) {

		repo.save(product);
	}

	public Product getUserById(long id) {
		return repo.findById(id).get();
	}

	public void update(Product product, long productid) {
		repo.save(product);
	}


////////delete
	public void deleteMemberById(Long id) {
		repo.deleteById(id);
		
	}

	
	///////edit
	public void save(Product existingProduct) {
		repo.save(existingProduct);
	}

	public Optional<Product> findById(Long id) {
		return Optional.empty();
	}

	public List<Product> getUserByCategoryId(long categoryid) {
		return repo.findByCategoryid(categoryid);
	}

	public List<Map<String, Object>> findStock() {
		return repo.findStock();
	}
	
//	public Iterable<Product> findByCategory(){
//		return this.repo.findAll();
//	}

	public List<Map<String, Object>> getProductView(){
		return repo.getProductView();
	}
	
	public long getProductCount() {
	    return repo.count();
	}

	public List<Map<String, Object>> getTotalStock() {
		
		return repo.getTotalStock();
	}

	
}
