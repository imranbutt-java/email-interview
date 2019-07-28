package com.friendsurance.processing.impl;

import com.friendsurance.backend.User;
import com.friendsurance.mail.EmailService.MailType;
import com.friendsurance.processing.InputItem;
import com.friendsurance.processing.OutputItem;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ItemProcessingImplTest {
    @Test
    public void mailType1Success() {
        User user = new User("1@abc.com" , false, 4, 2);
        InputItem item = new InputItem(user);
        OutputItem outputItem = new OutputItem(user, MailType.MAIL_TYPE_1);

        assertOutput(item, outputItem);
    }

    @Test
    public void mailType2Success() {
        List<InputItem> items = new ArrayList<>();
        User user1 = new User("2@abc.com" , false, 0, 0);
        User user2 = new User("2@abc.com" , false, 2, 2);
        InputItem item1 = new InputItem(user1);
        InputItem item2 = new InputItem(user2);

        items.addAll(Arrays.asList(new InputItem[] {item1, item2}));

        OutputItem outputItem1 = new OutputItem(user1, MailType.MAIL_TYPE_2);
        OutputItem outputItem2 = new OutputItem(user2, MailType.MAIL_TYPE_2);

        ItemProcessingImpl processing = prepare(items);
        assertEquals(outputItem1, processing.process(item1));
        assertEquals(outputItem2, processing.process(item2));
    }

    @Test
    public void mailType3Success() {
        List<InputItem> items = new ArrayList<>();
        User user1 = new User("3@abc.com" , false, 2, 0);
        User user2 = new User("3@abc.com" , false, 2, 7);
        User user3 = new User("3@abc.com" , true, 0, 0);
        InputItem item1 = new InputItem(user1);
        InputItem item2 = new InputItem(user2);
        InputItem item3 = new InputItem(user3);

        items.addAll(Arrays.asList(new InputItem[] {item1, item2, item3}));

        OutputItem outputItem1 = new OutputItem(user1, MailType.MAIL_TYPE_3);
        OutputItem outputItem2 = new OutputItem(user2, MailType.MAIL_TYPE_3);
        OutputItem outputItem3 = new OutputItem(user3, MailType.MAIL_TYPE_3);

        ItemProcessingImpl processing = prepare(items);
        assertEquals(outputItem1, processing.process(item1));
        assertEquals(outputItem2, processing.process(item2));
        assertEquals(outputItem3, processing.process(item3));
    }

    @Test
    public void mailType4Success() {
        User user = new User("4@abc.com" , true, 2, 0);
        InputItem item = new InputItem(user);
        OutputItem outputItem = new OutputItem(user, MailType.MAIL_TYPE_4);

        assertOutput(item, outputItem);
    }

    @Test
    public void mailType5Success() {
        User user = new User("5@abc.com" , true, 5, 4);
        InputItem item = new InputItem(user);
        OutputItem outputItem = new OutputItem(user, MailType.MAIL_TYPE_5);

        assertOutput(item, outputItem);
    }

    @Test
    public void noRuleApplied() {
        User user = new User("wrong@abc.com" , true, -1, -1);
        InputItem item = new InputItem(user);
        OutputItem outputItem = new OutputItem(user, null);

        assertOutput(item, null);
    }

    private ItemProcessingImpl prepare(List<InputItem> items) {
        return new ItemProcessingImpl(new ItemReaderImpl(items), new ItemWriterImpl());
    }

    private void assertOutput(InputItem item, OutputItem outputItem) {
        ItemProcessingImpl processing = prepare(Arrays.asList(new InputItem[]{item}));
        assertEquals(outputItem, processing.process(item));
    }
}
