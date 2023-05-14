package com.java.business.HeadOffice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.business.HeadOffice.entity.Distributor;
import com.java.business.HeadOffice.repository.DistributorRepository;

@Service
public class DistributorService {

	@Autowired
	private DistributorRepository repo;
	
	public Iterable<Distributor> listAll() {

		return this.repo.findAll();

		}

		public void Saveorupdate(Distributor distribution) {

		repo.save(distribution);

		}

		public Distributor getDetailById(long id) {

		return repo.findById(id).get();

		}

		public void save(Distributor existingDistributor) {

		repo.save(existingDistributor);

		}

		public Distributor findById(Long id) {

		return repo.findById(id).get();

		}

		public void deleteDistributionById(Long id) {

		repo.deleteById(id);

		}
		public Distributor findByPhoneno(long phoneno) {
			
			return repo.findByPhoneno(phoneno);
		}
		public long getDistributionCount() {
		    return repo.count();
		}

}
