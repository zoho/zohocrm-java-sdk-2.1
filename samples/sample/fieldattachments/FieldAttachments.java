package com.zoho.crm.sample.fieldattachments;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map;

import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.fieldattachments.APIException;
import com.zoho.crm.api.fieldattachments.FieldAttachmentsOperations;
import com.zoho.crm.api.fieldattachments.FileBodyWrapper;
import com.zoho.crm.api.fieldattachments.ResponseHandler;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;
import com.zoho.crm.api.util.StreamWrapper;

public class FieldAttachments {
	/*
	* <h3> Get FieldAttachments</h3>
	 * This method is used to get Field Attachments
	 * @param moduleAPIname The module name of the Module
	 * @param recordId The record Id of the record
	 * @param attachmentID The attachment ID of the attachment
	 * @throws Exception
	 */
	public static void getFieldAttachments(String destinationFolder,String moduleAPIname,Long recordId,Long attachmentID) throws Exception{
		
		//Get instance of FileOperations Class
		FieldAttachmentsOperations fieldAttachmentsOperations = new FieldAttachmentsOperations(moduleAPIname, recordId, attachmentID);
	
		
		//Call getFile method that takes paramInstance as parameters
		APIResponse<ResponseHandler> response = fieldAttachmentsOperations.getFieldAttachments();
		
		if(response != null)
		{
			//Get the status code from response
			System.out.println("Status Code: " + response.getStatusCode());
			
			if(Arrays.asList(204,304).contains(response.getStatusCode()))
			{
				System.out.println(response.getStatusCode() == 204? "No Content" : "Not Modified");
				return;
			}
			
			//Check if expected response is received
			if(response.isExpected())
			{
				//Get object from response
				ResponseHandler responseHandler = response.getObject();
				
				if(responseHandler instanceof FileBodyWrapper)
				{
					//Get object from response
					FileBodyWrapper fileBodyWrapper = (FileBodyWrapper)responseHandler;
					
					//Get StreamWrapper instance from the returned FileBodyWrapper instance
					StreamWrapper streamWrapper = fileBodyWrapper.getFile();
					
					//Create a file instance with the absolute_file_path
					java.io.File file = new java.io.File(destinationFolder + java.io.File.separatorChar + streamWrapper.getName());
					
					//Get InputStream from the response
					InputStream is = streamWrapper.getStream();
					
					//Create an OutputStream for the destination file
					OutputStream os = new FileOutputStream(file);
					
					byte[] buffer = new byte[1024];
					
			        int bytesRead;
			        
			        //read the InputStream till the end
			        while((bytesRead = is.read(buffer)) != -1)
			        {
			        	//write data to OutputStream
			        	os.write(buffer, 0, bytesRead);
			        }
			        
			        //Close the InputStream
			        is.close();
			        
			        //Flush and close the OutputStream
			        os.flush();
			        
			        os.close();
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
			else if(response.getStatusCode() != 204 )
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
