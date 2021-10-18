package com.zoho.crm.sample.emailtemplates;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.crm.api.emailtemplates.EmailTemplatesOperations;
import com.zoho.crm.api.emailtemplates.EmailTemplatesOperations.GetEmailTemplatesParam;
import com.zoho.crm.api.emailtemplates.ResponseHandler;
import com.zoho.crm.api.emailtemplates.ResponseWrapper;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.emailtemplates.APIException;
import com.zoho.crm.api.emailtemplates.Attachment;
import com.zoho.crm.api.emailtemplates.EmailTemplate;
import com.zoho.crm.api.modules.Module;
import com.zoho.crm.api.record.Info;
import com.zoho.crm.api.users.User;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class EmailTemplates {
	/*
	 * <h3> Get EmailTemplates</h3> This method is used to get Email Templates
	 * 
	 * @throws Exception
	 */
	public static void getEmailTemplates() throws Exception {
		// Get instance of EmailTemplatesOperations Class
		String moduleAPIName = "Deals";
		EmailTemplatesOperations emailTemplatesOperations = new EmailTemplatesOperations();
		
		ParameterMap paramInstance = new ParameterMap();
		
		paramInstance.add(GetEmailTemplatesParam.MODULE, moduleAPIName);

		// Call getEmailTemplates method
		APIResponse<ResponseHandler> response = emailTemplatesOperations.getEmailTemplates(paramInstance);
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

					// Get the list of obtained EmailTemplate instances
					List<EmailTemplate> emailTemplates = responseWrapper.getEmailTemplates();

					for (EmailTemplate emailTemplate : emailTemplates) {

						// Get the CreatedTime of each EmailTemplate
						System.out.println("EmailTemplate CreatedTime: " + emailTemplate.getCreatedTime());

						List<Attachment> attachments = emailTemplate.getAttachments();
						
						if(attachments != null)
						{
							for (Attachment attachment : attachments) {

								// Get the File ID of each Attachment
								System.out.println("EmailTemplate Attachment File ID: " + attachment.getFileId());

								// Get the File Name of each Attachment
								System.out.println("EmailTemplate Attachment File Name: " + attachment.getFileName());

								// Get the Size of Attachment
								System.out.println("EmailTemplate Attachment Size: " + attachment.getSize());

								// Get the ID of Attachment
								System.out.println("EmailTemplate Attachment ID: " + attachment.getId());
							}
						}

						// Get the Subject of each EmailTemplate
						System.out.println("EmailTemplate Subject: " + emailTemplate.getSubject());

						// Get the Module of each EmailTemplate
						Module module = emailTemplate.getModule();
						if (module != null) {
							// Get the ID of Module
							System.out.println("EmailTemplate Module ID: " + module.getId());

							// Get the apiName of Module
							System.out.println("EmailTemplate Module apiName: " + module.getAPIName());
						}
						
						// Get the Type of each EmailTemplate
						System.out.println("EmailTemplate Type: " + emailTemplate.getType());
						
						//Get the  Created by
						User createdBy = emailTemplate.getCreatedBy();
						
						if(createdBy!=null) {
							System.out.println("EmailTemplate Created By Name : " + createdBy.getName());
							System.out.println("EmailTemplate Created By id : " + createdBy.getId());
							System.out.println("EmailTemplate Created By Name : " + createdBy.getEmail());

						}
						// Get the ModifiedTime of each EmailTemplate
						System.out.println("EmailTemplate ModifiedTime: " + emailTemplate.getModifiedTime());
						
						//Get the  Created by
						EmailTemplate folder = emailTemplate.getFolder();
						
						if(folder!=null) {
							System.out.println("EmailTemplate Folder  id : " + folder.getId());
							System.out.println("EmailTemplate Folder  Name : " + folder.getName());

						}
						// Get the Last Usage time of each EmailTemplate
						System.out.println("EmailTemplate Last Usage Time: " + emailTemplate.getLastUsageTime());
						
						// Get the Associated of each EmailTemplate
						System.out.println("EmailTemplate Associated: " + emailTemplate.getAssociated());
						
						// Get the Name of each EmailTemplate
						System.out.println("EmailTemplate Name: " + emailTemplate.getName());
						
						// Get the Consent Linked of each EmailTemplate
						System.out.println("EmailTemplate Consent Linked: " + emailTemplate.getConsentLinked());
						
						//Get the  Modified by
						User modifiedBy = emailTemplate.getModifiedBy();
						
						if(modifiedBy!=null) {
							System.out.println("EmailTemplate Modified By Name : " + modifiedBy.getName());
							System.out.println("EmailTemplate Modified By id : " + modifiedBy.getId());
							System.out.println("EmailTemplate Modified By Name : " + modifiedBy.getEmail());

						}
						
						// Get the ID of each EmailTemplate
						System.out.println("EmailTemplate ID: " + emailTemplate.getId());
						
						// Get the Editor mode of each EmailTemplate
						System.out.println("EmailTemplate : " + emailTemplate.getEditorMode());
						
						System.out.println("EmailTemplate Content: " + emailTemplate.getContent());

						// Get the Description of each EmailTemplate
						System.out.println("EmailTemplate Description: " + emailTemplate.getDescription());

						// Get the EditorMode of each EmailTemplate
						System.out.println("EmailTemplate EditorMode: " + emailTemplate.getEditorMode());

						// Get the Favourite of each EmailTemplate
						System.out.println("EmailTemplate Favourite: " + emailTemplate.getFavorite());
					
						// Get the Favourite of each EmailTemplate
						System.out.println("EmailTemplate Subject: " + emailTemplate.getSubject());

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

				// Get all declared EmailTemplates of the response class
				java.lang.reflect.Field[] Fields = clas.getDeclaredFields();

				for (java.lang.reflect.Field Field : Fields) {
					// Get each value
					System.out.println(Field.getName() + ":" + Field.get(responseObject));
				}
			}
		}
	}

	/*
	 * <h3> Get EmailTemplate</h3> This method is used to get a single Email
	 * Template
	 * 
	 * @param emailTemplateID The id of the Email Template
	 * 
	 * @throws Exception
	 */
	public static void getEmailTemplateById(Long emailTemplateID) throws Exception {
		// Get instance of EmailTemplatesOperations Class
		EmailTemplatesOperations emailTemplatesOperations = new EmailTemplatesOperations();

		APIResponse<ResponseHandler> response = emailTemplatesOperations.getEmailTemplateById(emailTemplateID);
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

					// Get the list of obtained EmailTemplate instances
					List<EmailTemplate> emailTemplates = responseWrapper.getEmailTemplates();

					for (EmailTemplate emailTemplate : emailTemplates) {

						// Get the CreatedTime of each EmailTemplate
						System.out.println("EmailTemplate CreatedTime: " + emailTemplate.getCreatedTime());

						List<Attachment> attachments = emailTemplate.getAttachments();
						
						if(attachments != null)
						{
							for (Attachment attachment : attachments) {

								// Get the File ID of each Attachment
								System.out.println("EmailTemplate Attachment File ID: " + attachment.getFileId());

								// Get the File Name of each Attachment
								System.out.println("EmailTemplate Attachment File Name: " + attachment.getFileName());

								// Get the Size of Attachment
								System.out.println("EmailTemplate Attachment Size: " + attachment.getSize());

								// Get the ID of Attachment
								System.out.println("EmailTemplate Attachment ID: " + attachment.getId());
							}
						}

						// Get the Subject of each EmailTemplate
						System.out.println("EmailTemplate Subject: " + emailTemplate.getSubject());

						// Get the Module of each EmailTemplate
						Module module = emailTemplate.getModule();
						if (module != null) {
							// Get the ID of Module
							System.out.println("EmailTemplate Module ID: " + module.getId());

							// Get the apiName of Module
							System.out.println("EmailTemplate Module apiName: " + module.getAPIName());
						}
						
						// Get the Type of each EmailTemplate
						System.out.println("EmailTemplate Type: " + emailTemplate.getType());
						
						//Get the  Created by
						User createdBy = emailTemplate.getCreatedBy();
						
						if(createdBy!=null) {
							System.out.println("EmailTemplate Created By Name : " + createdBy.getName());
							System.out.println("EmailTemplate Created By id : " + createdBy.getId());
							System.out.println("EmailTemplate Created By Name : " + createdBy.getEmail());

						}
						// Get the ModifiedTime of each EmailTemplate
						System.out.println("EmailTemplate ModifiedTime: " + emailTemplate.getModifiedTime());
						
						//Get the  Created by
						EmailTemplate folder = emailTemplate.getFolder();
						
						if(folder!=null) {
							System.out.println("EmailTemplate Folder  id : " + folder.getId());
							System.out.println("EmailTemplate Folder  Name : " + folder.getName());

						}
						// Get the Last Usage time of each EmailTemplate
						System.out.println("EmailTemplate Last Usage Time: " + emailTemplate.getLastUsageTime());
						
						// Get the Associated of each EmailTemplate
						System.out.println("EmailTemplate Associated: " + emailTemplate.getAssociated());
						
						// Get the Name of each EmailTemplate
						System.out.println("EmailTemplate Name: " + emailTemplate.getName());
						
						// Get the Consent Linked of each EmailTemplate
						System.out.println("EmailTemplate Consent Linked: " + emailTemplate.getConsentLinked());
						
						//Get the  Modified by
						User modifiedBy = emailTemplate.getModifiedBy();
						
						if(modifiedBy!=null) {
							System.out.println("EmailTemplate Modified By Name : " + modifiedBy.getName());
							System.out.println("EmailTemplate Modified By id : " + modifiedBy.getId());
							System.out.println("EmailTemplate Modified By Name : " + modifiedBy.getEmail());

						}
						
						// Get the ID of each EmailTemplate
						System.out.println("EmailTemplate ID: " + emailTemplate.getId());
						
						// Get the Editor mode of each EmailTemplate
						System.out.println("EmailTemplate : " + emailTemplate.getEditorMode());
						
						System.out.println("EmailTemplate Content: " + emailTemplate.getContent());

						// Get the Description of each EmailTemplate
						System.out.println("EmailTemplate Description: " + emailTemplate.getDescription());

						// Get the EditorMode of each EmailTemplate
						System.out.println("EmailTemplate EditorMode: " + emailTemplate.getEditorMode());

						// Get the Favourite of each EmailTemplate
						System.out.println("EmailTemplate Favourite: " + emailTemplate.getFavorite());
					
						// Get the Favourite of each EmailTemplate
						System.out.println("EmailTemplate Subject: " + emailTemplate.getSubject());

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

				// Get all declared EmailTemplates of the response class
				java.lang.reflect.Field[] Fields = clas.getDeclaredFields();

				for (java.lang.reflect.Field Field : Fields) {
					// Get each value
					System.out.println(Field.getName() + ":" + Field.get(responseObject));
				}
			}
		}
	}
}
