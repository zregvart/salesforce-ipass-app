package com.github.zregvart.salesforce.ipaas;

import com.github.zregvart.salesforce.ipaas.dto.Account;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IntegrationConfiguration extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("timer://every10s?period=10000").process(exchange -> {
            final Message in = exchange.getIn();

            final Account account = new Account();
            account.setName("test-account-" + exchange.getProperty(Exchange.TIMER_COUNTER, String.class));
            in.setBody(account);
        }).to("salesforce:createSObject");
    }

}
