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
        for (int n=0; n<bookSet.size(); n++) {
            bookSignatureMap.put((new BookSignature(Book())))
        }
    }
}
