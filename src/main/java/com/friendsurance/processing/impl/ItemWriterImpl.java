package com.friendsurance.processing.impl;

import com.friendsurance.mail.EmailService;
import com.friendsurance.mail.impl.EmailServiceImpl;
import com.friendsurance.processing.ItemWriter;
import com.friendsurance.processing.OutputItem;

public class ItemWriterImpl implements ItemWriter<OutputItem> {

    private EmailService emailService = new EmailServiceImpl();

    public void write(OutputItem item) {
        emailService.sendMail(item, item.getMailType());
    }
}
