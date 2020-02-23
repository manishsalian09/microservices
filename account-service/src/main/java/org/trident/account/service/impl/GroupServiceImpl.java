package org.trident.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.trident.account.dto.AccountDTO;
import org.trident.account.dto.GroupDTO;
import org.trident.account.entity.Account;
import org.trident.account.entity.Group;
import org.trident.account.exception.ValidationException;
import org.trident.account.repository.GroupRepository;
import org.trident.account.service.GroupService;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GroupServiceImpl implements GroupService {

    private GroupRepository groupRepository;

    @Autowired
    public GroupServiceImpl(final GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public GroupDTO createGroup(final GroupDTO groupDTO) {
        Group group = groupDTO.toEntity();
        group.setAccounts(groupDTO.getAccounts().stream().map(AccountDTO::toEntity).collect(Collectors.toSet()));
        group = this.groupRepository.save(group);
        return group.toDto();
    }

    @Override
    public GroupDTO findByGroupId(final Long groupId) {
        Optional<Group> group = this.groupRepository.findById(groupId);
        if (group.isEmpty()) throw new ValidationException("Group does not exist", null);
        GroupDTO groupDTO = group.get().toDto();
        groupDTO.setAccounts(group.get().getAccounts().stream().map(Account::toDto).collect(Collectors.toSet()));
        return groupDTO;
    }
}
