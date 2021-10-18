package com.zoho.crm.sample.fields;

import java.util.Arrays;

import java.util.List;

import java.util.Map;
import java.util.Map.Entry;

import com.zoho.crm.api.ParameterMap;

import com.zoho.crm.api.fields.APIException;

import com.zoho.crm.api.fields.AssociationDetails;

import com.zoho.crm.api.fields.AutoNumber;

import com.zoho.crm.api.fields.Crypt;

import com.zoho.crm.api.fields.Currency;

import com.zoho.crm.api.fields.Field;

import com.zoho.crm.api.fields.FieldsOperations;

import com.zoho.crm.api.fields.FieldsOperations.GetFieldsParam;

import com.zoho.crm.api.fields.Formula;
import com.zoho.crm.api.fields.HistoryTracking;
import com.zoho.crm.api.fields.LookupField;
import com.zoho.crm.api.fields.Maps;
import com.zoho.crm.api.fields.Module;
import com.zoho.crm.api.fields.MultiModuleLookup;
import com.zoho.crm.api.fields.MultiSelectLookup;
import com.zoho.crm.api.fields.MultiUserLookup;
import com.zoho.crm.api.fields.PickListValue;

import com.zoho.crm.api.fields.Private;

import com.zoho.crm.api.fields.ResponseHandler;

import com.zoho.crm.api.fields.ResponseWrapper;

import com.zoho.crm.api.fields.ToolTip;

import com.zoho.crm.api.fields.Unique;

import com.zoho.crm.api.fields.ViewType;

import com.zoho.crm.api.layouts.Layout;
import com.zoho.crm.api.profiles.Profile;
import com.zoho.crm.api.util.APIResponse;

import com.zoho.crm.api.util.Model;

