package com.jv.opsinsight.ops;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class OperationControllerIntegrationTest {
  @Autowired MockMvc mockMvc;
  @Autowired ObjectMapper objectMapper;

  @Test
  void shouldRequireAuthenticationForEventsEndpoint() throws Exception {
    mockMvc.perform(get("/api/events")).andExpect(status().isUnauthorized());
  }

  @Test
  void shouldExposeEventsEndpointWithBearerToken() throws Exception {
    var token = loginAndGetToken();

    mockMvc.perform(get("/api/events").header("Authorization", "Bearer " + token))
        .andDo(print())
        .andExpect(status().isOk());
  }

  private String loginAndGetToken() throws Exception {
    var response = mockMvc.perform(post("/api/auth/login")
            .contentType(MediaType.APPLICATION_JSON)
            .content("""
                {"email":"demo@atlasops.dev","password":"atlas123"}
                """))
        .andExpect(status().isOk())
        .andReturn()
        .getResponse()
        .getContentAsString();

    JsonNode node = objectMapper.readTree(response);
    return node.get("token").asText();
  }
}
