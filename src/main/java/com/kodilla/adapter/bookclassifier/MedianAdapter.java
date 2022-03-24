package com.kodilla.adapter.bookclassifier;

import com.kodilla.adapter.bookclassifier.librarya.Book;
import com.kodilla.adapter.bookclassifier.librarya.Classifier;
import com.kodilla.adapter.bookclassifier.libraryb.BookSignature;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Classifier {

    @Override
    public int publicationYearMedian(Set<Book> bookSet) {
        Map<BookSignature, Book> bookSignatureMap = new HashMap();
        BookSignature bookSignatureKey = new BookSignature((bookSet.stream()
                .map(Book::getSignature)
                .toString()));

        String bookTitle = bookSet.stream()
                .map(Book::getAuthor)
                .toString();
        String bookAuthor = bookSet.stream()
                .map(Book::getAuthor)
                .toString();

        int bookPublicationYear = 2004;

        String bookSignature = bookSet.stream()
                .map(Book::getSignature)
                .toString();

        for (int n = 0; n < bookSet.size(); n++) {
            bookSignatureMap.put(bookSignatureKey, new Book(bookAuthor, bookTitle, bookPublicationYear, bookSignature));
        }
        return medianPublicationYear(bookSignatureMap);
    }
}