public class Fields
{
	/**
	 * <h3> Get Fields </h3>
	 * This method is used to get metadata about all the fields of a module and print the response.
	 * @throws Exception
	 * @param moduleAPIName The API Name of the module to get fields
	 */
	public static void getFields(String moduleAPIName) throws Exception
	{
		//example
		//String moduleAPIName = "Leads";
		
		//Get instance of FieldsOperations Class that takes moduleAPIName as parameter
		FieldsOperations fieldOperations = new FieldsOperations(moduleAPIName);
		
		//Get instance of ParameterMap Class
		ParameterMap paramInstance = new ParameterMap();
		
		paramInstance.add(GetFieldsParam.TYPE, "unused");
		
		//Call getFields method that takes paramInstance as parameter 
		APIResponse<ResponseHandler> response = fieldOperations.getFields(paramInstance);
		
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
					
					//Get the list of obtained Field instances
					List<Field> fields = responseWrapper.getFields();
				
					for(Field field : fields)
					{
						//Get the SystemMandatory of each Field
						System.out.println("Field SystemMandatory: " + field.getSystemMandatory().toString());
						
						//Get the Webhook of each Field
						System.out.println("Field Webhook: " + field.getWebhook().toString());
						
						//Get the JsonType of each Field
						System.out.println("Field JsonType: " + field.getJsonType());
						
						//Get the private info of each field
						Private privateInfo = field.getPrivate();
						
						//Check if privateInfo is not null
						if(privateInfo != null)
						{
							System.out.println("Private Details");
							
							//Get the type
							System.out.println("Field Private Type: " + privateInfo.getType());
							
							//Get the Export
							System.out.println("Field Private Export: " + privateInfo.getExport());
							
							//Get the Restricted
							System.out.println("Field Private Restricted: " + privateInfo.getRestricted());
						}
						
						//Get the Object obtained Crypt instance
						Crypt crypt = field.getCrypt();
						
						//Check if crypt is not null
						if(crypt != null)
						{
							//Get the Mode of the Crypt
							System.out.println("Field Crypt Mode: " + crypt.getMode());
							
							//Get the Column of the Crypt
							System.out.println("Field Crypt Column: " + crypt.getColumn());
							
							//Get the Table of the Crypt
							System.out.println("Field Crypt Table: " + crypt.getTable());
							
							//Get the Status of the Crypt
							System.out.println("Field Crypt Status: " + crypt.getStatus().toString());

							List<String> encFldIds = crypt.getEncfldids();

                            if(encFldIds != null)
                            {
                                System.out.println("EncFldIds : ");

                                for(String encFldId : encFldIds)
                                {
                                    System.out.println(encFldId );
                                }
                            }

                            //Get the Notify of the Crypt
                            System.out.println("Field Crypt Notify: "+ crypt.getNotify() );
						}
						
						//Get the FieldLabel of each Field
						System.out.println("Field FieldLabel: " + field.getFieldLabel());
						
						//Get the Object obtained ToolTip instance
						ToolTip tooltip = field.getTooltip();
						
						//Check if tooltip is not null
						if(tooltip != null)
						{
							//Get the Name of the ToolTip
							System.out.println("Field ToolTip Name: " + tooltip.getName());
							
							//Get the Value of the ToolTip
							System.out.println("Field ToolTip Value: " + tooltip.getValue());
						}
						
						//Get the CreatedSource of each Field
						System.out.println("Field CreatedSource: " + field.getCreatedSource());
						
						System.out.println("Field Type :" + field.getType());

						//Get the FieldReadOnly of each Field
						System.out.println("Field FieldReadOnly: " + field.getFieldReadOnly().toString());
						
						//Get the DisplayLabel of each Field
						System.out.println("Field DisplayLabel: " + field.getDisplayLabel());

						if(field.getDisplayType() != null)
						{
							//Get the display type of each Field
							System.out.println("Field DisplayType : " + field.getDisplayType().getValue().toString());
						}

						if(field.getUiType()!= null) 
						{
							//get UI type of field
							System.out.println("Field UI Type " + field.getUiType());
						}
						
						//Get the ReadOnly of each Field
						System.out.println("Field ReadOnly: " + field.getReadOnly().toString());
						
						//Get the Object obtained AssociationDetails instance
						AssociationDetails associationDetails = field.getAssociationDetails();
						
						//Check if associationDetails is not null
						if(associationDetails != null)
						{
							//Get the Object obtained LookupField instance
							LookupField lookupField = associationDetails.getLookupField();
							
							//Check if lookupField is not null
							if(lookupField != null)
							{
								//Get the ID of the LookupField
								System.out.println("Field AssociationDetails LookupField ID: " + lookupField.getId());
								
								//Get the Name of the LookupField
								System.out.println("Field AssociationDetails LookupField Name: " + lookupField.getName());
							}
							
							//Get the Object obtained LookupField instance
							LookupField relatedField = associationDetails.getRelatedField();
							
							//Check if relatedField is not null
							if(relatedField != null)
							{
								//Get the ID of the relatedField
								System.out.println("Field AssociationDetails RelatedField ID: " + relatedField.getId());
								
								//Get the Name of the relatedField
								System.out.println("Field AssociationDetails RelatedField Name: " + relatedField.getName());
							}
						}
						
						if(field.getQuickSequenceNumber() != null)
						{
							//Get the QuickSequenceNumber of each Field
							System.out.println("Field QuickSequenceNumber: " + field.getQuickSequenceNumber().toString());
						}
						
						//Get the BusinesscardSupported of each Field
						System.out.println("Field BusinesscardSupported: " + field.getBusinesscardSupported().toString());
						
						//Get the Object obtained MultiModuleLookup instance
						MultiModuleLookup multiModuleLookup = field.getMultiModuleLookup();
						
						//Check if multiModuleLookup is not null
						if(multiModuleLookup != null)
						{
							//Get the Name of the MultiModuleLookup
							System.out.println("Field MultiModuleLookup Name: " + multiModuleLookup.getName());
							
							//Get the Value of the MultiModuleLookup
							System.out.println("Field MultiModuleLookup Id: " + multiModuleLookup.getId());
							
							//Get the Object obtained Module instance
							Module module = multiModuleLookup.getModule();
							
							//Check if module is not null
							if(module != null)
							{
								//Get the ID of the Module
								System.out.println("Field MultiModuleLookup Module ID: " + module.getId());
								
								//Get the Name of the Module
								System.out.println("Field MultiModuleLookup Module APIName: " + module.getAPIName());
							}
						}
						
						//Get the Object obtained Currency instance
						Currency currency = field.getCurrency();
						
						//Check if currency is not null
						if(currency != null)
						{
							//Get the RoundingOption of the Currency
							System.out.println("Field Currency RoundingOption: " + currency.getRoundingOption());
							
							if(currency.getPrecision() != null)
							{
								//Get the Precision of the Currency
								System.out.println("Field Currency Precision: " + currency.getPrecision().toString());
							}
						}
						
						//Get the ID of each Field
						System.out.println("Field ID: " + field.getId().toString());
						
						if(field.getCustomField() != null)
						{
							//Get the CustomField of each Field
							System.out.println("Field CustomField: " + field.getCustomField().toString());
						}
						
						//Get the Object obtained Module instance
						Module lookup = field.getLookup();
						
						//Check if lookup is not null
						if(lookup != null)
						{
							//Get the Object obtained Layout instance
							Layout layout = lookup.getLayout();
							
							//Check if layout is not null
							if(layout != null)
							{
								//Get the ID of the Layout
								System.out.println("Field ModuleLookup Layout ID: " + layout.getId().toString());
								
								//Get the Name of the Layout
								System.out.println("Field ModuleLookup Layout Name: " + layout.getName());
							}
							
							//Get the DisplayLabel of the Module
							System.out.println("Field ModuleLookup DisplayLabel: " + lookup.getDisplayLabel());
							
							//Get the APIName of the Module
							System.out.println("Field ModuleLookup APIName: " + lookup.getAPIName());
							
							//Get the Module of the Module
							System.out.println("Field ModuleLookup Module: " + lookup.getModule());
							
							if(lookup.getId() != null)
							{
								//Get the ID of the Module
								System.out.println("Field ModuleLookup ID: " + lookup.getId().toString());
							}
						}

						//Get the Filterable of each Field
						System.out.println("Field Filterable: "+ field.getFilterable() );
						
						if(field.getVisible() != null)
						{
							//Get the Visible of each Field
							System.out.println("Field Visible: " + field.getVisible().toString());
						}

						//Get field profiles
						List<Profile> fieldProfiles = field.getProfiles();

						for (Profile fieldProfile : fieldProfiles) 
						{
							//get profile permission type
							System.out.println("Profile permission Type "+fieldProfile.getPermissionType());
							
							//get profile name
							System.out.println("Profile Name  "+fieldProfile.getName());
							
							//get profile id
							System.out.println("Profile ID  "+fieldProfile.getId());
						}

						if(field.getLength() != null)
						{
							//Get the Length of each Field
							System.out.println("Field Length: " + field.getLength().toString());
						}

						//Get the Object obtained ViewType instance
						ViewType viewType = field.getViewType();

						//Check if viewType is not null
						if(viewType != null)
						{
							//Get the View of the ViewType
							System.out.println("Field ViewType View: " + viewType.getView().toString());
							
							//Get the Edit of the ViewType
							System.out.println("Field ViewType Edit: " + viewType.getEdit().toString());
							
							//Get the Create of the ViewType
							System.out.println("Field ViewType Create: " + viewType.getCreate().toString());
							
							//Get the View of the ViewType
							System.out.println("Field ViewType QuickCreate: " + viewType.getQuickCreate().toString());
						}
						
						if(field.getDisplayField() != null) 
						{
							//check if field is DisplayField
							System.out.println("Field DisplayField " + field.getDisplayField());
						}
						
						if(field.getPickListValuesSortedLexically() != null)
						{
							//check if pick list values is lexically sorted for each Field
							System.out.println("Field pick list values lexically sorted: " + field.getPickListValuesSortedLexically());
						}

						if(field.getSortable()!= null) 
						{
							//check if field is sortable
							System.out.println("Field sortable " + field.getSortable());
						}

						//Get the Object obtained Module instance
						Module subform = field.getSubform();
						
						//Check if subform is not null
						if(subform != null)
						{
							//Get the Object obtained Layout instance
							Layout layout = subform.getLayout();
							
							//Check if layout is not null
							if(layout != null)
							{
								//Get the ID of the Layout
								System.out.println("Field Subform Layout ID: " + layout.getId().toString());
								
								//Get the Name of the Layout
								System.out.println("Field Subform Layout Name: " + layout.getName());
							}
							
							//Get the DisplayLabel of the Module
							System.out.println("Field Subform DisplayLabel: " + subform.getDisplayLabel());
							
							//Get the APIName of the Module
							System.out.println("Field Subform APIName: " + subform.getAPIName());
							
							//Get the Module of the Module
							System.out.println("Field Subform Module: " + subform.getModule());
							
							if(subform.getId() != null)
							{
								//Get the ID of the Module
								System.out.println("Field Subform ID: " + subform.getId().toString());	
							}
						}

						if(field.getSequenceNumber()!=null) {
							//get UI type of field
							System.out.println("Field sequence number " + field.getSequenceNumber());
						}
						
						//Check if External is not null
						if(field.getExternal() != null) 
						{
							System.out.println("Get External show " + field.getExternal().getShow());
							System.out.println("Get External type" + field.getExternal().getType());
							System.out.println("allow multiple config" + field.getExternal().getAllowMultipleConfig());
						}
						
						//Get the APIName of each Field
						System.out.println("Field APIName: " + field.getAPIName().toString());
						
						//Get the Object obtained Unique instance
						Unique unique = field.getUnique();
						
						//Check if unique is not null
						if(unique != null)
						{
							//Get the Casesensitive of the Unique
							System.out.println("Field Unique Casesensitive : " + unique.getCasesensitive());
						}
						
						if(field.getHistoryTracking() != null)
						{
							HistoryTracking historytracking = field.getHistoryTracking();
							
							//Get the Module  of history tracking 
							Module module =  historytracking.getModule();
							
							if (module!=null) {
								Layout moduleLayout = module.getLayout();
								if (moduleLayout!=null) {
									System.out.println("Module layout id"+moduleLayout.getId());
								}
								System.out.println("Module  display label"+module.getDisplayLabel());
								System.out.println("Module  api name"+module.getAPIName());
								System.out.println("Module  id"+module.getId());
								System.out.println("Module  module"+module.getModule());
								System.out.println("Module  module name"+module.getModuleName());
							}
							//Get the duration configured field of each history tracking
							Field durationConfigured=historytracking.getDurationConfiguredField();
							if(durationConfigured!=null) {
								System.out.println("historytracking duration configured field"+durationConfigured.getId());
							}
				
						}
						
						//Get the DataType of each Field
						System.out.println("Field DataType: " + field.getDataType().toString());
						
						//Get the Object obtained Formula instance
						Formula formula = field.getFormula();
						
						//Check if formula is not null
						if(formula != null)
						{
							//Get the ReturnType of the Formula
							System.out.println("Field Formula ReturnType : " + formula.getReturnType());
							
							if(formula.getExpression() != null)
							{
								//Get the Expression of the Formula
								System.out.println("Field Formula Expression : " + formula.getExpression().toString());
							}
						}
						
						if(field.getDecimalPlace() != null)
						{
							//Get the DecimalPlace of each Field
							System.out.println("Field DecimalPlace: " + field.getDecimalPlace().toString());
						}
						
						//Get the MassUpdate of each Field
						System.out.println("Field MassUpdate: " + field.getMassUpdate().toString());
						
						if(field.getBlueprintSupported() != null)
						{
							//Get the BlueprintSupported of each Field
							System.out.println("Field BlueprintSupported: " + field.getBlueprintSupported().toString());
						}
						
						//Get all entries from the MultiSelectLookup instance
						MultiSelectLookup multiSelectLookup = field.getMultiselectlookup();
						
						//Check if formula is not null
						if(multiSelectLookup != null)
						{
							//Get the DisplayValue of the MultiSelectLookup
							System.out.println("Field MultiSelectLookup DisplayLabel: " + multiSelectLookup.getDisplayLabel());
							
							//Get the LinkingModule of the MultiSelectLookup
							System.out.println("Field MultiSelectLookup LinkingModule: " + multiSelectLookup.getLinkingModule());
							
							//Get the LookupApiname of the MultiSelectLookup
							System.out.println("Field MultiSelectLookup LookupApiname: " + multiSelectLookup.getLookupApiname());
							
							//Get the APIName of the MultiSelectLookup
							System.out.println("Field MultiSelectLookup APIName: " + multiSelectLookup.getAPIName());
							
							//Get the ConnectedlookupApiname of the MultiSelectLookup
							System.out.println("Field MultiSelectLookup ConnectedlookupApiname: " + multiSelectLookup.getConnectedlookupApiname());
							
							//Get the ID of the MultiSelectLookup
							System.out.println("Field MultiSelectLookup ID: " + multiSelectLookup.getId());
							
							//Get the connected module of the MultiSelectLookup
							System.out.println("Field MultiSelectLookup connected module: " + multiSelectLookup.getConnectedModule());

						}
						
						//Get the PickListValue of each Field
						List<PickListValue> pickListValues = field.getPickListValues();
						
						//Check if formula is not null
						if(pickListValues != null)
						{
							for(PickListValue pickListValue : pickListValues)
							{
								printPickListValue(pickListValue);
							}
						}
						
						//Get the AutoNumber of each Field
						AutoNumber autoNumber = field.getAutoNumber();
						
						//Check if autoNumber is not null
						if(autoNumber != null)
						{
							//Get the Prefix of the AutoNumber
							System.out.println("Field AutoNumber Prefix: " + autoNumber.getPrefix());
							
							//Get the Suffix of the AutoNumber
							System.out.println("Field AutoNumber Suffix: " + autoNumber.getSuffix());
							
							if(autoNumber.getStartNumber() != null)
							{
								//Get the StartNumber of the AutoNumber
								System.out.println("Field AutoNumber StartNumber: " + autoNumber.getStartNumber().toString());
							}
						}
						
						if(field.getDefaultValue() != null)
						{
							//Get the DefaultValue of each Field
							System.out.println("Field DefaultValue: " + field.getDefaultValue().toString());
						}
						
						//Check if ValidationRule is not null
						if(field.getValidationRule() != null)
						{
							//Get the details map
							for(Map.Entry<String, Object> entry : field.getValidationRule().entrySet())
							{
								//Get each value in the map
								System.out.println(entry.getKey() + ": " + entry.getValue());
							}
						}
						
						//Check if ConvertMapping is not null
						if(field.getConvertMapping() != null)
						{
							//Get the details map
							for(Map.Entry<String, Object> entry : field.getConvertMapping().entrySet())
							{
								//Get each value in the map
								System.out.println(entry.getKey() + ": " + entry.getValue());
							}
						}
						
						//get multi user lookup for field
						if (field.getMultiuserlookup()!=null) 
						{
							MultiUserLookup multiuserlookup = field.getMultiuserlookup();
							
							//get displaylabel of multiuser lookup
							System.out.println("Get multiuserlookup display label" + multiuserlookup.getDisplayLabel());
							
							//get linking module of multiuser lookup
							System.out.println("Get multiuserlookup linking module" + multiuserlookup.getLinkingModule());
							
							//get lookup apiname of multiuser lookup
							System.out.println("Get multiuserlookup lookup api_name" + multiuserlookup.getLookupApiname());
							
							//get apiname of multiuser lookup
							System.out.println("Get multiuserlookup api name" + multiuserlookup.getAPIName());
							
							//get id of multiuser lookup
							System.out.println("Get multiuserlookup id" + multiuserlookup.getId());
							
							//get connected module of multiuser lookup
							System.out.println("Get multiuserlookup connected module" + multiuserlookup.getConnectedModule());
							
							//get connected lookup apiname of multiuser lookup
							System.out.println("Get multiuserlookup connected lookup api name" + multiuserlookup.getConnectedlookupApiname());
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
	 * <h3> Get Field </h3>
	 * This method is used to get metadata about a single field of a module with fieldID and print the response.
	 * @param moduleAPIName The API Name of the field's module
	 * @param fieldId The ID of the field to be obtained
	 * @throws Exception
	 */
	public static void getField(String moduleAPIName, Long fieldId) throws Exception
	{
		//example,
		//String moduleAPIName = "Leads";
		//Long fieldId = 5255085067912l;
		
		//Get instance of FieldsOperations Class that takes moduleAPIName as parameter
		FieldsOperations fieldOperations = new FieldsOperations(moduleAPIName);
		
		//Call getField method which takes fieldId as parameter
		APIResponse<ResponseHandler>response = fieldOperations.getField(fieldId);
		
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
					
					//Get the list of obtained Field instances
					List<Field> fields = responseWrapper.getFields();
				
					for(Field field : fields)
					{
						//Get the SystemMandatory of each Field
						System.out.println("Field SystemMandatory: " + field.getSystemMandatory().toString());
						
						//Get the Webhook of each Field
						System.out.println("Field Webhook: " + field.getWebhook().toString());
						
						//Get the JsonType of each Field
						System.out.println("Field JsonType: " + field.getJsonType());
						
						//Get the private info of each field
						Private privateInfo = field.getPrivate();
						
						//Check if privateInfo is not null
						if(privateInfo != null)
						{
							System.out.println("Private Details");
							
							//Get the type
							System.out.println("Field Private Type: " + privateInfo.getType());
							
							//Get the Export
							System.out.println("Field Private Export: " + privateInfo.getExport());
							
							//Get the Restricted
							System.out.println("Field Private Restricted: " + privateInfo.getRestricted());
						}
						
						//Get the Object obtained Crypt instance
						Crypt crypt = field.getCrypt();
						
						//Check if crypt is not null
						if(crypt != null)
						{
							//Get the Mode of the Crypt
							System.out.println("Field Crypt Mode: " + crypt.getMode());
							
							//Get the Column of the Crypt
							System.out.println("Field Crypt Column: " + crypt.getColumn());
							
							//Get the Table of the Crypt
							System.out.println("Field Crypt Table: " + crypt.getTable());
							
							//Get the Status of the Crypt
							System.out.println("Field Crypt Status: " + crypt.getStatus().toString());
							List<String> encFldIds = crypt.getEncfldids();

                            if(encFldIds != null)
                            {
                                System.out.println("EncFldIds : ");

                                for(String encFldId : encFldIds)
                                {
                                    System.out.println(encFldId );
                                }
                            }

                            //Get the Notify of the Crypt
                            System.out.println("Field Crypt Notify: "+ crypt.getNotify() );
						}
						
						//Get the FieldLabel of each Field
						System.out.println("Field FieldLabel: " + field.getFieldLabel());
						
						//Get the Object obtained ToolTip instance
						ToolTip tooltip = field.getTooltip();
						
						//Check if tooltip is not null
						if(tooltip != null)
						{
							//Get the Name of the ToolTip
							System.out.println("Field ToolTip Name: " + tooltip.getName());
							
							//Get the Value of the ToolTip
							System.out.println("Field ToolTip Value: " + tooltip.getValue());
						}
						
						//Get the CreatedSource of each Field
						System.out.println("Field CreatedSource: " + field.getCreatedSource());

						System.out.println("Field Type :" + field.getType());
						
						//Get the FieldReadOnly of each Field
						System.out.println("Field FieldReadOnly: " + field.getFieldReadOnly().toString());
						
						//Get the DisplayLabel of each Field
						System.out.println("Field DisplayLabel: " + field.getDisplayLabel());

						if(field.getDisplayType() != null)
						{
							//Get the display type of each Field
							System.out.println("Field DisplayType : " + field.getDisplayType().getValue().toString());
						}

						if(field.getUiType()!= null) 
						{
							//get UI type of field
							System.out.println("Field UI Type " + field.getUiType());
						}
						
						//Get the ReadOnly of each Field
						System.out.println("Field ReadOnly: " + field.getReadOnly().toString());
						
						//Get the Object obtained AssociationDetails instance
						AssociationDetails associationDetails = field.getAssociationDetails();
						
						//Check if associationDetails is not null
						if(associationDetails != null)
						{
							//Get the Object obtained LookupField instance
							LookupField lookupField = associationDetails.getLookupField();
							
							//Check if lookupField is not null
							if(lookupField != null)
							{
								//Get the ID of the LookupField
								System.out.println("Field AssociationDetails LookupField ID: " + lookupField.getId());
								
								//Get the Name of the LookupField
								System.out.println("Field AssociationDetails LookupField Name: " + lookupField.getName());
							}
							
							//Get the Object obtained LookupField instance
							LookupField relatedField = associationDetails.getRelatedField();
							
							//Check if relatedField is not null
							if(relatedField != null)
							{
								//Get the ID of the relatedField
								System.out.println("Field AssociationDetails RelatedField ID: " + relatedField.getId());
								
								//Get the Name of the relatedField
								System.out.println("Field AssociationDetails RelatedField Name: " + relatedField.getName());
							}
						}

						if(field.getQuickSequenceNumber() != null)
						{
							//Get the QuickSequenceNumber of each Field
							System.out.println("Field QuickSequenceNumber: " + field.getQuickSequenceNumber().toString());
						}

						//Get the BusinesscardSupported of each Field
						System.out.println("Field BusinesscardSupported: " + field.getBusinesscardSupported().toString());

						//Get the Object obtained MultiModuleLookup instance
						MultiModuleLookup multiModuleLookup = field.getMultiModuleLookup();
						
						//Check if multiModuleLookup is not null
						if(multiModuleLookup != null)
						{
							//Get the Name of the MultiModuleLookup
							System.out.println("Field MultiModuleLookup Name: " + multiModuleLookup.getName());
							
							//Get the Value of the MultiModuleLookup
							System.out.println("Field MultiModuleLookup Id: " + multiModuleLookup.getId());
							
							//Get the Object obtained Module instance
							Module module = multiModuleLookup.getModule();
							
							//Check if module is not null
							if(module != null)
							{
								//Get the ID of the Module
								System.out.println("Field MultiModuleLookup Module ID: " + module.getId());
								
								//Get the Name of the Module
								System.out.println("Field MultiModuleLookup Module APIName: " + module.getAPIName());
							}
						}

						//Get the Object obtained Currency instance
						Currency currency = field.getCurrency();

						//Check if currency is not null
						if(currency != null)
						{
							//Get the RoundingOption of the Currency
							System.out.println("Field Currency RoundingOption: " + currency.getRoundingOption());
							
							if(currency.getPrecision() != null)
							{
								//Get the Precision of the Currency
								System.out.println("Field Currency Precision: " + currency.getPrecision().toString());
							}
						}

						//Get the ID of each Field
						System.out.println("Field ID: " + field.getId().toString());

						if(field.getCustomField() != null)
						{
							//Get the CustomField of each Field
							System.out.println("Field CustomField: " + field.getCustomField().toString());
						}

						//Get the Object obtained Module instance
						Module lookup = field.getLookup();

						//Check if lookup is not null
						if(lookup != null)
						{
							//Get the Object obtained Layout instance
							Layout layout = lookup.getLayout();
							
							//Check if layout is not null
							if(layout != null)
							{
								//Get the ID of the Layout
								System.out.println("Field ModuleLookup Layout ID: " + layout.getId().toString());
								
								//Get the Name of the Layout
								System.out.println("Field ModuleLookup Layout Name: " + layout.getName());
							}
							
							//Get the DisplayLabel of the Module
							System.out.println("Field ModuleLookup DisplayLabel: " + lookup.getDisplayLabel());
							
							//Get the APIName of the Module
							System.out.println("Field ModuleLookup APIName: " + lookup.getAPIName());
							
							//Get the Module of the Module
							System.out.println("Field ModuleLookup Module: " + lookup.getModule());
							
							if(lookup.getId() != null)
							{
								//Get the ID of the Module
								System.out.println("Field ModuleLookup ID: " + lookup.getId().toString());
							}
						}

						//Get the Filterable of each Field
						System.out.println("Field Filterable: " + field.getFilterable() );

						if(field.getVisible() != null)
						{
							//Get the Visible of each Field
							System.out.println("Field Visible: " + field.getVisible().toString());
						}
						
						//Get field profiles
						List<Profile> fieldProfiles = field.getProfiles();

						for (Profile fieldProfile : fieldProfiles) 
						{
							//get profile permission type
							System.out.println("Profile permission Type "+fieldProfile.getPermissionType());
							//get profile name
							System.out.println("Profile Name  "+fieldProfile.getName());
							//get profile id
							System.out.println("Profile ID  "+fieldProfile.getId());
						}

						if(field.getLength() != null)
						{
							//Get the Length of each Field
							System.out.println("Field Length: " + field.getLength().toString());
						}

						//Get the Object obtained ViewType instance
						ViewType viewType = field.getViewType();

						//Check if viewType is not null
						if(viewType != null)
						{
							//Get the View of the ViewType
							System.out.println("Field ViewType View: " + viewType.getView().toString());
							
							//Get the Edit of the ViewType
							System.out.println("Field ViewType Edit: " + viewType.getEdit().toString());
							
							//Get the Create of the ViewType
							System.out.println("Field ViewType Create: " + viewType.getCreate().toString());
							
							//Get the View of the ViewType
							System.out.println("Field ViewType QuickCreate: " + viewType.getQuickCreate().toString());
						}

						if(field.getDisplayField() != null) 
						{
							//check if field is DisplayField
							System.out.println("Field DisplayField " + field.getDisplayField());
						}

						if(field.getPickListValuesSortedLexically() != null)
						{
							//check if pick list values is lexically sorted for each Field
							System.out.println("Field pick list values lexically sorted: " + field.getPickListValuesSortedLexically());
						}

						if(field.getSortable() != null) 
						{
							//check if field is sortable
							System.out.println("Field sortable " + field.getSortable());
						}

						//Get the Object obtained Module instance
						Module subform = field.getSubform();
						
						//Check if subform is not null
						if(subform != null)
						{
							//Get the Object obtained Layout instance
							Layout layout = subform.getLayout();
							
							//Check if layout is not null
							if(layout != null)
							{
								//Get the ID of the Layout
								System.out.println("Field Subform Layout ID: " + layout.getId().toString());
								
								//Get the Name of the Layout
								System.out.println("Field Subform Layout Name: " + layout.getName());
							}
							
							//Get the DisplayLabel of the Module
							System.out.println("Field Subform DisplayLabel: " + subform.getDisplayLabel());
							
							//Get the APIName of the Module
							System.out.println("Field Subform APIName: " + subform.getAPIName());
							
							//Get the Module of the Module
							System.out.println("Field Subform Module: " + subform.getModule());
							
							if(subform.getId() != null)
							{
								//Get the ID of the Module
								System.out.println("Field Subform ID: " + subform.getId().toString());	
							}
						}

						//Check if External is not null
						if(field.getExternal() != null) 
						{
							System.out.println("Get External show " + field.getExternal().getShow());
							System.out.println("Get External type" + field.getExternal().getType());
							System.out.println("allow multiple config" + field.getExternal().getAllowMultipleConfig());
						}

						//Get the APIName of each Field
						System.out.println("Field APIName: " + field.getAPIName().toString());

						//Get the Object obtained Unique instance
						Unique unique = field.getUnique();

						//Check if unique is not null
						if(unique != null)
						{
							//Get the Casesensitive of the Unique
							System.out.println("Field Unique Casesensitive : " + unique.getCasesensitive());
						}

						if(field.getHistoryTracking() != null)
						{
							HistoryTracking historytracking = field.getHistoryTracking();
							
							//Get the Module  of history tracking 
							Module module =  historytracking.getModule();
							
							if (module != null) 
							{
								Layout moduleLayout = module.getLayout();
								if (moduleLayout != null) 
								{
									System.out.println("Module layout id"+moduleLayout.getId());
								}
								System.out.println("Module layout display label"+module.getDisplayLabel());
								System.out.println("Module layout api name"+module.getAPIName());
								System.out.println("Module layout module"+module.getId());
								System.out.println("Module layout id"+module.getModule());
								System.out.println("Module layout module name"+module.getModuleName());
							}
							//Get the duration configured field of each history tracking
							Field durationConfigured = historytracking.getDurationConfiguredField();
							if(durationConfigured != null) 
							{
								System.out.println("historytracking duration configured field"+durationConfigured.getId());
							}
						}

						//Get the DataType of each Field
						System.out.println("Field DataType: " + field.getDataType().toString());

						//Get the Object obtained Formula instance
						Formula formula = field.getFormula();

						//Check if formula is not null
						if(formula != null)
						{
							//Get the ReturnType of the Formula
							System.out.println("Field Formula ReturnType : " + formula.getReturnType());
							
							if(formula.getExpression() != null)
							{
								//Get the Expression of the Formula
								System.out.println("Field Formula Expression : " + formula.getExpression().toString());
							}
						}

						if(field.getDecimalPlace() != null)
						{
							//Get the DecimalPlace of each Field
							System.out.println("Field DecimalPlace: " + field.getDecimalPlace().toString());
						}

						//Get the MassUpdate of each Field
						System.out.println("Field MassUpdate: " + field.getMassUpdate().toString());

						if(field.getBlueprintSupported() != null)
						{
							//Get the BlueprintSupported of each Field
							System.out.println("Field BlueprintSupported: " + field.getBlueprintSupported().toString());
						}

						//Get all entries from the MultiSelectLookup instance
						MultiSelectLookup multiSelectLookup = field.getMultiselectlookup();

						//Check if formula is not null
						if(multiSelectLookup != null)
						{
							//Get the DisplayValue of the MultiSelectLookup
							System.out.println("Field MultiSelectLookup DisplayLabel: " + multiSelectLookup.getDisplayLabel());
							
							//Get the LinkingModule of the MultiSelectLookup
							System.out.println("Field MultiSelectLookup LinkingModule: " + multiSelectLookup.getLinkingModule());
							
							//Get the LookupApiname of the MultiSelectLookup
							System.out.println("Field MultiSelectLookup LookupApiname: " + multiSelectLookup.getLookupApiname());
							
							//Get the APIName of the MultiSelectLookup
							System.out.println("Field MultiSelectLookup APIName: " + multiSelectLookup.getAPIName());
							
							//Get the ConnectedlookupApiname of the MultiSelectLookup
							System.out.println("Field MultiSelectLookup ConnectedlookupApiname: " + multiSelectLookup.getConnectedlookupApiname());
							
							//Get the ID of the MultiSelectLookup
							System.out.println("Field MultiSelectLookup ID: " + multiSelectLookup.getId());
							
							//Get the connected module of the MultiSelectLookup
							System.out.println("Field MultiSelectLookup connected module: " + multiSelectLookup.getConnectedModule());
						}

						//Get the PickListValue of each Field
						List<PickListValue> pickListValues = field.getPickListValues();

						if(pickListValues != null)
						{
							for(PickListValue pickListValue : pickListValues)
							{
								printPickListValue(pickListValue);
							}
						}

						//Check if ConvertMapping is not null
						if(field.getConvertMapping() != null)
						{
							//Get the details map
							for(Entry<String, Object> cm :field.getConvertMapping().entrySet()) {
								//Get each value in the map
								System.out.println(cm.getKey() + " : "+ cm.getValue() );
							}
							
						}

						if(field.getSequenceNumber()!=null) {
							//get UI type of field
							System.out.println("Field sequence number " + field.getSequenceNumber());
						}
						
						if(field.getHistoryTracking() != null)
						{
							//Get the HistoryTracking of each Field
							System.out.println("Field HistoryTracking: " + field.getHistoryTracking().toString());
						}
						
						//Get the AutoNumber of each Field
						AutoNumber autoNumber = field.getAutoNumber();
						
						//Check if autoNumber is not null
						if(autoNumber != null)
						{
							//Get the Prefix of the AutoNumber
							System.out.println("Field AutoNumber Prefix: " + autoNumber.getPrefix());
							
							//Get the Suffix of the AutoNumber
							System.out.println("Field AutoNumber Suffix: " + autoNumber.getSuffix());
							
							if(autoNumber.getStartNumber() != null)
							{
								//Get the StartNumber of the AutoNumber
								System.out.println("Field AutoNumber StartNumber: " + autoNumber.getStartNumber().toString());
							}
						}
						
						if(field.getDefaultValue() != null)
						{
							//Get the DefaultValue of each Field
							System.out.println("Field DefaultValue: " + field.getDefaultValue().toString());
						}
						
						//Check if ValidationRule is not null
						if(field.getValidationRule() != null)
						{
							//Get the details map
							for(Map.Entry<String, Object> entry : field.getValidationRule().entrySet())
							{
								//Get each value in the map
								System.out.println(entry.getKey() + ": " + entry.getValue());
							}
						}

						//get multi user lookup for field
						if (field.getMultiuserlookup()!=null) {
							MultiUserLookup multiuserlookup = field.getMultiuserlookup();
							//get displaylabel of multiuser lookup
							System.out.println("Get multiuserlookup display label" + multiuserlookup.getDisplayLabel());
							//get linking module of multiuser lookup
							System.out.println("Get multiuserlookup linking module" + multiuserlookup.getLinkingModule());
							//get lookup apiname of multiuser lookup
							System.out.println("Get multiuserlookup lookup api_name" + multiuserlookup.getLookupApiname());
							//get apiname of multiuser lookup
							System.out.println("Get multiuserlookup api name" + multiuserlookup.getAPIName());
							//get id of multiuser lookup
							System.out.println("Get multiuserlookup id" + multiuserlookup.getId());
							//get connected module of multiuser lookup
							System.out.println("Get multiuserlookup connected module" + multiuserlookup.getConnectedModule());
							//get connected lookup apiname of multiuser lookup
							System.out.println("Get multiuserlookup connected lookup api name" + multiuserlookup.getConnectedlookupApiname());
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
		
		//Get the Probability of each PickListValues
		System.out.println(" Fields PickListValue Probability: " + pickListValue.getProbability());
		
		//Get the ForecastCategory of each PickListValues
		System.out.println(" Fields PickListValue ForecastCategory: " + pickListValue.getForecastCategory());
		
		//Get the SequenceNumber of each PickListValues
		System.out.println(" Fields PickListValue SequenceNumber: " + pickListValue.getSequenceNumber());
		
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
		
		//Get the ForecastType of each PickListValues
		System.out.println(" Fields PickListValue ForecastType: " + pickListValue.getForecastType());
		
		if (pickListValue.getMaps()!=null) 
		{
			for(Maps map : pickListValue.getMaps())
			{
				//Get each value from the map
				System.out.println(map);

				List<PickListValue> pickListValues = map.getPickListValues();
	
				//Check if formula is not null
				if(pickListValues != null)
				{
					for(PickListValue pickListValue1 : pickListValues)
					{
						printPickListValue(pickListValue1);
					}
				}
			}
		}
    }
}
