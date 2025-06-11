package com.xworkz.project.util.mailutil;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class MailSender {

	public void sendOtp(int otp, String email, String Username) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom("shashisg993@gmail.com");
		mail.setTo(email);
		mail.setSubject("OTP");
		mail.setText("Hello" + " " + Username + "\n" + "Your OTP for password reset is:" + otp);
		mail.setReplyTo("shashisg993@gmail.com");
        JavaMailSender send= mailSetting();
        send.send(mail);
		// javamailsender.send(mail);
	}
	
	public void sendWelComeMessage(String email) {
		SimpleMailMessage message1 = new SimpleMailMessage();
		message1.setFrom("shashisg993@gmail.com");
		message1.setTo(email);
		message1.setSubject("Welcome to Auto_Spare");
		message1.setText("Congratulations! " +email +  "\n" + " You have successfully registered with AUTO_SPARE. You can log in once your account is approved by the admin. You will receive an email notification once your approval is completed.");
		JavaMailSender sender =	mailSetting();
		sender.send(message1);
	}
	
	public void ApproveAndSendOtp(String email, String Username) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom("shashisg993@gmail.com");
		mail.setTo(email);
		mail.setSubject("Approved");
		mail.setText("Hello" + " " + Username + "\n" + "Your request is approved. You can login to your account using your email ID");
		mail.setReplyTo("shashisg993@gmail.com");
        JavaMailSender send= mailSetting();
        send.send(mail);
		// javamailsender.send(mail);
	}
	
	public void sendRejectMessage(String email) {
		SimpleMailMessage message1 = new SimpleMailMessage();
		message1.setFrom("shashisg993@gmail.com");
		message1.setTo(email);
		message1.setSubject("Welcome to Auto_Spare");
		message1.setText("Hello! " +email +  "\n" + " \"Your request is Rejected by AUTO_SPARE. Unfortunatly we are not moving forword with your application. Thank you");
		JavaMailSender sender =	mailSetting();
		sender.send(message1);
	}
@Bean
	public JavaMailSender mailSetting() {
		JavaMailSenderImpl javamailsender = new JavaMailSenderImpl();
		javamailsender.setUsername("shashisg993@gmail.com");
		javamailsender.setHost("smtp.gmail.com");
		javamailsender.setPort(587);
		javamailsender.setPassword("rtbu ldyd bjsi momm");
		Properties properties = javamailsender.getJavaMailProperties();
		properties.put("mail.transport.protocol", "smtp");
	//	properties.put(javamailsender, properties);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		return javamailsender;

	}

}  
