package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianAdapterTestSuite {

    @Test
    public void publicationYearMedianTest() {
        //Given
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(new Book("Author 1", "Title 1", 2000, "signature_1"));
        bookSet.add(new Book("Author 2", "Title 2", 2020, "signature_2"));
        bookSet.add(new Book("Author 3", "Title 3", 2023, "signature_3"));
        bookSet.add(new Book("Author 4", "Title 4", 2010, "signature_4"));
        bookSet.add(new Book("Author 5", "Title 5", 1850, "signature_5"));
        MedianAdapter medianAdapter = new MedianAdapter();
        //When
        int resultMedianYear = medianAdapter.publicationYearMedian(bookSet);
        //Then
        assertEquals(2010, resultMedianYear);
    }
}
