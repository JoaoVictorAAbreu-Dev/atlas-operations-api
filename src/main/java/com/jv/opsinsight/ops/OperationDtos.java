package com.jv.opsinsight.ops;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.UUID;

public final class OperationDtos {
  private OperationDtos() {}
  public record CreateOperationEventRequest(@NotBlank @Size(max = 140) String title, @NotBlank @Size(max = 1000) String details, @NotNull OperationState state, @NotNull OperationEventType type, boolean actionable) {}
  public record OperationEventResponse(UUID id, String title, String details, OperationState state, OperationEventType type, boolean actionable, LocalDateTime createdAt) {}
  public record OpsSnapshot(long totalEvents, long criticalEvents, long actionableEvents, int healthScore) {}
}
