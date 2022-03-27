package com.kodilla.adapter.bookclassifier.librarya;

import java.util.Objects;

public class Book {
    private final String author;
    private final String title;
    private final int publicationYear;
    private final String signatureA;


    public Book(final String author, final String title,
                final int publicationYear, final String signatureA) {
        this.author = author;
        this.title = title;
        this.publicationYear = publicationYear;
        this.signatureA = signatureA;
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

    public String getSignatureA() {
        return signatureA;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return getSignatureA().equals(book.getSignatureA());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSignatureA());
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                ", signature='" + signatureA + '\'' +
                '}';
    }
}
