package com.java.business.HeadOffice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import com.java.business.HeadOffice.entity.Distributor;
import com.java.business.HeadOffice.service.DistributorService;

@RestController
@CrossOrigin
public class DistributorController {

	@Autowired
	private DistributorService services;

	// @GetMapping("/Distribution")

	// public Iterable<Distributor> getCompany() {

	// 	return services.listAll();

	// }

	// @PostMapping(value = "/save_Distribution")

	// private long saveBook(@RequestBody Distributor distribution) {

	// 	services.Saveorupdate(distribution);

	// 	return distribution.getDistributorid();

	// }

	@GetMapping("/Distribution")

	public ResponseEntity<?> getDistributors() {

	try {

	Iterable<Distributor> distributors = services.listAll();

	return ResponseEntity.ok(distributors);

	} catch (Exception e) {

	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving distributors: " + e.getMessage());

	}

	}

	@PostMapping(value = "/save_Distribution")

	public ResponseEntity<String> saveDistribution(@RequestBody Distributor distribution) {

	try {

	Distributor existingDistributor = services.findByPhoneno(distribution.getPhoneno());

	if (existingDistributor != null) {

	return ResponseEntity.status(HttpStatus.CONFLICT).body("A distributor with the same phone number or email already exists");

	}

	services.Saveorupdate(distribution);

	return ResponseEntity.ok("Distribution saved with id: " + distribution.getDistributorid());

	} catch (Exception e) {

	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving distribution: " + e.getMessage());

	}

	}
	
	@GetMapping(value = "/distribution/count")
	public ResponseEntity<Long> getDistributionCount() {
	    long count = services.getDistributionCount();
	    return ResponseEntity.ok(count);
	}


	@RequestMapping("/Shop_Distribution/{id}")

	private Distributor getBooks(@PathVariable(name = "id") long distributorid) {

		return services.getDetailById(distributorid);

	}

	@PutMapping("/edit/Distribution/{id}")

	public ResponseEntity<Distributor> updateOrder(@PathVariable("id") Long distributorid,
			@RequestBody Distributor existingDistributor) {

		try {

			// Find the order by ID

			Distributor distribution = services.findById(distributorid);

			if (distribution == null) {

				return ResponseEntity.notFound().build();

			}

			// Update the existing order with the new data

			distribution.setName(existingDistributor.getName());

			distribution.setPhoneno(existingDistributor.getPhoneno());

			distribution.setEmail(existingDistributor.getEmail());

			distribution.setDistrict(existingDistributor.getDistrict());

			distribution.setState(existingDistributor.getState());

			distribution.setCode(existingDistributor.getCode());

			distribution.setPincode(existingDistributor.getPincode());

			distribution.setGst_no(existingDistributor.getGst_no());

			distribution.setDistributorid(existingDistributor.getDistributorid());

			distribution.setAddress(existingDistributor.getAddress());

			// Save the updated order to the database

			services.save(distribution);

			return ResponseEntity.ok(distribution);

		} catch (Exception e) {

			// Log the error and return a 500 internal server error

			e.printStackTrace();

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

		}

	}

	@DeleteMapping("/delete/Distribution/{id}")

	public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long id) {

		services.deleteDistributionById(id);

		return ResponseEntity.ok("Customer deleted successfully");

	}
}
