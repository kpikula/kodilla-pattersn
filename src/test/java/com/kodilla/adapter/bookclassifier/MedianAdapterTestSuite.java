package com.kodilla.adapter.bookclassifier;

import com.kodilla.adapter.bookclassifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MedianAdapterTestSuite {

    @Test
    public void testMedianPublicationYear() {
        //Given
        Book book1 = new Book("Max Czornyj", "Grób", 2018, "ABC123");
        Book book2 = new Book("Max Czornyj", "Mortalista", 2020, "ABC124");
        Book book3 = new Book("Max Czornyj", "Obcy", 2022, "ABC125");

        Set<Book> books = new HashSet<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);

        MedianAdapter medianAdapter = new MedianAdapter();

        //When
        int medianYearOfPublication = medianAdapter.publicationYearMedian(books);

        //Then
        System.out.println("Median publication year in the library A is: " + medianYearOfPublication);
        assertEquals(3, books.size());
        assertEquals(2020, medianYearOfPublication);
    }
}