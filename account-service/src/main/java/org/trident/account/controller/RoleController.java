package org.trident.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.trident.account.dto.RoleDTO;
import org.trident.account.entity.Role;
import org.trident.account.exception.ValidationException;
import org.trident.account.service.RoleService;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("{roleId}")
    public ResponseEntity<?> findRoleByRoleId(@PathVariable("roleId") Long roleId) {
        final RoleDTO roleDTO = this.roleService.findByRoleId(roleId);
        return ResponseEntity.status(HttpStatus.OK).body(roleDTO);
    }

    @GetMapping
    public ResponseEntity<?> findAllRole() {
        List<RoleDTO> roleDTO = this.roleService.findAllRole();
        return ResponseEntity.status(HttpStatus.OK).body(roleDTO);
    }

    @PostMapping
    public ResponseEntity<?> createRole(@Valid @RequestBody RoleDTO roleDTO, Errors errors) throws URISyntaxException {
        if (errors.hasErrors()) throw new ValidationException("Field Validation Errors", errors);
        final Long roleId = roleService.createRole(roleDTO).getRoleId();
        final URI location = new URI("/roles/" + roleId);
        return ResponseEntity.created(location).build();
    }
}
