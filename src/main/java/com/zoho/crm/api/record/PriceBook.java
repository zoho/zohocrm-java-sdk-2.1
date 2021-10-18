package com.zoho.crm.api.record;

import com.zoho.crm.api.record.Record;
import com.zoho.crm.api.util.Model;

public class PriceBook extends Record implements Model
{

	/**
	 * The method to get the value of name
	 * @return A String representing the name
	 */
	public String getName()
	{
		return (String) this.getKeyValue("name");

	}

	/**
	 * The method to set the value to name
	 * @param name A String representing the name
	 */
	public void setName(String name)
	{
		 this.addKeyValue("name", name);

	}
}