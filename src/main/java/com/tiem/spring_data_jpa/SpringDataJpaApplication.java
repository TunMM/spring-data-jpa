package com.tiem.spring_data_jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tiem.spring_data_jpa.entities.Customer;
import com.tiem.spring_data_jpa.repositories.CustomerRepository;

@SpringBootApplication
public class SpringDataJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringDataJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return args -> {

			repository.save(new Customer("Aung", "Kyaw"));
			repository.save(new Customer("Kyaw", "Soe"));
			repository.save(new Customer("Zaw", "Min"));
			repository.save(new Customer("Lwin", "Zaw"));
			repository.save(new Customer("Kyaw", "Min"));

			log.info("find all customers");
			repository.findAll().forEach(customer -> log.info(customer.toString()));
			log.info("--------------------------------\n\n");

			log.info("find by customers id 1");
			Customer cus = repository.findById(1L).get();
			log.info(cus.toString());
			log.info("--------------------------------\n\n");
			
			log.info("find customer last name min");
			repository.findByLastName("Min").forEach(min -> log.info(min.toString()));
			log.info("--------------------------------\n\n");
		};
	}
}
