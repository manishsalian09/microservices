package org.trident.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.trident.account.dto.PolicyDTO;
import org.trident.account.entity.Policy;
import org.trident.account.exception.ValidationException;
import org.trident.account.service.PolicyService;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("policies")
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @GetMapping("{policyId}")
    public ResponseEntity<?> findByPolicyId(@PathVariable("policyId") Long policyId) {
        final PolicyDTO policyDTO = policyService.findByPolicyId(policyId);
        return ResponseEntity.status(HttpStatus.OK).body(policyDTO);
    }

    @GetMapping
    public ResponseEntity<?> findAllPolicy() {
        final List<PolicyDTO> policyDTO = this.policyService.findAllPolicy();
        return ResponseEntity.status(HttpStatus.OK).body(policyDTO);
    }

    @PostMapping
    public ResponseEntity<?> createPolicy(@Valid @RequestBody PolicyDTO policyDTO, Errors errors) throws URISyntaxException {
        if (errors.hasErrors()) throw new ValidationException("Field Validation Errors", errors);
        final Long policyId = policyService.createPolicy(policyDTO).getPolicyId();
        final URI location = new URI("/policies/" + policyId);
        return ResponseEntity.created(location).build();
    }
}
