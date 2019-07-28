package com.friendsurance.mail.impl;

import com.friendsurance.mail.EmailService.MailType;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class EmailContentSupplier {
    private static final Map<MailType, Supplier<EmailContent>> MAIL_BODY_SUPPLIER;

    static {
        final Map<MailType, Supplier<EmailContent>> mailContent = new HashMap<>();
        mailContent.put(MailType.MAIL_TYPE_1, EmailContent.builder().subject("Registration Reminder").body("Hey {0}, do you remember us? Give us a try and be social with your insurances!").build());
        mailContent.put(MailType.MAIL_TYPE_2, EmailContent.builder().subject("Email Type 2").body("Hi {0}, Type 2 Email Template").build());
        mailContent.put(MailType.MAIL_TYPE_3, EmailContent.builder().subject("Email Type 3").body("Hi {0}, Type 3 Email Template").build());
        mailContent.put(MailType.MAIL_TYPE_4, EmailContent.builder().subject("Email Type 4").body("Hi {0}, Type 4 Email Template").build());
        mailContent.put(MailType.MAIL_TYPE_5, EmailContent.builder().subject("Email Type 5").body("Hi {0}, Type 5 Email Template").build());

        MAIL_BODY_SUPPLIER = Collections.unmodifiableMap(mailContent);
    }

    public Supplier<EmailContent> supplyMailBody(MailType mailType) {
        return MAIL_BODY_SUPPLIER.get(mailType);
    }
}
