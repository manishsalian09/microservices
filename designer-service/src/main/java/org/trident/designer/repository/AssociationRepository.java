package org.trident.designer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.trident.designer.entity.Association;

@Repository
public interface AssociationRepository extends JpaRepository<Association, Long> {

}
