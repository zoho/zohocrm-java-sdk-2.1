package com.zoho.crm.api.sendmail;

import com.zoho.crm.api.attachments.Attachment;
import com.zoho.crm.api.util.Model;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;

public class Mail implements Model
{
	private UserAddress from;

	private List<UserAddress> to;

	private List<UserAddress> cc;

	private List<UserAddress> bcc;

	private UserAddress replyTo;

	private Template template;

	private Integer email;

	private Long id;

	private String inReplyTo;

	private OffsetDateTime scheduledTime;

	private String subject;

	private String content;

	private String paperType;

	private String viewType;

	private String mailFormat;

	private Boolean consentEmail;

	private Boolean orgEmail;

	private List<Attachment> attachments;

	private InventoryDetails inventoryDetails;

	private DataSubjectRequest dataSubjectRequest;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of from
	 * @return An instance of UserAddress
	 */
	public UserAddress getFrom()
	{
		return  this.from;

	}

	/**
	 * The method to set the value to from
	 * @param from An instance of UserAddress
	 */
	public void setFrom(UserAddress from)
	{
		 this.from = from;

		 this.keyModified.put("from", 1);

	}

	/**
	 * The method to get the value of to
	 * @return An instance of List<UserAddress>
	 */
	public List<UserAddress> getTo()
	{
		return  this.to;

	}

	/**
	 * The method to set the value to to
	 * @param to An instance of List<UserAddress>
	 */
	public void setTo(List<UserAddress> to)
	{
		 this.to = to;

		 this.keyModified.put("to", 1);

	}

	/**
	 * The method to get the value of cc
	 * @return An instance of List<UserAddress>
	 */
	public List<UserAddress> getCc()
	{
		return  this.cc;

	}

	/**
	 * The method to set the value to cc
	 * @param cc An instance of List<UserAddress>
	 */
	public void setCc(List<UserAddress> cc)
	{
		 this.cc = cc;

		 this.keyModified.put("cc", 1);

	}

	/**
	 * The method to get the value of bcc
	 * @return An instance of List<UserAddress>
	 */
	public List<UserAddress> getBcc()
	{
		return  this.bcc;

	}

	/**
	 * The method to set the value to bcc
	 * @param bcc An instance of List<UserAddress>
	 */
	public void setBcc(List<UserAddress> bcc)
	{
		 this.bcc = bcc;

		 this.keyModified.put("bcc", 1);

	}

	/**
	 * The method to get the value of replyTo
	 * @return An instance of UserAddress
	 */
	public UserAddress getReplyTo()
	{
		return  this.replyTo;

	}

	/**
	 * The method to set the value to replyTo
	 * @param replyTo An instance of UserAddress
	 */
	public void setReplyTo(UserAddress replyTo)
	{
		 this.replyTo = replyTo;

		 this.keyModified.put("reply_to", 1);

	}

	/**
	 * The method to get the value of template
	 * @return An instance of Template
	 */
	public Template getTemplate()
	{
		return  this.template;

	}

	/**
	 * The method to set the value to template
	 * @param template An instance of Template
	 */
	public void setTemplate(Template template)
	{
		 this.template = template;

		 this.keyModified.put("template", 1);

	}

	/**
	 * The method to get the value of email
	 * @return An Integer representing the email
	 */
	public Integer getEmail()
	{
		return  this.email;

	}

