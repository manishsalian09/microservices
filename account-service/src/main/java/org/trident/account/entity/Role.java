package org.trident.account.entity;

import org.trident.account.dto.RoleDTO;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "wf_role")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Long roleId;
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "enabled")
    private Boolean enabled;
    @Column(name = "created_by")
    private Long createdBy;
    @Column(name = "created_on")
    private Date createdOn;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "wf_role_policy",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "policy_id", referencedColumnName = "policy_id")
    )
    private Set<Policy> policies = new HashSet<>();

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
    public Set<Policy> getPolicies() {
        return policies;
    }
    public void setPolicies(Set<Policy> policies) {
        this.policies = policies;
    }
    public RoleDTO toDto() {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRoleId(this.getRoleId());
        roleDTO.setRoleName(this.getRoleName());
        roleDTO.setCreatedBy(this.getCreatedBy());
        roleDTO.setCreatedOn(this.getCreatedOn());
        roleDTO.setEnabled(this.getEnabled());
        return roleDTO;
    }
}
