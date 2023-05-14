package com.java.business.HeadOffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.business.HeadOffice.entity.Distributor;

public interface DistributorRepository extends JpaRepository<Distributor, Long>{

    Distributor findByPhoneno(long phoneno);

}
