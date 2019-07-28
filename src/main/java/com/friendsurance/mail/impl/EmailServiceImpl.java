package com.friendsurance.mail.impl;

import com.friendsurance.mail.EmailContentService;
import com.friendsurance.mail.EmailRecipient;
import com.friendsurance.mail.EmailService;

public class EmailServiceImpl implements EmailService {

    private EmailContentService contentService= new EmailContentServiceImpl();

    @Override
    public void sendMail(EmailRecipient recipient, MailType mailType) {
        sendEmail(contentService.generateEmailContent(recipient.getEmail(), mailType));
    }

    private void sendEmail(EmailContent content) {
        System.out.format("Recipient: %s, Subject: %s, Body: %s \n", content.getRecipient(), content.getSubject(), content.getBody());
    }
}