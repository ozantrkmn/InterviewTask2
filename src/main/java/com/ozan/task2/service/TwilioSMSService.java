package com.ozan.task2.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozan.task2.configuration.TwilioConfig;
import com.ozan.task2.model.MessageResponse;
import com.ozan.task2.model.SMS;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.Message.Status;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

@Service
public class TwilioSMSService implements ITwilioSMSService {
	
	private final TwilioConfig twilioConfiguration;
	
    @Autowired
    public TwilioSMSService(TwilioConfig twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }
    
    @Override
    public Status sendSMS(SMS smsRequest) {

        	
        PhoneNumber to = new PhoneNumber(smsRequest.getNumber());
        PhoneNumber from = new PhoneNumber(twilioConfiguration.getNumber());
        
        String message = smsRequest.getMessage();
        MessageCreator creator = Message.creator(to, from, message);
        Message msg = creator.create();
        
        return msg.getStatus();

    }
    
    
    @Override
    public List<MessageResponse> getMessageList() {
    	
        ResourceSet<Message> messages = Message.reader().read();
        
    	List<MessageResponse> SMSList = new ArrayList<>();
    	for(Message message : messages) {
    		SMSList.add(new MessageResponse(message.getStatus().toString(), Date.from(message.getDateSent().toInstant()), message.getTo(), message.getBody()));
    	}
    	
        return SMSList;
        
    }

}
