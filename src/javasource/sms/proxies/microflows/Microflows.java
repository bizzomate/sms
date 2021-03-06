// This file was generated by Mendix Business Modeler 5.0.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package sms.proxies.microflows;

import java.util.HashMap;
import java.util.Map;
import com.mendix.core.Core;
import com.mendix.core.CoreException;
import com.mendix.systemwideinterfaces.MendixRuntimeException;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;

public class Microflows
{
	// These are the Microflows for the SMS module

	public static void checkBalance(IContext context, sms.proxies.SMSSettings _sMSSettings)
	{
		try
		{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("SMSSettings", _sMSSettings == null ? null : _sMSSettings.getMendixObject());
			Core.execute(context, "SMS.CheckBalance", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}

	public static sms.proxies.SMSSettings getCreateSMSSettings(IContext context)
	{
		try
		{
			Map<String, Object> params = new HashMap<String, Object>();
			IMendixObject result = (IMendixObject)Core.execute(context, "SMS.GetCreateSMSSettings", params);
			return result == null ? null : sms.proxies.SMSSettings.initialize(context, result);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}

	public static void openSMSSettings(IContext context)
	{
		try
		{
			Map<String, Object> params = new HashMap<String, Object>();
			Core.execute(context, "SMS.OpenSMSSettings", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}

	public static void saveSMSSettingsWithoutClosing(IContext context, sms.proxies.SMSSettings _sMSSettings)
	{
		try
		{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("SMSSettings", _sMSSettings == null ? null : _sMSSettings.getMendixObject());
			Core.execute(context, "SMS.SaveSMSSettingsWithoutClosing", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}

	public static void sendSMS_Main(IContext context, String _phoneNumber, String _message, String _from)
	{
		try
		{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("PhoneNumber", _phoneNumber);
			params.put("Message", _message);
			params.put("From", _from);
			Core.execute(context, "SMS.SendSMS_Main", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}

	public static void sendSMS_Test(IContext context, sms.proxies.SMSSettings _sMSSettings)
	{
		try
		{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("SMSSettings", _sMSSettings == null ? null : _sMSSettings.getMendixObject());
			Core.execute(context, "SMS.SendSMS_Test", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
}