package com.example.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Customer;

@SpringBootApplication
public class CustomerSpringbootApplication implements CommandLineRunner {

	private SessionFactory sessionFactory;

	public CustomerSpringbootApplication(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomerSpringbootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(new Customer("Mounika", "Manchala", "mounika.manchala@gmail.com"));
		session.save(new Customer("Vijay", "Choudarapu", "vijay@gmail.com"));
		session.getTransaction().commit();
	}

}
