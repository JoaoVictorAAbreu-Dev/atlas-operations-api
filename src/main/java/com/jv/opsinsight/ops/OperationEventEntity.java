package com.jv.opsinsight.ops;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "operation_events")
public class OperationEventEntity {
  @Id @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  @Column(nullable = false, length = 140) private String title;
  @Column(nullable = false, length = 1000) private String details;
  @Enumerated(EnumType.STRING) @Column(nullable = false, length = 20) private OperationState state;
  @Enumerated(EnumType.STRING) @Column(nullable = false, length = 20) private OperationEventType type;
  @Column(nullable = false) private boolean actionable;
  @Column(nullable = false, updatable = false) private LocalDateTime createdAt;
  @PrePersist void prePersist(){ if(state==null) state = OperationState.OK; if(type==null) type = OperationEventType.MANUAL_REVIEW; createdAt = LocalDateTime.now(); }
  public UUID getId(){return id;} public String getTitle(){return title;} public void setTitle(String v){title=v;}
  public String getDetails(){return details;} public void setDetails(String v){details=v;}
  public OperationState getState(){return state;} public void setState(OperationState v){state=v;}
  public OperationEventType getType(){return type;} public void setType(OperationEventType v){type=v;}
  public boolean isActionable(){return actionable;} public void setActionable(boolean v){actionable=v;}
  public LocalDateTime getCreatedAt(){return createdAt;}
}
