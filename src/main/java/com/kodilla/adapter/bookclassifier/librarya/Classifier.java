package com.kodilla.adapter.bookclassifier.librarya;

import java.util.Set;

public interface Classifier {
    int publicationYearMedian(Set<BookA> bookSet);
}
