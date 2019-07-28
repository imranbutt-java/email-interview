package com.friendsurance.rules;

import com.deliveredtechnologies.rulebook.RuleState;
import com.deliveredtechnologies.rulebook.annotation.*;
import com.friendsurance.mail.EmailService.MailType;

@Rule(order = 1)
public class MailType5Rule {

    @Given("ruleFact")
    private RuleFact ruleFact;
    @Result
    private MailType result;

    @When
    public boolean when() {
        return ruleFact.isHasContract() && ruleFact.getFriendsNumber() > 4 && ruleFact.getSentInvitationsNumber() > 3;
    }

    @Then
    public RuleState then() {
        result = MailType.MAIL_TYPE_5;
        return RuleState.BREAK;
    }
}
