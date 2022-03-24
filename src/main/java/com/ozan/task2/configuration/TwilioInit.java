package com.ozan.task2.configuration;

import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * inits the twilio settings
 * @author OZAN
 *
 */
@Configuration
public class TwilioInit {
	
    private final TwilioConfig twilioConfiguration;
    
    @Autowired
    public TwilioInit(TwilioConfig twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
        
        Twilio.init(
                twilioConfiguration.getAccountSid(),
                twilioConfiguration.getAuthToken()
        );
        
    }
}
