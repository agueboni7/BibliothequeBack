package com.gestbibliotheq.bib.mailconfig;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.gestbibliotheq.bib.mail.Email;

@Configuration
public class MailConfig {
	@Bean
	public JavaMailSender getMailSender() {
		JavaMailSenderImpl mailSender= new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		
		mailSender.setUsername(Email.myMail);
		mailSender.setPassword(Email.myPassWord);
		
		Properties prop=mailSender.getJavaMailProperties();
		  prop.put("mail.transport.protocol", "smtp");
	      prop.put("mail.smtp.auth", "true");
	      prop.put("mail.smtp.starttls.enable", "true");
	      prop.put("mail.debug", "true");
	      
	      return mailSender;
	}

}
