package com.kiran.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kiran.model.Customer;
@Repository
public interface BankingRepo extends JpaRepository<Customer, Integer> {

}
