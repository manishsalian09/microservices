package org.trident.designer.entity;

import org.trident.designer.dto.ActivityTypeDTO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wf_activity_type")
public class ActivityType implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "activity_type_id")
	private Long activityTypeId;
	@Column(name = "activity_type_name")
	private String activityTypeName;
	
	public Long getActivityTypeId() {
		return activityTypeId;
	}
	public void setActivityTypeId(Long activityTypeId) {
		this.activityTypeId = activityTypeId;
	}
	public String getActivityTypeName() {
		return activityTypeName;
	}
	public void setActivityTypeName(String activityTypeName) {
		this.activityTypeName = activityTypeName;
	}
	public ActivityTypeDTO toDto() {
		final ActivityTypeDTO activityTypeDTO = new ActivityTypeDTO();
		activityTypeDTO.setActivityTypeId(this.getActivityTypeId());
		activityTypeDTO.setActivityTypeName(this.getActivityTypeName());
		return activityTypeDTO;
	}
}
