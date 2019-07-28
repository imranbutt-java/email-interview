package com.friendsurance.processing;

import com.friendsurance.backend.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class InputItem {
    private User user;
}
