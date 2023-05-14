package com.java.business.HeadOffice.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
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
import com.java.business.HeadOffice.entity.Product;
import com.java.business.HeadOffice.entity.PurchaseList;
import com.java.business.HeadOffice.entity.Sales;
import com.java.business.HeadOffice.entity.SalesList;
import com.java.business.HeadOffice.repository.MyCompanyRepository;
import com.java.business.HeadOffice.repository.ProductRepository;
import com.java.business.HeadOffice.service.SalesService;

@RestController
@CrossOrigin
public class SalesController {

	@Autowired
	private SalesService service;

	@Autowired
	private ProductRepository repo;
	
	@Autowired
	private MyCompanyRepository companyRepo;

	// @GetMapping("/sales")
	// public Iterable<Sales> getUser() {
	// return service.listAll();

	// }

	@GetMapping("/sales")

	public ResponseEntity<?> getSales() {

		try {

			Iterable<Sales> sales = service.listAll();

			return ResponseEntity.ok(sales);

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error retrieving Sales: " + e.getMessage());

		}

	}

	@GetMapping("/sales/invoice/{id}")

	public List<Map<String, Object>> getSalesInovice(@PathVariable(name = "id") long sales_id) {
		ObjectMapper object = new ObjectMapper();
		List<Map<String, Object>> report = service.getAllDistributorDetail(sales_id);
		List<MyCompany> companyList = companyRepo.findAll();
		List<Map<String, Object>> salesDataList = object.convertValue(report, List.class);
		Map<String, List<Map<String, Object>>> salesGroupMap = salesDataList.stream().collect(Collectors.groupingBy(action -> action.get("sales_id").toString()));
		List<Map<String, Object>> salesList = new ArrayList<>();
		for(Entry<String, List<Map<String, Object>>> salesDataMap : salesGroupMap.entrySet()) {
			Map<String, Object> salesMap = new HashMap<>();
			salesMap.putAll(salesDataMap.getValue().get(0));
			salesMap.put("saleslist", salesDataMap.getValue());
			if (companyList.get(0).getCode() == 33 && salesMap.get("code").toString().equals("33")) {
				double gst = Double.parseDouble(salesMap.get("total_tax").toString());
				salesMap.put("sgst", gst / 2);
				salesMap.put("cgst", gst / 2);
				for (Map<String, Object> salesData : (List<Map<String, Object>>) salesMap.get("saleslist")) {
					double productgst = Double.parseDouble(salesData.get("tax_amt").toString());
					salesData.put("sgst", productgst / 2);
					salesData.put("cgst", productgst / 2);
				}
			} else {
				salesMap.put("igst", salesMap.get("total_tax"));
				for (Map<String, Object> salesData : (List<Map<String, Object>>) salesMap.get("saleslist")) {
					salesData.put("igst", salesData.get("tax_amt"));
				}
			}
			salesList.add(salesMap);
		}
		return salesList;
	}

	@GetMapping("/sales/invoice")
	public List<Map<String, Object>> getSalesInvoiceList() {
		ObjectMapper object = new ObjectMapper();
		List<Map<String, Object>> report = service.getAllSalesInvoices();
		List<MyCompany> companyList = companyRepo.findAll();
		List<Map<String, Object>> salesDataList = object.convertValue(report, List.class);
		Map<String, List<Map<String, Object>>> salesGroupMap = salesDataList.stream().collect(Collectors.groupingBy(action -> action.get("sales_id").toString()));
		List<Map<String, Object>> salesList = new ArrayList<>();
		for(Entry<String, List<Map<String, Object>>> salesDataMap : salesGroupMap.entrySet()) {
			Map<String, Object> salesMap = new HashMap<>();
			salesMap.putAll(salesDataMap.getValue().get(0));
			salesMap.put("saleslist", salesDataMap.getValue());
			if (companyList.get(0).getCode() == 33 && salesMap.get("code").toString().equals("33")) {
				double gst = Double.parseDouble(salesMap.get("total_tax").toString());
				salesMap.put("sgst", gst / 2);
				salesMap.put("cgst", gst / 2);
				for (Map<String, Object> salesData : (List<Map<String, Object>>) salesMap.get("saleslist")) {
					double productgst = Double.parseDouble(salesData.get("tax_amt").toString());
					salesData.put("sgst", productgst / 2);
					salesData.put("cgst", productgst / 2);
				}
			} else {
				salesMap.put("igst", salesMap.get("total_tax"));
				for (Map<String, Object> salesData : (List<Map<String, Object>>) salesMap.get("saleslist")) {
					salesData.put("igst", salesData.get("tax_amt"));
				}
			}
			salesList.add(salesMap);
		}
		return salesList;
	}

	@PostMapping(value = "/sales/save")
	private long saveBook(@RequestBody Sales sales) {
		List<Long> productIdList = sales.getSaleslist().stream().map(action -> action.getProductid())
				.collect(Collectors.toList());
		List<Product> productList = repo.findAllById(productIdList);
		for (Product product : productList) {
			for (SalesList salesList : sales.getSaleslist()) {
				if (product.getProductid() == salesList.getProductid()) {
					product.setStock(
							Objects.nonNull(product.getStock()) ? product.getStock() - salesList.getShipped_qty()
									: -salesList.getShipped_qty());
				}
			}
		}
		repo.saveAll(productList);

		service.save(sales);
		return sales.getSales_id();

	}

	@GetMapping(value = "/sales/count")
	public ResponseEntity<Long> getSalesCount() {
		long count = service.getSalesCount();
		return ResponseEntity.ok(count);
	}

	@RequestMapping("/sales/{id}")
	private Sales getBooks(@PathVariable(name = "id") long sales_id) {
		return service.getDetailBySalesId(sales_id);
	}

	@RequestMapping("/sales/report")
	public List<Map<String, Object>> getAllSales() {
		return service.findAllSales();
	}

	@PutMapping("/sales/edit/{id}")
	public ResponseEntity<Sales> updateOrder(@PathVariable("id") Long sales_id, @RequestBody Sales sales) {
		try {
			// Find the order by ID
			Sales existingSales = service.findById(sales_id);

			if (existingSales == null) {
				return ResponseEntity.notFound().build();
			}

			// Update the existing order with the new data
			existingSales.setBalance(sales.getBalance());

//			existingSales.setSales_id(sales.getSales_id());
			existingSales.setDescription(sales.getDescription());
			existingSales.setInvoice_date(sales.getInvoice_date());
			existingSales.setPayment_type(sales.getPayment_type());

			existingSales.setSaleslist(sales.getSaleslist());

			existingSales.setDistributorid(sales.getDistributorid());
			existingSales.setRoundoff(sales.getRoundoff());

			existingSales.setReceived(sales.getReceived());
			existingSales.setPhone_number(sales.getPhone_number());
			existingSales.setRoundoff_amount(sales.getRoundoff_amount());
			existingSales.setShipping_address(sales.getShipping_address());
			existingSales.setTotal_amount(sales.getTotal_amount());
			existingSales.setTotal_tax(sales.getTotal_tax());
			existingSales.setTotal_qty(sales.getTotal_qty());
			existingSales.setTotal_discount(sales.getTotal_discount());

			// Save the updated order to the database
			service.save(existingSales);

			return ResponseEntity.ok(existingSales);

		} catch (Exception e) {
			// Log the error and return a 500 internal server error
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DeleteMapping("/sales/delete/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long id) {
		service.deletePurchaseById(id);
		return ResponseEntity.ok("Customer deleted successfully");
	}

}
