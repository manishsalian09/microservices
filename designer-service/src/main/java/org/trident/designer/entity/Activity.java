package org.trident.designer.entity;

import org.trident.designer.dto.ActivityDTO;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "wf_activity")
public class Activity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "activity_id")
	private Long activityId;
	@Column(name = "activity_name")
	private String activityName;
	@Column(name = "activity_description")
	private String activityDescription;
	@Column(name = "created_by")
	private Long createdBy;
	@Column(name = "created_on")
	private Date createdOn;
	@Column(name = "modified_by")
	private Long modifiedBy;
	@Column(name = "modified_on")
	private Date modifiedOn;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "activityTypeId")
	private ActivityType activityType;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "source_activity_id", referencedColumnName = "activity_id")
	private Set<Association> associations = new HashSet<>();
	//@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	//@JoinColumn(name = "activityId")
	//private Set<Rule> rules = new LinkedHashSet<>();
	
	public Long getActivityId() {
		return activityId;
	}
	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public String getActivityDescription() {
		return activityDescription;
	}
	public void setActivityDescription(String activityDescription) {
		this.activityDescription = activityDescription;
	}
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Long getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public ActivityType getActivityType() {
		return activityType;
	}
	public void setActivityType(ActivityType activityType) {
		this.activityType = activityType;
	}
	public Set<Association> getAssociations() {
		return associations;
	}
	public void setAssociations(Set<Association> associations) {
		this.associations = associations;
	}
	public ActivityDTO toDto() {
		final ActivityDTO activityDTO = new ActivityDTO();
		activityDTO.setActivityId(this.getActivityId());
		activityDTO.setActivityName(this.getActivityName());
		activityDTO.setActivityDescription(this.getActivityDescription());
		activityDTO.setCreatedBy(this.getCreatedBy());
		activityDTO.setCreatedOn(this.getCreatedOn());
		activityDTO.setModifiedBy(this.getModifiedBy());
		activityDTO.setModifiedOn(this.getModifiedOn());
		return activityDTO;
	}
}
