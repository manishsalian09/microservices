package org.trident.account.service;

import org.trident.account.dto.RoleDTO;

import java.util.List;

public interface RoleService {

    RoleDTO createRole(final RoleDTO roleDTO);
    RoleDTO findByRoleId(final Long roleId);
    List<RoleDTO> findAllRole();
}
