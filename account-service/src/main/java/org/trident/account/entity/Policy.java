package org.trident.account.entity;

import org.trident.account.dto.PolicyDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "wf_policy")
public class Policy implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "policy_id")
    private Long policyId;
    @Column(name = "policy_name")
    private String policyName;
    @Column(name = "policy_description")
    private String policyDescription;
    @Column(name = "policy_type")
    private String policyType;
    @Column(name = "created_by")
    private Long createdBy;
    @Column(name = "created_on")
    private Date createdOn;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "json")
    private String json;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "wf_role_policy",
            joinColumns = @JoinColumn(name = "policy_id", referencedColumnName = "policy_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

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
    public Set<Role> getRoles() {
        return roles;
    }
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    public PolicyDTO toDto() {
        PolicyDTO policyDTO = new PolicyDTO();
        policyDTO.setPolicyId(this.getPolicyId());
        policyDTO.setPolicyName(this.getPolicyName());
        policyDTO.setPolicyDescription(this.getPolicyDescription());
        policyDTO.setPolicyType(this.getPolicyType());
        policyDTO.setActive(this.getActive());
        policyDTO.setCreatedBy(this.getCreatedBy());
        policyDTO.setCreatedOn(this.getCreatedOn());
        policyDTO.setJson(this.getJson());
        return policyDTO;
    }
}
