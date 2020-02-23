package org.trident.account.service;

import org.trident.account.dto.GroupDTO;

public interface GroupService {

    GroupDTO createGroup(final GroupDTO groupDTO);
    GroupDTO findByGroupId(final Long groupId);
}
