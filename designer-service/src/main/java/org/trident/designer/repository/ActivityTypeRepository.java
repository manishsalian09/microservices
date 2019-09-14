package org.trident.designer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.trident.designer.entity.ActivityType;

@Repository
public interface ActivityTypeRepository extends JpaRepository<ActivityType, Long> {

}
