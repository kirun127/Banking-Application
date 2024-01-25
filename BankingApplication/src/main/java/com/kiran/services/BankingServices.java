package com.kiran.services;

import java.util.List;

import com.kiran.model.Customer;

public interface BankingServices {
public Customer saveCustomer(Customer c);
public Customer updateCustomer(Customer c,int Acc_no);
public void deleteCustomer(int Acc_no);
public Customer getCustomer(int Acc_no);
public String showBalance(Customer c);
public String withdrawAmount(Customer c);
public String depositAmount(Customer c);
public String transferAmount(Customer c,long targetaccountnumber);
}
