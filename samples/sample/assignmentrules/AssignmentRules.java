package com.zoho.crm.sample.assignmentrules;

import java.util.List;
import java.util.Map;

import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.assignmentrules.APIException;
import com.zoho.crm.api.assignmentrules.AssignmentRulesOperations;
import com.zoho.crm.api.assignmentrules.DefaultUser;
import com.zoho.crm.api.assignmentrules.ResponseHandler;
import com.zoho.crm.api.assignmentrules.ResponseWrapper;
import com.zoho.crm.api.modules.Module;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class AssignmentRules {
	/*
	* <h3> Get AssignmentRules</h3>
	 * This method is used to get assignment rules
	 * @throws Exception
	 */
	public static void getAssignmentRules() throws Exception
	{
		
		//Get instance of AssignmentRulesOperations Class 
		AssignmentRulesOperations assignmentRuleOperations = new AssignmentRulesOperations();
		
		
		//Call getAssignmentRules method
		APIResponse<ResponseHandler> response = assignmentRuleOperations.getAssignmentRules();
		
		if(response != null)
		{
			//Get the status code from response
			System.out.println("Status Code: " + response.getStatusCode());
			
			if(response.getStatusCode()==204)
			{
				System.out.println( "No Content");
				return;
			}
			
			//Check if expected response is received
			if(response.isExpected())
			{
				//Get object from response
				ResponseHandler responseHandler = response.getObject();
				
				if(responseHandler instanceof ResponseWrapper)
				{
					//Get the received ResponseWrapper instance
					ResponseWrapper responseWrapper = (ResponseWrapper) responseHandler;
					
					//Get the list of obtained AssignmentRule instances
					List<com.zoho.crm.api.assignmentrules.AssignmentRule> assignmentRules = responseWrapper.getAssignmentRules();
				
					for(com.zoho.crm.api.assignmentrules.AssignmentRule assignmentRule : assignmentRules)
					{
						
						//Get the modified time of each AssignmentRule
						System.out.println("AssignmentRule Modified Time: " + assignmentRule.getModifiedTime().toString());

						//Get the created time of each AssignmentRule
						System.out.println("AssignmentRule Created Time: " + assignmentRule.getCreatedTime().toString());
						
						//Get the  DefaultUser of each AssignmentRule
						DefaultUser defaultAssignee = assignmentRule.getDefaultAssignee();
						
						//Check if DefaultUser is not null
						if(defaultAssignee != null)
						{
							//Get the Name of the Owner
							System.out.println("AssignmentRule DefaultUser User-ID: " + defaultAssignee.getId());
							
							//Get the ID of the Owner
							System.out.println("AssignmentRule DefaultUser User-Name: " + defaultAssignee.getName());
							
						}
						
						//Get the  Module of each AssignmentRule
						Module module = assignmentRule.getModule();
						
						//Check if Module is not null
						if(module != null)
						{
							//Get the Name of the Owner
							System.out.println("AssignmentRule Module ID: " + module.getId());
							
							//Get the ID of the Owner
							System.out.println("AssignmentRule Module API Name: " + module.getAPIName());
							
						}
						
											
						//Get the name of the AssignmentRule
						System.out.println("AssignmentRule  Name: " + assignmentRule.getName());
						
						//Get the modifiedBy User instance of each AssignmentRule
						com.zoho.crm.api.users.User modifiedBy = assignmentRule.getModifiedBy();
						
						//Check if modifiedBy is not null
						if(modifiedBy != null)
						{
							//Get the Name of the modifiedBy User
							System.out.println("AssignmentRule Modified By User-Name: " + modifiedBy.getName());
							
							//Get the ID of the modifiedBy User
							System.out.println("AssignmentRule Modified By User-ID: " + modifiedBy.getId());
							
							//Get the Email of the modifiedBy User
							System.out.println("AssignmentRule Modified By User-Email: " + modifiedBy.getEmail());
						}	
						//Get the createdBy User instance of each AssignmentRule
						com.zoho.crm.api.users.User createdBy = assignmentRule.getCreatedBy();
						//Check if createdBy is not null
						if(createdBy != null)
						{
							//Get the name of the createdBy User
							System.out.println("AssignmentRule Created By User-Name: " + createdBy.getName());
							
							//Get the ID of the createdBy User
							System.out.println("AssignmentRule Created By User-ID: " + createdBy.getId());
							
							//Get the Email of the createdBy User
							System.out.println("AssignmentRule Created By User-Email: " + createdBy.getEmail());
						}
						
						//Get the ID of each AssignmentRule
						System.out.println("AssignmentRule ID: " + assignmentRule.getId());
						
						//Get the description of each AssignmentRule
						System.out.println("AssignmentRule description: " + assignmentRule.getDescription());
					}
				}
				//Check if the request returned an exception
				else if(responseHandler instanceof APIException)
				{
					//Get the received APIException instance
					APIException exception = (APIException) responseHandler;
					
					//Get the Status
					System.out.println("Status: " + exception.getStatus().getValue());
					
					//Get the Code
					System.out.println("Code: " + exception.getCode().getValue());
					
					System.out.println("Details: " );
					
					//Get the details map
					for(Map.Entry<String, Object> entry : exception.getDetails().entrySet())
					{
						//Get each value in the map
						System.out.println(entry.getKey() + ": " + entry.getValue());
					}
					
					//Get the Message
					System.out.println("Message: " + exception.getMessage().getValue());
				}
			}
			else
			{//If response is not as expected
				
				//Get model object from response
				Model responseObject = response.getModel();
				
				//Get the response object's class
				Class<? extends Model> clas = responseObject.getClass();
				
				//Get all declared fields of the response class
				java.lang.reflect.Field[] fields = clas.getDeclaredFields();
				
				for(java.lang.reflect.Field field : fields)
				{
					//Get each value
					System.out.println(field.getName() + ":" + field.get(responseObject));
				}
			}
		}
	}
	/*
	* <h3> Get AssignmentRule</h3>
	 * This method is used to get a single assignment rule
	 * @throws Exception
	 * @param assignmentRuleID The id of the assignment rule
	*/
	public static void getAssignmentRule(Long assignmentRuleID) throws Exception
	{

		
		//Get instance of AssignmentRulesOperations Class 
		AssignmentRulesOperations assignmentRuleOperations = new AssignmentRulesOperations();
		
		ParameterMap pm = new ParameterMap();
		pm.add(AssignmentRulesOperations.GetAssignmentRuleParam.MODULE, "Leads");
		//Call getAssignmentRules method
		APIResponse<ResponseHandler> response = assignmentRuleOperations.getAssignmentRule(assignmentRuleID,pm);
		
		if(response != null)
		{
			//Get the status code from response
			System.out.println("Status Code: " + response.getStatusCode());
			
			if(response.getStatusCode()==204)
			{
				System.out.println( "No Content");
				return;
			}
			
			//Check if expected response is received
			if(response.isExpected())
			{
				//Get object from response
				ResponseHandler responseHandler = response.getObject();
				
				if(responseHandler instanceof ResponseWrapper)
				{
					//Get the received ResponseWrapper instance
					ResponseWrapper responseWrapper = (ResponseWrapper) responseHandler;
					
					//Get the list of obtained AssignmentRule instances
					List<com.zoho.crm.api.assignmentrules.AssignmentRule> assignmentRules = responseWrapper.getAssignmentRules();
				
					for(com.zoho.crm.api.assignmentrules.AssignmentRule assignmentRule : assignmentRules)
					{
						
						//Get the modified time of each AssignmentRule
						System.out.println("AssignmentRule Modified Time: " + assignmentRule.getModifiedTime().toString());

						//Get the created time of each AssignmentRule
						System.out.println("AssignmentRule Created Time: " + assignmentRule.getCreatedTime().toString());
						
						//Get the  DefaultUser of each AssignmentRule
						DefaultUser defaultAssignee = assignmentRule.getDefaultAssignee();
						
						//Check if DefaultUser is not null
						if(defaultAssignee != null)
						{
							//Get the Name of the Owner
							System.out.println("AssignmentRule DefaultUser User-ID: " + defaultAssignee.getId());
							
							//Get the ID of the Owner
							System.out.println("AssignmentRule DefaultUser User-Name: " + defaultAssignee.getName());
							
						}
						
						//Get the  Module of each AssignmentRule
						Module module = assignmentRule.getModule();
						
						//Check if Module is not null
						if(module != null)
						{
							//Get the Name of the Owner
							System.out.println("AssignmentRule Module ID: " + module.getId());
							
							//Get the ID of the Owner
							System.out.println("AssignmentRule Module API Name: " + module.getAPIName());
							
						}
						
											
						//Get the name of the AssignmentRule
						System.out.println("AssignmentRule  Name: " + assignmentRule.getName());
						
						//Get the modifiedBy User instance of each AssignmentRule
						com.zoho.crm.api.users.User modifiedBy = assignmentRule.getModifiedBy();
						
						//Check if modifiedBy is not null
						if(modifiedBy != null)
						{
							//Get the Name of the modifiedBy User
							System.out.println("AssignmentRule Modified By User-Name: " + modifiedBy.getName());
							
							//Get the ID of the modifiedBy User
							System.out.println("AssignmentRule Modified By User-ID: " + modifiedBy.getId());
							
							//Get the Email of the modifiedBy User
							System.out.println("AssignmentRule Modified By User-Email: " + modifiedBy.getEmail());
						}	
						//Get the createdBy User instance of each AssignmentRule
						com.zoho.crm.api.users.User createdBy = assignmentRule.getCreatedBy();
						//Check if createdBy is not null
						if(createdBy != null)
						{
							//Get the name of the createdBy User
							System.out.println("AssignmentRule Created By User-Name: " + createdBy.getName());
							
							//Get the ID of the createdBy User
							System.out.println("AssignmentRule Created By User-ID: " + createdBy.getId());
							
							//Get the Email of the createdBy User
							System.out.println("AssignmentRule Created By User-Email: " + createdBy.getEmail());
						}
						
						//Get the ID of each AssignmentRule
						System.out.println("AssignmentRule ID: " + assignmentRule.getId());
						
						//Get the description of each AssignmentRule
						System.out.println("AssignmentRule description: " + assignmentRule.getDescription());
					}
				}
				//Check if the request returned an exception
				else if(responseHandler instanceof APIException)
				{
					//Get the received APIException instance
					APIException exception = (APIException) responseHandler;
					
					//Get the Status
					System.out.println("Status: " + exception.getStatus().getValue());
					
					//Get the Code
					System.out.println("Code: " + exception.getCode().getValue());
					
					System.out.println("Details: " );
					
					//Get the details map
					for(Map.Entry<String, Object> entry : exception.getDetails().entrySet())
					{
						//Get each value in the map
						System.out.println(entry.getKey() + ": " + entry.getValue());
					}
					
					//Get the Message
					System.out.println("Message: " + exception.getMessage().getValue());
				}
			}
			else
			{//If response is not as expected
				
				//Get model object from response
				Model responseObject = response.getModel();
				
				//Get the response object's class
				Class<? extends Model> clas = responseObject.getClass();
				
				//Get all declared fields of the response class
				java.lang.reflect.Field[] fields = clas.getDeclaredFields();
				
				for(java.lang.reflect.Field field : fields)
				{
					//Get each value
					System.out.println(field.getName() + ":" + field.get(responseObject));
				}
			}
		}
	}
	
}
