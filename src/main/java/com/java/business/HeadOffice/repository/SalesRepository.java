package com.java.business.HeadOffice.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.java.business.HeadOffice.entity.Sales;




public interface SalesRepository extends JpaRepository<Sales, Long> {
	@Query(value=" select* from sales as s join distributor as d on s.distributorid=d.distributorid", nativeQuery = true)
	List<Map<String, Object>> getAllSales();


	@Query(value="select (select code from mycompany where code = 33) = (select code from distributor where distributorid = :distributorid) as gst_code",nativeQuery = true)
	List<Map<String, Object>> getAllGst(Long distributorid);
	
	@Query(value="select s.sales_id, s.balance, s.description, s.invoice_date, s.invoice_no,s.payment_type,s.received,"

		+ " s.roundoff,s.roundoff_amount,s.shipping_address,s.total_amount,s.total_discount,s.total_qty,s.total_tax,s.phone_number,p.productname,c.*,d.*,sl.*,u.unitname "

		+ " from sales as s join distributor as d on s.distributorid=d.distributorid "

		+ " join saleslist as sl on s.sales_id=sl.fk_sales_id join product as p on p.productid=sl.productid"

		+ " join category as c on sl.categoryid=c.category_id"
		+ " join unit as u on sl.unit_id=u.unit_id where sales_id=:sales_id", nativeQuery = true)

	List<Map<String, Object>> getAllDistributorDetails(long sales_id);

	@Query(value="select s.sales_id, s.balance, s.description, s.invoice_date, s.invoice_no,s.payment_type,s.received,"

		+ " s.roundoff,s.roundoff_amount,s.shipping_address,s.total_amount,s.total_discount,s.total_qty,s.total_tax,s.phone_number,p.productname,c.*,d.*,sl.*,u.unitname "

		+ " from sales as s join distributor as d on s.distributorid=d.distributorid "

		+ " join saleslist as sl on s.sales_id=sl.fk_sales_id join product as p on p.productid=sl.productid"

		+ " join category as c on sl.categoryid=c.category_id"
		+ " join unit as u on sl.unit_id=u.unit_id", nativeQuery = true)
	List<Map<String, Object>> getAllDistributorDetails();
	
	
	

}
