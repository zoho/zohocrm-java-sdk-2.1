package com.zoho.crm.sample.inventorytemplates;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.inventorytemplates.APIException;
import com.zoho.crm.api.inventorytemplates.InventoryTemplate;
import com.zoho.crm.api.inventorytemplates.InventoryTemplatesOperations;
import com.zoho.crm.api.inventorytemplates.InventoryTemplatesOperations.GetInventoryTemplatesParam;
import com.zoho.crm.api.inventorytemplates.ResponseHandler;
import com.zoho.crm.api.inventorytemplates.ResponseWrapper;
import com.zoho.crm.api.modules.Module;
import com.zoho.crm.api.record.Info;
import com.zoho.crm.api.users.User;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class InventoryTemplates 
{
	/*
	* <h3> Get InventoryTemplates</h3>
	 * This method is used to get Inventory Templates
	 * @throws Exception
	 */
	public static void getInventoryTemplates() throws Exception
	{	
		// Get instance of InventoryTemplatesOperations Class
		String moduleAPIName = "Quotes";
		String sortby = "modified_time";
		String sortOrder = "desc";
		String category = "created_by_me";
		InventoryTemplatesOperations inventoryTemplatesOperations = new InventoryTemplatesOperations(sortby, sortOrder, category);
		
		ParameterMap paramInstance = new ParameterMap();
		
		paramInstance.add(GetInventoryTemplatesParam.MODULE, moduleAPIName);

		// Call getInventoryTemplates method
		APIResponse<ResponseHandler> response = inventoryTemplatesOperations.getInventoryTemplates(paramInstance);
		if (response != null) {
			// Get the status code from response
			System.out.println("Status Code: " + response.getStatusCode());

			if (Arrays.asList(204, 304).contains(response.getStatusCode())) {
				System.out.println(response.getStatusCode() == 204 ? "No Content" : "Not Modified");
				return;
			}

			// Check if expected response is received
			if (response.isExpected()) {
				// Get object from response
				ResponseHandler responseHandler = response.getObject();

				if (responseHandler instanceof ResponseWrapper) {
					// Get the received ResponseWrapper instance
					ResponseWrapper responseWrapper = (ResponseWrapper) responseHandler;

					// Get the list of obtained InventoryTemplate instances
					List<InventoryTemplate> inventoryTemplates = responseWrapper.getInventoryTemplates();

					for (InventoryTemplate inventoryTemplate : inventoryTemplates) {

						// Get the CreatedTime of each InventoryTemplate
						System.out.println("InventoryTemplate CreatedTime: " + inventoryTemplate.getCreatedTime());


						// Get the Subject of each InventoryTemplate
						System.out.println("InventoryTemplate Subject: " + inventoryTemplate.getSubject());

						// Get the Module of each InventoryTemplate
						Module module = inventoryTemplate.getModule();
						if (module != null) {
							// Get the ID of Module
							System.out.println("InventoryTemplate Module ID: " + module.getId());

							// Get the apiName of Module
							System.out.println("InventoryTemplate Module apiName: " + module.getAPIName());
						}
						
						// Get the Type of each InventoryTemplate
						System.out.println("InventoryTemplate Type: " + inventoryTemplate.getType());
						
						//Get the  Created by
						User createdBy = inventoryTemplate.getCreatedBy();
						
						if(createdBy!=null) {
							System.out.println("InventoryTemplate Created By Name : " + createdBy.getName());
							System.out.println("InventoryTemplate Created By id : " + createdBy.getId());
						}
						// Get the ModifiedTime of each InventoryTemplate
						System.out.println("InventoryTemplate ModifiedTime: " + inventoryTemplate.getModifiedTime());
						
						//Get the  Created by
						InventoryTemplate folder = inventoryTemplate.getFolder();
						
						if(folder!=null) {
							System.out.println("InventoryTemplate Folder  id : " + folder.getId());
							System.out.println("InventoryTemplate Folder  Name : " + folder.getName());

						}
						// Get the Last Usage time of each InventoryTemplate
						System.out.println("InventoryTemplate Last Usage Time: " + inventoryTemplate.getLastUsageTime());
						
						// Get the Associated of each InventoryTemplate
						System.out.println("InventoryTemplate Associated: " + inventoryTemplate.getAssociated());
						
						// Get the Name of each InventoryTemplate
						System.out.println("InventoryTemplate Name: " + inventoryTemplate.getName());
						
						
						//Get the  Modified by
						User modifiedBy = inventoryTemplate.getModifiedBy();
						
						if(modifiedBy!=null) {
							System.out.println("InventoryTemplate Modified By Name : " + modifiedBy.getName());
							System.out.println("InventoryTemplate Modified By id : " + modifiedBy.getId());
						}
						
						// Get the ID of each InventoryTemplate
						System.out.println("InventoryTemplate ID: " + inventoryTemplate.getId());
						
						// Get the Editor mode of each InventoryTemplate
						System.out.println("InventoryTemplate : " + inventoryTemplate.getEditorMode());
						
						System.out.println("InventoryTemplate Content: " + inventoryTemplate.getContent());

						// Get the Description of each InventoryTemplate
						System.out.println("InventoryTemplate Description: " + inventoryTemplate.getDescription());

						// Get the EditorMode of each InventoryTemplate
						System.out.println("InventoryTemplate EditorMode: " + inventoryTemplate.getEditorMode());

						// Get the Favourite of each InventoryTemplate
						System.out.println("InventoryTemplate Favourite: " + inventoryTemplate.getFavorite());
					
						// Get the Favourite of each InventoryTemplate
						System.out.println("InventoryTemplate Subject: " + inventoryTemplate.getSubject());

					}
					
					//Get the Object obtained Info instance
					Info info = responseWrapper.getInfo();
					
					//Check if info is not null
					if(info != null)
					{
						if(info.getPerPage() != null)
						{
							//Get the PerPage of the Info
							System.out.println("Record Info PerPage: " + info.getPerPage().toString());
						}
						
						if(info.getCount() != null)
						{
							//Get the Count of the Info
							System.out.println("Record Info Count: " + info.getCount().toString());
						}
	
						if(info.getPage() != null)
						{
							//Get the Page of the Info
							System.out.println("Record Info Page: " + info.getPage().toString());
						}
						
						if(info.getMoreRecords() != null)
						{
							//Get the MoreRecords of the Info
							System.out.println("Record Info MoreRecords: " + info.getMoreRecords().toString());
						}
					}
				}
				// Check if the request returned an exception
				else if (responseHandler instanceof APIException) {
					// Get the received APIException instance
					APIException exception = (APIException) responseHandler;

					// Get the Status
					System.out.println("Status: " + exception.getStatus().getValue());

					// Get the Code
					System.out.println("Code: " + exception.getCode().getValue());

					System.out.println("Details: ");

					// Get the details map
					for (Map.Entry<String, Object> entry : exception.getDetails().entrySet()) {
						// Get each value in the map
						System.out.println(entry.getKey() + ": " + entry.getValue());
					}

					// Get the Message
					System.out.println("Message: " + exception.getMessage().getValue());
				}
			} else {// If response is not as expected

				// Get model object from response
				Model responseObject = response.getModel();

				// Get the response object's class
				Class<? extends Model> clas = responseObject.getClass();

				// Get all declared InventoryTemplates of the response class
				java.lang.reflect.Field[] Fields = clas.getDeclaredFields();

				for (java.lang.reflect.Field Field : Fields) {
					// Get each value
					System.out.println(Field.getName() + ":" + Field.get(responseObject));
				}
			}
		}	
	}
	/*
	* <h3> Get InventoryTemplates</h3>
	 * This method is used to get Inventory Templates
	 * @param InventoryTemplateID The id of the Inventory Template
	 * @throws Exception
	 */
	public static void getInventoryTemplate(Long InventoryTemplateID) throws Exception{
		// Get instance of InventoryTemplatesOperations Class
		String sortby ="modified_time";
		String sortOrder = "desc";
		String category = "created_by_me";
		InventoryTemplatesOperations inventoryTemplatesOperations = new InventoryTemplatesOperations(sortby, sortOrder, category);

		// Call getInventoryTemplates method

		APIResponse<ResponseHandler> response = inventoryTemplatesOperations.getInventoryTemplateById(InventoryTemplateID);
		if (response != null) {
			// Get the status code from response
			System.out.println("Status Code: " + response.getStatusCode());

			if (Arrays.asList(204, 304).contains(response.getStatusCode())) {
				System.out.println(response.getStatusCode() == 204 ? "No Content" : "Not Modified");
				return;
			}

			// Check if expected response is received
			if (response.isExpected()) {
				// Get object from response
				ResponseHandler responseHandler = response.getObject();

				if (responseHandler instanceof ResponseWrapper) {
					// Get the received ResponseWrapper instance
					ResponseWrapper responseWrapper = (ResponseWrapper) responseHandler;

					// Get the list of obtained InventoryTemplate instances
					List<InventoryTemplate> inventoryTemplates = responseWrapper.getInventoryTemplates();

					for (InventoryTemplate inventoryTemplate : inventoryTemplates) {

						// Get the CreatedTime of each InventoryTemplate
						System.out.println("InventoryTemplate CreatedTime: " + inventoryTemplate.getCreatedTime());


						// Get the Subject of each InventoryTemplate
						System.out.println("InventoryTemplate Subject: " + inventoryTemplate.getSubject());

						// Get the Module of each InventoryTemplate
						Module module = inventoryTemplate.getModule();
						if (module != null) {
							// Get the ID of Module
							System.out.println("InventoryTemplate Module ID: " + module.getId());

							// Get the apiName of Module
							System.out.println("InventoryTemplate Module apiName: " + module.getAPIName());
						}
						
						// Get the Type of each InventoryTemplate
						System.out.println("InventoryTemplate Type: " + inventoryTemplate.getType());
						
						//Get the  Created by
						User createdBy = inventoryTemplate.getCreatedBy();
						
						if(createdBy!=null) {
							System.out.println("InventoryTemplate Created By Name : " + createdBy.getName());
							System.out.println("InventoryTemplate Created By id : " + createdBy.getId());

						}
						// Get the ModifiedTime of each InventoryTemplate
						System.out.println("InventoryTemplate ModifiedTime: " + inventoryTemplate.getModifiedTime());
						
						//Get the  Created by
						InventoryTemplate folder = inventoryTemplate.getFolder();
						
						if(folder!=null) {
							System.out.println("InventoryTemplate Folder  id : " + folder.getId());
							System.out.println("InventoryTemplate Folder  Name : " + folder.getName());

						}
						// Get the Last Usage time of each InventoryTemplate
						System.out.println("InventoryTemplate Last Usage Time: " + inventoryTemplate.getLastUsageTime());
						
						// Get the Associated of each InventoryTemplate
						System.out.println("InventoryTemplate Associated: " + inventoryTemplate.getAssociated());
						
						// Get the Name of each InventoryTemplate
						System.out.println("InventoryTemplate Name: " + inventoryTemplate.getName());
						
						
						//Get the  Modified by
						User modifiedBy = inventoryTemplate.getModifiedBy();
						
						if(modifiedBy!=null) {
							System.out.println("InventoryTemplate Modified By Name : " + modifiedBy.getName());
							System.out.println("InventoryTemplate Modified By id : " + modifiedBy.getId());

						}
						
						// Get the ID of each InventoryTemplate
						System.out.println("InventoryTemplate ID: " + inventoryTemplate.getId());
						
						// Get the Editor mode of each InventoryTemplate
						System.out.println("InventoryTemplate : " + inventoryTemplate.getEditorMode());
						
						System.out.println("InventoryTemplate Content: " + inventoryTemplate.getContent());

						// Get the Description of each InventoryTemplate
						System.out.println("InventoryTemplate Description: " + inventoryTemplate.getDescription());

						// Get the EditorMode of each InventoryTemplate
						System.out.println("InventoryTemplate EditorMode: " + inventoryTemplate.getEditorMode());

						// Get the Favourite of each InventoryTemplate
						System.out.println("InventoryTemplate Favourite: " + inventoryTemplate.getFavorite());
					
						// Get the Favourite of each InventoryTemplate
						System.out.println("InventoryTemplate Subject: " + inventoryTemplate.getSubject());

					}
				}
				// Check if the request returned an exception
				else if (responseHandler instanceof APIException) {
					// Get the received APIException instance
					APIException exception = (APIException) responseHandler;

					// Get the Status
					System.out.println("Status: " + exception.getStatus().getValue());

					// Get the Code
					System.out.println("Code: " + exception.getCode().getValue());

					System.out.println("Details: ");

					// Get the details map
					for (Map.Entry<String, Object> entry : exception.getDetails().entrySet()) {
						// Get each value in the map
						System.out.println(entry.getKey() + ": " + entry.getValue());
					}

					// Get the Message
					System.out.println("Message: " + exception.getMessage().getValue());
				}
			} else {// If response is not as expected

				// Get model object from response
				Model responseObject = response.getModel();

				// Get the response object's class
				Class<? extends Model> clas = responseObject.getClass();

				// Get all declared InventoryTemplates of the response class
				java.lang.reflect.Field[] Fields = clas.getDeclaredFields();

				for (java.lang.reflect.Field Field : Fields) {
					// Get each value
					System.out.println(Field.getName() + ":" + Field.get(responseObject));
				}
			}
		}
	}
}
