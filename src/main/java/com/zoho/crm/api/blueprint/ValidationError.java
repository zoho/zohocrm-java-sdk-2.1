package com.zoho.crm.api.blueprint;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class ValidationError implements Model
{
	private String apiName;

	private String infoMessage;

	private String message;

	private Integer index;

	private String parentAPIName;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of apiName
	 * @return A String representing the apiName
	 */
	public String getAPIName()
	{
		return  this.apiName;

	}

	/**
	 * The method to set the value to apiName
	 * @param apiName A String representing the apiName
	 */
	public void setAPIName(String apiName)
	{
		 this.apiName = apiName;

		 this.keyModified.put("api_name", 1);

	}

	/**
	 * The method to get the value of infoMessage
	 * @return A String representing the infoMessage
	 */
	public String getInfoMessage()
	{
		return  this.infoMessage;

	}

	/**
	 * The method to set the value to infoMessage
	 * @param infoMessage A String representing the infoMessage
	 */
	public void setInfoMessage(String infoMessage)
	{
		 this.infoMessage = infoMessage;

		 this.keyModified.put("info_message", 1);

	}

	/**
	 * The method to get the value of message
	 * @return A String representing the message
	 */
	public String getMessage()
	{
		return  this.message;

	}

	/**
	 * The method to set the value to message
	 * @param message A String representing the message
	 */
	public void setMessage(String message)
	{
		 this.message = message;

		 this.keyModified.put("message", 1);

	}

	/**
	 * The method to get the value of index
	 * @return An Integer representing the index
	 */
	public Integer getIndex()
	{
		return  this.index;

	}

	/**
	 * The method to set the value to index
	 * @param index An Integer representing the index
	 */
	public void setIndex(Integer index)
	{
		 this.index = index;

		 this.keyModified.put("index", 1);

	}

	/**
	 * The method to get the value of parentapiName
	 * @return A String representing the parentAPIName
	 */
	public String getParentAPIName()
	{
		return  this.parentAPIName;

	}

	/**
	 * The method to set the value to parentapiName
	 * @param parentAPIName A String representing the parentAPIName
	 */
	public void setParentAPIName(String parentAPIName)
	{
		 this.parentAPIName = parentAPIName;

		 this.keyModified.put("parent_api_name", 1);

	}

	/**
	 * The method to check if the user has modified the given key
	 * @param key A String representing the key
	 * @return An Integer representing the modification
	 */
	public Integer isKeyModified(String key)
	{
		if((( this.keyModified.containsKey(key))))
		{
			return  this.keyModified.get(key);

		}
		return null;

	}

	/**
	 * The method to mark the given key as modified
	 * @param key A String representing the key
	 * @param modification An Integer representing the modification
	 */
	public void setKeyModified(String key, Integer modification)
	{
		 this.keyModified.put(key, modification);

	}
}