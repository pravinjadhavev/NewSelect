package LISTENERS;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ResList implements ITestListener{

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
	}
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	//	ITestListener.super.onTestStart(result);
	}
	
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	//	ITestListener.super.onFinish(context);
	}
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);
		String para="";
		try {

			Object[] p = result.getParameters();
			System.out.println(p[0]);
			
			for (Object obj : p) {
				para=para+" "+obj.toString();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			para="No parameter provided";
		}
		
		
		System.out.println(para +" are the parameteres");
	
		
		
		
		try {
			
			System.out.println(result.getMethod().getMethodName() + " Failed and error msg is " +  result.getThrowable().getMessage());
			
			UTIL.ExcelProgram.updateResult("error",result.getMethod().getMethodName(),para, "Failed", result.getThrowable().getMessage());
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	//	ITestListener.super.onTestSuccess(result);
		String para="";
		try {

			Object[] p = result.getParameters();
			System.out.println(p[0]);
			
			for (Object obj : p) {
				para=para+" "+obj.toString();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			para="No parameter provided";
		}

		System.out.println(para +" are the parameteres");
		try {
			System.out.println(result.getMethod().getMethodName() + " pass " + "");
			
			UTIL.ExcelProgram.updateResult("pass",result.getMethod().getMethodName(),para, "Passed", "");
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
	}
}
