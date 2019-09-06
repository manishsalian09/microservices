package org.trident.account.service;

import org.trident.account.dto.PolicyDTO;

import java.util.List;

public interface PolicyService {

    PolicyDTO createPolicy(final PolicyDTO policyDTO);
    PolicyDTO findByPolicyId(final Long policyId);
    List<PolicyDTO> findAllPolicy();
}
