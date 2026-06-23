package com.jv.opsinsight.ops;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OperationServiceTest {
  @Mock OperationEventRepository repository;
  @InjectMocks OperationService service;

  @Test
  void createShouldPersistOperationalEvent() {
    when(repository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));
    var response = service.create(new OperationDtos.CreateOperationEventRequest("Deploy", "New release in production", OperationState.WARNING, OperationEventType.DEPLOYMENT, true));
    assertThat(response.state()).isEqualTo(OperationState.WARNING);
    assertThat(response.type()).isEqualTo(OperationEventType.DEPLOYMENT);
  }
}
