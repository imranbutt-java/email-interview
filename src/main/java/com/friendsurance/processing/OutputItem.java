package com.friendsurance.processing;

import com.friendsurance.backend.User;
import com.friendsurance.mail.EmailRecipient;
import com.friendsurance.mail.EmailService.MailType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
public class OutputItem implements EmailRecipient {
    private User recipient;
    private MailType mailType;

    @Override
    public String getEmail() {
        return this.recipient.getEmail();
    }
}
