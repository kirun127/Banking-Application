package com.kiran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kiran.model.Customer;
import com.kiran.repo.BankingRepo;
import com.kiran.services.BankingServicesImp;

@Controller

public class BankingController {
@SuppressWarnings("unused")
@Autowired
private BankingServicesImp service;
@Autowired
private BankingRepo repo;
@RequestMapping("/")
public String homePage() 
{
	return "home";
}
@RequestMapping("register")
public String registerPage()
{
	return "Register";
}

@RequestMapping("login")
public String loginPage()
{
	return "Loginform";
}

@RequestMapping("/Log")
public String login(@ModelAttribute Customer c)
{
	String name=c.getName();
	String psw=c.getPassword();
	
	Customer c1=repo.findById((int) c.getAccount_NO()).get();
	String name_db=c1.getName();
	String psw_db=c1.getPassword();
	if(name.equals(name_db)&&psw.equals(psw_db))
	{
		return "Login";
	}
	else 
	{
		return "Error";
	}

}
@RequestMapping("/save")
public String openAccount(Customer c) {
Customer c1=service.saveCustomer(c);
  return "Success";
}
@RequestMapping("balance")
public String balancePage()
{
	return "BalanceForm";
}
@RequestMapping("/showbalance")
public String balance(@ModelAttribute Customer c,ModelMap m)
{
	 m.put("bal",service.showBalance(c));
	return "viewbalance";

}
@RequestMapping("withdraw")
public String withdrawform()
{
	return "Withdrawform";
}

@RequestMapping("/withdrawmoney")
public String withdraw(@ModelAttribute Customer c,ModelMap m)
{
	 m.put("wit",service.withdrawAmount(c));
	return "Withdraw";
}

@RequestMapping("deposit")
public String depositform()
{
	return "Depositform";
}


@RequestMapping("/depositmoney")
public String deposit(@ModelAttribute Customer c,ModelMap m)
{
	 m.put("bal",service.depositAmount(c));
	return "viewbalance";
}

@RequestMapping("transfer")
public String transferform()
{
	return "Transferform";
}
@RequestMapping("/transfermoney")
public String transfer(@ModelAttribute Customer c,@RequestParam long targetaccountnumber,ModelMap m)
{
	 m.put("bal",service.transferAmount(c,targetaccountnumber));
	return "viewbalance";
}
}
