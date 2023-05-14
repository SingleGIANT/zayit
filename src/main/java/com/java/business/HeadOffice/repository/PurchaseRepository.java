package com.java.business.HeadOffice.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.java.business.HeadOffice.entity.Purchase;



public interface PurchaseRepository extends JpaRepository<Purchase, Long>{

	@Query(value="select * from purchase as p join outsource as o on p.companyid=o.companyid", nativeQuery = true)
	List<Map<String, Object>> getAllPurchase();
	
	@Query(value="select p.purchase_id,p.balance,p.description,p.payment_type,p.phone_number,p.purchase_date,"
			+ "p.received,p.roundoff,p.roundoff_amount,p.total_amount,p.total_discount,p.total_qty,p.total_tax,"
			+ "u.unitname,pro.productname,pro.stock,pro.hsn_code,pro.productdescription,pro.categoryid,pl.purchase_list_id,pl.amount,pl.discount_amt,pl.discount_percentage,"
			+ "pl.price,pl.productid,pl.qty,pl.shipped_qty,pl.tax_amt,pl.tax_percentage,"
			+ "pl.fk_purchase_id,pl.unit_id,c.category_id,c.category,o.* from purchase as p join "
			+ "outsource as o on p.companyid=o.companyid"
			+ " join purchaselist as pl on p.purchase_id=pl.fk_purchase_id"
			+ " join product as pro on pro.productid=pl.productid"
			+ " join category as c on pl.categoryid=c.category_id"
			+ " join unit as u on pl.unit_id=u.unit_id where purchase_id=:purchase_id",nativeQuery = true)
	List<Map<String, Object>> getAllOutsource(long purchase_id);

	@Query(value="select p.purchase_id,p.balance,p.description,p.payment_type,p.phone_number,p.purchase_date,"
			+ "p.received,p.invoice_no,p.roundoff,p.roundoff_amount,p.total_amount,p.total_discount,p.total_qty,p.total_tax,"
			+ "u.unitname,pro.productname,pro.stock,pro.hsn_code,pro.productdescription,pro.categoryid,pl.purchase_list_id,pl.amount,pl.discount_amt,"
			+ "pl.discount_percentage,pl.price,pl.productid,pl.qty,pl.shipped_qty,"
			+ "pl.tax_amt,pl.tax_percentage,pl.fk_purchase_id,"
			+ "pl.unit_id,c.category_id,c.category,o.* from purchase as p join outsource as o on p.companyid=o.companyid"
			+ " join purchaselist as pl on p.purchase_id=pl.fk_purchase_id"
			+ " join product as pro on pro.productid=pl.productid"
			+ " join category as c on pl.categoryid=c.category_id"
			+ " join unit as u on pl.unit_id=u.unit_id  ",nativeQuery = true)
	List<Map<String, Object>> getAllOutsource();

}
