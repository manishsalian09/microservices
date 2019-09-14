package org.trident.designer.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.trident.designer.entity.ActivityType;

@JsonInclude(Include.NON_EMPTY)
@JsonPropertyOrder(value = {
		"activityTypeId",
		"activityTypeName"
})
public class ActivityTypeDTO implements Serializable {

	@JsonProperty("activityTypeId")
	private Long activityTypeId;
	@JsonProperty("activityTypeName")
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
	public ActivityType toEntity() {
		final ActivityType activityType = new ActivityType();
		activityType.setActivityTypeId(this.getActivityTypeId());
		activityType.setActivityTypeName(this.getActivityTypeName());
		return activityType;
	}
}
