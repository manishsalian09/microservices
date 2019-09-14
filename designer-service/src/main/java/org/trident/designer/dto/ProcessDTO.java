package org.trident.designer.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.trident.designer.entity.Process;

@JsonInclude(Include.NON_EMPTY)
@JsonPropertyOrder(value = {
		"processId",
		"processName",
		"processDescription",
		"createdBy",
		"createdOn",
		"enabled",
		"activities"
})
public class ProcessDTO implements Serializable {

	@JsonProperty("processId")
	private Long processId;
	@NotBlank(message = "Process Name cannot be blank")
	@JsonProperty("processName")
	private String processName;
	@JsonProperty("processDescription")
	private String processDescription;
	@JsonProperty("createdBy")
	private Long createdBy;
	@JsonProperty("createdOn")
	private Date createdOn;
	@JsonProperty("enabled")
	private Boolean enabled;
	@JsonProperty("activities")
	private Set<ActivityDTO> activities = new HashSet<>();
	
	public Long getProcessId() {
		return processId;
	}
	public void setProcessId(Long processId) {
		this.processId = processId;
	}
	public String getProcessName() {
		return processName;
	}
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	public String getProcessDescription() {
		return processDescription;
	}
	public void setProcessDescription(String processDescription) {
		this.processDescription = processDescription;
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
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public Set<ActivityDTO> getActivities() {
		return activities;
	}
	public void setActivities(Set<ActivityDTO> activities) {
		this.activities = activities;
	}
	public Process toEntity() {
		final Process process = new Process();
		process.setProcessId(this.getProcessId());
		process.setProcessDescription(this.getProcessDescription());
		process.setCreatedBy(this.getCreatedBy());
		process.setCreatedOn(this.getCreatedOn());
		process.setEnabled(this.getEnabled());
		return  process;
	}
}
