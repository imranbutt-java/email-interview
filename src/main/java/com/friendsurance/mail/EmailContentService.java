package com.friendsurance.mail;

import com.friendsurance.mail.impl.EmailContent;
import com.friendsurance.mail.EmailService.MailType;

public interface EmailContentService {
    EmailContent generateEmailContent(String recipient, MailType mailType);
}
