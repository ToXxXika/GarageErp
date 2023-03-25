package com.example.pierp.Controllers;


import com.example.pierp.Models.WorkflowBuilder;
import com.example.pierp.Models.Workflow;
import com.example.pierp.Services.Implementation.WorkflowServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@PreAuthorize("hasAnyRole('RESPONSABLE','ADMIN')")
@CrossOrigin("*") /* this is for the front end to access the api */ /*TODO: need to change this to a specific url */
@RequestMapping("/tache")
public class TacheController {

    @Autowired
    WorkflowServiceImpl workflowService;

    @PostMapping("/flow/addworkflow")
    //  @PreAuthorize("hasAnyRole('RESPONSABLE','ADMIN')")
    public ResponseEntity<String> addPhoto(@RequestBody Workflow workflow, @RequestParam(name = "jpg") String photo) throws IOException {
        if (workflowService.AddWorkflow(workflow, photo)) {
            return ResponseEntity.ok("Workflow added successfully");
        }
        return ResponseEntity.badRequest().body("Error while adding the workflow");

    }
    @PostMapping("/flow/test")
    public ResponseEntity<String> addPhoto2(@RequestBody WorkflowBuilder workflowBuilder){
        String photo  = workflowBuilder.getPhoto();
        Workflow workflow= workflowBuilder.getWorkflow();
        System.out.println(workflow);
        if (workflowService.AddWorkflow(workflow, photo)) {
            return ResponseEntity.ok("Workflow added successfully");
        }
        return ResponseEntity.badRequest().body("Error while adding the workflow");

    }

    @GetMapping("/flow/verifyworkflowstatus")
    public ResponseEntity<String> verifyWorkflowStatus(@RequestParam(name = "reference") String reference) {
        String status = workflowService.VerifyWorkflowStatus(reference);
        if (status.equals("Workflow not found")) {
            return ResponseEntity.badRequest().body(status);
        } else {
            return ResponseEntity.ok(status);
        }
    }

}
