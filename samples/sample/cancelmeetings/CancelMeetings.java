package com.zoho.crm.sample.cancelmeetings;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zoho.crm.api.cancelmeetings.APIException;
import com.zoho.crm.api.cancelmeetings.ActionHandler;
import com.zoho.crm.api.cancelmeetings.ActionResponse;
import com.zoho.crm.api.cancelmeetings.ActionWrapper;
import com.zoho.crm.api.cancelmeetings.BodyWrapper;
import com.zoho.crm.api.cancelmeetings.CancelMeetingsOperations;
import com.zoho.crm.api.cancelmeetings.Notify;
import com.zoho.crm.api.cancelmeetings.SuccessResponse;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class CancelMeetings {
	
	public static void cancelmeetings(long event_id,boolean sendcancelmail) throws SDKException, IllegalArgumentException, IllegalAccessException {
		
		//Get instance of CancelMeetingsOperations Class
		CancelMeetingsOperations CMO= new CancelMeetingsOperations(event_id);
		
		//Get instance of BodyWrapper Class
		BodyWrapper request=new BodyWrapper();
		
		//Get instance of Notify Class
		Notify notify= new Notify();
		
		//Set boolean for SendCancellingMail to Notify instance
		notify.setSendCancellingMail(sendcancelmail);
		 
		//Get list of Notify instances
		List<Notify> notify_list = new ArrayList<Notify>();
		
		//Set the notify instance to the List
		notify_list.add(notify);
		
		//Set the List of notify to BodyWrapper instance
		request.setData(notify_list);
		
		//Call cancelmeetings method with BodyWrapper instance as parameter to get the response
		APIResponse<ActionHandler> response= CMO.cancelMeetings(request);

		if(response != null)
		{
			//Get the status code from response
			System.out.println("Status Code: " + response.getStatusCode());
			
			//Check if expected response is received
			if(response.isExpected())
			{
				//Get object from response
				ActionHandler actionHandler = response.getObject();
				
				if(actionHandler instanceof ActionWrapper)
				{
					//Get the received ActionWrapper instance
					ActionWrapper actionWrapper = (ActionWrapper) actionHandler;
					
					//Get the list of obtained ActionResponse instances
					List<ActionResponse> actionResponses = actionWrapper.getData();
					
					for(ActionResponse actionresponse :actionResponses)
					{
						
						if(actionresponse instanceof SuccessResponse)
						{
							//Get the received SuccessResponse instance
							SuccessResponse successResponse = (SuccessResponse)actionresponse;
							
							//Get the Status
							System.out.println("Status: " + successResponse.getStatus().getValue());
							
							//Get the Code
							System.out.println("Code: " + successResponse.getCode().getValue());
							
							System.out.println("Details: " );
							
							//Get the details map
							for(Map.Entry<String, Object> entry : (successResponse.getDetails().entrySet()))
							{
								//Get each value in the map
								System.out.println(entry.getKey() + ": " + entry.getValue());
							}
							
							//Get the Message
							System.out.println("Message: " + successResponse.getMessage().getValue());
						}
					
					//Check if the request returned an exception
						else if(actionresponse instanceof APIException)
						{
							//Get the received APIException instance
							APIException exception = (APIException) actionresponse;
							
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
				}
			//Check if the request returned an exception
			else if(actionHandler instanceof APIException)
			{
				//Get the received APIException instance
				APIException exception = (APIException) actionHandler;
				
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
				Field[] fields = clas.getDeclaredFields();
				
				for(Field field : fields)
				{
					//Get each value
					System.out.println(field.getName() + ":" + field.get(responseObject));
				}
			}
		}			
	}
}
