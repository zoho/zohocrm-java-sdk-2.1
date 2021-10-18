package com.zoho.crm.sample.sendmail;

import java.lang.reflect.Field;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.crm.api.attachments.Attachment;
import com.zoho.crm.api.emailtemplates.EmailTemplate;
import com.zoho.crm.api.sendmail.APIException;
import com.zoho.crm.api.sendmail.ActionHandler;
import com.zoho.crm.api.sendmail.ActionResponse;
import com.zoho.crm.api.sendmail.ActionWrapper;
import com.zoho.crm.api.sendmail.BodyWrapper;
import com.zoho.crm.api.sendmail.Mail;
import com.zoho.crm.api.sendmail.ResponseHandler;
import com.zoho.crm.api.sendmail.ResponseWrapper;
import com.zoho.crm.api.sendmail.SendMailOperations;
import com.zoho.crm.api.sendmail.SuccessResponse;
import com.zoho.crm.api.sendmail.UserAddress;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class SendMail {
	/*
	* <h3> get Email Addresses</h3>
	 * This method is used to get Email Addresses
	 * @throws Exception
	 */
	public static void getEmailAddresses() throws Exception{

		//Get instance of SendMailOperations Class
		SendMailOperations sendMailsOperations = new SendMailOperations();
		
		//Call getEmailAddresses method
		APIResponse<ResponseHandler> response = sendMailsOperations.getEmailAddresses();
		
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
				
				if(responseHandler instanceof ResponseWrapper)
				{
					//Get the received ResponseWrapper instance
					ResponseWrapper responseWrapper = (ResponseWrapper) responseHandler;

					//Get the list of obtained UserAdress instances
					List<UserAddress> userAddresses = responseWrapper.getFromAddresses();
					for(UserAddress userAddress : userAddresses)
					{
						//Get the ID of each UserAdress
						System.out.println("UserAdress ID: " + userAddress.getId());
						
						//Get the Email of each UserAdress
						System.out.println("UserAdress Email: " + userAddress.getEmail());
						
						//Get the Type of each UserAdress
						System.out.println("UserAdress Type: " + userAddress.getType());

						//Get the UserName of each UserAdress
						System.out.println("UserAdress UserName: " + userAddress.getUserName());
						
						//Get the Default of each UserAdress
						System.out.println("UserAdress Default: " + userAddress.getDefault());
						
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
			else if(response.getStatusCode() != 204 )
			{//If response is not as expected
				
				//Get model object from response
				Model responseObject = response.getModel();
				
				//Get the response object's class
				Class<? extends Model> clas = responseObject.getClass();
				
				//Get all declared fields of the response class
				Field[] fields = clas.getDeclaredFields();
				
				for(Field field : fields)
				{
					field.setAccessible(true);
					
					//Get each value
					System.out.println(field.getName() + ":" + field.get(responseObject));
				}
			}
		}
	
	}
	/*
	* <h3> send Mail</h3>
	 * This method is used to send Mail
	 * @param recordID The id of the record
	 * @param moduleAPIName The api name of the module
	 * @throws Exception
	 */
	public static void sendMail(Long recordID, String moduleAPIName) throws Exception{

		//Get instance of SendMailOperations Class
		SendMailOperations sendMailOperations = new SendMailOperations();
		
		//Get instance of BodyWrapper Class that will contain the request body
		BodyWrapper bodyWrapper = new BodyWrapper();
		
		
		//List of SendMail instances
		List<Mail> mails = new ArrayList<Mail>();
		
		for(int i = 1; i <= 1; i++)
		{
			//Get instance of SendMail Class
			Mail mail = new Mail();
			UserAddress userAddressFrom = new UserAddress();
			UserAddress userAddressTo = new UserAddress();
			UserAddress userAddressCc = new UserAddress();
			UserAddress userAddressBcc = new UserAddress();
			UserAddress userAddressReplyTo = new UserAddress();
	        Attachment attachment = new Attachment();
	        attachment.setId("2cceafa194d037b63f2000181dd81864b4812b1f8b0b4fe0949a982de89fa75a");
	        EmailTemplate template = new EmailTemplate();
	        template.setId(36523972497001L);
	        userAddressFrom.setUserName("patricia Boyle");
	        userAddressFrom.setEmail("patricia.a@zohocorp.com");
	        userAddressTo.setUserName("Jason Smith");
	        userAddressTo.setEmail("patricia.a@zohocorp.com");
	        userAddressCc.setUserName("Jasweon Smith");
	        userAddressCc.setEmail("patricia.a@zohocorp.com");
	        userAddressBcc.setUserName("Jassdon Smith");
	        userAddressBcc.setEmail("patricia.a@zohocorp.com");
	        userAddressReplyTo.setUserName("Jassdon Smith");
	        userAddressReplyTo.setEmail("patricia.a@zohocorp.com");
	       
	        mail.setFrom(userAddressFrom);
	        ArrayList<UserAddress> userAddressesTo =new ArrayList<UserAddress>();
	        userAddressesTo.add(userAddressTo);
			mail.setTo(userAddressesTo);
			ArrayList<UserAddress> userAddressesBcc =new ArrayList<UserAddress>();
	        userAddressesBcc.add(userAddressBcc);
			mail.setBcc(userAddressesBcc);
			ArrayList<UserAddress> userAddressesCc = new ArrayList<UserAddress>();
	        userAddressesCc.add(userAddressCc);
			mail.setCc(userAddressesCc);
	        mail.setReplyTo(userAddressReplyTo);
	        mail.setOrgEmail(false);
	        mail.setInReplyTo("2cceafa194d037b63f2000181dd8186486f1eb0360aee76d802b6d376dea97e7");
	        OffsetDateTime scheduledTIme=OffsetDateTime.of(2021, 07, 02, 11, 00, 01, 00, ZoneOffset.of("+05:30"));
			mail.setScheduledTime(scheduledTIme);
	        mail.setSubject("Testing Send Mail API");
	        mail.setContent("<h3><span style=\"background-color: rgb(254, 255, 102)\">Mail is of rich text format</span></h3><h3><span style=\"background-color: rgb(254, 255, 102)\"><img src=\"https://www.zohoapis.com/crm/viewInLineImage?fileContent=2cceafa194d037b63f2000181dd818646fd5e5167a274098b625c35654a20ed2\"></span></h3><h3><span style=\"background-color: rgb(254, 255, 102)\">REGARDS,</span></h3><div><span style=\"background-color: rgb(254, 255, 102)\">AZ</span></div><div><span style=\"background-color: rgb(254, 255, 102)\">ADMIN</span></div> <div></div>");
	        mail.setMailFormat("html");
	        mails.add(mail);
		}
		
		//Set the list to sendMail in BodyWrapper instance
		bodyWrapper.setData(mails);
		
		//Call createSendMail method that takes BodyWrapper instance as parameter 
		APIResponse<ActionHandler> response = sendMailOperations.sendMail(recordID, moduleAPIName, bodyWrapper);
		
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
					
					for(ActionResponse actionResponse : actionResponses)
					{
						//Check if the request is successful
						if(actionResponse instanceof SuccessResponse)
						{
							//Get the received SuccessResponse instance
							SuccessResponse successResponse = (SuccessResponse)actionResponse;
							
							//Get the Status
							System.out.println("Status: " + successResponse.getStatus().getValue());
							
							//Get the Code
							System.out.println("Code: " + successResponse.getCode().getValue());
							
							System.out.println("Details: " );
							
							//Get the details map
							for(Map.Entry<String, Object> entry : successResponse.getDetails().entrySet())
							{
								//Get each value in the map
								System.out.println(entry.getKey() + ": " + entry.getValue());
							}
							
							//Get the Message
							System.out.println("Message: " + successResponse.getMessage().getValue());
						}
						//Check if the request returned an exception
						else if(actionResponse instanceof APIException)
						{
							//Get the received APIException instance
							APIException exception = (APIException) actionResponse;
							
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
