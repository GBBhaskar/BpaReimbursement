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
@Table(name="entertainment_expense")
public class EntertainmentExpense
{
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="entertainment_expense_id")
	private Integer entertainmentExpenseId;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="description")
	private String description;
	
	@Column(name="notes")
	private String notes;
	
	@Column(name="amount")
	private double amount;
	
	@Column(name="currency")
	private String currency;
	
	@ManyToOne
	@JoinColumn(name="reimbursement_id",referencedColumnName="reimbursement_id")
	public Reimbursement reimbursement2;

	
	public Integer getEntertainmentExpenseId()
	{
		return entertainmentExpenseId;
	}

	public void setEntertainmentExpenseId(Integer entertainmentExpenseId) 
	{
		this.entertainmentExpenseId = entertainmentExpenseId;
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

	public String getNotes() 
	{
		return notes;
	}

	public void setNotes(String notes)
	{
		this.notes = notes;
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

	public Reimbursement getReimbursement2()
	{
		return reimbursement2;
	}

	public void setReimbursement2(Reimbursement reimbursement2)
	{
		this.reimbursement2 = reimbursement2;
	}

	

	
}
