package com.ozan.task2.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ozan.task2.model.MessageResponse;
import com.ozan.task2.model.SMS;
import com.ozan.task2.service.ITwilioSMSService;
import com.ozan.task2.utils.Utils;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.Message.Status;

@Controller
public class TwilioController {
	
    @Autowired
    private ApplicationContext appContext;
	
    @GetMapping("/getSmsForm")
    public String getSmsForm(Model model) {
    	model.addAttribute("sms", new SMS());
        return "sms-form";
    }
	
    @PostMapping("/sendSms")
    public String sendSms(SMS sms, BindingResult result, Model model) {
    	
    	ITwilioSMSService twilioSMSService = (ITwilioSMSService) appContext.getBean("twilioSMSService");

        if(Utils.isEmpty(sms.getNumber()) || Utils.isEmpty(sms.getMessage())) {
        	model.addAttribute("error", "Do not leave blank number and message!");
        	model.addAttribute("sms", new SMS());
        	return "sms-form";
        }else if(!Utils.isPhoneNumberValid(sms.getNumber())){
        	model.addAttribute("error", "Wrong Mobile Phone format, use (+905554443322), Only Turkish numbers will be accepted");
        	model.addAttribute("sms", new SMS());
        	return "sms-form";
        }else {
        	Status status = twilioSMSService.sendSMS(sms);
        	model.addAttribute("error", "message status : " + status.toString());
        	model.addAttribute("sms", new SMS());
        	return "sms-form";
        }

    }
    
    @GetMapping("/getMessages")
    public String getMessages(Model model) {
    	
    	ITwilioSMSService twilioSMSService = (ITwilioSMSService) appContext.getBean("twilioSMSService");
    	List<MessageResponse> messageList = twilioSMSService.getMessageList();
	    model.addAttribute("messages", messageList);
	    return "messages";
    }
    
    @GetMapping("/index")
    public String showIndex(Model model) {
        return "index";
    }

}
