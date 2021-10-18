package com.zoho.crm.sample.pipeline;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.crm.api.pipeline.*;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class Pipeline 
{
	/*
	* <h3> to Transfer And Delete</h3>
	 * This method is used to Transfer And Delete
	 * @param LayoutID The id of the Layout
	 * @throws Exception
	 */
	public static void TransferAndDelete(Long LayoutID) throws Exception 
	{
		//Get instance of PipelineOperations Class
		PipelineOperations pipelineOperations = new PipelineOperations(LayoutID);
		
		//Call transferAndDelete method that takes TransferAndDeleteWrapper instance  
		TransferAndDeleteWrapper request = new TransferAndDeleteWrapper();
		ArrayList<TransferPipeLine> transferPipelines = new ArrayList<TransferPipeLine>() ;
		TransferPipeLine transferPipeline = new TransferPipeLine();
		com.zoho.crm.api.pipeline.Pipeline pipeline = new com.zoho.crm.api.pipeline.Pipeline();
		pipeline.setFrom(36523973712004L);
		pipeline.setTo(36523973712004L);
		transferPipeline.setPipeline(pipeline);
		ArrayList<Stage> stages = new ArrayList<Stage>();
		Stage stage = new Stage();
		stage.setFrom(36523970006817L);
		stage.setTo(36523970006819L);
		stages.add(stage);
		transferPipeline.setStages(stages);
		transferPipelines.add(transferPipeline);
		request.setTransferPipeline(transferPipelines);
		APIResponse<TransferActionHandler> response = pipelineOperations.transferAndDelete(request);
		
		if(response != null)
		{
			//Get the status code from response
			System.out.println("Status Code: " + response.getStatusCode());
			
			//Check if expected response is received
			if(response.isExpected())
			{
				//Get object from response
				TransferActionHandler transferActionHandler = response.getObject();
				
				if(transferActionHandler instanceof TransferActionWrapper)
				{
					
					
					//Get the list of obtained ActionResponse instances
					 TransferActionWrapper transferActionWrapper = (TransferActionWrapper) transferActionHandler;
					
					 List<TransferActionResponse> transferPipelines1 = transferActionWrapper.getTransferPipeline();
					 
					for(TransferActionResponse transferPipeline1 : transferPipelines1)
					{
						//Check if the request is successful
						if(transferPipeline1 instanceof SuccessResponse)
						{
							//Get the received SuccessResponse instance
							SuccessResponse successResponse = (SuccessResponse)transferPipeline1;
							
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
						else if(transferPipeline1 instanceof APIException)
						{
							//Get the received APIException instance
							APIException exception = (APIException) transferPipeline1;
							
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
				else if(transferActionHandler instanceof APIException)
				{
					//Get the received APIException instance
					APIException exception = (APIException) transferActionHandler;
					
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
	/*
	* <h3> Get Pipelines</h3>
	 * This method is used to get Pipelines
	 * @param LayoutID The id of the Layout
	 * @throws Exception
	 */
	public static void getPipelines(Long LayoutID) throws Exception
	{
		//Get instance of PipelineOperations Class
		PipelineOperations pipelineOperations = new PipelineOperations(LayoutID);
		
		//Call getPipeline method
		APIResponse<ResponseHandler> response = pipelineOperations.getPipelines();
		
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
					
					//Get the list of obtained Pipeline instances
					List<com.zoho.crm.api.pipeline.Pipeline> pipelines = responseWrapper.getPipeline();
					
					for(com.zoho.crm.api.pipeline.Pipeline pipeline : pipelines)
					{
						//Get the ID of each Pipeline
						System.out.println("Pipeline ID: " + pipeline.getId());

						//Get the default of each Pipeline
						System.out.println("Pipeline default  : " + pipeline.getDefault());
						
						//Get the Display value of each Pipeline
						System.out.println("Pipeline Display value : " + pipeline.getDisplayValue());
						
						//Get the Actual value of each Pipeline
						System.out.println("Pipeline Actual value : " + pipeline.getActualValue());
						
						//Get the child available of each Pipeline
						System.out.println("Pipeline child available  : " + pipeline.getChildAvailable());
						
						com.zoho.crm.api.pipeline.Pipeline parent = pipeline.getParent();
						
						if(parent != null) 
						{
							//Get the ID of  parent
							System.out.println("Pipeline parent ID: " + parent.getId());
						}

						//Get the maps picklist value of each Pipeline
						List<PickListValue> maps = pipeline.getMaps();
						
						for(PickListValue map : maps) 
						{
							//Get PickListValue Display Value
							System.out.println("PickListValue Display Value" + map.getDisplayValue());
							//Get PickListValue sequence number
							System.out.println("PickListValue Sequence Number" + map.getSequenceNumber());

							//Get PickListValue Forecast Category
							ForecastCategory forecastCategory = map.getForecastCategory();
							if (forecastCategory != null) 
							{
								//Get Forecast Category Name
								System.out.println("Forecast Category Name" + forecastCategory.getName());
								//Get Forecast Category id
								System.out.println("Forecast Category ID" + forecastCategory.getId());
							}

							//Get PickListValue Actual Value
							System.out.println("PickListValue Actual Value" + map.getActualValue());

							//Get PickListValue ID
							System.out.println("PickListValue ID" + map.getId());
							//Get PickListValue Forecast type
							System.out.println("PickListValue Forecast type" + map.getForecastType());
							//Get PickListValue delete
							System.out.println("PickListValue delete" + map.getDelete());
						}
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
	* <h3> create Pipelines</h3>
	 * This method is used to create Pipelines
	 * @param LayoutID The id of the Layout
	 * @throws Exception
	 */
	public static void createPipelines(Long LayoutID) throws Exception{
		//Get instance of PipelineOperations Class
		PipelineOperations pipelineOperations = new PipelineOperations(LayoutID);
		
		BodyWrapper bodyWrapper = new BodyWrapper();
		ArrayList<com.zoho.crm.api.pipeline.Pipeline> pipelines= new ArrayList<com.zoho.crm.api.pipeline.Pipeline>();
		com.zoho.crm.api.pipeline.Pipeline pipeLine = new com.zoho.crm.api.pipeline.Pipeline();
		pipeLine.setDisplayValue("Pipeline1");
		pipeLine.setDefault(true);
		ArrayList<PickListValue> maps = new ArrayList<PickListValue>();
		PickListValue pickListValue = new PickListValue();
		pickListValue.setSequenceNumber(1);
		pickListValue.setId(34770610006805l);
		pickListValue.setDisplayValue("Closed Won");
		maps.add(pickListValue );
		pipeLine.setMaps(maps);
		pipelines.add(pipeLine);
		
		bodyWrapper.setPipeline(pipelines);
		//Call createPipeline method that takes BodyWrapper instance as parameter 
		APIResponse<ActionHandler> response = pipelineOperations.createPipelines(bodyWrapper );
		
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
					List<ActionResponse> actionResponses = actionWrapper.getPipeline();
					
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
	/*
	* <h3> update Pipelines</h3>
	 * This method is used to update Pipelines
	 * @param LayoutID The id of the Layout
	 * @throws Exception
	 */
	public static void updatePipelines(Long LayoutID) throws Exception{
		BodyWrapper bodyWrapper = new BodyWrapper();
		ArrayList<com.zoho.crm.api.pipeline.Pipeline> pipelines= new ArrayList<com.zoho.crm.api.pipeline.Pipeline>();
		com.zoho.crm.api.pipeline.Pipeline pipeLine = new com.zoho.crm.api.pipeline.Pipeline();
		pipeLine.setDisplayValue("Pipeline222");
		pipeLine.setDefault(true);
		ArrayList<PickListValue> maps = new ArrayList<PickListValue>();
		PickListValue pickListValue = new PickListValue();
		pickListValue.setSequenceNumber(1);
		pickListValue.setId(34770610006801l);
		pickListValue.setDisplayValue("Closed Won");
		maps.add(pickListValue );
		pipeLine.setMaps(maps);
		pipelines.add(pipeLine);
		pipeLine.setId(34770619599012l);
		
		bodyWrapper.setPipeline(pipelines);
		//Get instance of PipelineOperations Class
		PipelineOperations pipelineOperations = new PipelineOperations(LayoutID);
		
		//Call updatePipelines method that takes BodyWrapper instance as parameter 
		APIResponse<ActionHandler> response = pipelineOperations.updatePipelines(bodyWrapper);
		
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
					List<ActionResponse> actionResponses = actionWrapper.getPipeline();
					
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
	
	/*
	* <h3> Get Pipeline</h3>
	 * This method is used to get single Pipeline
	 * @param LayoutID The id of the Layout
	 * @param pipelineID The id of the pipeline
	 * @throws Exception
	 */
	public static void getPipeline(Long LayoutID,Long pipelineID) throws Exception{
		//Get instance of PipelineOperations Class
		PipelineOperations pipelineOperations = new PipelineOperations(LayoutID);
		
		//Call getPipeline method
		APIResponse<ResponseHandler> response = pipelineOperations.getPipeline(pipelineID);
				
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
					
					//Get the list of obtained Pipeline instances
					List<com.zoho.crm.api.pipeline.Pipeline> pipelines = responseWrapper.getPipeline();
					
					for(com.zoho.crm.api.pipeline.Pipeline pipeline : pipelines)
					{
						//Get the ID of each Pipeline
						System.out.println("Pipeline ID: " + pipeline.getId());
						
						//Get the Display value of each Pipeline
						System.out.println("Pipeline Display value : " + pipeline.getDisplayValue());
						
						//Get the Actual value of each Pipeline
						System.out.println("Pipeline Actual value : " + pipeline.getActualValue());
						
						//Get the default of each Pipeline
						System.out.println("Pipeline default  : " + pipeline.getDefault());
						
						//Get the child available of each Pipeline
						System.out.println("Pipeline child available  : " + pipeline.getChildAvailable());
						
						com.zoho.crm.api.pipeline.Pipeline parent = pipeline.getParent();
						
						if(parent!=null) {
							//Get the ID of  parent
							System.out.println("Pipeline parent ID: " + parent.getId());
						}
						//Get the maps picklist value of each Pipeline
						List<PickListValue> maps = pipeline.getMaps();
						
						for(PickListValue map:maps) {
							//Get PickListValue Actual Value
							System.out.println("PickListValue Actual Value"+map.getActualValue());
							//Get PickListValue delete
							System.out.println("PickListValue delete" +map.getDelete());
							//Get PickListValue Display Value
							System.out.println("PickListValue Display Value"+map.getDisplayValue());
							//Get PickListValue Forecast Category
							ForecastCategory forecastCategory = map.getForecastCategory();
							if (forecastCategory!=null) {
								//Get Forecast Category Name
								System.out.println("Forecast Category Name"+forecastCategory.getName());
								//Get Forecast Category id
								System.out.println("Forecast Category ID" +forecastCategory.getId());
							}
							//Get PickListValue Forecast type
							System.out.println("PickListValue Forecast type"+map.getForecastType());
							//Get PickListValue ID
							System.out.println("PickListValue ID"+map.getId());
							//Get PickListValue sequence number
							System.out.println("PickListValue sequence number"+map.getSequenceNumber());
						}

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
	* <h3> update Pipeline</h3>
	 * This method is used to update Pipeline
	 * @param LayoutID The id of the Layout
	 * @param pipelineID The id of the pipeline
	 * @throws Exception
	 */
	public static void updatePipeline(Long LayoutID,Long pipelineID) throws Exception{
		
		BodyWrapper bodyWrapper = new BodyWrapper();
		ArrayList<com.zoho.crm.api.pipeline.Pipeline> pipelines= new ArrayList<com.zoho.crm.api.pipeline.Pipeline>();
		com.zoho.crm.api.pipeline.Pipeline pipeLine = new com.zoho.crm.api.pipeline.Pipeline();
		pipeLine.setDisplayValue("Adfasfsad112");
		pipeLine.setDefault(true);
		ArrayList<PickListValue> maps = new ArrayList<PickListValue>();
		PickListValue pickListValue = new PickListValue();
		pickListValue.setSequenceNumber(1);
		pickListValue.setId(34770610006801l);
		pickListValue.setDisplayValue("Adfasfsad112");
		maps.add(pickListValue );
		pipeLine.setMaps(maps);
		pipelines.add(pipeLine);
		
		bodyWrapper.setPipeline(pipelines);
		//Get instance of PipelineOperations Class
		PipelineOperations pipelineOperations = new PipelineOperations(LayoutID);
		
		//Call updatePipeline method that takes BodyWrapper instance as parameter 
		APIResponse<ActionHandler> response = pipelineOperations.updatePipeline(pipelineID, bodyWrapper);
		
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
					List<ActionResponse> actionResponses = actionWrapper.getPipeline();
					
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
