package com.zoho.crm.sample.blueprint;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import java.util.Map;
import java.util.Map.Entry;

import com.zoho.crm.api.blueprint.APIException;

import com.zoho.crm.api.blueprint.ActionResponse;

import com.zoho.crm.api.fields.AutoNumber;
import com.zoho.crm.api.fields.Currency;
import com.zoho.crm.api.fields.External;
import com.zoho.crm.api.fields.Maps;
import com.zoho.crm.api.fields.Module;
import com.zoho.crm.api.fields.MultiModuleLookup;
import com.zoho.crm.api.blueprint.BluePrintOperations;

import com.zoho.crm.api.blueprint.BodyWrapper;
import com.zoho.crm.api.blueprint.Escalation;
import com.zoho.crm.api.blueprint.Field;
import com.zoho.crm.api.fields.MultiSelectLookup;

import com.zoho.crm.api.fields.PickListValue;

import com.zoho.crm.api.fields.ToolTip;
import com.zoho.crm.api.fields.Unique;
import com.zoho.crm.api.fields.ViewType;

import com.zoho.crm.api.layouts.Layout;
import com.zoho.crm.api.profiles.Profile;
import com.zoho.crm.api.blueprint.NextTransition;

import com.zoho.crm.api.blueprint.ProcessInfo;

import com.zoho.crm.api.blueprint.ResponseHandler;

import com.zoho.crm.api.blueprint.ResponseWrapper;

import com.zoho.crm.api.blueprint.SuccessResponse;

import com.zoho.crm.api.blueprint.Transition;
import com.zoho.crm.api.blueprint.ValidationError;
import com.zoho.crm.api.record.Record;

import com.zoho.crm.api.users.User;

import com.zoho.crm.api.util.APIResponse;

import com.zoho.crm.api.util.Model;

