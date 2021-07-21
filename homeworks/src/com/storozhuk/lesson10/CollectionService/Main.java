package com.storozhuk.lesson10.CollectionService;

import com.storozhuk.lesson10.CollectionService.service.impl.StringCollectionIterator;
import com.storozhuk.lesson8.StringCollection.service.impl.StringCollection;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static com.storozhuk.lesson10.CollectionService.service.DuplicatesRemover.withoutDuplicates;

/**
 * 1. Method which takes and returns collection without duplicates.
 * 2. Iterator realization for collection from lesson8 homework.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("\nTask1. Removing duplicates:");
        String[] strArr = new String[] {"1", "2", "3", "5", "1", "6", "2", "7", "8", "5", "9", "9"};
        List<String> list = new LinkedList<>(Arrays.asList(strArr));
        System.out.println(list);
        System.out.println(withoutDuplicates(list));

        System.out.println("\nTask2. Implementation of Iterator for StringCollection:");
        StringCollection stringCollection = new StringCollection();
        for(String s : strArr) {
            stringCollection.add(s);
        }
        System.out.println(stringCollection);
        StringCollectionIterator iterator = new StringCollectionIterator(stringCollection);
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
