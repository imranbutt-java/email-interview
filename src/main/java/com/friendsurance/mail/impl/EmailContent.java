package com.friendsurance.mail.impl;

import com.sun.javafx.binding.StringFormatter;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.function.Supplier;

@Data
@Builder
@ToString
public class EmailContent implements Supplier<EmailContent> {
    private String recipient;
    private String subject;
    private String body;

    @Builder
    public EmailContent(String recipient, String subject, String body) {
        this.recipient = recipient;
        this.subject = subject;
        this.body = StringFormatter.format(body, recipient).getValue();
    }

    @Builder
    public EmailContent(String subject, String body) {
        this.subject = subject;
        this.body = StringFormatter.format(body, recipient).getValue();
    }

    @Override
    public EmailContent get() {
        return this;
    }
}
