package org.trident.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.trident.account.dto.PolicyDTO;
import org.trident.account.entity.Policy;
import org.trident.account.exception.ValidationException;
import org.trident.account.repository.PolicyRepository;
import org.trident.account.service.PolicyService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PolicyServiceImpl implements PolicyService {

    private PolicyRepository policyRepository;

    @Autowired
    public PolicyServiceImpl(final PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    @Override
    public PolicyDTO createPolicy(final PolicyDTO policyDTO) {
        Policy policy = policyDTO.toEntity();
        policy = this.policyRepository.save(policy);
        return policy.toDto();
    }

    @Override
    public PolicyDTO findByPolicyId(final Long policyId) {
        final Optional<Policy> policy = this.policyRepository.findById(policyId);
        if (policy.isEmpty()) throw new ValidationException("Policy does not exist", null);
        return policy.get().toDto();
    }

    @Override
    public List<PolicyDTO> findAllPolicy() {
        final List<Policy> policies = policyRepository.findAll();
        if (policies.isEmpty()) throw new ValidationException("No policies present", null);
        final List<PolicyDTO> policyDTO = policies.stream().map(policy -> policy.toDto()).collect(Collectors.toList());
        return policyDTO;
    }
}
