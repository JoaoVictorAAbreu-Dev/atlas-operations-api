package com.jv.opsinsight.ops;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class OperationController {
  private final OperationService service;
  public OperationController(OperationService service){this.service=service;}
  @PostMapping OperationDtos.OperationEventResponse create(@Valid @RequestBody OperationDtos.CreateOperationEventRequest request){ return service.create(request); }
  @GetMapping List<OperationDtos.OperationEventResponse> list(){ return service.list(); }
}
