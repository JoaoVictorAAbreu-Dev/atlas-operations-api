package com.jv.opsinsight.dashboard;

import com.jv.opsinsight.ops.OperationDtos;
import com.jv.opsinsight.ops.OperationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpsDashboardController {
  private final OperationService service;
  public OpsDashboardController(OperationService service){this.service=service;}
  @GetMapping("/api/dashboard")
  OperationDtos.OpsSnapshot dashboard(){ return service.snapshot(); }
}
