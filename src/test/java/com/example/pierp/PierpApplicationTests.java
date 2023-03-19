package com.example.pierp;

import com.example.pierp.Controllers.PersonneController;
import com.example.pierp.Repositories.FactureRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PierpApplicationTests {
    PersonneController pc = new PersonneController();
    @Mock
    FactureRepository fr;


    @Test
    void contextLoads() {

    }





}
