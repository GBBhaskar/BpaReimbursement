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

@Entity
@Table(name="miscellaneous_expense")
public class MiscellaneousExpense 
{
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="miscellaneous_expense_id")
	private Integer miscellaneousExpenseId;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="description")
	private String description;
	
	@Column(name="currency")
	private String currency;
	
	@Column(name="amount")
	private double amount;

	@ManyToOne
	@JoinColumn(name="reimbursement_id",referencedColumnName="reimbursement_id")
	public Reimbursement reimbursement3;



	public Integer getMiscellaneousExpenseId()
	{
		return miscellaneousExpenseId;
	}

	public void setMiscellaneousExpenseId(Integer miscellaneousExpenseId)
	{
		this.miscellaneousExpenseId = miscellaneousExpenseId;
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

	public String getCurrency()
	{
		return currency;
	}

	public void setCurrency(String currency)
	{
		this.currency = currency;
	}

	public double getAmount()
	{
		return amount;
	}

	public void setAmount(double amount)
	{
		this.amount = amount;
	}

	public Reimbursement getReimbursement3()
	{
		return reimbursement3;
	}

	public void setReimbursement3(Reimbursement reimbursement3) 
	{
		this.reimbursement3 = reimbursement3;
	}
}
