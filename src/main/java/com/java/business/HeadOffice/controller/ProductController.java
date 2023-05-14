package com.java.business.HeadOffice.controller;

import java.io.File;
import java.nio.file.Files;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.criteria.Path;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.java.business.HeadOffice.entity.Product;

import com.java.business.HeadOffice.service.ProductService;

@RestController
@CrossOrigin
public class ProductController {

	@Autowired
	private ProductService service;

// 	@GetMapping("/product")
// 	public Iterable<Product> getUser() {
// 		return service.listAll();

// }

// 	@PostMapping(value = "/product/save")
// 	private long saveBook(@RequestBody Product product) {
// 		service.Save(product);
// 		return product.getProductid();
// 	}

	@GetMapping("/product")

	public ResponseEntity<?> getProducts() {

		try {

			Iterable<Product> products = service.listAll();

			return ResponseEntity.ok(products);

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error retrieving Products: " + e.getMessage());

		}

	}

	@PostMapping(value = "/product/save")

	public ResponseEntity<String> saveProduct(@RequestBody Product product) {

		try {

			service.save(product);

			return ResponseEntity.ok("Product saved with id: " + product.getProductid());

		} catch (DataIntegrityViolationException e) {

			if (e.getCause() instanceof ConstraintViolationException) {

				ConstraintViolationException cause = (ConstraintViolationException) e.getCause();

				if (cause.getConstraintViolations().equals("uk_product_hsn_code")) {

					return ResponseEntity.status(HttpStatus.BAD_REQUEST)
							.body("Error saving Product: Product with this HSN code already exists.");

				}

			}

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error saving Product: " + e.getMessage());

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error saving Product: " + e.getMessage());

		}

	}
	
	
//	@PostMapping(value = "/product/save")
//	public ResponseEntity<String> saveProduct(@RequestBody Product product, @RequestParam("file") MultipartFile file) {
//
//	    try {
//	        // Save the image file to disk
//	        byte[] imageData = file.getBytes();
//	        Path imagePath = (Path) Files.createTempFile("product-", ".jpg");
//	        Files.write(imagePath, imageData);
//
//	        // Update the product entity
//	        product.setImageData(imageData);
//	        product.setImagePath(imagePath.toString());
//
//	        // Save the product to the database
//	        service.save(product);
//
//	        return ResponseEntity.ok("Product saved with id: " + product.getProductid());
//	    } catch (DataIntegrityViolationException e) {
//	        // Handle exception as before
//	    } catch (Exception e) {
//	        // Handle exception as before
//	    }
//	}


	@GetMapping(value = "/product/count")
	public ResponseEntity<Long> getProductCount() {
		long count = service.getProductCount();
		return ResponseEntity.ok(count);
	}

////////stock//////

	@GetMapping("/stockview")
	private List<Map<String, Object>> findStock() {
		return service.findStock();
	}

	/////// stock/////

	////// productview

	@GetMapping("/productview")
	private List<Map<String, Object>> getProductView() {
		return service.getProductView();
	}

	////// productview

	@RequestMapping("/product/{id}")
	private Product getBooks(@PathVariable(name = "id") long productid) {
		return service.getUserById(productid);
	}

	@RequestMapping("/product/category/{id}")
	private List<Product> getCategory(@PathVariable(name = "id") long categoryid) {
		return service.getUserByCategoryId(categoryid);
	}

	@PutMapping("/product/edit/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") Long productId, @RequestBody Product newProduct) {
	    try {
	        // Find the product by ID
	        Optional<Product> optionalProduct = service.findById(productId);

	        if (optionalProduct.isEmpty()) {
	            return ResponseEntity.notFound().build();
	        }

	        Product existingProduct = optionalProduct.get();

	        // Update the existing product with the new data
	        existingProduct.setCategoryid(newProduct.getCategoryid());
	        existingProduct.setImageData(newProduct.getImageData());
	        existingProduct.setProductdescription(newProduct.getProductdescription());
	        existingProduct.setProductname(newProduct.getProductname());
	        existingProduct.setHsn_code(newProduct.getHsn_code());

	        // Save the updated product to the database
	        service.save(existingProduct);

	        return ResponseEntity.ok(existingProduct);

	    } catch (Exception e) {
	        // Log the error and return a 500 internal server error
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}


	@DeleteMapping("/product/delete/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long id) {
		service.deleteMemberById(id);
		return ResponseEntity.ok("Customer deleted successfully");
	}
}
