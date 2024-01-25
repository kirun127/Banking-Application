package com.kiran.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Customer {
@Id
@Column(columnDefinition="number(10)")
public long Account_NO;
@Column(columnDefinition="varchar2(10)")
public String Name;
@Column(columnDefinition="varchar2(10)")
public String Password;
@Column(columnDefinition="number(10)")
public int Amount;
@Column(columnDefinition="varchar2(10)")
public String Address;
@Column(columnDefinition="number(20)")
public long Mobile_No;
public Customer() {
	super();
	// TODO Auto-generated constructor stub
}
public long getAccount_NO() {
	return Account_NO;
}
public void setAccount_NO(long account_NO) {
	Account_NO = account_NO;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public int getAmount() {
	return Amount;
}
public void setAmount(int amount) {
	Amount = amount;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public long getMobile_No() {
	return Mobile_No;
}
public void setMobile_No(long mobile_No) {
	Mobile_No = mobile_No;
}
@Override
public String toString() {
	return "Customer [Account_NO=" + Account_NO + ", Name=" + Name + ", Password=" + Password + ", Amount=" + Amount
			+ ", Address=" + Address + ", Mobile_No=" + Mobile_No + "]";
}


}
