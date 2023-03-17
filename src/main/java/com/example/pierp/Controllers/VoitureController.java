package com.example.pierp.Controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/voiture")
@PreAuthorize("hasRole('RESPONSABLE')")
public class VoitureController {

}
