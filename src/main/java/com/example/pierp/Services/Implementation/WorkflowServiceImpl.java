package com.example.pierp.Services.Implementation;

import com.example.pierp.Models.Workflow;
import com.example.pierp.Repositories.WorkflowRepository;
import com.example.pierp.Services.WorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkflowServiceImpl implements WorkflowService {

    @Autowired
    WorkflowRepository workflowRepository;
    @Autowired
    CommonServicesImpl commonServicesImpl;
    @Override
    public boolean AddWorkflow(Workflow workflow,String photo) {
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
        if(workflow == null){
            return "Workflow not found";
        }

            return workflow.getStatus().toString();

    }
}
