package com.kodilla.adapter.bookclassifier;

import com.kodilla.adapter.bookclassifier.librarya.Classifier;
import com.kodilla.adapter.bookclassifier.libraryb.BookSignature;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Classifier {

    @Override
    public int publicationYearMedian(Set<com.kodilla.adapter.bookclassifier.librarya.Book> bookSet) {

        Map<BookSignature, com.kodilla.adapter.bookclassifier.libraryb.Book> bookSignatureMap = new HashMap();

        for (com.kodilla.adapter.bookclassifier.librarya.Book book : bookSet) {
            bookSignatureMap.put(new BookSignature(book.getSignatureA()), new com.kodilla.adapter.bookclassifier.libraryb.Book(book.getAuthor(), book.getTitle(), book.getPublicationYear()));
        }
        return medianPublicationYear(bookSignatureMap);
    }
}