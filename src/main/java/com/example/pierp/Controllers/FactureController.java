package com.example.pierp.Controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasRole('RESPONSABLE')")
@CrossOrigin("*")
@RequestMapping("/facture")
public class FactureController {
}
