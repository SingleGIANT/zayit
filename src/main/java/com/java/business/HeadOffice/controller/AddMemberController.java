package com.java.business.HeadOffice.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.java.business.HeadOffice.entity.AddMember;
import com.java.business.HeadOffice.repository.AddMemberRepository;
import com.java.business.HeadOffice.service.AddMemberService;



@RestController
@CrossOrigin
public class AddMemberController {

	@Autowired
	private AddMemberService service;
	
	@Autowired
	private AddMemberRepository repo;
	

	  
	  
	  
	

	@GetMapping("/member")
	public Iterable<AddMember> getUser() {
		return service.listAll();
		
	}

	@PostMapping(value = "/member/save")
	private long saveBook(@RequestBody AddMember member) {
		 member.setDate(new Date());
		service.Save(member);
		return member.getMemberid();
	}

	@RequestMapping("/member/{id}")
	private AddMember getBooks(@PathVariable(name = "id") long memberid) {
		return service.getUserById(memberid);
	}

	@PutMapping("/member/edit/{id}")
	public ResponseEntity<AddMember> updateOrder(@PathVariable("id") Long memberid, @RequestBody AddMember customer) {
		try {
			// Find the order by ID
			AddMember existingCustomer = service.findById(memberid);

			if (existingCustomer == null) {
				return ResponseEntity.notFound().build();
			}

			// Update the existing order with the new data
			existingCustomer.setAadharno(customer.getAadharno());
//			existingCustomer.setMemberid(customer.getMemberid());
			existingCustomer.setName(customer.getName());
			existingCustomer.setPhone(customer.getPhone());
			existingCustomer.setEmail(customer.getEmail());
			existingCustomer.setDob(customer.getDob());
			existingCustomer.setPassword(customer.getPassword());
		
			existingCustomer.setGender(customer.getGender());
			existingCustomer.setPanno(customer.getPanno());
			existingCustomer.setAddress(customer.getAddress());
			existingCustomer.setDate(customer.getDate());

			existingCustomer.setDescription(customer.getDescription());
;
			
			
			


			// Save the updated order to the database
			service.save(existingCustomer);

			return ResponseEntity.ok(existingCustomer);

		} catch (Exception e) {
			// Log the error and return a 500 internal server error
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}



	@DeleteMapping("/member/delete/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long id) {
		service.deleteMemberById(id);
		return ResponseEntity.ok("Customer deleted successfully");
	}
	
}

	

	
	

	
	
	
