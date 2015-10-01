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

/* 
@ManyToOne
@JoinColumn(name= "OC_SERVICE_MASTER_ID", referencedColumnName="OC_SERVICE_MASTER_ID")
@GeneratedValue(strategy=GenerationType.IDENTITY)
 */


@Entity//This indicates the entire code given below is referred as an entity
@Table(name="out_station_expense")
public class OutStationExpense 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//This indicates that the given entity in the database must provide primary key for that
	@Column(name="out_station_expense_id")
	private Integer outStationExpenseId;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="state")
	private String state;
	
	@Column(name="description")
	private String description;
	
	@Column(name="room_rent")
	private double roomRent;
	
	@Column(name="transport_road")
	private double transportRoad;
	
	@Column(name="car_rental")
	private double carRental;
	
	@Column(name="automobile_expense")
	private double automobileExpense;
	
	@Column(name="breakfast_expense")
	private double breakfastExpense;
	
	@Column(name="lunch_expense")
	private double lunchExpense;
	
	@Column(name="dinner_expense")
	private double dinnerExpense;
	
	@Column(name="entertainment_expense")
	private double entertainmentExpense;
	
	@Column(name="miscellaneous_expense")
	private double miscellaneousExpense;
	
	@Column(name="daily_total")
	private double dailyTotal;

	@ManyToOne
	@JoinColumn(name="reimbursement_id",referencedColumnName="reimbursement_id")
	public Reimbursement reimbursement4;
	
	
	public Integer getOutStationExpenseId() 
	{
		return outStationExpenseId;
	}

	public void setOutStationExpenseId(Integer outStationExpenseId)
	{
		this.outStationExpenseId = outStationExpenseId;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date) 
	{
		this.date = date;
	}

	public String getState() 
	{
		return state;
	}

	public void setState(String state) 
	{
		this.state = state;
	}

	public String getDescription() 
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public double getRoomRent() 
	{
		return roomRent;
	}

	public void setRoomRent(double roomRent) 
	{
		this.roomRent = roomRent;
	}

	public double getTransportRoad() 
	{
		return transportRoad;
	}

	public void setTransportRoad(double transportRoad)
	{
		this.transportRoad = transportRoad;
	}

	public double getCarRental()
	{
		return carRental;
	}

	public void setCarRental(double carRental)
	{
		this.carRental = carRental;
	}

	public double getAutomobileExpense() 
	{
		return automobileExpense;
		
	}

	public void setAutomobileExpense(double automobileExpense) 
	{
		this.automobileExpense = automobileExpense;
	}

	public double getBreakfastExpense() 
	{
		return breakfastExpense;
	}

	public void setBreakfastExpense(double breakfastExpense) 
	{
		this.breakfastExpense = breakfastExpense;
	}

	public double getLunchExpense() 
	{
		return lunchExpense;
	}

	public void setLunchExpense(double lunchExpense) 
	{
		this.lunchExpense = lunchExpense;
	}

	public double getDinnerExpense() 
	{
		return dinnerExpense;
	}

	public void setDinnerExpense(double dinnerExpense)
	{
		this.dinnerExpense = dinnerExpense;
	}

	public double getEntertainmentExpense()
	{
		return entertainmentExpense;
	}

	public void setEntertainmentExpense(double entertainmentExpense)
	{
		this.entertainmentExpense = entertainmentExpense;
	}

	public double getMiscellaneousExpense() 
	{
		return miscellaneousExpense;
	}

	public void setMiscellaneousExpense(double miscellaneousExpense)
	{
		this.miscellaneousExpense = miscellaneousExpense;
	}

	public double getDailyTotal() {
		return dailyTotal;
	}

	public void setDailyTotal(double dailyTotal)
	{
		this.dailyTotal = dailyTotal;
	}

	public Reimbursement getReimbursement4() 
	{
		return reimbursement4;
	}

	public void setReimbursement4(Reimbursement reimbursement4)
	{
		this.reimbursement4 = reimbursement4;
	}

}
