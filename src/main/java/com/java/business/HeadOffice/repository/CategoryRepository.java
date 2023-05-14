package com.java.business.HeadOffice.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.java.business.HeadOffice.entity.Category;

public interface CategoryRepository  extends JpaRepository<Category, Long> {

	@Query(value="select c.category_id, c.category, p.productid, p.productname, p.hsn_code, p.unit_id, u.unitname from category as c"
			+ " left join product as p on c.category_id = p.categoryid"
			+ " left join unit as u on p.unit_id = u.unit_id", nativeQuery = true)
	List<Map<String, Object>> getAllProductsByCategory();
	
}
