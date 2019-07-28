package com.friendsurance.mail.impl;

import com.friendsurance.mail.EmailContentService;
import com.friendsurance.mail.EmailService.MailType;

public class EmailContentServiceImpl implements EmailContentService {

    private EmailContentSupplier supplier = new EmailContentSupplier();

    @Override
    public EmailContent generateEmailContent(String recipient, MailType mailType) {
        EmailContent emailContent = supplier.supplyMailBody(mailType).get();
        emailContent.setBody(emailContent.getBody().replace("{0}", recipient));
        emailContent.setRecipient(recipient);
        return emailContent;
    }
}
