package com.friendsurance;

import com.friendsurance.backend.User;
import com.friendsurance.processing.InputItem;
import com.friendsurance.processing.ItemProcessing;
import com.friendsurance.processing.impl.ItemProcessingImpl;
import com.friendsurance.processing.impl.ItemReaderImpl;
import com.friendsurance.processing.impl.ItemWriterImpl;

import java.time.format.DateTimeFormatter;
import java.util.*;

public class MainApp {
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    public static void main(String[] args) {
        Timer timer = new Timer();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 3);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date time = calendar.getTime();

        timer.schedule(new EmailTask(), time);
    }

    static class EmailTask extends TimerTask {
        public void run() {
            List<InputItem> items = getAllEmails();
            ItemProcessing itemProcessor = new ItemProcessingImpl(new ItemReaderImpl(items), new ItemWriterImpl());
            itemProcessor.doProcessing();
        }
    }

    private static List<InputItem> getAllEmails() {
        List<InputItem> items = new ArrayList<>();

        items.add(new InputItem(new User("1@abc.com" , false, 0, 0)));
        items.add(new InputItem(new User("2@abc.com" , false, 3, 0)));
        items.add(new InputItem(new User("3@abc.com" , false, 4, 2)));
        items.add(new InputItem(new User("4@abc.com" , false, 2, 2)));
        items.add(new InputItem(new User("5@abc.com" , false, 2, 10)));
        items.add(new InputItem(new User("6@abc.com" , true, 0, 0)));
        items.add(new InputItem(new User("7@abc.com" , true, 0, 5)));
        items.add(new InputItem(new User("8@abc.com" , true, 2, 2)));
        items.add(new InputItem(new User("9@abc.com" , true, 5, 4)));
        items.add(new InputItem(new User("wrong@abc.com" , false, -1, -1)));

        return items;
    }
}
