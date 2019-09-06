package org.trident.account.service;

import org.springframework.stereotype.Service;
import org.trident.account.dto.RoleDTO;
import org.trident.account.entity.Role;
import org.trident.account.exception.ValidationException;
import org.trident.account.repository.RoleRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    public RoleServiceImpl(final RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleDTO createRole(final RoleDTO roleDTO) {
        Role role = roleDTO.toEntity();
        role.setPolicies(roleDTO.getPolicies().stream().map(policyDTO -> policyDTO.toEntity()).collect(Collectors.toSet()));
        role = this.roleRepository.save(role);
        return role.toDto();
    }

    @Override
    public RoleDTO findByRoleId(final Long roleId) {
        final Optional<Role> role = this.roleRepository.findById(roleId);
        if (role.isEmpty()) throw new ValidationException("Role does not exist", null);
        final RoleDTO roleDTO = role.get().toDto();
        roleDTO.setPolicies(role.get().getPolicies().stream().map(policy -> policy.toDto()).collect(Collectors.toSet()));
        return roleDTO;
    }

    @Override
    public List<RoleDTO> findAllRole() {
        final List<Role> roles = this.roleRepository.findAll();
        if (roles.isEmpty()) throw new ValidationException("Roles does not exist", null);
        final List<RoleDTO> roleDTO = roles.stream().map(role -> role.toDto()).collect(Collectors.toList());
        return roleDTO;
    }
}
