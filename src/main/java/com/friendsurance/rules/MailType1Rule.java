package com.friendsurance.rules;

import com.deliveredtechnologies.rulebook.RuleState;
import com.deliveredtechnologies.rulebook.annotation.*;
import com.friendsurance.mail.EmailService.MailType;

@Rule(order = 5)
public class MailType1Rule {
    @Given("ruleFact")
    private RuleFact ruleFact;

    @Result
    private MailType result;

    @When
    public boolean when() {
        return (!ruleFact.isHasContract() && ruleFact.getFriendsNumber() > 3 && ruleFact.getSentInvitationsNumber() > 1);
    }

    @Then
    public RuleState then() {
        result = MailType.MAIL_TYPE_1;
        return RuleState.BREAK;
    }
}