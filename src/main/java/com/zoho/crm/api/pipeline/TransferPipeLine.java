package com.zoho.crm.api.pipeline;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class TransferPipeLine implements Model
{
	private Pipeline pipeline;

	private List<Stage> stages;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of pipeline
	 * @return An instance of Pipeline
	 */
	public Pipeline getPipeline()
	{
		return  this.pipeline;

	}

	/**
	 * The method to set the value to pipeline
	 * @param pipeline An instance of Pipeline
	 */
	public void setPipeline(Pipeline pipeline)
	{
		 this.pipeline = pipeline;

		 this.keyModified.put("pipeline", 1);

	}

	/**
	 * The method to get the value of stages
	 * @return An instance of List<Stage>
	 */
	public List<Stage> getStages()
	{
		return  this.stages;

	}

	/**
	 * The method to set the value to stages
	 * @param stages An instance of List<Stage>
	 */
	public void setStages(List<Stage> stages)
	{
		 this.stages = stages;

		 this.keyModified.put("stages", 1);

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