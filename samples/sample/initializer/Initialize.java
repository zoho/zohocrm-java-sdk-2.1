package com.zoho.crm.sample.initializer;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.api.authenticator.store.DBStore;
import com.zoho.api.authenticator.store.FileStore;

import com.zoho.api.authenticator.store.TokenStore;
import com.zoho.api.logger.Logger;
import com.zoho.api.logger.Logger.Builder;
import com.zoho.api.logger.Logger.Levels;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.RequestProxy;
import com.zoho.crm.api.SDKConfig;
import com.zoho.crm.api.UserSignature;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.dc.USDataCenter;

public class Initialize
{
	public static void main(String[] args) throws Exception
	{
		initialize();
	}
	
	public static void initialize() throws Exception
	{
		/*
		 * Create an instance of Logger Class that takes two parameters
		 * level -> Level of the log messages to be logged. Can be configured by typing Levels "." and choose any level from the list displayed.
		 * filePath -> Absolute file path, where messages need to be logged.
		 */
		Logger logger = new Logger.Builder()
				.filePath("/Users/user_name/Documents/java_sdk_log.log")
				.level(Levels.INFO)
				.build();
		
		//Create an UserSignature instance that takes user Email as parameter
		UserSignature user = new UserSignature("abc@zoho.com");
		
		/*
		 * Configure the environment
		 * which is of the pattern Domain.Environment
		 * Available Domains: USDataCenter, EUDataCenter, INDataCenter, CNDataCenter, AUDataCenter
		 * Available Environments: PRODUCTION, DEVELOPER, SANDBOX
		 */
		Environment environment = USDataCenter.PRODUCTION;
		
		/*
        * Create a Token instance that requires the following
        * clientId -> OAuth client id.
        * clientSecret -> OAuth client secret.
        * refreshToken -> REFRESH token.
        * grantToken -> GRANT token.
        * id -> User unique id.
        * redirectURL -> OAuth redirect URL.
        */
        // if grant token is available
		Token token = new OAuthToken.Builder()
        .clientID("clientId")
        .clientSecret("clientSecret")
        .grantToken("grantToken")
        .redirectURL("redirectURL")
        .build();
		
		/*
        * Create an instance of DBStore that requires the following
        * host -> DataBase host name. Default value "localhost"
        * databaseName -> DataBase name. Default  value "zohooauth"
        * userName -> DataBase user name. Default value "root"
        * password -> DataBase password. Default value ""
        * portNumber -> DataBase port number. Default value "3306"
        * tabletName -> DataBase table name. Default value "oauthtoken"
        */
        //TokenStore tokenstore = new DBStore.Builder().build();

        TokenStore tokenstore = new DBStore.Builder()
        .host("hostName")
        .databaseName("databaseName")
        .tableName("tableName")
        .userName("userName")
        .password("password")
        .portNumber("portNumber")
        .build();
		
		SDKConfig config = new SDKConfig.Builder()
		.autoRefreshFields(true)
		.pickListValidation(false)
		.build();
		
		String resourcePath = "/Users/user_name/Documents/javasdk-application";
			
		/*
        * Create an instance of RequestProxy
        * host -> proxyHost
        * port -> proxyPort
        * user -> proxyUser
        * password -> password
        * userDomain -> userDomain
        */
        RequestProxy requestProxy = new RequestProxy.Builder()
        .host("host")
        .port(proxyPort)
        .user("userName")
        .password("password")
        .userDomain("userDomain")
        .build();
		
		/*
	      * Set the following in InitializeBuilder
	      * user -> UserSignature instance
	      * environment -> Environment instance
	      * token -> Token instance
	      * store -> TokenStore instance
	      * SDKConfig -> SDKConfig instance
	      * resourcePath -> resourcePath - A String
	      * logger -> Log instance (optional)
	      * requestProxy -> RequestProxy instance (optional)
	    */
		new Initializer.Builder()
		.user(user)
		.environment(environment)
		.token(token)
		.SDKConfig(config)
		.store(tokenstore)
		.resourcePath(resourcePath)
		.logger(logger)
		.initialize();
		
//		token.remove();
	}
}

