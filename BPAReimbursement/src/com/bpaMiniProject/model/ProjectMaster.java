package com.bpaMiniProject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="project_master")
public class ProjectMaster
{
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="project_master_id")
	private Integer projectMasterId;
	
	@Column(name="project_name")
	private String projectName;
	
	@Column(name="project_description")
	private String projectDescription;
	
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
	
	 /*@ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "user_name")
	 private List<>;*/

	/*public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}*/

	public Integer getProjectMasterId() 
	{
		return projectMasterId;
	}

	public void setProjectMasterId(Integer projectMasterId)
	{
		this.projectMasterId = projectMasterId;
	}

	public String getProjectName() 
	{
		return projectName;
	}

	public void setProjectName(String projectName)
	{
		this.projectName = projectName;
	}

	public String getProjectDescription() 
	{
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) 
	{
		this.projectDescription = projectDescription;
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
