package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LibraryTestSuite {

    @Test
    void testGetBooks() {
        //Given
        //creating library with books
        Library library = new Library("Library original");
        Book book1 = new Book("Title 1", "Author 1", LocalDate.of(2001, 1, 1));
        Book book2 = new Book("Title 2", "Author 2", LocalDate.of(2002, 1, 1));
        Book book3 = new Book("Title 3", "Author 3", LocalDate.of(2003, 1, 1));
        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);
        //creating shallow clone
        Library shallowClonedLibrary = null;
        try {
            shallowClonedLibrary = library.shallowCopy();
            shallowClonedLibrary.setName("Library clone shallow");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        //creating deep clone
        Library deepClonedLirary = null;
        try {
            deepClonedLirary = library.deepCopy();
            deepClonedLirary.setName("Library clone deep");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        
        //When
        library.getBooks().remove(book1);

        //Then
        System.out.println(library.getBooks());
        System.out.println(shallowClonedLibrary.getBooks());
        System.out.println(deepClonedLirary.getBooks());
        assertEquals(2, library.getBooks().size());
        assertEquals(2, shallowClonedLibrary.getBooks().size());
        assertEquals(3, deepClonedLirary.getBooks().size());
        assertEquals(shallowClonedLibrary.getBooks(), library.getBooks());
        assertNotEquals(deepClonedLirary.getBooks(), library.getBooks());
    }
}
