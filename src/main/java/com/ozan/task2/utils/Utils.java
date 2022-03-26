package com.ozan.task2.utils;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

public class Utils {

	/**
	 * checks if phone number is a valid Turkish number
	 * 
	 * @param phoneNumber
	 * @return
	 */
	public static final boolean isPhoneNumberValid(String phoneNumber) {
		
		if(phoneNumber.matches("[a-zA-Z]+")) {
			return false;
		}
    	
    	PhoneNumberUtil numberUtil = PhoneNumberUtil.getInstance();  
    	PhoneNumber number = null;
    	try {
			number = numberUtil.parse(phoneNumber, "TR");
		} catch (NumberParseException e) {
			e.printStackTrace();
		}  
    	
        return numberUtil.isValidNumber(number);
    }
}
