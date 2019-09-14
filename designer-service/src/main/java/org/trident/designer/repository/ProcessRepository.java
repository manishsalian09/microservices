package org.trident.designer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.trident.designer.entity.Process;

@Repository
public interface ProcessRepository extends JpaRepository<Process, Long> {

}
