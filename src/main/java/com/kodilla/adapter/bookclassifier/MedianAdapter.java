package com.kodilla.adapter.bookclassifier;

import com.kodilla.adapter.bookclassifier.librarya.BookA;
import com.kodilla.adapter.bookclassifier.librarya.Classifier;
import com.kodilla.adapter.bookclassifier.libraryb.Book;
import com.kodilla.adapter.bookclassifier.libraryb.BookSignature;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MedianAdapter extends MedianAdaptee implements Classifier {

    @Override
    public int publicationYearMedian(Set<BookA> bookSet) {
        Map<BookSignature, Book> bookSignatureMap = new HashMap();

        String bookTitle = bookSet.stream()
                .map(BookA::getAuthor)
                .toString();

        String bookAuthor = bookSet.stream()
                .map(BookA::getAuthor)
                .toString();

        int bookPublicationYear = bookSet.stream()
                .map(BookA::getPublicationYear);

        String bookSignature = bookSet.stream()
                .map(BookA::getSignature)
                .toString();

        for (int n = 0; n < bookSet.size(); n++) {
            bookSignatureMap.put(new BookSignature(bookSignature), new Book(bookAuthor, bookTitle, bookPublicationYear));
        }
        return medianPublicationYear(bookSignatureMap);
    }
}
