package org.trident.account.entity;

import org.trident.account.dto.AccountDTO;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "wf_account")
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id")
    private Long accountId;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "password")
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "created_by")
    private Long createdBy;
    @Column(name = "created_on")
    private Date createdOn;
    @Column(name = "last_login_date")
    private Date lastLoginDate;
    @Column(name = "login_attempts")
    private Integer loginAttempts;
    @Column(name = "locked")
    private Boolean locked;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "temporary_password")
    private String temporaryPassword;
    @Column(name = "email_id")
    private String emailId;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "wf_account_role",
            joinColumns = @JoinColumn(name = "account_id", referencedColumnName = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    )
    private Set<Role> roles = new HashSet<>();
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "wf_account_group",
            joinColumns = @JoinColumn(name = "account_id", referencedColumnName = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id", referencedColumnName = "group_id")
    )
    private Set<Group> groups = new HashSet<>();

    public Long getAccountId() {
        return accountId;
    }
    public void setAccountId(final Long accountId) {
        this.accountId = accountId;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(final String userId) {
        this.userId = userId;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(final String middleName) {
        this.middleName = middleName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }
    public Long getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(final Long createdBy) {
        this.createdBy = createdBy;
    }
    public Date getCreatedOn() {
        return createdOn;
    }
    public void setCreatedOn(final Date createdOn) {
        this.createdOn = createdOn;
    }
    public Date getLastLoginDate() {
        return lastLoginDate;
    }
    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }
    public Integer getLoginAttempts() {
        return loginAttempts;
    }
    public void setLoginAttempts(Integer loginAttempts) {
        this.loginAttempts = loginAttempts;
    }
    public Boolean getLocked() {
        return locked;
    }
    public void setLocked(Boolean locked) {
        this.locked = locked;
    }
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
    public String getTemporaryPassword() {
        return temporaryPassword;
    }
    public void setTemporaryPassword(String temporaryPassword) {
        this.temporaryPassword = temporaryPassword;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public Set<Role> getRoles() {
        return roles;
    }
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public AccountDTO toDto() {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountId(this.getAccountId());
        accountDTO.setUserId(this.getUserId());
        accountDTO.setFirstName(this.getFirstName());
        accountDTO.setMiddleName(this.getMiddleName());
        accountDTO.setLastName(this.getLastName());
        accountDTO.setCreatedBy(this.getCreatedBy());
        accountDTO.setCreatedOn(this.getCreatedOn());
        accountDTO.setLastLoginDate(this.getLastLoginDate());
        accountDTO.setLoginAttempts(this.getLoginAttempts());
        accountDTO.setActive(this.getActive());
        accountDTO.setLocked(this.getLocked());
        accountDTO.setTemporaryPassword(this.getTemporaryPassword());
        accountDTO.setEmailId(this.getEmailId());
        return accountDTO;
    }
}
