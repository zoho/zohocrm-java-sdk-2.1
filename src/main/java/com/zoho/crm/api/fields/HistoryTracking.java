package com.zoho.crm.api.fields;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class HistoryTracking implements Model
{
	private Module module;

	private Field durationConfiguredField;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of module
	 * @return An instance of Module
	 */
	public Module getModule()
	{
		return  this.module;

	}

	/**
	 * The method to set the value to module
	 * @param module An instance of Module
	 */
	public void setModule(Module module)
	{
		 this.module = module;

		 this.keyModified.put("module", 1);

	}

	/**
	 * The method to get the value of durationConfiguredField
	 * @return An instance of Field
	 */
	public Field getDurationConfiguredField()
	{
		return  this.durationConfiguredField;

	}

	/**
	 * The method to set the value to durationConfiguredField
	 * @param durationConfiguredField An instance of Field
	 */
	public void setDurationConfiguredField(Field durationConfiguredField)
	{
		 this.durationConfiguredField = durationConfiguredField;

		 this.keyModified.put("duration_configured_field", 1);

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