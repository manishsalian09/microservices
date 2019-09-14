package org.trident.designer.entity;

import org.trident.designer.dto.AssociationDTO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wf_association")
public class Association implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "association_id")
	private Long associationId;
	@Column(name = "source_activity_id")
	private Long sourceActivityId;
	@Column(name = "destination_activity_id")
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
	public AssociationDTO toDto() {
		final AssociationDTO associationDTO = new AssociationDTO();
		associationDTO.setAssociationId(this.getAssociationId());
		associationDTO.setSourceActivityId(this.getSourceActivityId());
		associationDTO.setDestinationActivityId(this.getDestinationActivityId());
		return associationDTO;
	}
}
