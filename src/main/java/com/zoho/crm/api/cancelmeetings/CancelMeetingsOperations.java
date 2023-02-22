package com.zoho.crm.api.cancelmeetings;

import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Constants;

public class CancelMeetingsOperations
{
	private Long eventId;

	/**
	 * Creates an instance of CancelMeetingsOperations with the given parameters
	 * @param eventId A Long representing the eventId
	 */
	public CancelMeetingsOperations(Long eventId)
	{
		 this.eventId = eventId;


	}

	/**
	 * The method to cancel meetings
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> cancelMeetings(BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v2.1/Events/");

		apiPath = apiPath.concat( this.eventId.toString());

		apiPath = apiPath.concat("/actions/cancel");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_ACTION);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}
}