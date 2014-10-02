// This file was generated by Mendix Business Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package sms.actions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;

/**
 * To get the current balance of Clockworks account.
 * 
 * Parameters:
 * APIKey: API key for this application
 */
public class GetBalance extends CustomJavaAction<String>
{
	private String APIKey;

	public GetBalance(IContext context, String APIKey)
	{
		super(context);
		this.APIKey = APIKey;
	}

	@Override
	public String executeAction() throws Exception
	{
		// BEGIN USER CODE
		StringBuilder result = new StringBuilder();
		
		String requestBody = "";
		requestBody += "key=" + APIKey;
			
		Core.getLogger("SMS").info("Get current balance.");
		
		StringEntity se = new StringEntity(requestBody, "UTF-8");
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		
		try {
			      
			HttpPost httpPost = new HttpPost("https://api.clockworksms.com/http/balance");
			
			httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
			httpPost.setHeader("Accept", "text/html");
			httpPost.setEntity(se);
						
			CloseableHttpResponse response = httpclient.execute(httpPost);
			
			HttpEntity reponseentity = response.getEntity();
			BufferedReader rd = new BufferedReader(new InputStreamReader(reponseentity.getContent()));
	    	String line = "";
	    	while ((line = rd.readLine()) != null) {
	    		result.append(line);
	    		result.append(System.lineSeparator());
	    	}
	    	EntityUtils.consume(reponseentity);
	    	response.close();
	    	
			if (response.getStatusLine().getStatusCode() == 200) {
				
				// request was technically successful, check response content for error
				if (result.toString().contains("Error")) {
					Core.getLogger("SMS").error("Failed: Code 200 - " + result);
					return null;
				} else {
					Core.getLogger("SMS").info("Successful: Code 200 - " + result);
					return result.toString();
				}
				
			} else {
				Core.getLogger("SMS").error("Failed: Code " + response.getStatusLine().getStatusCode() + " - " + result);
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			Core.getLogger("SMS").error("Failed: " + result, e);
			return null;
		} finally {
			httpclient.close();
		}
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public String toString()
	{
		return "GetBalance";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
