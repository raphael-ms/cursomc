package com.raphael.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.raphael.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
}
