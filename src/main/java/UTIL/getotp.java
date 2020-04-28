package UTIL;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

public class getotp {

	static	String hostName = "smtp.gmail.com";
	static String username = "pravin.jadhav@evolutionco.com";
	static String password = "8983006577anju";
	static int messageCount;
	static int unreadMsgCount;
	static String emailSubject;
	static Message emailMessage;

	public static String MailTestnew() throws MessagingException {
	    Properties sysProps = System.getProperties();
	    sysProps.setProperty("mail.store.protocol", "imaps");
	    
	    try {
	        Session session = Session.getInstance(sysProps, null);
	        Store store = session.getStore();
	        store.connect(hostName, username, password);
	        System.out.println("login done");
	        Folder emailInbox = store.getFolder("INBOX");
	        emailInbox.open(Folder.READ_WRITE);
	        messageCount = emailInbox.getMessageCount();
	        System.out.println("Total Message Count: " + messageCount);
	        unreadMsgCount = emailInbox.getNewMessageCount();
	        System.out.println("Unread Emails count:" + unreadMsgCount);
	       
	        emailMessage = emailInbox.getMessage(messageCount);
	        emailSubject = emailMessage.getSubject();
	        String msg=emailMessage.getContent().toString();
	        
	        System.out.println(msg);
	        int start=msg.indexOf("[");
	        if(start!=-1)
	        {
	        int dd=msg.indexOf("</b");
	        System.out.println(dd+" end");
	        
	        String otp = msg.substring(start, dd);
	        System.out.println("Otp is : "+otp);
	        return otp;
	        }
	        
	    }catch (Exception mex) {
	        mex.printStackTrace();
	    }
		return " ";
	}
	
	
	public static void MailTest() {
	    Properties sysProps = System.getProperties();
	    sysProps.setProperty("mail.store.protocol", "imaps");

	    try {
	        Session session = Session.getInstance(sysProps, null);
	        Store store = session.getStore();
	        store.connect(hostName, username, password);
	        Folder emailInbox = store.getFolder("INBOX");
	        emailInbox.open(Folder.READ_WRITE);
	        messageCount = emailInbox.getMessageCount();
	        System.out.println("Total Message Count: " + messageCount);
	        unreadMsgCount = emailInbox.getNewMessageCount();
	        System.out.println("Unread Emails count:" + unreadMsgCount);
	      
	        System.out.println("getmsg");
	        emailMessage = emailInbox.getMessage(messageCount);
	        
	        System.out.println("getsub");
	        emailSubject = emailMessage.getSubject();
	        Pattern linkPattern = Pattern.compile("href=\"(.*)\" target"); // here you need to define regex as per you need
	        Matcher pageMatcher =
	                linkPattern.matcher(emailMessage.getContent().toString());

	        while (pageMatcher.find()) {
	            System.out.println("Found OTP " + pageMatcher.group(1));
	        }
	        emailMessage.setFlag(Flags.Flag.SEEN, true);
	        emailInbox.close(true);
	        store.close();

	    } catch (Exception mex) {
	        mex.printStackTrace();
	    }
	}
}
