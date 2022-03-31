package samples.main;

import java.io.ByteArrayOutputStream;

import java.io.FileInputStream;

import java.io.IOException;

import java.util.ArrayList;

import java.util.Arrays;

import java.util.List;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;

import org.apache.http.HttpResponse;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

import org.apache.http.client.methods.HttpPost;

import org.apache.http.client.methods.HttpUriRequest;

import org.apache.http.client.utils.URIBuilder;

import org.apache.http.conn.ssl.NoopHostnameVerifier;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;

import org.apache.http.entity.mime.MultipartEntityBuilder;

import org.apache.http.entity.mime.content.ByteArrayBody;

import org.apache.http.impl.client.CloseableHttpClient;

import org.apache.http.impl.client.HttpClientBuilder;

import org.apache.http.util.EntityUtils;

import com.zoho.crm.sample.initializer.Initialize;

public class Test
{
	public static void main(String[] args) throws Exception
	{
		Initialize.initialize();
		AssignmentRule();
		Attachment();
		BluePrint();
		BulkRead();
		BulkWrite();
		ContactRoles();
		Currency();
		CustomView();
		EmailTemplates();
		FieldAttachments();
		Field();
		File();
		InventoryTemplates();
		Layout();
		Module();
		Note();
		Notification();
		Organization();
		Pipeline();
		Profile();
		Query();
		Record();
		RelatedList();
		RelatedRecords();
		Role();
		SendMail();
		ShareRecords();
		Tags();
		Tax();
		Territory();
		User();
		VariableGroup();
		Variable();
		Wizards();
		TestUpload();
	}
	
