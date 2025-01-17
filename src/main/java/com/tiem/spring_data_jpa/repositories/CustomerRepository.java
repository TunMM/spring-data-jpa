package com.tiem.spring_data_jpa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.tiem.spring_data_jpa.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{

	List<Customer> findByLastName(String lastName);
	
	Optional<Customer> findById(Long Id);

}
