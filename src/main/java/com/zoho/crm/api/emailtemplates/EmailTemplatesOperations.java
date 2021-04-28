package com.zoho.crm.api.emailtemplates;

import com.zoho.crm.api.Param;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Constants;

public class EmailTemplatesOperations
{
	private String module;

	/**
	 * Creates an instance of EmailTemplatesOperations with the given parameters
	 * @param module A String representing the module
	 */
	public EmailTemplatesOperations(String module)
	{
		 this.module = module;


	}

	/**
	 * The method to get email templates
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getEmailTemplates() throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v2.1/settings/email_templates");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.addParam(new Param<String>("module", "com.zoho.crm.api.EmailTemplates.GetEmailTemplatesParam"),  this.module);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to get email template by id
	 * @param id A Long representing the id
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getEmailTemplateById(Long id) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v2.1/settings/email_templates/");

		apiPath = apiPath.concat(id.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.addParam(new Param<String>("module", "com.zoho.crm.api.EmailTemplates.GetEmailTemplatebyIDParam"),  this.module);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}
	public static class GetEmailTemplatesParam
	{
	}

	public static class GetEmailTemplatebyIDParam
	{
	}
}