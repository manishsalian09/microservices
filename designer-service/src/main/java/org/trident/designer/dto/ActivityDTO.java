package org.trident.designer.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.trident.designer.entity.Activity;

@JsonInclude(Include.NON_EMPTY)
@JsonPropertyOrder(value = {
		"activityId",
		"activityName",
		"activityDescription",
		"createdBy",
		"createdOn",
		"modifiedBy",
		"modifiedOn",
		"activityType",
		"associations"
})
public class ActivityDTO implements Serializable {

	@JsonProperty("activityId")
	private Long activityId;
	@JsonProperty("activityName")
	private String activityName;
	@JsonProperty("activityDescription")
	private String activityDescription;
	@JsonProperty("createdBy")
	private Long createdBy;
	@JsonProperty("createdOn")
	private Date createdOn;
	@JsonProperty("modifiedBy")
	private Long modifiedBy;
	@JsonProperty("modifiedOn")
	private Date modifiedOn;
	@JsonProperty("activityType")
	private ActivityTypeDTO activityType;
	@JsonProperty("associations")
	private Set<AssociationDTO> associations = new HashSet<>();
	//@JsonProperty("rules")
	//private Set<RuleDTO> rules = new LinkedHashSet<>();
	
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
	public ActivityTypeDTO getActivityType() {
		return activityType;
	}
	public void setActivityType(ActivityTypeDTO activityType) {
		this.activityType = activityType;
	}
	public Set<AssociationDTO> getAssociations() {
		return associations;
	}
	public void setAssociations(Set<AssociationDTO> associations) {
		this.associations = associations;
	}
	public Activity toEntity() {
		final Activity activity = new Activity();
		activity.setActivityId(this.getActivityId());
		activity.setActivityName(this.getActivityName());
		activity.setActivityDescription(this.getActivityDescription());
		activity.setCreatedBy(this.getCreatedBy());
		activity.setCreatedOn(this.getCreatedOn());
		activity.setModifiedBy(this.getModifiedBy());
		activity.setModifiedOn(this.getModifiedOn());
		return activity;
	}
}
