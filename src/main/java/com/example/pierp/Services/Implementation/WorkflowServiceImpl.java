package com.example.pierp.Services.Implementation;

import com.example.pierp.Models.Workflow;
import com.example.pierp.Repositories.WorkflowRepository;
import com.example.pierp.Services.WorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class WorkflowServiceImpl implements WorkflowService {

    @Autowired
    WorkflowRepository workflowRepository;
    @Autowired
    CommonServicesImpl commonServicesImpl;

    @Override
    public boolean AddWorkflow(Workflow workflow, String photo) {
        try {
            //TODO : we need to  maintin this function  after adding the workflow
            byte[] photoByte = commonServicesImpl.photoToByte(photo);
            workflow.setpAvant(photoByte);
            workflow.setpApres(null); /* this will be updated later when the status of the workflow is changed*/
            workflowRepository.save(workflow);
            return true;

        } catch (Exception e) {
            return false;
        }
    }


    @Override
    public String VerifyWorkflowStatus(String reference) {
        Workflow workflow = workflowRepository.findById(reference).get();
        // TODO : can make a problem here if the workflow is not found
        if (Objects.requireNonNull(workflow).getStatus() == null) {
            return "Workflow not found";
        }

        return workflow.getStatus().toString();

    }

    @Override
    public boolean UpdateWorkflowStatus(String reference, String status) {
        try {
            Workflow workflow;
            if (workflowRepository.findById(reference).isPresent()) {
                workflow = workflowRepository.findById(reference).get();
                workflow.setStatus(status);
                workflowRepository.saveAndFlush(workflow);
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println("Cause: " + e.getCause() + " \n Message  : " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean UpdateWorkFlowImage(String reference, String photo) {
        try {
               if(workflowRepository.findById(reference).isPresent()) {
                   Workflow workflow = workflowRepository.findById(reference).get();
                   byte[] photoByte = commonServicesImpl.photoToByte(photo);
                   workflow.setpApres(photoByte);
                   workflowRepository.save(workflow);
                   return true;
               }
               return false ;
        } catch (Exception e) {
            System.out.println("Cause: " + e.getCause() + " \n Message  : " + e.getMessage());
            return false;
        }
    }
}
