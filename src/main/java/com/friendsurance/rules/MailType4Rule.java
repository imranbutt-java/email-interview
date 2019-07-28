package com.friendsurance.rules;

import com.deliveredtechnologies.rulebook.RuleState;
import com.deliveredtechnologies.rulebook.annotation.*;
import com.friendsurance.mail.EmailService.MailType;

@Rule(order = 2)
public class MailType4Rule {
    @Given("ruleFact")
    private RuleFact ruleFact;

    @Result
    private MailType result;

    @When
    public boolean when() {
        return (ruleFact.isHasContract() && ruleFact.getFriendsNumber() > 1);
    }

    @Then
    public RuleState then() {
        result = MailType.MAIL_TYPE_4;
        return RuleState.BREAK;
    }
}

