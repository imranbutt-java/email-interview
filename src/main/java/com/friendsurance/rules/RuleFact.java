package com.friendsurance.rules;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class RuleFact {
    private boolean hasContract;
    private int     friendsNumber;
    private int     sentInvitationsNumber;
}
