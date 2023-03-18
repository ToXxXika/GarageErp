package com.example.pierp.Controllers;


import com.example.pierp.Services.Implementation.CommonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
//@PreAuthorize("hasAnyRole('RESPONSABLE','ADMIN')")
@CrossOrigin("*")
@RequestMapping("/tache")
public class TacheController {

    @Autowired
    CommonServices commonServices ;

 @PostMapping("/flow/addworkflow")
  //  @PreAuthorize("hasAnyRole('RESPONSABLE','ADMIN')")
    public boolean addPhoto(@RequestBody String photo) throws IOException {
     //TODO: need to add a full workflow here , images implementation work
        return commonServices.photoToByte(photo);
 }

}
