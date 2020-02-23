package org.trident.account.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.trident.account.entity.Role;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder(value = {
        "roleId",
        "roleName",
        "enabled",
        "createdBy",
        "createdOn",
        "policies"
})
public class RoleDTO implements Serializable {

    @JsonProperty("roleId")
    private Long roleId;
    @NotBlank(message = "Cannot be blank")
    @JsonProperty("roleName")
    private String roleName;
    @NotNull(message = "Cannot be null")
    @JsonProperty("enabled")
    private Boolean enabled;
    @NotNull(message = "Cannot be null")
    @JsonProperty("createdBy")
    private Long createdBy;
    @NotNull(message = "Cannot be null")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy hh:mm:ss")
    @JsonProperty("createdOn")
    private Date createdOn;
    @JsonProperty("policies")
    private Set<PolicyDTO> policies = new HashSet<>();

    public Long getRoleId() {
        return roleId;
    }
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public Boolean getEnabled() {
        return enabled;
    }
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
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
    public Set<PolicyDTO> getPolicies() {
        return policies;
    }
    public void setPolicies(Set<PolicyDTO> policies) {
        this.policies = policies;
    }
    public Role toEntity() {
        Role role = new Role();
        role.setRoleId(this.getRoleId());
        role.setRoleName(this.getRoleName());
        role.setCreatedBy(this.getCreatedBy());
        role.setCreatedOn(this.getCreatedOn());
        role.setEnabled(this.getEnabled());
        return role;
    }
}
