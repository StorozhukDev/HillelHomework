package com.storozhuk.lesson10.CollectionService.service.impl;

import com.storozhuk.lesson8.StringCollection.service.impl.StringCollection;

import java.util.Iterator;

/**
 * Class StringCollectionIterator
 *
 * Implementation of Iterator for StringCollection.
 */
public class StringCollectionIterator implements Iterator {
    private final StringCollection collection;
    private int index = 0;

    public StringCollectionIterator(StringCollection collection) {
        this.collection = collection;
    }

    @Override
    public boolean hasNext() {
        return (this.index < this.collection.size());
    }

    @Override
    public String next() {
        if(!hasNext()) {
            return null; /* TODO throw exception */
        }
        return (String)this.collection.get(index++);
    }
}
