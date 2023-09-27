package org.bb.quarkus.starting.repositories;

import java.util.List;
import java.util.Optional;

import org.bb.quarkus.starting.classes.Book;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BookRepository {

  @ConfigProperty(name = "books.genre", defaultValue = "Drama")
  String genre;

  public List<Book> getAllBooks() {
    return List.of(
        new Book(1, "EZ JavaScript", "Mr.Bookworm", 2007, genre),
        new Book(1, "EZ JavaScript", "Mr.Bookworm", 2007, genre),
        new Book(1, "EZ JavaScript", "Mr.Bookworm", 2007, genre),
        new Book(1, "EZ JavaScript", "Mr.Bookworm", 2007, genre));
  }

  public Optional<Book> getBook(int id) {
    return getAllBooks().stream().filter(book -> book.id == id).findFirst();
  }

}
