package com.github.zregvart.salesforce.ipaas;

import org.apache.camel.CamelContext;
import org.apache.camel.component.salesforce.SalesforceComponent;
import org.apache.camel.component.salesforce.SalesforceLoginConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Profile("!kubernetes")
@EnableScheduling
@Configuration
public class ChangeRefreshTokenOnPurpose {

    @Autowired
    CamelContext contaxt;

    @Scheduled(initialDelay = 12000, fixedDelay = Long.MAX_VALUE)
    public void changeRefreshToken() {
        final SalesforceComponent component = (SalesforceComponent) contaxt.getComponent("salesforce-component");
        final SalesforceLoginConfig loginConfig = component.getLoginConfig();
        loginConfig.setRefreshToken("abracadabra");
    }
}
