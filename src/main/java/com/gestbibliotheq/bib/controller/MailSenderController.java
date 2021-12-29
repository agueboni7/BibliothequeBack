package com.gestbibliotheq.bib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gestbibliotheq.bib.mail.Email;

@CrossOrigin
@RestController
public class MailSenderController {
	
	
	@Autowired
	public JavaMailSender emailSender;
	  @ResponseBody
	    @RequestMapping("mail/sendMail")
	    public void sendSimpleEmail(@RequestBody Email email) {
	 
	        // Create a Simple MailMessage.
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setFrom(Email.myMail);
	        message.setTo(email.getCosmail());
	        message.setSentDate(email.getDatSend());
	        message.setSubject(email.getObject());
	        message.setText(email.getMsg());
	      //  message.setReplyTo(email.getCosmail());
	        System.out.println("Voici le Mail que vous sent"+message);
	        
	         emailSender.send(message);
	    }

}
