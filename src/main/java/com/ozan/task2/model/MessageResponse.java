package com.ozan.task2.model;

import java.util.Date;

public class MessageResponse {
	
	private String status;
	private Date dateSent;
	private String recipient;
	private String message;
	
	public MessageResponse(String status, Date dateSent, String recipient, String message) {
		super();
		this.status = status;
		this.dateSent = dateSent;
		this.recipient = recipient;
		this.message = message;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDateSent() {
		return dateSent;
	}
	public void setDateSent(Date dateSent) {
		this.dateSent = dateSent;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
