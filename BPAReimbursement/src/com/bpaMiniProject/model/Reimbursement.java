package com.bpaMiniProject.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.IndexColumn;


@Entity
@Table(name="reimbursement")
public class Reimbursement 
{
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="reimbursement_id")
	private Integer reimbursementId;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="employee_name")
	private String employeeName;
	
	@Column(name="department")
	private String department;
	
	@Column(name="manager")
	private Integer manager;
	
	@Column(name="status")
	private String status;
	
	@Column(name="supplementary_information")
	private String supplementaryInformation;
	
	@Column(name="currency")
	private String currency;
	
	@Column(name="total_expense")
	private double totalExpense;
	
	@Column(name="amount_paid")
	private double amountPaid;
	
	@Column(name="advance_amount")
	private double advanceAmount;
	
	@Column(name="due_amount")
	private double dueAmount;
	
	@Column(name="reimbursement_code")
	private String reimbursementCode;
	
	@Column(name="purpose_of_travel")
	private String purposeOfTravel;

	@Column(name="billable_to_customer")
	private String billableToCustomer;
	
	@Column(name="created_by")
	private Integer createdBy;
	
	@Column(name="created_on")
	private Date createdOn;
	
	@Column(name="updated_by")
	private int updatedBy;
	
	@Column(name="updated_on")
	private Date updatedOn;
	
	@Column(name="approver_comments")
	private String approverComments;
	
	
	@OneToMany (mappedBy="reimbursement1", fetch = FetchType.EAGER)
	@Cascade({ CascadeType.DELETE })
	@IndexColumn(name="automobile_expense_id")
	private List<AutomobileExpense> autoMobileExpenses;
	
	@OneToMany (mappedBy="reimbursement2", fetch = FetchType.EAGER)
	@Cascade({ CascadeType.DELETE })
    @IndexColumn(name="entertainment_expense_id")
	private List<EntertainmentExpense> entertainmentExpenses;
	
	@OneToMany (mappedBy="reimbursement3", fetch = FetchType.EAGER)
	@Cascade({ CascadeType.DELETE })
	@IndexColumn(name="miscellaneous_expense_id")
	private List<MiscellaneousExpense> miscellaneousExpenses;
	
	@OneToMany (mappedBy="reimbursement4", fetch = FetchType.EAGER)
	@Cascade({ CascadeType.DELETE})
	@IndexColumn(name="out_station_expense_id")
	private List<OutStationExpense> outStationExpenses;

	

	public Date getDate() 
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public String getEmployeeName()
	{
		return employeeName;
	}

	public void setEmployeeName(String employeeName)
	{
		this.employeeName = employeeName;
	}

	public String getDepartment()
	{
		return department;
	}

	public void setDepartment(String department)
	{
		this.department = department;
	}

	

	public String getStatus() 
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getSupplementaryInformation() 
	{
		return supplementaryInformation;
	}

	public void setSupplementaryInformation(String supplementaryInformation)
	{
		this.supplementaryInformation = supplementaryInformation;
	}

	public String getCurrency() 
	{
		return currency;
	}

	public void setCurrency(String currency)
	{
		this.currency = currency;
	}

	public double getTotalExpense()
	{
		return totalExpense;
	}

	public void setTotalExpense(double totalExpense)
	{
		this.totalExpense = totalExpense;
	}

	public double getAmountPaid()
	{
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) 
	{
		this.amountPaid = amountPaid;
	}

	public double getAdvanceAmount()
	{
		return advanceAmount;
	}

	public void setAdvanceAmount(double advanceAmount)
	{
		this.advanceAmount = advanceAmount;
	}

	public double getDueAmount() 
	{
		return dueAmount;
	}

	public void setDueAmount(double dueAmount) 
	{
		this.dueAmount = dueAmount;
	}

	public String getReimbursementCode() 
	{
		return reimbursementCode;
	}

	public void setReimbursementCode(String reimbursementCode)
	{
		this.reimbursementCode = reimbursementCode;
	}

	public String getPurposeOfTravel()
	{
		return purposeOfTravel;
	}

	public void setPurposeOfTravel(String purposeOfTravel) 
	{
		this.purposeOfTravel = purposeOfTravel;
	}

	public String getBillableToCustomer() 
	{
		return billableToCustomer;
	}

	public void setBillableToCustomer(String billableToCustomer) 
	{
		this.billableToCustomer = billableToCustomer;
	}

	public Integer getCreatedBy() 
	{
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy)
	{
		this.createdBy = createdBy;
	}

	public Date getCreatedOn()
	{
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) 
	{
		this.createdOn = createdOn;
	}

	public int getUpdatedBy() 
	{
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) 
	{
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedOn()
	{
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) 
	{
		this.updatedOn = updatedOn;
	}

	public List<AutomobileExpense> getAutoMobileExpenses()
	{
		return autoMobileExpenses;
	}

	public void setAutoMobileExpenses(List<AutomobileExpense> autoMobileExpenses)
	{
		this.autoMobileExpenses = autoMobileExpenses;
	}

	public List<EntertainmentExpense> getEntertainmentExpenses()
	{
		return entertainmentExpenses;
	}

	public void setEntertainmentExpenses(
			List<EntertainmentExpense> entertainmentExpenses) 
	{
		this.entertainmentExpenses = entertainmentExpenses;
	}

	public List<MiscellaneousExpense> getMiscellaneousExpenses() 
	{
		return miscellaneousExpenses;
	}

	public void setMiscellaneousExpenses(
			List<MiscellaneousExpense> miscellaneousExpenses)
	{
		this.miscellaneousExpenses = miscellaneousExpenses;
	}

	public List<OutStationExpense> getOutStationExpenses() 
	{
		return outStationExpenses;
	}

	public void setOutStationExpenses(List<OutStationExpense> outStationExpenses)
	{
		this.outStationExpenses = outStationExpenses;
	}

	public Integer getManager() 
	{
		return manager;
	}

	public void setManager(Integer manager)
	{
		this.manager = manager;
	}

	public String getApproverComments()
	{
		return approverComments;
	}

	public void setApproverComments(String approverComments) 
	{
		this.approverComments = approverComments;
	}

	public Integer getReimbursementId()
	{
		return reimbursementId;
	}

	public void setReimbursementId(Integer reimbursementId)
	{
		this.reimbursementId = reimbursementId;
	}

	
	
	

}
