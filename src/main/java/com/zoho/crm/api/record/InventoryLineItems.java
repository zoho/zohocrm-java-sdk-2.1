package com.zoho.crm.api.record;

import com.zoho.crm.api.record.Record;
import com.zoho.crm.api.util.Model;
import java.util.List;

public class InventoryLineItems extends Record implements Model
{

	/**
	 * The method to get the value of productName
	 * @return An instance of LineItemProduct
	 */
	public LineItemProduct getProductName()
	{
		return (LineItemProduct) this.getKeyValue("Product_Name");

	}

	/**
	 * The method to set the value to productName
	 * @param productName An instance of LineItemProduct
	 */
	public void setProductName(LineItemProduct productName)
	{
		 this.addKeyValue("Product_Name", productName);

	}

	/**
	 * The method to get the value of parentId
	 * @return An instance of Record
	 */
	public Record getParentId()
	{
		return (Record) this.getKeyValue("parent_id");

	}

	/**
	 * The method to set the value to parentId
	 * @param parentId An instance of Record
	 */
	public void setParentId(Record parentId)
	{
		 this.addKeyValue("parent_id", parentId);

	}

	/**
	 * The method to get the value of quantity
	 * @return An instance of Double
	 */
	public Double getQuantity()
	{
		return (Double) this.getKeyValue("Quantity");

	}

	/**
	 * The method to set the value to quantity
	 * @param quantity An instance of Double
	 */
	public void setQuantity(Double quantity)
	{
		 this.addKeyValue("Quantity", quantity);

	}

	/**
	 * The method to get the value of discount
	 * @return A String representing the discount
	 */
	public String getDiscount()
	{
		return (String) this.getKeyValue("Discount");

	}

	/**
	 * The method to set the value to discount
	 * @param discount A String representing the discount
	 */
	public void setDiscount(String discount)
	{
		 this.addKeyValue("Discount", discount);

	}

	/**
	 * The method to get the value of totalAfterDiscount
	 * @return An instance of Double
	 */
	public Double getTotalAfterDiscount()
	{
		return (Double) this.getKeyValue("Total_After_Discount");

	}

	/**
	 * The method to set the value to totalAfterDiscount
	 * @param totalAfterDiscount An instance of Double
	 */
	public void setTotalAfterDiscount(Double totalAfterDiscount)
	{
		 this.addKeyValue("Total_After_Discount", totalAfterDiscount);

	}

	/**
	 * The method to get the value of netTotal
	 * @return An instance of Double
	 */
	public Double getNetTotal()
	{
		return (Double) this.getKeyValue("Net_Total");

	}

	/**
	 * The method to set the value to netTotal
	 * @param netTotal An instance of Double
	 */
	public void setNetTotal(Double netTotal)
	{
		 this.addKeyValue("Net_Total", netTotal);

	}

	/**
	 * The method to get the value of priceBookName
	 * @return An instance of Double
	 */
	public Double getPriceBookName()
	{
		return (Double) this.getKeyValue("Price_Book_Name");

	}

	/**
	 * The method to set the value to priceBookName
	 * @param priceBookName An instance of Double
	 */
	public void setPriceBookName(Double priceBookName)
	{
		 this.addKeyValue("Price_Book_Name", priceBookName);

	}

	/**
	 * The method to get the value of tax
	 * @return An instance of Double
	 */
	public Double getTax()
	{
		return (Double) this.getKeyValue("Tax");

	}

	/**
	 * The method to set the value to tax
	 * @param tax An instance of Double
	 */
	public void setTax(Double tax)
	{
		 this.addKeyValue("Tax", tax);

	}

	/**
	 * The method to get the value of listPrice
	 * @return An instance of Double
	 */
	public Double getListPrice()
	{
		return (Double) this.getKeyValue("List_Price");

	}

	/**
	 * The method to set the value to listPrice
	 * @param listPrice An instance of Double
	 */
	public void setListPrice(Double listPrice)
	{
		 this.addKeyValue("List_Price", listPrice);

	}

	/**
	 * The method to get the value of unitPrice
	 * @return An instance of Double
	 */
	public Double getUnitPrice()
	{
		return (Double) this.getKeyValue("unit_price");

	}

	/**
	 * The method to set the value to unitPrice
	 * @param unitPrice An instance of Double
	 */
	public void setUnitPrice(Double unitPrice)
	{
		 this.addKeyValue("unit_price", unitPrice);

	}

	/**
	 * The method to get the value of quantityInStock
	 * @return An instance of Double
	 */
	public Double getQuantityInStock()
	{
		return (Double) this.getKeyValue("quantity_in_stock");

	}

	/**
	 * The method to set the value to quantityInStock
	 * @param quantityInStock An instance of Double
	 */
	public void setQuantityInStock(Double quantityInStock)
	{
		 this.addKeyValue("quantity_in_stock", quantityInStock);

	}

	/**
	 * The method to get the value of total
	 * @return An instance of Double
	 */
	public Double getTotal()
	{
		return (Double) this.getKeyValue("Total");

	}

	/**
	 * The method to set the value to total
	 * @param total An instance of Double
	 */
	public void setTotal(Double total)
	{
		 this.addKeyValue("Total", total);

	}

	/**
	 * The method to get the value of description
	 * @return A String representing the description
	 */
	public String getDescription()
	{
		return (String) this.getKeyValue("Description");

	}

	/**
	 * The method to set the value to description
	 * @param description A String representing the description
	 */
	public void setDescription(String description)
	{
		 this.addKeyValue("Description", description);

	}

	/**
	 * The method to get the value of lineTax
	 * @return An instance of List<LineTax>
	 */
	public List<LineTax> getLineTax()
	{
		return (List<LineTax>) this.getKeyValue("Line_Tax");

	}

	/**
	 * The method to set the value to lineTax
	 * @param lineTax An instance of List<LineTax>
	 */
	public void setLineTax(List<LineTax> lineTax)
	{
		 this.addKeyValue("Line_Tax", lineTax);

	}
}