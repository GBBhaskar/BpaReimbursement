package com.bpaMiniProject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="role")
public class Role 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="role_id")
	private Integer roleId;
	
	@Column(name="role_name")
	private String roleName;
	
	@Column(name="role_description")
	private String roleDescription;
	
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

	public Integer getRoleId()
	{
		return roleId;
	}

	public void setRoleId(Integer roleId) 
	{
		this.roleId = roleId;
	}

	public String getRoleName() 
	{
		return roleName;
	}

	public void setRoleName(String roleName)
	{
		this.roleName = roleName;
	}

	public String getRoleDescription() 
	{
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription)
	{
		this.roleDescription = roleDescription;
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
