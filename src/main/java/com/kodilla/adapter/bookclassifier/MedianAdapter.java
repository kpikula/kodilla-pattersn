package com.kodilla.adapter.bookclassifier;

import com.kodilla.adapter.bookclassifier.librarya.BookA;
import com.kodilla.adapter.bookclassifier.librarya.Classifier;
import com.kodilla.adapter.bookclassifier.libraryb.Book;
import com.kodilla.adapter.bookclassifier.libraryb.BookSignature;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Classifier {

    @Override
    public int publicationYearMedian(Set<BookA> bookSet) {

        Map<BookSignature, Book> bookSignatureMap = new HashMap();

        for (BookA bookA : bookSet) {
            bookSignatureMap.put(new BookSignature(bookA.getSignatureA()), new Book(bookA.getAuthor(), bookA.getTitle(), bookA.getPublicationYear()));
        }
        return medianPublicationYear(bookSignatureMap);
    }
}