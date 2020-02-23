package org.trident.account.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.trident.account.entity.Group;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder(value = {
        "groupId",
        "groupName",
        "groupDescription",
        "enabled",
        "createdBy",
        "createdOn",
        "accounts"
})
public class GroupDTO implements Serializable {

    @JsonProperty("groupId")
    private Long groupId;
    @NotBlank(message = "Cannot be blank")
    @JsonProperty("groupName")
    private String groupName;
    @NotBlank(message = "Cannot be blank")
    @JsonProperty("groupDescription")
    private String groupDescription;
    @NotNull(message = "Cannot be null")
    @JsonProperty("enabled")
    private Boolean enabled;
    @NotNull(message = "Cannot be null")
    @JsonProperty("createdBy")
    private Long createdBy;
    @NotNull(message = "Cannot be null")
    @JsonProperty("createdOn")
    private Date createdOn;
    @JsonProperty("accounts")
    private Set<AccountDTO> accounts = new HashSet<>();

    public Long getGroupId() {
        return groupId;
    }
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
    public String getGroupName() {
        return groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    public String getGroupDescription() {
        return groupDescription;
    }
    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
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
    public Set<AccountDTO> getAccounts() {
        return accounts;
    }
    public void setAccounts(Set<AccountDTO> accounts) {
        this.accounts = accounts;
    }
    public Group toEntity() {
        Group group = new Group();
        group.setGroupId(this.getGroupId());
        group.setGroupName(this.getGroupName());
        group.setGroupDescription(this.getGroupDescription());
        group.setEnabled(this.getEnabled());
        group.setCreatedBy(this.getCreatedBy());
        group.setCreatedOn(this.getCreatedOn());
        return group;
    }
}
