package com.friendsurance.rules;

import com.deliveredtechnologies.rulebook.RuleState;
import com.deliveredtechnologies.rulebook.annotation.*;
import com.friendsurance.mail.EmailService.MailType;

@Rule(order = 4)
public class MailType2Rule {
    @Given("ruleFact")
    private RuleFact ruleFact;

    @Result
    private MailType result;

    @When
    public boolean when() {
        return (!ruleFact.isHasContract() && ruleFact.getFriendsNumber() == 0 && ruleFact.getSentInvitationsNumber() == 0) ||
                (!ruleFact.isHasContract() && ruleFact.getFriendsNumber() < 3 && ruleFact.getSentInvitationsNumber() > 1);
    }

    @Then
    public RuleState then() {
        result = MailType.MAIL_TYPE_2;
        return RuleState.BREAK;
    }
}
