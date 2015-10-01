package com.bpaMiniProject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bpaMiniProject.model.Reimbursement;


@Entity
@Table(name="automobile_expense")
public class AutomobileExpense
{
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)//This Identity general we use to refer for primary key column in table in the database to allow the database to automatically assign an id to the object when its row is inserted.  
	@Column(name="automobile_expense_id")
	private Integer automobileExpenseId;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="description")
	private String description;
	
	@Column(name="amount")
	private double amount;
	
	@Column(name="currency")
	private String currency;
	
	@ManyToOne
	@JoinColumn(name="reimbursement_id",referencedColumnName="reimbursement_id")
	public Reimbursement reimbursement1;

	
	
	public Integer getAutomobileExpenseId() 
	{
		return automobileExpenseId;
	}

	public void setAutomobileExpenseId(Integer automobileExpenseId) 
	{
		this.automobileExpenseId = automobileExpenseId;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date) 
	{
		this.date = date;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public double getAmount()
	{
		return amount;
	}

	public void setAmount(double amount) 
	{
		this.amount = amount;
	}

	public String getCurrency() 
	{
		return currency;
	}

	public void setCurrency(String currency)
	{
		this.currency = currency;
	}

	public Reimbursement getReimbursement1() {
		return reimbursement1;
	}

	public void setReimbursement1(Reimbursement reimbursement1) {
		this.reimbursement1 = reimbursement1;
	}
	
	

	
	
}
