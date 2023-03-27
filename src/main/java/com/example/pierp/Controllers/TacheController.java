package com.example.pierp.Controllers;


import com.example.pierp.Models.Tache;
import com.example.pierp.Models.WorkflowBuilder;
import com.example.pierp.Models.Workflow;
import com.example.pierp.Services.Implementation.TacheServiceImpl;
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

    @Autowired
    TacheServiceImpl tacheService;


    @PostMapping("/addtache")
    public ResponseEntity<String> addTache(@RequestBody Tache tache){
        if (tacheService.ajouterTache(tache)) {
            return ResponseEntity.ok("Tache added successfully");
        }
        return ResponseEntity.badRequest().body("Error while adding the tache");
    }
    @GetMapping("/get_taches_byuser")
    public ResponseEntity<?> getTachesByUser(@RequestParam(name = "username") String username){
        return ResponseEntity.ok(tacheService.getTachesByUser(username));
    }
    @DeleteMapping("/deletetache")
    public ResponseEntity<String> deleteTache(@RequestParam(name = "reference") String reference){
        if (tacheService.supprimerTache(reference)) {
            return ResponseEntity.ok("Tache deleted successfully");
        }
        return ResponseEntity.badRequest().body("Error while deleting the tache");
    }
    @PutMapping("/updatetache")
    public ResponseEntity<String> updateTache(@RequestParam(name = "reference") String reference, @RequestParam(name = "etat") String etat){
        if (tacheService.modifierEtatTache(reference, etat)) {
            return ResponseEntity.ok("Tache updated successfully");
        }
        return ResponseEntity.badRequest().body("Error while updating the tache");
    }

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
    @PutMapping("/flow/updateworkflow")
    public ResponseEntity<String> updateWorkflow(@RequestParam(name = "reference") String reference, @RequestParam(name = "status") String status) {
        if (workflowService.UpdateWorkflowStatus(reference, status)) {
            return ResponseEntity.ok("Workflow status updated successfully");
        }
        return ResponseEntity.badRequest().body("verify updateworkflow method in workflow controller");
    }
    @PutMapping("/flow/update_workflow_image")
    public ResponseEntity<String> updateWorkflowImage(@RequestParam(name = "reference") String reference, @RequestParam(name = "jpg") String photo) throws IOException {
        if (workflowService.UpdateWorkFlowImage(reference, photo)) {
            return ResponseEntity.ok("Workflow image updated successfully");
        }
        return ResponseEntity.badRequest().body("verify updateworkflow method in workflow controller");
    }

}