	/**
	 * The method to set the value to email
	 * @param email An Integer representing the email
	 */
	public void setEmail(Integer email)
	{
		 this.email = email;

		 this.keyModified.put("email", 1);

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
	 * The method to get the value of inReplyTo
	 * @return A String representing the inReplyTo
	 */
	public String getInReplyTo()
	{
		return  this.inReplyTo;

	}

	/**
	 * The method to set the value to inReplyTo
	 * @param inReplyTo A String representing the inReplyTo
	 */
	public void setInReplyTo(String inReplyTo)
	{
		 this.inReplyTo = inReplyTo;

		 this.keyModified.put("in_reply_to", 1);

	}

	/**
	 * The method to get the value of scheduledTime
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getScheduledTime()
	{
		return  this.scheduledTime;

	}

	/**
	 * The method to set the value to scheduledTime
	 * @param scheduledTime An instance of OffsetDateTime
	 */
	public void setScheduledTime(OffsetDateTime scheduledTime)
	{
		 this.scheduledTime = scheduledTime;

		 this.keyModified.put("scheduled_time", 1);

	}

	/**
	 * The method to get the value of subject
	 * @return A String representing the subject
	 */
	public String getSubject()
	{
		return  this.subject;

	}

	/**
	 * The method to set the value to subject
	 * @param subject A String representing the subject
	 */
	public void setSubject(String subject)
	{
		 this.subject = subject;

		 this.keyModified.put("subject", 1);

	}

	/**
	 * The method to get the value of content
	 * @return A String representing the content
	 */
	public String getContent()
	{
		return  this.content;

	}

	/**
	 * The method to set the value to content
	 * @param content A String representing the content
	 */
	public void setContent(String content)
	{
		 this.content = content;

		 this.keyModified.put("content", 1);

	}

	/**
	 * The method to get the value of paperType
	 * @return A String representing the paperType
	 */
	public String getPaperType()
	{
		return  this.paperType;

	}

	/**
	 * The method to set the value to paperType
	 * @param paperType A String representing the paperType
	 */
	public void setPaperType(String paperType)
	{
		 this.paperType = paperType;

		 this.keyModified.put("paper_type", 1);

	}

	/**
	 * The method to get the value of viewType
	 * @return A String representing the viewType
	 */
	public String getViewType()
	{
		return  this.viewType;

	}

	/**
	 * The method to set the value to viewType
	 * @param viewType A String representing the viewType
	 */
	public void setViewType(String viewType)
	{
		 this.viewType = viewType;

		 this.keyModified.put("view_type", 1);

	}

	/**
	 * The method to get the value of mailFormat
	 * @return A String representing the mailFormat
	 */
	public String getMailFormat()
	{
		return  this.mailFormat;

	}

	/**
	 * The method to set the value to mailFormat
	 * @param mailFormat A String representing the mailFormat
	 */
	public void setMailFormat(String mailFormat)
	{
		 this.mailFormat = mailFormat;

		 this.keyModified.put("mail_format", 1);

	}

	/**
	 * The method to get the value of consentEmail
	 * @return A Boolean representing the consentEmail
	 */
	public Boolean getConsentEmail()
	{
		return  this.consentEmail;

	}

	/**
	 * The method to set the value to consentEmail
	 * @param consentEmail A Boolean representing the consentEmail
	 */
	public void setConsentEmail(Boolean consentEmail)
	{
		 this.consentEmail = consentEmail;

		 this.keyModified.put("consent_email", 1);

	}

	/**
	 * The method to get the value of orgEmail
	 * @return A Boolean representing the orgEmail
	 */
	public Boolean getOrgEmail()
	{
		return  this.orgEmail;

	}

	/**
	 * The method to set the value to orgEmail
	 * @param orgEmail A Boolean representing the orgEmail
	 */
	public void setOrgEmail(Boolean orgEmail)
	{
		 this.orgEmail = orgEmail;

		 this.keyModified.put("org_email", 1);

	}

	/**
	 * The method to get the value of attachments
	 * @return An instance of List<Attachment>
	 */
	public List<Attachment> getAttachments()
	{
		return  this.attachments;

	}

	/**
	 * The method to set the value to attachments
	 * @param attachments An instance of List<Attachment>
	 */
	public void setAttachments(List<Attachment> attachments)
	{
		 this.attachments = attachments;

		 this.keyModified.put("attachments", 1);

	}

	/**
	 * The method to get the value of inventoryDetails
	 * @return An instance of InventoryDetails
	 */
	public InventoryDetails getInventoryDetails()
	{
		return  this.inventoryDetails;

	}

	/**
	 * The method to set the value to inventoryDetails
	 * @param inventoryDetails An instance of InventoryDetails
	 */
	public void setInventoryDetails(InventoryDetails inventoryDetails)
	{
		 this.inventoryDetails = inventoryDetails;

		 this.keyModified.put("inventory_details", 1);

	}

	/**
	 * The method to get the value of dataSubjectRequest
	 * @return An instance of DataSubjectRequest
	 */
	public DataSubjectRequest getDataSubjectRequest()
	{
		return  this.dataSubjectRequest;

	}

	/**
	 * The method to set the value to dataSubjectRequest
	 * @param dataSubjectRequest An instance of DataSubjectRequest
	 */
	public void setDataSubjectRequest(DataSubjectRequest dataSubjectRequest)
	{
		 this.dataSubjectRequest = dataSubjectRequest;

		 this.keyModified.put("data_subject_request", 1);

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