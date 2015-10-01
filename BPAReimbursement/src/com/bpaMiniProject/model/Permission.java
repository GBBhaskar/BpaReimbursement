package com.bpaMiniProject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="permission")
public class Permission 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="permission_id")
	private Integer permissionId;
	
	@Column(name="permission_name")
	private String permisssionName;
	
	@Column(name="permission_description")
	private String permissionDescription;
	
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

	public Integer getPermissionId()
	{
		return permissionId;
	}

	public void setPermissionId(Integer permissionId) 
	{
		this.permissionId = permissionId;
	}

	public String getPermisssionName()
	{
		return permisssionName;
	}

	public void setPermisssionName(String permisssionName) 
	{
		this.permisssionName = permisssionName;
	}

	public String getPermissionDescription()
{
		return permissionDescription;
	}

	public void setPermissionDescription(String permissionDescription) 
	{
		this.permissionDescription = permissionDescription;
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
