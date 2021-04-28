package com.zoho.crm.api.pipeline;

import com.zoho.crm.api.Param;
import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Constants;

public class PipelineOperations
{
	private Long layoutId;

	/**
	 * Creates an instance of PipelineOperations with the given parameters
	 * @param layoutId A Long representing the layoutId
	 */
	public PipelineOperations(Long layoutId)
	{
		 this.layoutId = layoutId;


	}

	/**
	 * The method to transfer and delete
	 * @param request An instance of TransferAndDeleteWrapper
	 * @return An instance of APIResponse<TransferActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<TransferActionHandler> transferAndDelete(TransferAndDeleteWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v2.1/settings/pipeline/actions/transfer");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_CREATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.addParam(new Param<Long>("layout_id", "com.zoho.crm.api.Pipeline.TransferAndDeleteParam"),  this.layoutId);

		return handlerInstance.apiCall(TransferActionHandler.class, "application/json");

	}

	/**
	 * The method to get pipelines
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getPipelines() throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v2.1/settings/pipeline");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.addParam(new Param<Long>("layout_id", "com.zoho.crm.api.Pipeline.GetPipelinesParam"),  this.layoutId);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to create pipelines
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> createPipelines(BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v2.1/settings/pipeline");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_CREATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.addParam(new Param<Long>("layout_id", "com.zoho.crm.api.Pipeline.CreatePipelinesParam"),  this.layoutId);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to update pipelines
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> updatePipelines(BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v2.1/settings/pipeline");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_UPDATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		handlerInstance.addParam(new Param<Long>("layout_id", "com.zoho.crm.api.Pipeline.UpdatePipelinesParam"),  this.layoutId);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}

	/**
	 * The method to get pipeline
	 * @param pipelineId A Long representing the pipelineId
	 * @return An instance of APIResponse<ResponseHandler>
	 * @throws SDKException
	 */
	public APIResponse<ResponseHandler> getPipeline(Long pipelineId) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v2.1/settings/pipeline/");

		apiPath = apiPath.concat(pipelineId.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ);

		handlerInstance.addParam(new Param<Long>("layout_id", "com.zoho.crm.api.Pipeline.GetPipelineParam"),  this.layoutId);

		return handlerInstance.apiCall(ResponseHandler.class, "application/json");

	}

	/**
	 * The method to update pipeline
	 * @param pipelineId A Long representing the pipelineId
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<ActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<ActionHandler> updatePipeline(Long pipelineId, BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v2.1/settings/pipeline/");

		apiPath = apiPath.concat(pipelineId.toString());

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_PUT);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_UPDATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.addParam(new Param<Long>("layout_id", "com.zoho.crm.api.Pipeline.UpdatePipelineParam"),  this.layoutId);

		return handlerInstance.apiCall(ActionHandler.class, "application/json");

	}
	public static class TransferAndDeleteParam
	{
	}

	public static class GetPipelinesParam
	{
	}

	public static class CreatePipelinesParam
	{
	}

	public static class UpdatePipelinesParam
	{
	}

	public static class GetPipelineParam
	{
	}

	public static class UpdatePipelineParam
	{
	}
}