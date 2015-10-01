package com.bpaMiniProject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="department")
public class Department 
{
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="department_id")
	private Integer departmentId;
	
	@Column(name="department_name")
	private String departmentName;
	
	@Column(name="department_description")
	private String departmentDescription;
	
	@Column(name="is_active")
	private Boolean isActive;
	
	@Column(name="created_by")
	private Integer createdBy;
	
	@Column(name="created_on")
	private Date createdOn;
	
	@Column(name="updated_by")
	private int updatedBy;
	
	@Column(name="updated_on")
	private Date updatedOn;

	public Integer getDepartmentId() 
	{
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) 
	{
		this.departmentId = departmentId;
	}

	public String getDepartmentName()
	{
		return departmentName;
	}

	public void setDepartmentName(String departmentName)
	{
		this.departmentName = departmentName;
	}

	public String getDepartmentDescription() 
	{
		return departmentDescription;
	}

	public void setDepartmentDescription(String departmentDescription) 
	{
		this.departmentDescription = departmentDescription;
	}

	public Boolean getIsActive() 
	{
		return isActive;
	}

	public void setIsActive(Boolean isActive)
	{
		this.isActive = isActive;
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
	
}
