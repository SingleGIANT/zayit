package com.java.business.HeadOffice.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.java.business.HeadOffice.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByCategoryid(long categoryid);
	



	@Query(value="select p.productid, p.productname, c.category_id, c.category, u.unitname,p.hsn_code,p.stock from product p"

			+ " join category c on p.categoryid = c.category_id"

			+ " join unit u on p.unit_id = u.unit_id", nativeQuery = true)
	List<Map<String, Object>> getProductView();

	@Query(value="select p.categoryid, c.category, p.productid, p.productname, p.stock from product as p"
			+ " join category as c on p.categoryid = c.category_id",nativeQuery = true)
	List<Map<String, Object>> findStock();




	
	@Query(value="select sum(stock) stock from product",nativeQuery = true)
	List<Map<String, Object>> getTotalStock();
	
}

