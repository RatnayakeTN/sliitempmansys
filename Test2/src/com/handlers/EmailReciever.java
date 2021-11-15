package com.handlers;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.*;

import model.Email;


public class EmailReciever{
	public static List<Email> recieveMail(String useremail, String password) {
		List<Email> list =  new ArrayList<Email>();
		
		try {
			Properties properties = new Properties();
			properties.setProperty("mail.store.protocol","imaps");
			
			Session emailSession = Session.getDefaultInstance(properties);
			Store emailStore = emailSession.getStore("imaps");
			emailStore.connect("imap.gmail.com",useremail,password);
			
			Folder emailFolder = emailStore.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);
			
			Message messages[] = emailFolder.getMessages();
			
			for(int i=0;i<messages.length;i++) {
				
				Message message = messages[i];
				Email email = new Email();
				
				email.setFrom(message.getFrom()[0]);
				email.setSubject(message.getSubject());
				email.setSentDate(message.getSentDate());
				
				list.add(email);
			}
			
			emailFolder.close(false);
			emailStore.close();
		}catch(NoSuchProviderException e) {
			e.printStackTrace();
			
		}catch(MessagingException m) {
			m.printStackTrace();
			
		}
		return list;
	}

	
}