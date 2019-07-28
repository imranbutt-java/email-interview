package com.friendsurance.processing.impl;

import com.deliveredtechnologies.rulebook.FactMap;
import com.deliveredtechnologies.rulebook.NameValueReferableMap;
import com.deliveredtechnologies.rulebook.model.runner.RuleBookRunner;
import com.friendsurance.backend.User;
import com.friendsurance.mail.EmailService.MailType;
import com.friendsurance.processing.*;
import com.friendsurance.rules.RuleFact;

public class ItemProcessingImpl extends ItemProcessing<InputItem, OutputItem> {

    private RuleBookRunner ruleBook = new RuleBookRunner("com.friendsurance.rules");
    public ItemProcessingImpl(ItemReader<InputItem> reader, ItemWriter<OutputItem> writer) {
        super(reader, writer);
    }

    protected OutputItem process(InputItem item) {
        User user = item.getUser();

        NameValueReferableMap<RuleFact> facts = new FactMap<>();
        facts.setValue("ruleFact", new RuleFact(
                user.hasContract(),
                user.getFriendsNumber(),
                user.getSentInvitationsNumber()
        ));

        ruleBook.setDefaultResult(null);
        ruleBook.run(facts);
        return ruleBook.getResult().map(f -> {
            return new OutputItem(user, (MailType) f.getValue());
        }).orElse(null);
    }
}
