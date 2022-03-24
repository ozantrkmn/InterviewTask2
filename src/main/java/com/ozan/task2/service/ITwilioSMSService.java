package com.ozan.task2.service;

import java.util.List;

import com.ozan.task2.model.MessageResponse;
import com.ozan.task2.model.SMS;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.Message.Status;

public interface ITwilioSMSService {

	/**
	 * Send sms using twili
	 * @param smsRequest sms
	 * @return status of sent sms
	 */
	Status sendSMS(SMS smsRequest);

	/**
	 * lists all sent sms
	 * @return
	 */
	List<MessageResponse> getMessageList();

}
