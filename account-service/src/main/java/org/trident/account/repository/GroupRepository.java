package org.trident.account.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.trident.account.entity.Group;

@Repository
public interface GroupRepository extends CrudRepository<Group, Long> {
}
