package org.bb.quarkus.starting;

import java.util.List;
import java.util.Optional;

import org.bb.quarkus.starting.classes.Book;
import org.bb.quarkus.starting.repositories.BookRepository;
import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    @Inject
    BookRepository bookRepository;
    @Inject
    Logger logger;

    @GET
    public List<Book> getAllBooks() {
        logger.info("Returns all of the books");
        return bookRepository.getAllBooks();
    }

    @GET
    @Path("/count")
    public int countAllBooks() {
        logger.info("Returns number of the books");
        return getAllBooks().size();
    }

    @GET
    @Path("{id}")
    public Optional<Book> getBook(@PathParam("id") int id) {
        logger.info("Returns a single book with id " + id);
        return bookRepository.getBook(id);
    }
}
