package com.java.business.HeadOffice.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.business.HeadOffice.entity.Category;
import com.java.business.HeadOffice.service.CategoryService;

@RestController
@CrossOrigin
public class CategoryController {

	@Autowired
	private CategoryService service;

	// @GetMapping("/category")
	// public Iterable<Category> getUser() {
	// return service.listAll();

	// }

	@GetMapping("/category/product/unit")
	private List<Map<String, Object>> findAllBYCategoryAndProduct() {
		List<Map<String, Object>> orderList = new ArrayList<>();
		Iterable<Map<String, Object>> iterable = service.findAllProductsByCategory();
		Map<String, List<Map<String, Object>>> categoryGroupMap = StreamSupport.stream(iterable.spliterator(), false)
				.collect(Collectors.groupingBy(action -> action.get("category_id").toString()));
		for (Entry<String, List<Map<String, Object>>> list : categoryGroupMap.entrySet()) {
			Map<String, Object> categoryMap = new HashMap<>();
			categoryMap.put("category_id", list.getKey());
			categoryMap.put("category_name", list.getValue().get(0).get("category"));
			categoryMap.put("products", categoryGroupMap.get(list.getKey()));
			orderList.add(categoryMap);
		}
		return orderList;
	}

	// @PostMapping(value = "/category/save")
	// private long saveBook(@RequestBody Category category) {
	// service.Save(category);
	// return category.getCategory_id();
	// }

	@GetMapping("/category")
	public ResponseEntity<?> getCategories() {
		try {
			Iterable<Category> categories = service.listAll();
			return ResponseEntity.ok(categories);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error retrieving categories: " + e.getMessage());
		}
	}

	@PostMapping(value = "/category/save")
	private ResponseEntity<String> saveCategory(@RequestBody Category category) {
		try {
			service.save(category);
			return ResponseEntity.ok("Category saved with id: " + category.getCategory_id());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error saving category: " + e.getMessage());
		}

	}

	@RequestMapping("/category/{id}")
	private Category getBooks(@PathVariable(name = "id") long category_id) {
		return service.getUserById(category_id);
	}

	@PutMapping("/category/edit/{id}")
	public ResponseEntity<Category> updateOrder(@PathVariable("id") Long category_id, @RequestBody Category category) {
		try {
			Category existingCategory = service.findById(category_id);
			if (existingCategory == null) {
				return ResponseEntity.notFound().build();
			}
			// Update the existing order with the new data
//			existingCategory.setCategoryid(category.getCategoryid());
			existingCategory.setCategory(category.getCategory());

			// Save the updated order to the database
			service.save(existingCategory);

			return ResponseEntity.ok(existingCategory);

		} catch (Exception e) {
			// Log the error and return a 500 internal server error
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DeleteMapping("/category/delete/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long id) {
		service.deleteMemberById(id);
		return ResponseEntity.ok("Customer deleted successfully");
	}

}
