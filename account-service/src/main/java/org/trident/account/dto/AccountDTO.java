package org.trident.account.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.trident.account.annotation.ValidPassword;
import org.trident.account.entity.Account;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder(value = {
        "accountId",
        "userId",
        "password",
        "firstName",
        "middleName",
        "lastName",
        "active",
        "createdBy",
        "createdOn",
        "lastLoginDate",
        "loginAttempts",
        "locked",
        "roles"
})
public class AccountDTO implements Serializable {

    @JsonProperty("accountId")
    private Long accountId;
    @NotBlank(message = "Cannot be blank")
    @JsonProperty("userId")
    private String userId;
    @NotBlank(message = "Cannot be blank")
    @ValidPassword
    @JsonProperty("password")
    private String password;
    @NotBlank(message = "Cannot be blank")
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("middleName")
    private String middleName;
    @NotBlank(message = "Cannot be blank")
    @JsonProperty("lastName")
    private String lastName;
    @NotNull(message = "Cannot be null")
    @JsonProperty("active")
    private Boolean active;
    @NotNull(message = "Cannot be null")
    @JsonProperty("createdBy")
    private Long createdBy;
    @NotNull(message = "Cannot be null")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy hh:mm:ss")
    @JsonProperty("createdOn")
    private Date createdOn;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd-MM-yyyy hh:mm:ss")
    @JsonProperty("lastLoginDate")
    private Date lastLoginDate;
    @NotNull(message = "Cannot be null")
    @Min(value = 0, message = "Cannot be negative")
    @Max(value = 5, message = "No of attempts cannot be greater than 5")
    @JsonProperty("loginAttempts")
    private Integer loginAttempts;
    @NotNull(message = "Cannot be null")
    @JsonProperty("locked")
    private Boolean locked;
    @JsonProperty("temporaryPassword")
    private String temporaryPassword;
    @NotNull(message = "Cannot be null")
    @JsonProperty("emailId")
    private String emailId;
    @JsonProperty("roles")
    private Set<RoleDTO> roles = new HashSet<>();

    public Long getAccountId() {
        return accountId;
    }
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
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
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
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
    public Set<RoleDTO> getRoles() {
        return roles;
    }
    public void setRoles(Set<RoleDTO> roles) {
        this.roles = roles;
    }
    public Account toEntity() {
        Account account = new Account();
        account.setAccountId(this.getAccountId());
        account.setUserId(this.getUserId());
        account.setPassword(this.getPassword());
        account.setFirstName(this.getFirstName());
        account.setMiddleName(this.getMiddleName());
        account.setLastName(this.getLastName());
        account.setCreatedBy(this.getCreatedBy());
        account.setCreatedOn(this.getCreatedOn());
        account.setLastLoginDate(this.getLastLoginDate());
        account.setLoginAttempts(this.getLoginAttempts());
        account.setActive(this.getActive());
        account.setLocked(this.getLocked());
        account.setEmailId(this.getEmailId());
        account.setTemporaryPassword(this.getTemporaryPassword());
        return account;
    }
}
