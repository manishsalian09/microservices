package org.trident.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.trident.account.entity.Policy;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {
}
