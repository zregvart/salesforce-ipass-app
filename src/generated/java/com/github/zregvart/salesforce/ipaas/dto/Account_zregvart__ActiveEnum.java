/*
 * Salesforce DTO generated by camel-salesforce-maven-plugin
 * Generated on: Tue Mar 14 19:39:58 CET 2017
 */
package com.github.zregvart.salesforce.ipaas.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Salesforce Enumeration DTO for picklist zregvart__Active__c
 */
public enum Account_zregvart__ActiveEnum {

    // No
    NO("No"),
    // Yes
    YES("Yes");

    final String value;

    private Account_zregvart__ActiveEnum(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return this.value;
    }

    @JsonCreator
    public static Account_zregvart__ActiveEnum fromValue(String value) {
        for (Account_zregvart__ActiveEnum e : Account_zregvart__ActiveEnum.values()) {
            if (e.value.equals(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException(value);
    }

}