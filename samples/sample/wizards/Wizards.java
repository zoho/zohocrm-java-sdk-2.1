package com.zoho.crm.sample.wizards;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.customviews.Criteria;
import com.zoho.crm.api.fields.Field;
import com.zoho.crm.api.layouts.Layout;
import com.zoho.crm.api.modules.Module;
import com.zoho.crm.api.profiles.Profile;
import com.zoho.crm.api.users.User;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;
import com.zoho.crm.api.wizards.APIException;
import com.zoho.crm.api.wizards.Button;
import com.zoho.crm.api.wizards.ChartData;
import com.zoho.crm.api.wizards.Container;
import com.zoho.crm.api.wizards.Node;
import com.zoho.crm.api.wizards.ResponseHandler;
import com.zoho.crm.api.wizards.ResponseWrapper;
import com.zoho.crm.api.wizards.Screen;
import com.zoho.crm.api.wizards.Segment;
import com.zoho.crm.api.wizards.Wizard;
import com.zoho.crm.api.wizards.WizardsOperations;

public class Wizards {
	/*
	* <h3> get Wizards</h3>
	 * This method is used to get Wizards
	 * @throws Exception
	 */
	public static void getWizards() throws Exception{
		// Get instance of WizardsOperations Class
		WizardsOperations wizardsOperations = new WizardsOperations();

		// Call getWizards method

		APIResponse<ResponseHandler> response = wizardsOperations.getWizards();
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

					// Get the list of obtained Wizard instances
					List<Wizard> wizards = responseWrapper.getWizards();

					for (Wizard wizard : wizards) {

						// Get the CreatedTime of each Wizard
						System.out.println("Wizard CreatedTime: " + wizard.getCreatedTime());
						
						// Get the ModifiedTime of each Wizard
						System.out.println("Wizard ModifiedTime: " + wizard.getModifiedTime());
						
						// Get the Module of each Wizard
						Module module = wizard.getModule();
						if (module != null) {
							// Get the ID of Module
							System.out.println("Wizard Module ID: " + module.getId());

							// Get the apiName of Module
							System.out.println("Wizard Module apiName: " + module.getAPIName());
						}
						// Get the Name of each Wizard
						System.out.println("Wizard Name: " + wizard.getName());
						
						//Get the  Modified by
						User modifiedBy = wizard.getModifiedBy();
						
						if(modifiedBy!=null) {
							System.out.println("Wizard Modified By Name : " + modifiedBy.getName());
							System.out.println("Wizard Modified By id : " + modifiedBy.getId());
							System.out.println("Wizard Modified By Name : " + modifiedBy.getEmail());

						}

						List<Profile> profiles = wizard.getProfiles();

						for (Profile profile : profiles) {

							// Get the  Name of each Profile
							System.out.println("Wizard Profile  Name: " + profile.getName());

							// Get the ID of Attachment
							System.out.println("Wizard Profile ID: " + profile.getId());
						}
						
						// Get the active of each Wizard
						System.out.println("Wizard Active: " + wizard.getActive());
						
						// Get the containers of each Wizard
						List<Container> containers = wizard.getContainers();
						
						for (Container container : containers) {
							// Get the id of each Container
							System.out.println("Wizard Container ID: " + container.getId());
							
							// Get the layout  of each Container
							Layout layout = container.getLayout();
							if (layout!=null) {
								//get  Layout ID
								System.out.println("Wizard Container Layout ID: "+layout.getId());
								//get  Layout Name
								System.out.println("Wizard Container Layout Name: "+layout.getName());
							}
							ChartData chartData = container.getChartData();
							if(chartData!=null) {
								//get  Chart nodes
								List<Node> nodes = chartData.getNodes();
								
								for(Node node : nodes) {
									//get Node poistion y
									System.out.println("Chart Data Node poistion y: "+node.getPosY());
									//get Node poistion x
									System.out.println("Chart Data Node poistion X: "+node.getPosX());
									//get Node start node
									System.out.println("Chart Data Node start node: "+node.getStartNode());
									//get Node screen
									
									Screen nodeScreen = node.getScreen();
									if(nodeScreen!=null){
										//get  screens id
										System.out.println(" screens id: "+nodeScreen.getId());
										//get  display label
										System.out.println("display label: "+nodeScreen.getDisplayLabel());
									}

								}
								//get  Chart connections
								List<com.zoho.crm.api.wizards.Connection> connections = chartData.getConnections();
								for(com.zoho.crm.api.wizards.Connection connection : connections) {
									//get connection target screen
									Screen connectionScreen = connection.getTargetScreen();
									if(connectionScreen!=null){
										//get  screens id
										System.out.println(" screens id: "+connectionScreen.getId());
										//get  display label
										System.out.println("display label: "+connectionScreen.getDisplayLabel());
									}
									//get connection source button
									Button connectionButton = connection.getSourceButton();
									if(connectionButton!=null){
										//get  connectionButton id
										System.out.println(" button id: "+connectionButton.getId());
										//get  display label
										System.out.println("display label: "+connectionButton.getDisplayLabel());
									}
								}
								//get  Chart Data Canvas width
								System.out.println("Chart Data Canvas width: "+chartData.getCanvasWidth());
								//get  Chart Data Canvas height
								System.out.println("Chart Data Canvas height: "+chartData.getCanvasHeight());
								
							}
							
							List<Screen> screens = container.getScreens();
							
							if(screens != null)
							{
								for(Screen screen : screens) {
									//get  screens id
									System.out.println(" screens id: "+screen.getId());
									//get  display label
									System.out.println("display label: "+screen.getDisplayLabel());
									//get  segments
									List<Segment> segments = screen.getSegments();
									for (Segment segment:segments) {
										//get  screens segment id
										System.out.println("screens segment id: "+segment.getId());
										//get  screens segment sequence number
										System.out.println("screens segment equence number: "+segment.getSequenceNumber());
										//get  screens segment display label
										System.out.println("screens segment display label: "+segment.getDisplayLabel());
										//get  screens segment type
										System.out.println("screens segment type: "+segment.getType());
										//get  screens segment column count
										System.out.println("screens segment column count: "+segment.getColumnCount());
										List<Field> fields = segment.getFields();
										for (Field field :fields) {
											//get  screens segment field id
											System.out.println("screens segment field id: "+field.getId());
											//get  screens segment field apiname
											System.out.println("screens segment field apiname: "+field.getAPIName());
										}
										//get  screens segment Buttons
										List<Button> buttons = segment.getButtons();
										for(Button button:buttons) {
											//get  screens segment Button critera
											Criteria criteria = button.getCriteria();
											
											if(criteria!=null) {
												printCriteria(criteria);
											}
											//get Button target screen
											Screen targetScreen = button.getTargetScreen();
											if(targetScreen!=null) {
												//get Button target screen id 
												System.out.println(" Button targetScreen id : "+targetScreen.getId());
												//get Button target screen display label
												System.out.println(" Button targetScreen display label: "+targetScreen.getDisplayLabel());
											}
											//get Button display label
											System.out.println(" Button display label: "+button.getDisplayLabel());
											//get Button id
											System.out.println(" Button id: "+button.getId());
											//get Button display label
											System.out.println(" Button display label: "+button.getDisplayLabel());
											//get Button type
											System.out.println(" Button type: "+button.getType());
											//get Button bg color
											System.out.println(" Button bg color: "+button.getBackgroundColor());
											//get Button sequence number
											System.out.println(" Button sequence number: "+button.getSequenceNumber());
											//get Button color 
											System.out.println(" Button color: "+button.getColor());
											//get Button shape
											System.out.println(" Button shape: "+button.getShape());
											//get Button sequence number
											System.out.println(" Button sequence number: "+button.getSequenceNumber());
										}
									}
								}
							}
						}
						
						//Get the  Created by
						User createdBy = wizard.getCreatedBy();
						
						if(createdBy!=null) {
							System.out.println("Wizard Created By Name : " + createdBy.getName());
							System.out.println("Wizard Created By id : " + createdBy.getId());
							System.out.println("Wizard Created By Name : " + createdBy.getEmail());

						}
						
						//Get the  parent Wizard 
						Wizard parentWizard = wizard.getParentWizard();
						
						if(parentWizard!=null) {
							System.out.println("Wizard parent Wizard  id : " + parentWizard.getId());
							System.out.println("Wizard parent Wizard  Name : " + parentWizard.getName());

						}
						// Get the draft of each Wizard
						System.out.println("Wizard Draft: " + wizard.getDraft());
						
						// Get the ID of each Wizard
						System.out.println("Wizard ID: " + wizard.getId());
						

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

				// Get all declared Wizards of the response class
				java.lang.reflect.Field[] Fields = clas.getDeclaredFields();

				for (java.lang.reflect.Field Field : Fields) {
					// Get each value
					System.out.println(Field.getName() + ":" + Field.get(responseObject));
				}
			}
		}
	}
	/*
	* <h3> get Wizard</h3>
	 * This method is used to get single Wizard
	 * @param wizardID  id of the wizard
	 * @throws Exception
	 */
	public static void getWizard(Long wizardID) throws Exception{
		// Get instance of WizardsOperations Class
		WizardsOperations wizardsOperations = new WizardsOperations();
		ParameterMap paramInstance = new ParameterMap();
		// Call getWizardbyid method
		paramInstance.add(WizardsOperations.GetWizardbyIDParam.LAYOUT_ID, "34770610091055");
		APIResponse<ResponseHandler> response = wizardsOperations.getWizardById(wizardID, paramInstance);
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

					// Get the list of obtained Wizard instances
					List<Wizard> wizards = responseWrapper.getWizards();

					for (Wizard wizard : wizards) {

						// Get the CreatedTime of each Wizard
						System.out.println("Wizard CreatedTime: " + wizard.getCreatedTime());
						
						// Get the ModifiedTime of each Wizard
						System.out.println("Wizard ModifiedTime: " + wizard.getModifiedTime());
						
						// Get the Module of each Wizard
						Module module = wizard.getModule();
						if (module != null) {
							// Get the ID of Module
							System.out.println("Wizard Module ID: " + module.getId());

							// Get the apiName of Module
							System.out.println("Wizard Module apiName: " + module.getAPIName());
						}
						// Get the Name of each Wizard
						System.out.println("Wizard Name: " + wizard.getName());
						
						//Get the  Modified by
						User modifiedBy = wizard.getModifiedBy();
						
						if(modifiedBy!=null) {
							System.out.println("Wizard Modified By Name : " + modifiedBy.getName());
							System.out.println("Wizard Modified By id : " + modifiedBy.getId());
							System.out.println("Wizard Modified By Name : " + modifiedBy.getEmail());

						}

						List<Profile> profiles = wizard.getProfiles();

						for (Profile profile : profiles) {

							// Get the  Name of each Profile
							System.out.println("Wizard Profile  Name: " + profile.getName());

							// Get the ID of Attachment
							System.out.println("Wizard Profile ID: " + profile.getId());
						}
						
						// Get the active of each Wizard
						System.out.println("Wizard Active: " + wizard.getActive());
						
						// Get the containers of each Wizard
						List<Container> containers = wizard.getContainers();
						
						for (Container container : containers) {
							// Get the id of each Container
							System.out.println("Wizard Container ID: " + container.getId());
							
							// Get the layout  of each Container
							Layout layout = container.getLayout();
							if (layout!=null) {
								//get  Layout ID
								System.out.println("Wizard Container Layout ID: "+layout.getId());
								//get  Layout Name
								System.out.println("Wizard Container Layout Name: "+layout.getName());
							}
							ChartData chartData = container.getChartData();
							if(chartData!=null) {
								//get  Chart nodes
								List<Node> nodes = chartData.getNodes();
								
								for(Node node : nodes) {
									//get Node poistion y
									System.out.println("Chart Data Node poistion y: "+node.getPosY());
									//get Node poistion x
									System.out.println("Chart Data Node poistion X: "+node.getPosX());
									//get Node start node
									System.out.println("Chart Data Node start node: "+node.getStartNode());
									//get Node screen
									
									Screen nodeScreen = node.getScreen();
									if(nodeScreen!=null){
										//get  screens id
										System.out.println(" screens id: "+nodeScreen.getId());
										//get  display label
										System.out.println("display label: "+nodeScreen.getDisplayLabel());
									}

								}
								//get  Chart connections
								List<com.zoho.crm.api.wizards.Connection> connections = chartData.getConnections();
								if(connections != null)
								{
									for(com.zoho.crm.api.wizards.Connection connection : connections) {
										//get connection target screen
										Screen connectionScreen = connection.getTargetScreen();
										if(connectionScreen!=null){
											//get  screens id
											System.out.println(" screens id: "+connectionScreen.getId());
											//get  display label
											System.out.println("display label: "+connectionScreen.getDisplayLabel());
										}
										//get connection source button
										Button connectionButton = connection.getSourceButton();
										if(connectionButton!=null){
											//get  connectionButton id
											System.out.println(" button id: "+connectionButton.getId());
											//get  display label
											System.out.println("display label: "+connectionButton.getDisplayLabel());
										}
									}
								}
								//get  Chart Data Canvas width
								System.out.println("Chart Data Canvas width: "+chartData.getCanvasWidth());
								//get  Chart Data Canvas height
								System.out.println("Chart Data Canvas height: "+chartData.getCanvasHeight());
								
							}
							
							List<Screen> screens = container.getScreens();

							if(screens != null)
							{
								for(Screen screen:screens) {
									//get  screens id
									System.out.println(" screens id: "+screen.getId());
									//get  display label
									System.out.println("display label: "+screen.getDisplayLabel());
									//get  segments
									List<Segment> segments = screen.getSegments();
									for (Segment segment:segments) {
										//get  screens segment id
										System.out.println("screens segment id: "+segment.getId());
										//get  screens segment sequence number
										System.out.println("screens segment equence number: "+segment.getSequenceNumber());
										//get  screens segment display label
										System.out.println("screens segment display label: "+segment.getDisplayLabel());
										//get  screens segment type
										System.out.println("screens segment type: "+segment.getType());
										//get  screens segment column count
										System.out.println("screens segment column count: "+segment.getColumnCount());
										List<Field> fields = segment.getFields();
										if(fields != null)
										{
											for (Field field :fields) {
												//get  screens segment field id
												System.out.println("screens segment field id: "+field.getId());
												//get  screens segment field apiname
												System.out.println("screens segment field apiname: "+field.getAPIName());
											}
										}
										//get  screens segment Buttons
										List<Button> buttons = segment.getButtons();
										if(buttons != null)
										{
											for(Button button:buttons) {
												//get  screens segment Button critera
												Criteria criteria = button.getCriteria();
												
												if(criteria!=null) {
													printCriteria(criteria);
												}
												//get Button target screen
												Screen targetScreen = button.getTargetScreen();
												if(targetScreen!=null) {
													//get Button target screen id 
													System.out.println(" Button targetScreen id : "+targetScreen.getId());
													//get Button target screen display label
													System.out.println(" Button targetScreen display label: "+targetScreen.getDisplayLabel());
												}
												//get Button display label
												System.out.println(" Button display label: "+button.getDisplayLabel());
												//get Button id
												System.out.println(" Button id: "+button.getId());
												//get Button display label
												System.out.println(" Button display label: "+button.getDisplayLabel());
												//get Button type
												System.out.println(" Button type: "+button.getType());
												//get Button bg color
												System.out.println(" Button bg color: "+button.getBackgroundColor());
												//get Button sequence number
												System.out.println(" Button sequence number: "+button.getSequenceNumber());
												//get Button color 
												System.out.println(" Button color: "+button.getColor());
												//get Button shape
												System.out.println(" Button shape: "+button.getShape());
												//get Button sequence number
												System.out.println(" Button sequence number: "+button.getSequenceNumber());
											}
										}
									}
								}
							}
						}
						
						//Get the  Created by
						User createdBy = wizard.getCreatedBy();
						
						if(createdBy!=null) {
							System.out.println("Wizard Created By Name : " + createdBy.getName());
							System.out.println("Wizard Created By id : " + createdBy.getId());
							System.out.println("Wizard Created By Name : " + createdBy.getEmail());

						}
					
						
						//Get the  parent Wizard 
						Wizard parentWizard = wizard.getParentWizard();
						
						if(parentWizard!=null) {
							System.out.println("Wizard Folder  id : " + parentWizard.getId());
							System.out.println("Wizard Folder  Name : " + parentWizard.getName());

						}
						// Get the draft of each Wizard
						System.out.println("Wizard Draft: " + wizard.getDraft());
						
						// Get the ID of each Wizard
						System.out.println("Wizard ID: " + wizard.getId());
						

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

				// Get all declared Wizards of the response class
				java.lang.reflect.Field[] Fields = clas.getDeclaredFields();

				for (java.lang.reflect.Field Field : Fields) {
					// Get each value
					System.out.println(Field.getName() + ":" + Field.get(responseObject));
				}
			}
		}
	}
	private static void printCriteria(Criteria criteria)
    {
		if(criteria.getComparator() != null)
		{
			//Get the Comparator of the Criteria
			System.out.println("CustomView Criteria Comparator: " + criteria.getComparator().getValue());
		}
		
		if (criteria.getField()!=null) {
			//Get the name of the field
			System.out.println("CustomView Criteria field name: " + criteria.getField().getAPIName());
		}
		
		if(criteria.getValue() != null)
		{
			//Get the Value of the Criteria
			System.out.println("CustomView Criteria Value: " + criteria.getValue().toString());
		}
		
		// Get the List of Criteria instance of each Criteria
		List<Criteria> criteriaGroup = criteria.getGroup();
		
		if(criteriaGroup != null)
		{
			for(Criteria criteria1 : criteriaGroup)
			{
				printCriteria(criteria1);
			}
		}
		
		if(criteria.getGroupOperator() != null)
		{
			//Get the Group Operator of the Criteria
			System.out.println("CustomView Criteria Group Operator: " + criteria.getGroupOperator().getValue());
		}
    }
}
