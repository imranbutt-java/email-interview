package com.friendsurance.processing.impl;

import com.friendsurance.processing.InputItem;
import com.friendsurance.processing.ItemReader;

import java.util.Iterator;
import java.util.List;

public class ItemReaderImpl implements ItemReader<InputItem> {

    private List<InputItem> items;
    private Iterator<InputItem> iterator;

    public ItemReaderImpl(List<InputItem> items) {
        this.items = items;
        this.iterator = items.iterator();
    }

    public InputItem read() {
        if (!hasNext())
            return null;

        return next();
    }

    private boolean hasNext() {
        return iterator.hasNext();
    }

    private InputItem next() {
        return iterator.next();
    }
}
