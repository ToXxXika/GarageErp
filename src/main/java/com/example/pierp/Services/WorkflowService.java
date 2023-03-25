package com.example.pierp.Services;

import com.example.pierp.Models.Workflow;

public interface WorkflowService {
  boolean AddWorkflow(Workflow workflow,String photo);
  String VerifyWorkflowStatus(String reference);
  boolean UpdateWorkflowStatus(String reference,String status);
  boolean UpdateWorkFlowImage(String reference,String photo);

}
