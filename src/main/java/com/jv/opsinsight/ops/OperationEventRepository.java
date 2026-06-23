package com.jv.opsinsight.ops;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface OperationEventRepository extends JpaRepository<OperationEventEntity, UUID> {
  List<OperationEventEntity> findAllByOrderByCreatedAtDesc();
}
