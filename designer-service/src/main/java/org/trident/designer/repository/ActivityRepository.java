package org.trident.designer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.trident.designer.entity.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

}
