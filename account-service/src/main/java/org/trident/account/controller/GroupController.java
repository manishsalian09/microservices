package org.trident.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.trident.account.dto.GroupDTO;
import org.trident.account.exception.ValidationException;
import org.trident.account.service.GroupService;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("groups")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping("{groupId}")
    public ResponseEntity<?> findByGroupId(@PathVariable("groupId") Long groupId) {
        final GroupDTO groupDTO = this.groupService.findByGroupId(groupId);
        return ResponseEntity.status(HttpStatus.OK).body(groupDTO);
    }

    @PostMapping
    public ResponseEntity<?> createGroup(@Valid @RequestBody GroupDTO groupDTO, Errors errors) throws URISyntaxException {
        if (errors.hasErrors()) throw new ValidationException("Field Validation Errors", errors);
        final Long groupId = this.groupService.createGroup(groupDTO).getGroupId();
        final URI location = new URI("/groups/" + groupId);
        return ResponseEntity.created(location).build();
    }
}
