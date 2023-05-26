package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Customer;

@Repository
@EnableTransactionManagement
public class CustomerDaoImpl  {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Customer> getAllCustomers() {

		Query query = entityManager.createQuery("FROM Customer", Customer.class);

		return query.getResultList();
	}

	@Transactional
	public Customer createCustomer(Customer customer) {
	
		//save or update
		 entityManager.merge(customer);
		 
		return customer ;
	}

	@Transactional
	public Customer getCustomer(int theId) {
		Customer customer= entityManager.find(Customer.class, theId);
		return customer;
	}

	@Transactional
	public void deleteCustomer(int theId) {
		Customer customer= entityManager.find(Customer.class, theId);
		entityManager.remove(customer);
	}

}