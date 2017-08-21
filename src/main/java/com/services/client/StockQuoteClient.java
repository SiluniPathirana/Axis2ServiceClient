package com.services.client;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import samples.services.GetQuoteDocument;
import samples.services.GetQuoteResponseDocument;
import samples.services.GetQuoteResponseDocument.GetQuoteResponse;
import samples.services.xsd.GetQuote;

import com.services.ws.SimpleStockQuoteServiceStub;

public class StockQuoteClient {
	
	
	public static SimpleStockQuoteServiceStub stub=null;
	
	public static void main(String args[])
	{
		
		try
		{
			//create WebService client using generated stub
			stub = new SimpleStockQuoteServiceStub();
			
		}
		catch(AxisFault e)
		{
			e.printStackTrace();
		}
		
		//create request document
		GetQuoteDocument requestDoc = GetQuoteDocument.Factory.newInstance();
		//Create request
		GetQuote request = GetQuote.Factory.newInstance();
		//set symbol to the request
		request.setSymbol("IBM");
		
		requestDoc.setGetQuote(getQuote);
		
		
		GetQuoteResponseDocument responseDoc = null;
		
		try
		{
			//Create a response document and Call a WebService operation
			responseDoc = stub.getQuote(requestDoc);
			
		}
		catch(RemoteException e)
		{
			e.printStackTrace();
		}
		
		// Get the response from the response document
		GetQuoteResponse response = responseDoc.getGetQuoteResponse();
		String rs = response.getReturn().toString();
		System.out.print("" + rs);
	}

}
