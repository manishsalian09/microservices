package org.trident.account.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.trident.account.entity.Policy;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder(value = {
        "policyId",
        "policyName",
        "policyDescription",
        "policyType",
        "createdBy",
        "createdOn",
        "active",
        "json"
})
public class PolicyDTO implements Serializable {

    @JsonProperty("policyId")
    private Long policyId;
    @NotBlank(message = "Cannot be blank")
    @JsonProperty("policyName")
    private String policyName;
    @JsonProperty("policyDescription")
    private String policyDescription;
    @NotBlank(message = "Cannot be blank")
    @JsonProperty("policyType")
    private String policyType;
    @NotNull(message = "Cannot be null")
    @JsonProperty("createdBy")
    private Long createdBy;
    @NotNull(message = "Cannot be null")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy hh:mm:ss")
    @JsonProperty("createdOn")
    private Date createdOn;
    @NotNull(message = "Cannot be null")
    @JsonProperty("active")
    private Boolean active;
    @NotBlank(message = "Cannot be blank")
    @JsonProperty("json")
    private String json;

    public Long getPolicyId() {
        return policyId;
    }
    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }
    public String getPolicyName() {
        return policyName;
    }
    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }
    public String getPolicyDescription() {
        return policyDescription;
    }
    public void setPolicyDescription(String policyDescription) {
        this.policyDescription = policyDescription;
    }
    public String getPolicyType() {
        return policyType;
    }
    public void setPolicyType(String policyType) {
        this.policyType = policyType;
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
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
    public String getJson() {
        return json;
    }
    public void setJson(String json) {
        this.json = json;
    }
    public Policy toEntity() {
        Policy policy = new Policy();
        policy.setPolicyId(this.getPolicyId());
        policy.setPolicyName(this.getPolicyName());
        policy.setPolicyDescription(this.getPolicyDescription());
        policy.setPolicyType(this.getPolicyType());
        policy.setActive(this.getActive());
        policy.setCreatedBy(this.getCreatedBy());
        policy.setCreatedOn(this.getCreatedOn());
        policy.setJson(this.getJson());
        return policy;
    }
}
