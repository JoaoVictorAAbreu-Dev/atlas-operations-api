package com.jv.opsinsight.ops;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class OperationService {
  private final OperationEventRepository repository;
  public OperationService(OperationEventRepository repository){this.repository=repository;}
  public OperationDtos.OperationEventResponse create(OperationDtos.CreateOperationEventRequest request){
    var event = new OperationEventEntity();
    event.setTitle(request.title().trim()); event.setDetails(request.details().trim()); event.setState(request.state()); event.setType(request.type()); event.setActionable(request.actionable());
    return toResponse(repository.save(event));
  }
  @Transactional(readOnly = true) public List<OperationDtos.OperationEventResponse> list(){ return repository.findAllByOrderByCreatedAtDesc().stream().map(this::toResponse).toList(); }
  @Transactional(readOnly = true) public OperationDtos.OpsSnapshot snapshot(){
    var all = repository.findAll();
    long critical = all.stream().filter(e -> e.getState() == OperationState.CRITICAL).count();
    long actionable = all.stream().filter(OperationEventEntity::isActionable).count();
    int score = Math.max(0, 100 - (int) critical * 25 - (int) actionable * 2);
    return new OperationDtos.OpsSnapshot(all.size(), critical, actionable, score);
  }
  private OperationDtos.OperationEventResponse toResponse(OperationEventEntity e){ return new OperationDtos.OperationEventResponse(e.getId(), e.getTitle(), e.getDetails(), e.getState(), e.getType(), e.isActionable(), e.getCreatedAt()); }
}
