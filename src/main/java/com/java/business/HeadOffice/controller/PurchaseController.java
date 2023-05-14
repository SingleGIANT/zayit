package com.java.business.HeadOffice.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;
import java.util.stream.Collectors;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.business.HeadOffice.entity.MyCompany;
import com.java.business.HeadOffice.entity.OutSource;
import com.java.business.HeadOffice.entity.Product;
import com.java.business.HeadOffice.entity.Purchase;
import com.java.business.HeadOffice.entity.PurchaseList;
import com.java.business.HeadOffice.repository.MyCompanyRepository;
import com.java.business.HeadOffice.repository.OutSourceRepository;
import com.java.business.HeadOffice.repository.ProductRepository;
import com.java.business.HeadOffice.service.PurchaseService;

@RestController
@CrossOrigin
public class PurchaseController {

	@Autowired
	private PurchaseService service;
	@Autowired
	private ProductRepository repo;
	@Autowired
	private OutSourceRepository companyRepo;

	// @GetMapping("/purchase")
	// public Iterable<Purchase> getUser() {
	// return service.listAll();

	// }
	@GetMapping("/purchase")

	public ResponseEntity<?> getPurchases() {

		try {

			Iterable<Purchase> purchases = service.listAll();

			return ResponseEntity.ok(purchases);

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error retrieving Purchases: " + e.getMessage());

		}

	}

	@PostMapping(value = "/purchase/save")
	private long saveBook(@RequestBody Purchase purchase) {
		List<Long> productIdList = purchase.getPurchaselist().stream().map(action -> action.getProductid())
				.collect(Collectors.toList());
		List<Product> productList = repo.findAllById(productIdList);
		for (Product product : productList) {
			for (PurchaseList purchaseList : purchase.getPurchaselist()) {
				if (product.getProductid() == purchaseList.getProductid()) {
					product.setStock(
							Objects.nonNull(product.getStock()) ? product.getStock() + purchaseList.getShipped_qty()
									: purchaseList.getShipped_qty());
				}
			}
		}
		repo.saveAll(productList);
		service.save(purchase);
		return purchase.getPurchase_id();
	}

	@GetMapping("/purchase/invoice")
	public List<Map<String, Object>> getSalesInvoiceList() {
		ObjectMapper object = new ObjectMapper();
		List<Map<String, Object>> report = service.getAllSalesInvoices();
		List<OutSource> companyList = companyRepo.findAll();
		List<Map<String, Object>> purchaseDataList = object.convertValue(report, List.class);
		Map<String, List<Map<String, Object>>> purchaseGroupMap = purchaseDataList.stream()
				.collect(Collectors.groupingBy(action -> action.get("purchase_id").toString()));
		List<Map<String, Object>> purchaseList = new ArrayList<>();
		for (Entry<String, List<Map<String, Object>>> salesDataMap : purchaseGroupMap.entrySet()) {
			Map<String, Object> purchaseMap = new HashMap<>();
			purchaseMap.putAll(salesDataMap.getValue().get(0));
			purchaseMap.put("purchaselist", salesDataMap.getValue());
//			if (companyList.get(0).getCode() == 33 && purchaseMap.get("code").toString().equals("33")) {
//				double gst = Double.parseDouble(purchaseMap.get("total_tax").toString());
//				purchaseMap.put("sgst", gst / 2);
//				purchaseMap.put("cgst", gst / 2);
//				for (Map<String, Object> purchaseData : (List<Map<String, Object>>) purchaseMap.get("purchaselist")) {
//					double productgst = Double.parseDouble(purchaseData.get("tax_amt").toString());
//					purchaseData.put("sgst", productgst / 2);
//					purchaseData.put("cgst", productgst / 2);
//				}
//			} else {
//				purchaseMap.put("igst", purchaseMap.get("total_tax"));
//				for (Map<String, Object> salesData : (List<Map<String, Object>>) purchaseMap.get("purchaselist")) {
//					salesData.put("igst", salesData.get("tax_amt"));
//				}
//			}
			purchaseList.add(purchaseMap);
		}
		return purchaseList;
	}

	@GetMapping(value = "/purchase/count")
	public ResponseEntity<Long> getPurchaseCount() {
		long count = service.getPurchaseCount();
		return ResponseEntity.ok(count);
	}

	@RequestMapping("/purchase/{id}")
	private Purchase getBooks(@PathVariable(name = "id") long purchase_id) {
		return service.getDetailByPurchaseId(purchase_id);
	}

	@RequestMapping("/purchase/report")
	public List<Map<String, Object>> getAllPurchase() {
		return service.findAllPurchase();
	}

	@PutMapping("/purchase/edit/{id}")
	public ResponseEntity<Purchase> updateOrder(@PathVariable("id") Long purchase_id, @RequestBody Purchase purchase) {
		try {
			// Find the order by ID
			Purchase existingPurchase = service.findById(purchase_id);

			if (existingPurchase == null) {
				return ResponseEntity.notFound().build();
			}

			// Update the existing order with the new data

			existingPurchase.setBalance(purchase.getBalance());

//			existingPurchase.setPurchase_id(purchase.getPurchase_id());
			existingPurchase.setDescription(purchase.getDescription());
			existingPurchase.setPurchase_date(purchase.getPurchase_date());
			existingPurchase.setPayment_type(purchase.getPayment_type());

			existingPurchase.setCompanyid(purchase.getCompanyid());
			existingPurchase.setRoundoff(purchase.getRoundoff());

			existingPurchase.setReceived(purchase.getReceived());
			existingPurchase.setPhone_number(purchase.getPhone_number());
			existingPurchase.setRoundoff_amount(purchase.getRoundoff_amount());

			existingPurchase.setInvoice_no(purchase.getInvoice_no());

			existingPurchase.setTotal_amount(purchase.getTotal_amount());
			existingPurchase.setTotal_tax(purchase.getTotal_tax());
			existingPurchase.setTotal_qty(purchase.getTotal_qty());
			existingPurchase.setTotal_discount(purchase.getTotal_discount());

			// Save the updated order to the database
			service.save(existingPurchase);

			return ResponseEntity.ok(existingPurchase);

		} catch (Exception e) {
			// Log the error and return a 500 internal server error
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DeleteMapping("/purchase/delete/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long id) {
		service.deletePurchaseById(id);
		return ResponseEntity.ok("Customer deleted successfully");
	}

}