 	public static void AssignmentRule() 
	{
		try 
		{
			com.zoho.crm.sample.assignmentrules.AssignmentRules.getAssignmentRule(352403311622l);
			com.zoho.crm.sample.assignmentrules.AssignmentRules.getAssignmentRules();
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void Attachment()
	{
		try
		{
			String moduleAPIName = "Leads";

			Long recordId = 347706111829018l;

			Long attachmentId = 3477061118951l;

			String absoluteFilePath = "/Users/file/download.png";
			
			String destinationFolder = "/Users/file";
			
			String attachmentURL = "https://5.imimg.com/data5/KJ/UP/MY-8655440/zoho-crm-500x500.png";

			List<Long> attachmentIds = new ArrayList<Long>(Arrays.asList(3477061118972l));

			com.zoho.crm.sample.attachments.Attachment.uploadAttachments(moduleAPIName, recordId, absoluteFilePath);

			com.zoho.crm.sample.attachments.Attachment.getAttachments(moduleAPIName, recordId);

			com.zoho.crm.sample.attachments.Attachment.deleteAttachments(moduleAPIName, recordId, attachmentIds);

			com.zoho.crm.sample.attachments.Attachment.downloadAttachment(moduleAPIName, recordId, attachmentId, destinationFolder);

			com.zoho.crm.sample.attachments.Attachment.deleteAttachment(moduleAPIName, recordId, attachmentId);

			com.zoho.crm.sample.attachments.Attachment.uploadLinkAttachments(moduleAPIName, recordId, attachmentURL);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void BluePrint()
	{
		try
		{
			String moduleAPIName = "Leads";

			Long recordId = 347706143812l;

			Long transitionId = 34770610173093l;

			com.zoho.crm.sample.blueprint.BluePrint.getBlueprint(moduleAPIName, recordId);

			com.zoho.crm.sample.blueprint.BluePrint.updateBlueprint(moduleAPIName, recordId, transitionId);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public static void BulkRead()
	{
		try
		{
			String moduleAPIName = "Leads";

			Long jobId = 3477061118997l;

			String destinationFolder = "/Users/file";

			com.zoho.crm.sample.bulkread.BulkRead.createBulkReadJob(moduleAPIName);

			com.zoho.crm.sample.bulkread.BulkRead.getBulkReadJobDetails(jobId);

			com.zoho.crm.sample.bulkread.BulkRead.downloadResult(jobId, destinationFolder);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public static void BulkWrite()
	{
		try
		{
			String absoluteFilePath = "/Users/Leads.zip";

			String destinationFolder = "/Users/file";

			String orgID = "xxxxx";

			String moduleAPIName = "Leads";

			String fileId = "347706112061";

			Long jobID = 3477061083l;

			String downloadUrl = "https://download-accl.zoho.com/v2/crm/xxxx/bulk-write/3477061083/3477061083.zip";

			com.zoho.crm.sample.bulkwrite.BulkWrite.uploadFile(orgID, absoluteFilePath);

			com.zoho.crm.sample.bulkwrite.BulkWrite.createBulkWriteJob(moduleAPIName, fileId);

			com.zoho.crm.sample.bulkwrite.BulkWrite.getBulkWriteJobDetails(jobID);

			com.zoho.crm.sample.bulkwrite.BulkWrite.downloadBulkWriteResult(downloadUrl, destinationFolder);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void ContactRoles()
	{
		try
		{
			Long contactRoleId = 347706188583l;

			ArrayList<String> contactRoleIds = new ArrayList<String>(Arrays.asList("347706111922015", "347706111922017", "3477061119229"));

			com.zoho.crm.sample.contactroles.ContactRoles.getContactRoles();

			com.zoho.crm.sample.contactroles.ContactRoles.createContactRoles();

			com.zoho.crm.sample.contactroles.ContactRoles.updateContactRoles();

			com.zoho.crm.sample.contactroles.ContactRoles.deleteContactRoles(contactRoleIds);

			com.zoho.crm.sample.contactroles.ContactRoles.getContactRole(contactRoleId);

			com.zoho.crm.sample.contactroles.ContactRoles.updateContactRole(contactRoleId);

			com.zoho.crm.sample.contactroles.ContactRoles.deleteContactRole(contactRoleId);
			
			com.zoho.crm.sample.contactroles.ContactRoles.getAllContactRolesOfDeal(3477061112997l);

			com.zoho.crm.sample.contactroles.ContactRoles.getContactRoleOfDeal(3477061112994l, 3477061112997l);

			com.zoho.crm.sample.contactroles.ContactRoles.addContactRoleToDeal(3477061112994l, 3477061112997l);

			com.zoho.crm.sample.contactroles.ContactRoles.removeContactRoleFromDeal(3477061112994l, 3477061112997l);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void Currency()
	{
		try
		{
			Long currencyId = 34770617368016l;

			com.zoho.crm.sample.currencies.Currency.getCurrencies();

			com.zoho.crm.sample.currencies.Currency.addCurrencies();

			com.zoho.crm.sample.currencies.Currency.updateCurrencies();

			com.zoho.crm.sample.currencies.Currency.enableMultipleCurrencies();

			com.zoho.crm.sample.currencies.Currency.updateBaseCurrency();

			com.zoho.crm.sample.currencies.Currency.getCurrency(currencyId);

			com.zoho.crm.sample.currencies.Currency.updateCurrency(currencyId);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public static void CustomView()
	{
		try
		{
			String moduleAPIName = "Leads";

			Long customID = 347706149373l;

			List<String> names = new ArrayList<String>(Arrays.asList("Products", "Tasks", "Vendors", "Calls", "Leads", "Deals", "Campaigns", "Quotes", "Invoices", "Attachments", "Price_Books", "Sales_Orders", "Contacts", "Solutions", "Events", "Purchase_Orders", "Accounts", "Cases", "Notes"));
			
			for(String name : names)
			{
				com.zoho.crm.sample.customview.CustomView.getCustomViews(name);
			}

			com.zoho.crm.sample.customview.CustomView.getCustomViews(moduleAPIName);

			com.zoho.crm.sample.customview.CustomView.getCustomView(moduleAPIName, customID);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void EmailTemplates() 
	{
		try 
		{
			com.zoho.crm.sample.emailtemplates.EmailTemplates.getEmailTemplates();
			com.zoho.crm.sample.emailtemplates.EmailTemplates.getEmailTemplateById(347706179l);
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void FieldAttachments() 
	{
		try 
		{
			String destinationFolder = "/Users/file";
			
			com.zoho.crm.sample.fieldattachments.FieldAttachments.getFieldAttachments(destinationFolder, "Leads", 3477061116132l, 347706111613032l);
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void Field()
	{
		try
		{
			String moduleAPIName = "Deals";

			Long fieldId = 34770612565l;

			List<String> names = new ArrayList<String>(Arrays.asList("Products", "Tasks", "Vendors", "Calls", "Leads", "Deals", "Campaigns", "Quotes", "Invoices", "Attachments", "Price_Books", "Sales_Orders", "Contacts", "Solutions", "Events", "Purchase_Orders", "Accounts", "Cases", "Notes"));
			
			for(String name :names)
			{
				com.zoho.crm.sample.fields.Fields.getFields(name);
			}

			com.zoho.crm.sample.fields.Fields.getFields(moduleAPIName);

			com.zoho.crm.sample.fields.Fields.getField(moduleAPIName, fieldId);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void File()
	{
		try
		{
			String destinationFolder = "/Users/file";

			String id = "ae9c7cedd15c3b";

			com.zoho.crm.sample.file.File.uploadFiles();

			com.zoho.crm.sample.file.File.getFile(id, destinationFolder);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void InventoryTemplates() 
	{
		try 
		{
			com.zoho.crm.sample.inventorytemplates.InventoryTemplates.getInventoryTemplates();
			com.zoho.crm.sample.inventorytemplates.InventoryTemplates.getInventoryTemplate(347706101743l);

		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void Layout()
	{
		try
		{
			String moduleAPIName = "Leads";

			Long layoutId = 347706191055l;

			List<String> names = new ArrayList<String>(Arrays.asList("Products", "Tasks", "Vendors", "Calls", "Leads", "Deals", "Campaigns", "Quotes", "Invoices", "Attachments", "Price_Books", "Sales_Orders", "Contacts", "Solutions", "Events", "Purchase_Orders", "Accounts", "Cases", "Notes"));
			
			for(String name :names)
			{
				com.zoho.crm.sample.layouts.Layout.getLayouts(name);
			}

			com.zoho.crm.sample.layouts.Layout.getLayouts(moduleAPIName);

			com.zoho.crm.sample.layouts.Layout.getLayout(moduleAPIName, layoutId);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void Module()
	{
		try
		{
			String moduleAPIName = "apiName1";

			Long moduleId = 347706139053L;

			com.zoho.crm.sample.modules.Modules.getModules();

			com.zoho.crm.sample.modules.Modules.getModule(moduleAPIName);

			com.zoho.crm.sample.modules.Modules.updateModuleByAPIName(moduleAPIName);

			com.zoho.crm.sample.modules.Modules.updateModuleById(moduleId);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void Note()
	{
		try
		{
			ArrayList<Long> notesId = new ArrayList<Long>(Arrays.asList(3477061119494l, 3477061119495l));

			Long noteId = 3477061119496l;

			com.zoho.crm.sample.notes.Note.getNotes();

			com.zoho.crm.sample.notes.Note.createNotes();

			com.zoho.crm.sample.notes.Note.updateNotes();

			com.zoho.crm.sample.notes.Note.deleteNotes(notesId);

			com.zoho.crm.sample.notes.Note.getNote(noteId);

			com.zoho.crm.sample.notes.Note.updateNote(noteId);

			com.zoho.crm.sample.notes.Note.deleteNote(noteId);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void Notification()
	{
		try
		{
			ArrayList<Long> channelIds = new ArrayList<Long>(Arrays.asList(168212l));

			com.zoho.crm.sample.notification.Notification.enableNotifications();

			com.zoho.crm.sample.notification.Notification.getNotificationDetails();

			com.zoho.crm.sample.notification.Notification.updateNotifications();

			com.zoho.crm.sample.notification.Notification.updateNotification();

			com.zoho.crm.sample.notification.Notification.disableNotifications(channelIds);

			com.zoho.crm.sample.notification.Notification.disableNotification();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void Organization()
	{
		try
		{
			String absoluteFilePath = "/Users/file";

			com.zoho.crm.sample.organization.Organization.getOrganization();

			com.zoho.crm.sample.organization.Organization.uploadOrganizationPhoto(absoluteFilePath);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void Pipeline() 
	{
		try 
		{
			Long layoutID = 347706191023l;
			
			Long pipelineID = 34770619599012l;
			
			com.zoho.crm.sample.pipeline.Pipeline.getPipelines(layoutID);
			
			com.zoho.crm.sample.pipeline.Pipeline.createPipelines(layoutID);
			
			com.zoho.crm.sample.pipeline.Pipeline.getPipeline(layoutID, pipelineID);
			
			com.zoho.crm.sample.pipeline.Pipeline.TransferAndDelete(layoutID);
			
			com.zoho.crm.sample.pipeline.Pipeline.updatePipeline(layoutID, pipelineID);
			
			com.zoho.crm.sample.pipeline.Pipeline.updatePipelines(layoutID);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void Profile()
	{
		try
		{
			Long profileId = 347706126011l;

			com.zoho.crm.sample.profile.Profile.getProfiles();

			com.zoho.crm.sample.profile.Profile.getProfile(profileId);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void Query()
	{
		try
		{
			com.zoho.crm.sample.query.Query.getRecords();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void Record()
	{
		try
		{
			String moduleAPIName = "leads";

			long recordId = 3477061121091l;
			
			String externalFieldValue = "TestExternalLead11";

			String destinationFolder = "/Users/file";

			String absoluteFilePath = "/Users/file/download.png";

			List<String> recordIds = new ArrayList<String>(Arrays.asList("Value1234", "34770615908017l", "347706159081l"));

			String jobId = "34770617416301";
			
//			List<String> names = new ArrayList<String>(Arrays.asList("Products", "Tasks", "Vendors", "Calls", "Leads", "Deals", "Campaigns", "Quotes", "Invoices", "Attachments", "Price_Books", "Sales_Orders", "Contacts", "Solutions", "Events", "Purchase_Orders", "Accounts", "Cases", "Notes"));
//			
//			for(String name : names)
//			{
//				 com.zoho.crm.sample.record.Record.getRecords(name);
//			}

			com.zoho.crm.sample.record.Record.getRecord(moduleAPIName, recordId, destinationFolder);

			com.zoho.crm.sample.record.Record.updateRecord(moduleAPIName, recordId);

			com.zoho.crm.sample.record.Record.deleteRecord(moduleAPIName, recordId);
			
			com.zoho.crm.sample.record.Record.getRecordUsingExternalId(moduleAPIName, externalFieldValue, destinationFolder);

			com.zoho.crm.sample.record.Record.updateRecordUsingExternalId(moduleAPIName, externalFieldValue);
			
			com.zoho.crm.sample.record.Record.deleteRecordUsingExternalId(moduleAPIName, externalFieldValue);
			
			com.zoho.crm.sample.record.Record.getRecords(moduleAPIName);

			com.zoho.crm.sample.record.Record.createRecords(moduleAPIName);

			com.zoho.crm.sample.record.Record.updateRecords(moduleAPIName);

			com.zoho.crm.sample.record.Record.deleteRecords(moduleAPIName, recordIds);

			com.zoho.crm.sample.record.Record.upsertRecords(moduleAPIName);

			com.zoho.crm.sample.record.Record.getDeletedRecords(moduleAPIName);

			com.zoho.crm.sample.record.Record.searchRecords(moduleAPIName);

			com.zoho.crm.sample.record.Record.convertLead(recordId);

			com.zoho.crm.sample.record.Record.getPhoto(moduleAPIName, recordId, destinationFolder);

			com.zoho.crm.sample.record.Record.uploadPhoto(moduleAPIName, recordId, absoluteFilePath);

			com.zoho.crm.sample.record.Record.deletePhoto(moduleAPIName, recordId);

			com.zoho.crm.sample.record.Record.massUpdateRecords(moduleAPIName);

			com.zoho.crm.sample.record.Record.getMassUpdateStatus(moduleAPIName, jobId);

			com.zoho.crm.sample.record.Record.getRecordCount();
			
			com.zoho.crm.sample.record.Record.assignTerritoriesToMultipleRecords(moduleAPIName);
			
			com.zoho.crm.sample.record.Record.assignTerritoryToRecord(moduleAPIName, recordId);
			
			com.zoho.crm.sample.record.Record.removeTerritoriesFromMultipleRecords(moduleAPIName);
			
			com.zoho.crm.sample.record.Record.removeTerritoriesFromRecord(moduleAPIName, recordId);
			
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void RelatedList()
	{
		try
		{
			String moduleAPIName = "Leads";

			Long relatedListId = 34770616819126l;

			List<String> names = new ArrayList<String>(Arrays.asList("Products", "Tasks", "Vendors", "Calls", "Leads", "Deals", "Campaigns", "Quotes", "Invoices", "Attachments", "Price_Books", "Sales_Orders", "Contacts", "Solutions", "Events", "Purchase_Orders", "Accounts", "Cases"));
			
			for(String name :names)
			{
				com.zoho.crm.sample.relatedlist.RelatedList.getRelatedLists(name);
			}

			com.zoho.crm.sample.relatedlist.RelatedList.getRelatedLists(moduleAPIName);

			com.zoho.crm.sample.relatedlist.RelatedList.getRelatedList(moduleAPIName, relatedListId);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public static void RelatedRecords()
	{
		try
		{
			String moduleAPIName = "leads";

			Long recordId = 3477061121091l;

			String relatedListAPIName = "products";

			Long relatedRecordId = 3477061106971l;

			String destinationFolder = "/Users/file/";

			List<String> relatedListIds = new ArrayList<String>(Arrays.asList("AutomatedSDKExternal", "347706159191"));
			
			String externalValue = "AutomatedSDKExternal";

			String externalFieldValue = "TestExternal121";

			com.zoho.crm.sample.relatedrecords.RelatedRecords.getRelatedRecords(moduleAPIName, recordId, relatedListAPIName);

			com.zoho.crm.sample.relatedrecords.RelatedRecords.updateRelatedRecords(moduleAPIName, recordId, relatedListAPIName);

			com.zoho.crm.sample.relatedrecords.RelatedRecords.delinkRecords(moduleAPIName, recordId, relatedListAPIName, relatedListIds);
			
			com.zoho.crm.sample.relatedrecords.RelatedRecords.getRelatedRecordsUsingExternalId(moduleAPIName, externalValue, relatedListAPIName);
			
			com.zoho.crm.sample.relatedrecords.RelatedRecords.updateRelatedRecordsUsingExternalId(moduleAPIName, externalValue, relatedListAPIName);
			
			com.zoho.crm.sample.relatedrecords.RelatedRecords.deleteRelatedRecordsUsingExternalId(moduleAPIName, externalValue, relatedListAPIName, relatedListIds);
			
			com.zoho.crm.sample.relatedrecords.RelatedRecords.getRelatedRecord(moduleAPIName, recordId, relatedListAPIName, relatedRecordId, destinationFolder);

			com.zoho.crm.sample.relatedrecords.RelatedRecords.updateRelatedRecord(moduleAPIName, recordId, relatedListAPIName, relatedRecordId);

			com.zoho.crm.sample.relatedrecords.RelatedRecords.delinkRecord(moduleAPIName, recordId, relatedListAPIName, relatedRecordId);
			
			com.zoho.crm.sample.relatedrecords.RelatedRecords.getRelatedRecordUsingExternalId(moduleAPIName, externalValue, relatedListAPIName, externalFieldValue, destinationFolder);
			
			com.zoho.crm.sample.relatedrecords.RelatedRecords.updateRelatedRecordUsingExternalId(moduleAPIName, externalValue, relatedListAPIName, externalFieldValue);
			
			com.zoho.crm.sample.relatedrecords.RelatedRecords.deleteRelatedRecordUsingExternalId(moduleAPIName, externalValue, relatedListAPIName, externalFieldValue);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public static void Role()
	{
		try
		{
			Long roleId = 3477061268l;

			com.zoho.crm.sample.role.Role.getRoles();

			com.zoho.crm.sample.role.Role.getRole(roleId);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void SendMail() {
		try {
			com.zoho.crm.sample.sendmail.SendMail.getEmailAddresses();
			com.zoho.crm.sample.sendmail.SendMail.sendMail(35240335495063L, "Leads");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void ShareRecords()
	{
		try
		{
			String moduleAPIName = "Leads";

			long recordId = 34770615623115L;

			com.zoho.crm.sample.sharerecords.ShareRecords.getSharedRecordDetails(moduleAPIName, recordId);

			com.zoho.crm.sample.sharerecords.ShareRecords.shareRecord(moduleAPIName, recordId);

			com.zoho.crm.sample.sharerecords.ShareRecords.updateSharePermissions(moduleAPIName, recordId);

			com.zoho.crm.sample.sharerecords.ShareRecords.revokeSharedRecord(moduleAPIName, recordId);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void Tags()
	{
		try
		{
			String moduleAPIName = "Leads";

			Long tagId = 347706111387010l;

			long recordId = 34770615623115L;

			ArrayList<String> tagNames = new ArrayList<String>(Arrays.asList("Variableasd33, addtag12"));

			ArrayList<Long> recordIds = new ArrayList<Long>(Arrays.asList(34770615623115l, 34770617421029l));

			String conflictId = "3477061117161";

			com.zoho.crm.sample.tags.Tag.getTags(moduleAPIName);

			com.zoho.crm.sample.tags.Tag.createTags(moduleAPIName);

			com.zoho.crm.sample.tags.Tag.updateTags(moduleAPIName);

			com.zoho.crm.sample.tags.Tag.updateTag(moduleAPIName, tagId);

			com.zoho.crm.sample.tags.Tag.deleteTag(tagId);

			com.zoho.crm.sample.tags.Tag.mergeTags(tagId, conflictId);

			com.zoho.crm.sample.tags.Tag.addTagsToRecord(moduleAPIName, recordId, tagNames);

			com.zoho.crm.sample.tags.Tag.removeTagsFromRecord(moduleAPIName, recordId, tagNames);

			com.zoho.crm.sample.tags.Tag.addTagsToMultipleRecords(moduleAPIName, recordIds, tagNames);

			com.zoho.crm.sample.tags.Tag.removeTagsFromMultipleRecords(moduleAPIName, recordIds, tagNames);

			com.zoho.crm.sample.tags.Tag.getRecordCountForTag(moduleAPIName, tagId);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public static void Tax()
	{
		try
		{
			Long taxId =  347706112047013l;

			ArrayList<Long> taxIds = new ArrayList<Long>(Arrays.asList(3477061120485l, 3477061120486l, 352403370572L));

			com.zoho.crm.sample.taxes.Tax.getTaxes();

			com.zoho.crm.sample.taxes.Tax.createTaxes();

			com.zoho.crm.sample.taxes.Tax.updateTaxes();

			com.zoho.crm.sample.taxes.Tax.deleteTaxes(taxIds);

			com.zoho.crm.sample.taxes.Tax.getTax(taxId);

			com.zoho.crm.sample.taxes.Tax.deleteTax(taxId);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public static void Territory()
	{
		try
		{
			Long territoryId = 34770613051397l;

			com.zoho.crm.sample.territories.Territory.getTerritories();

			com.zoho.crm.sample.territories.Territory.getTerritory(territoryId);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public static void User()
	{
		try
		{
			Long userId = 3477061120561l;

			com.zoho.crm.sample.users.User.getUsers();

			com.zoho.crm.sample.users.User.createUser();

			com.zoho.crm.sample.users.User.updateUsers();

			com.zoho.crm.sample.users.User.getUser(userId);

			com.zoho.crm.sample.users.User.updateUser(userId);

			com.zoho.crm.sample.users.User.deleteUser(userId);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public static void VariableGroup()
	{
		try
		{
			String variableGroupName = "General";

			Long variableGroupId = 352403302311l;

			com.zoho.crm.sample.variablegroups.VariableGroup.getVariableGroups();

			com.zoho.crm.sample.variablegroups.VariableGroup.getVariableGroupById(variableGroupId);

			com.zoho.crm.sample.variablegroups.VariableGroup.getVariableGroupByAPIName(variableGroupName);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public static void Variable()
	{
		try
		{
			ArrayList<Long> variableIds = new ArrayList<Long>(Arrays.asList(352403362971L, 352403360751L));

			Long variableId = 352403374041L;

			String variableName = "Variabladsde55";

			com.zoho.crm.sample.variables.Variable.getVariables();

			com.zoho.crm.sample.variables.Variable.createVariables();

			com.zoho.crm.sample.variables.Variable.updateVariables();

			com.zoho.crm.sample.variables.Variable.deleteVariables(variableIds);

			com.zoho.crm.sample.variables.Variable.getVariableById(variableId);

			com.zoho.crm.sample.variables.Variable.updateVariableById(variableId);

			com.zoho.crm.sample.variables.Variable.deleteVariable(variableId);

			com.zoho.crm.sample.variables.Variable.getVariableForAPIName(variableName);

			com.zoho.crm.sample.variables.Variable.updateVariableByAPIName(variableName);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void Wizards() {
		try {
			com.zoho.crm.sample.wizards.Wizards.getWizards();
			com.zoho.crm.sample.wizards.Wizards.getWizard(347706194979l);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void TestUpload() throws IOException
	{
		FileInputStream stream1 = null;
		FileInputStream stream = null;

		try
		{
			HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();

			SSLContext sslContext = SSLContext.getDefault();

			SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);

			CloseableHttpClient httpclient = httpClientBuilder.setSSLSocketFactory(sslConnectionSocketFactory).build();

			URIBuilder uriBuilder = new URIBuilder("https://www.zohoapis.com/crm/v2/files");

			HttpUriRequest requestObj = new HttpPost(uriBuilder.build());

			HttpEntityEnclosingRequestBase requestBase = (HttpEntityEnclosingRequestBase) requestObj;

//			requestObj.addHeader("feature", "bulk-write");
//			
//			requestObj.addHeader("X-CRM-ORG", "xxxxxx");

			requestObj.addHeader("Authorization", "Zoho-oauthtoken 1.xxxxxxxxx.xxxxxxx");

			MultipartEntityBuilder multipartEntity = MultipartEntityBuilder.create();

			java.io.File file = new java.io.File("/Users/Leads.zip");

			stream = new FileInputStream(file);

			byte[] buffer = new byte[8192];
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			int bytesRead;
			while ((bytesRead = stream.read(buffer)) != -1)
			{
				output.write(buffer, 0, bytesRead);
			}

			multipartEntity.addPart("file", new ByteArrayBody(output.toByteArray(), "Leads.zip"));

			stream.close();
			stream1 = new FileInputStream(file);

			buffer = new byte[8192];
			output = new ByteArrayOutputStream();

			while ((bytesRead = stream1.read(buffer)) != -1)
			{
				output.write(buffer, 0, bytesRead);
			}
		

			multipartEntity.addPart("file", new ByteArrayBody(output.toByteArray(), "Leads.zip"));

			requestBase.setEntity(multipartEntity.build());

			HttpResponse response = httpclient.execute(requestObj);

			HttpEntity responseEntity = response.getEntity();

			Object responseObject = EntityUtils.toString(responseEntity);

			String responseString = responseObject.toString();

			System.out.println(responseString);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		finally {
			if (stream1 != null) {
				stream1.close();
			}
			if (stream != null) {
				stream.close();
			}
		}
	}
}
