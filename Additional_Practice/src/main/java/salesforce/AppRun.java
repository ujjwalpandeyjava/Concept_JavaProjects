package salesforce;

import com.sforce.ws.ConnectorConfig;

public class AppRun {
	public static void main(String[] args) {
		ConnectorConfig credentials = new ConnectorConfig();
    credentials.setUsername("yoursalesforceusername@yourdomain.com");
    credentials.setPassword("YourPassword!apPenDdedSecurityToken);

    EnterpriseConnection connection;
    try {
      connection = Connector.newConnection(credentials);
      Lead le = new Lead();
      le.setLastName("AcmeEnterprises");
      le.setCompany("JavaPush");
      le.setIndustry("Hospitality"); 
      connection.create(new Lead[]{ le });
    } catch (ConnectionException e) {
      e.printStackTrace();
    }}
}