public class BluePrint
{
	/**
	 * <h3> Get Blueprint </h3>
	 * This method is used to get a single record's Blueprint details with ID and print the response.
	 * @param moduleAPIName The API Name of the record's module
	 * @param recordId The ID of the record to get Blueprint
	 * @throws Exception
	 */
	public static void getBlueprint(String moduleAPIName, Long recordId) throws Exception
	{
		//example
		//String moduleAPIName = "Leads";
		//Long recordId = 34770614381002l;
		
		//Get instance of BluePrintOperations Class that takes recordId and moduleAPIName as parameter
		BluePrintOperations bluePrintOperations = new BluePrintOperations(recordId, moduleAPIName);
		
		//Call getBlueprint method
		APIResponse<ResponseHandler> response = bluePrintOperations.getBlueprint();
		
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
					
					//Get the obtained BluePrint instance
					com.zoho.crm.api.blueprint.BluePrint bluePrint = responseWrapper.getBlueprint();
				
					//Get the ProcessInfo instance of the obtained BluePrint
					ProcessInfo processInfo = bluePrint.getProcessInfo();
					
					//Check if ProcessInfo is not null
					if(processInfo != null)
					{
						//Get the Field ID of the ProcessInfo
						System.out.println("ProcessInfo Field-ID: " + processInfo.getFieldId());
						
						Escalation escalation = processInfo.getEscalation();
						
						if (escalation!=null) {
							System.out.println("Escalation days: " + escalation.getDays());
							System.out.println("Escalation status: " + escalation.getStatus());
						}
						
						//Get the isContinuous of the ProcessInfo
						System.out.println("ProcessInfo isContinuous: " + processInfo.getIsContinuous());
						
						//Get the API Name of the ProcessInfo
						System.out.println("ProcessInfo API Name: " + processInfo.getAPIName());
						
						//Get the Continuous of the ProcessInfo
						System.out.println("ProcessInfo Continuous: " + processInfo.getContinuous());
						
						//Get the FieldLabel of the ProcessInfo
						System.out.println("ProcessInfo FieldLabel: " + processInfo.getFieldLabel());
						
						//Get the Name of the ProcessInfo
						System.out.println("ProcessInfo Name: " + processInfo.getName());
						
						//Get the ColumnName of the ProcessInfo
						System.out.println("ProcessInfo ColumnName: " + processInfo.getColumnName());
						
						//Get the FieldValue of the ProcessInfo
						System.out.println("ProcessInfo FieldValue: " + processInfo.getFieldValue());
						
						//Get the ID of the ProcessInfo
						System.out.println("ProcessInfo ID: " + processInfo.getId());
						
						//Get the FieldName of the ProcessInfo
						System.out.println("ProcessInfo FieldName: " + processInfo.getFieldName());	
					}
					
					//Get the list of transitions from BluePrint instance
					List<Transition> transitions = bluePrint.getTransitions();
					
					for(Transition transition : transitions)
					{
						
						List<NextTransition> nextTransitions = transition.getNextTransitions();
						
						for(NextTransition nextTransition : nextTransitions)
						{
							//Get the ID of the NextTransition
							System.out.println("NextTransition ID: " + nextTransition.getId());
							
							//Get the criteria_matched of the NextTransition
							System.out.println("NextTransition criteria_matched: " + nextTransition.getCriteriaMatched());
							
							//Get the Name of the NextTransition
							System.out.println("NextTransition Name: " + nextTransition.getName());
							
							//Get the type of the NextTransition
							System.out.println("NextTransition type: " + nextTransition.getType());
						}
						//Get the parent of the Transition
						Transition parentTransition = transition.getParentTransition();
						if (parentTransition!=null) {
							System.out.println("Parenttransition ID: " + parentTransition.getId());
						}
						
						Record data = transition.getData();
						
						//Get the ID of each record
						System.out.println("Record ID: " + data.getId());
						
						//Get the createdBy User instance of each record
						User createdBy = data.getCreatedBy();
						
						if(createdBy != null)
						{
							//Get the ID of the createdBy User
							System.out.println("Record Created By User-ID: " + createdBy.getId());
							
							//Get the name of the createdBy User
							System.out.println("Record Created By User-Name: " + createdBy.getName());
						}
						
						//Check if the created time is not null
						if(data.getCreatedTime() != null)
						{
							//Get the created time of each record
							System.out.println("Record Created Time: " + data.getCreatedTime().toString());
						}
						
						//Check if the modified time is not null
						if(data.getModifiedTime() != null)
						{
							//Get the modified time of each record
							System.out.println("Record Modified Time: " + data.getModifiedTime().toString());
						}
						
						//Get the modifiedBy User instance of each record
						User modifiedBy = data.getModifiedBy();
	
						//Check if modifiedByUser is not null
						if(modifiedBy != null)
						{
							//Get the ID of the modifiedBy User
							System.out.println("Record Modified By User-ID: " + modifiedBy.getId());
							
							//Get the name of the modifiedBy User
							System.out.println("Record Modified By user-Name: " + modifiedBy.getName());
						}
						
						//Get all entries from the keyValues map
						for(Map.Entry<String, Object>entry : data.getKeyValues().entrySet())
						{
							//Get each value from the map
							System.out.println(entry.getKey() + ": " + entry.getValue());
						}
						
						//Get the NextFieldValue of the Transition
						System.out.println("Transition NextFieldValue: " + transition.getNextFieldValue());
						
						//Get the Name of each Transition
						System.out.println("Transition Name: " + transition.getName());
						
						//Get the CriteriaMatched of the Transition
						System.out.println("Transition CriteriaMatched: " + transition.getCriteriaMatched().toString());
						
						//Get the ID of the Transition
						System.out.println("Transition ID: " + transition.getId());
						
						System.out.println("Transition Fields: ");
						
						List<Field> fields = transition.getFields();
						
						for(Field field : fields)
						{
							if(field.getSystemMandatory() != null)
							{
								//Get the SystemMandatory of each Field
								System.out.println("Field is SystemMandatory: " + field.getSystemMandatory() );
							}

							//Get the private of each Field
							System.out.println("Field is Private"+ field.getPrivate()) ;
							//Get the webhook of each Field
							System.out.println("Transition Fields Webhook: " + field.getWebhook());
							
							//Get the JsonType of each Field
							System.out.println("Transition Fields JsonType: " + field.getJsonType());
							
							//Get the DisplayLabel of each Field
							System.out.println("Transition Fields DisplayLabel: " + field.getDisplayLabel());

							//Get the UiType of each Field
							System.out.println("Transition Fields UiType: " + field.getUiType());
							
							//Get the ValidationRule of each Field
							System.out.println("Transition Fields ValidationRule: " + field.getValidationRule());
							
							//Get the DataType of each Field
							System.out.println("Transition Fields DataType: " + field.getDataType());
							
							//Get the Type of each Field
							System.out.println("Transition Fields Type: " + field.getType());
							
							//Get the ColumnName of each Field
							System.out.println("Transition Fields ColumnName: " + field.getColumnName());
							
							//Get the PersonalityName of each Field
							System.out.println("Transition Fields PersonalityName: " + field.getPersonalityName());
							
							//Get the ID of each Field
							System.out.println("Transition Fields ID: " + field.getId());
							
							//Get the TransitionSequence of each Field
							System.out.println("Transition Fields TransitionSequence: " + field.getTransitionSequence().toString());
							
							if(field.getMandatory() != null)
							{
								//Get the Mandatory of each Field
								System.out.println("Transition Fields Mandatory: " + field.getMandatory().toString());
							}
							
							Layout layout = field.getLayouts();
							
							if(layout != null)
							{
								//Get the ID of the Layout
								System.out.println("Transition Fields Layout ID: " + layout.getId());
								
								//Get the name of the Layout
								System.out.println("Transition Fields Layout Name: " + layout.getName());
							}

							 //Get the PickListValuesSortedLexically of each Field
							System.out.println("Field PickListValuesSortedLexically: " +field.getPickListValuesSortedLexically() );

							//Get the Sortable of each Field
							System.out.println("Field Sortable: " +field.getSortable() );

							//Get the TransitionSequence of each Field
							System.out.println("Field TransitionSequence: " +field.getTransitionSequence() );

							External external = field.getExternal();

							if(external != null)
							{
								//Get the Show of External
								System.out.println("Field External Show: " +external.getShow() );

								//Get the Type of External
								System.out.println("Field External Type: " +external.getType() );

								//Get the AllowMultipleConfig of External
								System.out.println("Field External AllowMultipleConfig: " +external.getAllowMultipleConfig() );
							}
							//Get the Object obtained Unique instance
                       		Unique unique = field.getUnique();

							if(unique != null)
							{
								//Get the Casesensitive of the Unique
								System.out.println("Field Unique Casesensitive : " +unique.getCasesensitive() );
							}
							if(field.getHistoryTracking() != null)
							{
								//Get the HistoryTracking of each Field
								System.out.println("Field HistoryTracking: " +field.getHistoryTracking() );
							}

							//Get the DataType of each Field
							System.out.println("Field DataType: " + field.getDataType() );
							//Get the APIName of each Field
							System.out.println("Transition Fields APIName: " + field.getAPIName());
							
							//Get the Content of each Field
							System.out.println("Transition Fields Content: " + field.getContent());
							
							if(field.getSystemMandatory() != null)
							{
								//Get the SystemMandatory of each Field
								System.out.println("Transition Fields SystemMandatory: " + field.getSystemMandatory().toString());
							}

							
							
							//Get the FieldLabel of each Field
							System.out.println("Transition Fields FieldLabel: " + field.getFieldLabel());

							//Get the MultiModuleLookup of each Field
                        	MultiModuleLookup multiModuleLookup = field.getMultiModuleLookup();

							if(multiModuleLookup != null)
							{
								Module module = multiModuleLookup.getModule();

								if(module != null)
								{
									//Get the APIName of MultiModuleLookup Module
									System.out.println("Field MultiModuleLookup Module APIName: " +module.getAPIName() );

									//Get the Id of MultiModuleLookup Module
									System.out.println("Field MultiModuleLookup Module Id: " +module.getId() );
								}

								//Get the APIName of MultiModuleLookup
								System.out.println("Field MultiModuleLookup APIName: " +multiModuleLookup.getName() );

								//Get the Id of MultiModuleLookup
								System.out.println("Field MultiModuleLookup Id: " +multiModuleLookup.getId() );
							}
							//Get the Object obtained Currency instance
							Currency currency = field.getCurrency();

							//Check if currency is not null
							if(currency != null)
							{
								//Get the RoundingOption of the Currency
								System.out.println("Field Currency RoundingOption: " + currency.getRoundingOption() );

								if(currency.getPrecision() != null)
								{
									//Get the Precision of the Currency
									System.out.println("Field Currency Precision: " + currency.getPrecision() );
								}
							}

							
							//Get the Tooltip of each Field
							ToolTip toolTip = field.getTooltip();
							
							if(toolTip != null)
							{
								//Get the Tooltip Name
								System.out.println("Transition Fields Tooltip Name: " + toolTip.getName());
								
								//Get the Tooltip Value
								System.out.println("Transition Fields Tooltip Value: " + toolTip.getValue());
							}
							
							//Get the CreatedSource of each Field
							System.out.println("Transition Fields CreatedSource: " + field.getCreatedSource());
							
							if(field.getFieldReadOnly() != null)
							{
								//Get the FieldReadOnly of each Field
								System.out.println("Transition Fields FieldReadOnly: " + field.getFieldReadOnly().toString());
							}

							if(field.getDisplayType() != null)
							{
								//Get the ReadOnly of each Field
								System.out.println("Transition Fields DisplayType: " + field.getDisplayType().toString());
							}
							
							if(field.getReadOnly() != null)
							{
								//Get the ReadOnly of each Field
								System.out.println("Transition Fields ReadOnly: " + field.getReadOnly().toString());
							}
							
							//Get the AssociationDetails of each Field
							System.out.println("Transition Fields AssociationDetails: " + field.getAssociationDetails());
							
							if(field.getQuickSequenceNumber() != null)
							{
								//Get the QuickSequenceNumber of each Field
								System.out.println("Transition Fields QuickSequenceNumber: " + field.getQuickSequenceNumber().toString());
							}
							
							if(field.getCustomField() != null)
							{
								//Get the CustomField of each Field
								System.out.println("Transition Fields CustomField: " + field.getCustomField().toString());
							}

							Module lookup = field.getLookup();

							//Check if lookup is not null
							if(lookup != null)
							{
								//Get the Object obtained Layout instance
								layout = lookup.getLayout();

								//Check if layout is not null
								if(layout != null)
								{
									//Get the ID of the Layout
									System.out.println("Field ModuleLookup Layout ID: "+ layout.getId() );

									//Get the Name of the Layout
									System.out.println("Field ModuleLookup Layout Name: "+ layout.getName() );
								}

								//Get the DisplayLabel of the Module
								System.out.println("Field ModuleLookup DisplayLabel: "+ lookup.getDisplayLabel() );

								//Get the APIName of the Module
								System.out.println("Field ModuleLookup APIName: "+ lookup.getAPIName() );

								//Get the Module of the Module
								System.out.println("Field ModuleLookup Module: "+ lookup.getModule() );

								if(lookup.getId() != null)
								{
									//Get the ID of the Module
									System.out.println("Field ModuleLookup ID: "+ lookup.getId() );
								}
							}

							//Get the Filterable of each Field
							System.out.println("Field Filterable: "+ field.getFilterable() );

							//Check if ConvertMapping is not null
							if(field.getConvertMapping() != null)
							{
								//Get the details map
								for(Entry<String, Object> cm :field.getConvertMapping().entrySet()) {
									//Get each value in the map
									System.out.println(cm.getKey() + " : "+ cm.getValue() );
								}
								
							}
							
							if(field.getVisible() != null)
							{
								//Get the Visible of each Field
								System.out.println("Transition Fields Visible: " + field.getVisible().toString());
							}

							List<Profile> profiles = field.getProfiles();

							if(profiles != null)
							{
								for (Profile profile:profiles) {
									//Get the PermissionType of each Profile
									System.out.println("Field Profile PermissionType: " + profile.getPermissionType() );

									//Get the Name of each Profile
									System.out.println("Field Profile Name: " + profile.getName() );

									//Get the Id of each Profile
									System.out.println("Field Profile Id: " + profile.getId() );
								}
							}

							
							if(field.getFormula() != null)
							{
								if(field.getFormula().getExpression() != null)
								{
									//Get the Length of each Field
									System.out.println("Field Formula Expression :  " + field.getFormula().getExpression());
								}
							}

							if(field.getDecimalPlace() != null)
							{
								//Get the Length of each Field
								System.out.println("Field DecimalPlace: " + field.getDecimalPlace());
							}

							if(field.getLength() != null)
							{
								//Get the Length of each Field
								System.out.println("Transition Fields Length: " + field.getLength().toString());
							}
							
							//Get the DecimalPlace of each Field
							System.out.println("Transition Fields DecimalPlace: " + field.getDecimalPlace());
							
							ViewType viewType = field.getViewType();
							
							if(viewType != null)
							{
								//Get the View of the ViewType
								System.out.println("Transition Fields ViewType View: " + viewType.getView().toString());
								
								//Get the Edit of the ViewType
								System.out.println("Transition Fields ViewType Edit: " + viewType.getEdit().toString());
								
								//Get the Create of the ViewType
								System.out.println("Transition Fields ViewType Create: " + viewType.getCreate().toString());
								
								//Get the View of the ViewType
								System.out.println("Transition Fields ViewType QuickCreate: " + viewType.getQuickCreate().toString());
							}
							
							List<PickListValue> pickListValues = field.getPickListValues();
							
							if(pickListValues != null)
							{
								for(PickListValue pickListValue : pickListValues)
								{
									printPickListValue(pickListValue);
								}
							}
							
							//Get all entries from the MultiSelectLookup instance
							MultiSelectLookup multiSelectLookup = field.getMultiselectlookup();
							
							if(multiSelectLookup != null)
							{
								//Get the DisplayValue of the MultiSelectLookup
								System.out.println("Transition Fields MultiSelectLookup DisplayLabel: " + multiSelectLookup.getDisplayLabel());
								
								//Get the LinkingModule of the MultiSelectLookup
								System.out.println("Transition Fields MultiSelectLookup LinkingModule: " + multiSelectLookup.getLinkingModule());
								
								//Get the LookupApiname of the MultiSelectLookup
								System.out.println("Transition Fields MultiSelectLookup LookupApiname: " + multiSelectLookup.getLookupApiname());
								
								//Get the APIName of the MultiSelectLookup
								System.out.println("Transition Fields MultiSelectLookup APIName: " + multiSelectLookup.getAPIName());
								
								//Get the ConnectedlookupApiname of the MultiSelectLookup
								System.out.println("Transition Fields MultiSelectLookup ConnectedlookupApiname: " + multiSelectLookup.getConnectedlookupApiname());
								
								//Get the ID of the MultiSelectLookup
								System.out.println("Transition Fields MultiSelectLookup ID: " + multiSelectLookup.getId());
							}
							
							//Get the AutoNumber of each Field
							AutoNumber autoNumber = field.getAutoNumber();
							
							if(autoNumber != null)
							{
								//Get the Prefix of the AutoNumber
								System.out.println("Transition Fields AutoNumber Prefix: " + autoNumber.getPrefix());
								
								//Get the Suffix of the AutoNumber
								System.out.println("Transition Fields AutoNumber Suffix: " + autoNumber.getSuffix());
								
								if(autoNumber.getStartNumber() != null)
								{
									//Get the StartNumber of the AutoNumber
									System.out.println("Transition Fields Auto StartNumber: " + autoNumber.getStartNumber().toString());
								}
							}
							
							//Get the ConvertMapping of each Field
							System.out.println("Transition Fields ConvertMapping: ");
							
							if(field.getConvertMapping() != null) 
							{
								//Get all entries from the ConvertMapping
								for(Map.Entry<String, Object>entry : field.getConvertMapping().entrySet())
								{
									//Get each value from the map
									System.out.println(entry.getKey() + ": " + entry.getValue());
								}
							}
						}
						
						//Get the CriteriaMessage of each Transition
						System.out.println("Transition CriteriaMessage: " + transition.getCriteriaMessage());

						//Get the PercentPartialSave of each PercentPartialSave
						System.out.println("Transition PercentPartialSave: " + transition.getPercentPartialSave());

						//Get the ExecutionTime of each Transition
						System.out.println("Transition ExecutionTime: " + transition.getExecutionTime());

						//Get the Type of each Transition
						System.out.println("Transition Type: " + transition.getType());

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
	
	/**
	 * <h3> Update Blueprint </h3>
	 * This method is used to update a single record's Blueprint details with ID and print the response.
	 * @param moduleAPIName The API Name of the record's module
	 * @param recordId The ID of the record to get Blueprint
	 * @param transitionId The ID of the Blueprint transition Id
	 * @throws Exception
	 */
	public static void updateBlueprint(String moduleAPIName, Long recordId, Long transitionId) throws Exception
	{
		//ID of the BluePrint to be updated
		//String moduleAPIName = "Leads";
		//Long recordId = 34770614381002l;
		//Long transitionId = 34770610173096l;
				
		//Get instance of BluePrintOperations Class that takes recordId and moduleAPIName as parameter
		BluePrintOperations bluePrintOperations = new BluePrintOperations(recordId, moduleAPIName);
		
		//Get instance of BodyWrapper Class that will contain the request body
		BodyWrapper bodyWrapper = new BodyWrapper();
		
		//List of BluePrint instances
		List<com.zoho.crm.api.blueprint.BluePrint> bluePrintList = new ArrayList<com.zoho.crm.api.blueprint.BluePrint>();

		//Get instance of BluePrint Class
		com.zoho.crm.api.blueprint.BluePrint bluePrint = new com.zoho.crm.api.blueprint.BluePrint();
		
		//Set transition_id to the BluePrint instance
		bluePrint.setTransitionId(transitionId);
		
		//Get instance of Record Class
		Record data = new Record();
		
		HashMap<String, Object> lookup = new HashMap<String, Object>();
		
		lookup.put("Phone", "8940372937");
		
		lookup.put("id", "8940372937");
		
		
		data.addKeyValue("Phone", "8940372937");
		
		data.addKeyValue("Notes", "Updated via blueprint");
		
		HashMap<String, Object> attachments = new HashMap<String, Object>();
		
		ArrayList<String> fileIds = new ArrayList<String>();
		
		fileIds.add("blojtd2d13b5f044e4041a3315e0793fb21ef");
		
		attachments.put("file_id", fileIds);
		
		data.addKeyValue("Attachments", attachments);
		
		ArrayList<HashMap<String, Object>> checkLists = new ArrayList<HashMap<String, Object>>();
		
		HashMap<String, Object> checkListItem = new HashMap<String, Object>();
		
		checkListItem.put("list 1", true);
		
		checkLists.add(checkListItem);
		
		checkListItem = new HashMap<String, Object>();
		
		checkListItem.put("list 2", true);
		
		checkLists.add(checkListItem);
		
		checkListItem = new HashMap<String, Object>();
		
		checkListItem.put("list 3", true);
		
		checkLists.add(checkListItem);
		
		data.addKeyValue("CheckLists", checkLists);
		
		//Set data to the BluePrint instance
		bluePrint.setData(data);
		
		//Add BluePrint instance to the list
		bluePrintList.add(bluePrint);
		
		//Set the list to bluePrint in BodyWrapper instance
		bodyWrapper.setBlueprint(bluePrintList);
		
		//Call updateBluePrint method that takes BodyWrapper instance 
		APIResponse<ActionResponse> response = bluePrintOperations.updateBlueprint(bodyWrapper);
		
		if(response != null)
		{
			//Get the status code from response
			System.out.println("Status Code: " + response.getStatusCode());
			
			//Check if expected response is received
			if(response.isExpected())
			{
				//Get object from response
				ActionResponse actionResponse = response.getObject();
				
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
					
					if(successResponse.getDetails() != null)
					{
						//Get the details map
						for(Map.Entry<String, Object> entry : successResponse.getDetails().entrySet())
						{
							//Get each value in the map
							System.out.println(entry.getKey() + ": " + entry.getValue());
						}
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
						System.out.println(entry.getKey() + ": ");
						
						if(entry.getValue() instanceof List)
						{
							@SuppressWarnings("unchecked")
							List<ValidationError> validationError = (List<ValidationError>) entry.getValue();
							
							for(ValidationError error : validationError)
							{
								System.out.println("Field APIName " + error.getAPIName() + " : " + error.getMessage());
								System.out.println("Field index "+error.getIndex());
								System.out.println("Field info message "+error.getInfoMessage());
								System.out.println("Field parent api name "+error.getParentAPIName());
							}
						}
						else
						{
							System.out.println(entry.getValue().toString());
						}
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

	public static void printPickListValue(PickListValue pickListValue)
    {
    
		//Get the DisplayValue of each PickListValues
		System.out.println(" Fields PickListValue DisplayValue: " + pickListValue.getDisplayValue());
		
		//Get the SequenceNumber of each PickListValues
		System.out.println(" Fields PickListValue SequenceNumber: " + pickListValue.getSequenceNumber().toString());
		
		//Get the ExpectedDataType of each PickListValues
		System.out.println(" Fields PickListValue ExpectedDataType: " + pickListValue.getExpectedDataType());
		
		//Get the ActualValue of each PickListValues
		System.out.println(" Fields PickListValue ActualValue: " + pickListValue.getActualValue());

		//Get the SysRefName of each PickListValues
		System.out.println(" Fields PickListValue SysRefName: " + pickListValue.getSysRefName());
		
		//Get the Type of each PickListValues
		System.out.println(" Fields PickListValue Type: " + pickListValue.getType());
		
		//Get the Id of each PickListValues
		System.out.println(" Fields PickListValue Id: " + pickListValue.getId());
		
		
		for(Maps map : pickListValue.getMaps())
		{
			//Get each value from the map
			System.out.println(map);
			 List<PickListValue> pickListValues = map.getPickListValues();

			//Check if formula is not null
			if(pickListValues != null)
			{
				for (PickListValue plv:pickListValues) {
					printPickListValue(plv);
				}
			}
		}
    }
}
