package com.kodilla.adapter.bookclassifier;

import com.kodilla.adapter.bookclassifier.libraryb.Book;
import com.kodilla.adapter.bookclassifier.libraryb.BookSignature;
import com.kodilla.adapter.bookclassifier.libraryb.BookStatistics;
import com.kodilla.adapter.bookclassifier.libraryb.Statistics;

import java.util.Map;

public class MedianAdaptee implements BookStatistics {

    @Override
    public int medianPublicationYear(Map<BookSignature, Book> books) {
        Statistics statistics = new Statistics();
        return statistics.medianPublicationYear(books);
    }

    @Override
    public int averagePublicationYear(Map<BookSignature, Book> books) {
        Statistics statistics = new Statistics();
        return statistics.averagePublicationYear(books);
    }
}
