package com.kodilla.adapter.bookclassifier;

import com.kodilla.adapter.bookclassifier.librarya.BookA;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MedianAdapterTestSuite {

    @Test
    public void testMedianPublicationYear() {
        //Given
        BookA book1 = new BookA("Max Czornyj", "Grób", 2020, "ABC123");
        BookA book2 = new BookA("Max Czornyj", "Mortalista", 2021, "ABC124");
        BookA book3 = new BookA("Max Czornyj", "Obcy", 2022, "ABC125");

        Set<BookA> books = new HashSet<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);

        MedianAdapter medianAdapter = new MedianAdapter();

        //When
        int medianYearOfPublication = medianAdapter.publicationYearMedian(books);

        //Then
        System.out.println("Median publication year in the library A is: " + medianYearOfPublication);
        assertEquals(3, books.size());
        assertEquals(medianYearOfPublication, 2021);
    }
}