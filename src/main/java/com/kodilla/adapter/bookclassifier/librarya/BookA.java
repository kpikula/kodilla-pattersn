package com.kodilla.adapter.bookclassifier.librarya;

import java.util.Objects;

public class BookA {
    private final String author;
    private final String title;
    private final int publicationYear;
    private final String signature;

    public BookA(final String author, final String title,
                 final int publicationYear, final String signature) {
        this.author = author;
        this.title = title;
        this.publicationYear = publicationYear;
        this.signature = signature;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getSignature() {
        return signature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookA)) return false;
        BookA book = (BookA) o;
        return getSignature().equals(book.getSignature());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSignature());
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                ", signature='" + signature + '\'' +
                '}';
    }
}
