package org.trident.designer.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.trident.designer.entity.Association;

@JsonInclude(Include.NON_EMPTY)
@JsonPropertyOrder(value = {
		"associationId",
		"sourceActivityId",
		"destinationActivityId"
})
public class AssociationDTO implements Serializable {

	@JsonProperty("associationId")
	private Long associationId;
	@JsonProperty("sourceActivityId")
	private Long sourceActivityId;
	@JsonProperty("destinationActivityId")
	private Long destinationActivityId;
	
	public Long getAssociationId() {
		return associationId;
	}
	public void setAssociationId(Long associationId) {
		this.associationId = associationId;
	}
	public Long getSourceActivityId() {
		return sourceActivityId;
	}
	public void setSourceActivityId(Long sourceActivityId) {
		this.sourceActivityId = sourceActivityId;
	}
	public Long getDestinationActivityId() {
		return destinationActivityId;
	}
	public void setDestinationActivityId(Long destinationActivityId) {
		this.destinationActivityId = destinationActivityId;
	}
	public Association toEntity() {
		final Association association = new Association();
		association.setAssociationId(this.getAssociationId());
		association.setSourceActivityId(this.getSourceActivityId());
		association.setDestinationActivityId(this.getDestinationActivityId());
		return association;
	}
}
