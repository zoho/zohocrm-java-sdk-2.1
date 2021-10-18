package com.zoho.crm.api.record;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class ImageUpload implements Model
{
	private String description;

	private String previewId;

	private String encryptedId;

	private String fileName;

	private String state;

	private String fileId;

	private Long size;

	private Integer sequenceNumber;

	private Long id;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of description
	 * @return A String representing the description
	 */
	public String getDescription()
	{
		return  this.description;

	}

	/**
	 * The method to set the value to description
	 * @param description A String representing the description
	 */
	public void setDescription(String description)
	{
		 this.description = description;

		 this.keyModified.put("Description", 1);

	}

	/**
	 * The method to get the value of previewId
	 * @return A String representing the previewId
	 */
	public String getPreviewId()
	{
		return  this.previewId;

	}

	/**
	 * The method to set the value to previewId
	 * @param previewId A String representing the previewId
	 */
	public void setPreviewId(String previewId)
	{
		 this.previewId = previewId;

		 this.keyModified.put("Preview_Id", 1);

	}

	/**
	 * The method to get the value of encryptedId
	 * @return A String representing the encryptedId
	 */
	public String getEncryptedId()
	{
		return  this.encryptedId;

	}

	/**
	 * The method to set the value to encryptedId
	 * @param encryptedId A String representing the encryptedId
	 */
	public void setEncryptedId(String encryptedId)
	{
		 this.encryptedId = encryptedId;

		 this.keyModified.put("Encrypted_Id", 1);

	}

	/**
	 * The method to get the value of fileName
	 * @return A String representing the fileName
	 */
	public String getFileName()
	{
		return  this.fileName;

	}

	/**
	 * The method to set the value to fileName
	 * @param fileName A String representing the fileName
	 */
	public void setFileName(String fileName)
	{
		 this.fileName = fileName;

		 this.keyModified.put("File_Name", 1);

	}

	/**
	 * The method to get the value of state
	 * @return A String representing the state
	 */
	public String getState()
	{
		return  this.state;

	}

	/**
	 * The method to set the value to state
	 * @param state A String representing the state
	 */
	public void setState(String state)
	{
		 this.state = state;

		 this.keyModified.put("State", 1);

	}

	/**
	 * The method to get the value of fileId
	 * @return A String representing the fileId
	 */
	public String getFileId()
	{
		return  this.fileId;

	}

	/**
	 * The method to set the value to fileId
	 * @param fileId A String representing the fileId
	 */
	public void setFileId(String fileId)
	{
		 this.fileId = fileId;

		 this.keyModified.put("File_Id", 1);

	}

	/**
	 * The method to get the value of size
	 * @return A Long representing the size
	 */
	public Long getSize()
	{
		return  this.size;

	}

	/**
	 * The method to set the value to size
	 * @param size A Long representing the size
	 */
	public void setSize(Long size)
	{
		 this.size = size;

		 this.keyModified.put("Size", 1);

	}

	/**
	 * The method to get the value of sequenceNumber
	 * @return An Integer representing the sequenceNumber
	 */
	public Integer getSequenceNumber()
	{
		return  this.sequenceNumber;

	}

	/**
	 * The method to set the value to sequenceNumber
	 * @param sequenceNumber An Integer representing the sequenceNumber
	 */
	public void setSequenceNumber(Integer sequenceNumber)
	{
		 this.sequenceNumber = sequenceNumber;

		 this.keyModified.put("Sequence_Number", 1);

	}

	/**
	 * The method to get the value of id
	 * @return A Long representing the id
	 */
	public Long getId()
	{
		return  this.id;

	}

	/**
	 * The method to set the value to id
	 * @param id A Long representing the id
	 */
	public void setId(Long id)
	{
		 this.id = id;

		 this.keyModified.put("id", 1);

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