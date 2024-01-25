package com.kiran.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kiran.model.Customer;
import com.kiran.repo.BankingRepo;
@Service
public class BankingServicesImp implements BankingServices {
@Autowired
private BankingRepo repo;
	@Override
	public Customer saveCustomer(Customer c) {
		Customer cust=repo.save(c);
		return cust;
	}

	@Override
	public Customer updateCustomer(Customer c, int Acc_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCustomer(int Acc_no) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer getCustomer(int Acc_no) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public  String showBalance(Customer c) {
           String name=c.getName();
           String psw=c.getPassword();
           Customer c1=repo.findById((int) c.Account_NO).get();
           String name_db=c1.getName();
           String psw_db=c1.getPassword();
           if(name.equals(name_db)&&psw.equals(psw_db))
           {
        	   int balance=c1.getAmount();
        	   return "Your Account Balance is "+balance;
           
	       }
           else
           {
        	   return "Enter Valid Details";
           }

	
		
	}
	@Override
	public String withdrawAmount(Customer c) {
		String name=c.getName();
        String psw=c.getPassword();
        int withdraw=c.getAmount();
        Customer c1=repo.findById((int) c.Account_NO).get();
        String name_db=c1.getName();
        String psw_db=c1.getPassword();
        int amount=c1.getAmount();
        int balance=0;
        if(name.equals(name_db)&&psw.equals(psw_db))
        {
        	if(amount>=withdraw)
        	{
        		balance=amount-withdraw;
        		c1.setAmount(balance);
        		repo.save(c1);
                amount=c1.getAmount();
        		return "Your Current balance is "+amount;
        	}
        	else
        	{
        		return "Insuffecient Funds";
        	}
        }
        else
        {
     	   return "Enter Valid Details";
        }
	
	}

	@Override
	public String depositAmount(Customer c) {
		String name=c.getName();
        String psw=c.getPassword();
        int deposit=c.getAmount();
        Customer c1=repo.findById((int) c.Account_NO).get();
        String name_db=c1.getName();
        String psw_db=c1.getPassword();
        int amount=c1.getAmount();
        int balance=0;
        if(name.equals(name_db)&&psw.equals(psw_db))
        {
        	
        		balance=amount+deposit;
        		c1.setAmount(balance);
        		repo.save(c1);
                amount=c1.getAmount();
        		return "Your Current balance is "+amount;
        
        }
        else
        {
     	   return "Enter Valid Details";
        }
	
	}

	@Override
	public String transferAmount(Customer c,long targetaccountnumber) {
		String name=c.getName();
        String psw=c.getPassword();
        int transfer=c.getAmount();
        int acc_no=(int) c.getAccount_NO();
        Customer c1=repo.findById(acc_no).get();
        Customer c2=repo.findById((int) targetaccountnumber).get();
        int amt1=c1.getAmount();
        int amt2=c2.getAmount();
        String name_db=c1.getName();
        String psw_db=c1.getPassword();
        if(name.equals(name_db)&&psw.equals(psw_db))
        {
        	amt1=amt1-transfer;
        	amt2=amt2+transfer;
        	c1.setAmount(amt1);
        	c2.setAmount(amt2);
        	repo.save(c1);
        	repo.save(c2);
        	return "Transaction Successful";
        }
        else
        {
        	return "Enter Valid Details";
        }
	}

	
}

