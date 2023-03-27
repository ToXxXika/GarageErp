package com.example.pierp;

import com.example.pierp.Controllers.PersonneController;
import com.example.pierp.Controllers.TacheController;
import com.example.pierp.Models.Tache;
import com.example.pierp.Repositories.FactureRepository;
import com.example.pierp.Services.Implementation.TacheServiceImpl;
import com.example.pierp.Services.Implementation.WorkflowServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@WebMvcTest(TacheController.class)

class PierpApplicationTests {
  @Autowired
    private MockMvc mockMvc;
  @MockBean
    private TacheServiceImpl tacheService;
  @MockBean
    private WorkflowServiceImpl workflowService;

  private ObjectMapper objectMapper = new ObjectMapper();

  @Test
    public void testAddTache() throws Exception {
             Tache tacheMock = mock(Tache.class);
      when(tacheService.ajouterTache(any(Tache.class))).thenReturn(true);
     // mockMvc.
  }





}
