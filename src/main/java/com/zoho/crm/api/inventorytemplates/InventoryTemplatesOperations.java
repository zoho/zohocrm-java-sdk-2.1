package com.zoho.crm.api.inventorytemplates;

import com.zoho.crm.api.Param;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Constants;

public class InventoryTemplatesOperations
{
	private String module;

	private String sortBy;

	private String sortOrder;

	private String category;

	/**
	 * Creates an instance of InventoryTemplatesOperations with the given parameters
	 * @param module A String representing the module
	 * @param sortBy A String representing the sortBy
	 * @param sortOrder A String representing the sortOrder
	 * @param category A String representing the category
	 */
	public InventoryTemplatesOperations(String module, String sortBy, String sortOrder, String category)
	{
		 this.module = module;

		 this.sortBy = sortBy;

		 this.sortOrder = sortOrder;

		 this.category = category;


	}

	/**
	 * The method to get inventory templates
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getInventoryTemplates() throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v2.1/settings/inventory_templates");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.addParam(new Param<String>("module", "com.zoho.crm.api.InventoryTemplates.GetInventoryTemplatesParam"),  this.module);

		handlerInstance.addParam(new Param<String>("sort_by", "com.zoho.crm.api.InventoryTemplates.GetInventoryTemplatesParam"),  this.sortBy);

		handlerInstance.addParam(new Param<String>("sort_order", "com.zoho.crm.api.InventoryTemplates.GetInventoryTemplatesParam"),  this.sortOrder);

		handlerInstance.addParam(new Param<String>("category", "com.zoho.crm.api.InventoryTemplates.GetInventoryTemplatesParam"),  this.category);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to get inventory template by id
	 * @param id A Long representing the id
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getInventoryTemplateById(Long id) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v2.1/settings/inventory_templates/");

		apiPath = apiPath.concat(id.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.addParam(new Param<String>("module", "com.zoho.crm.api.InventoryTemplates.GetInventoryTemplatebyIDParam"),  this.module);

		handlerInstance.addParam(new Param<String>("sort_by", "com.zoho.crm.api.InventoryTemplates.GetInventoryTemplatebyIDParam"),  this.sortBy);

		handlerInstance.addParam(new Param<String>("sort_order", "com.zoho.crm.api.InventoryTemplates.GetInventoryTemplatebyIDParam"),  this.sortOrder);

		handlerInstance.addParam(new Param<String>("category", "com.zoho.crm.api.InventoryTemplates.GetInventoryTemplatebyIDParam"),  this.category);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}
	public static class GetInventoryTemplatesParam
	{
	}

	public static class GetInventoryTemplatebyIDParam
	{
	}
}