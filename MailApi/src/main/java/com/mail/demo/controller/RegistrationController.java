package com.mail.demo.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mail.demo.model.MailMessage;
import com.mail.demo.service.MailService;

/**
 * This class contains a Mail API developed using Spring Boot
 * 
 * @author MukulJaiswal
 *
 */
@RestController

public class RegistrationController {

	@Autowired
	private MailService notificationService;
	@Autowired
	private MailMessage message;

	@GetMapping("/send-mail")
	public String send() {

		/*
		 * Creating a MailMessage with the help of MailMessage class that we have declared. Setting
		 * the First,Last and Email address of the sender.
		 */
//		
		message.setEmailAddress("bey60020@gmail.com"); // Receiver's email address
		message.setSubject("Greeting");
		message.setBodyText(" good job!! keep doing what you doing !");
		/*
		 * Here we will call sendEmail() for Sending mail to the sender.
		 */
		try {
			notificationService.sendEmail(message);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Congratulations! Your mail has been send to the user.";
	}

	/**
	 * 
	 * @return
	 * @throws MessagingException
	 */
	@GetMapping("/send-mail-attachment")
	public String sendWithAttachment(@RequestBody MailMessage message) throws MessagingException {

		/*
		 * Creating a MailMessage with the help of MailMessage class that we have declared. Setting
		 * the First,Last and Email address of the sender.
		 */

		message.setEmailAddress("bey60020@gmail.com");// Receiver's email address
		message.setSubject("Greeting ");
		message.setBodyText(" keep doing what you doing !");
		/*
		 * Here we will call sendEmailWithAttachment() for Sending mail to the sender
		 * that contains a attachment.
		 */
		try {

			notificationService.sendEmailWithAttachment(message);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Congratulations! Your mail has been send to the user.";
	}
}
