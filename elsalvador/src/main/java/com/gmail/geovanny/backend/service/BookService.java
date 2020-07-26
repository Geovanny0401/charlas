package com.gmail.geovanny.backend.service;

import com.gmail.geovanny.backend.model.Book;
import com.gmail.geovanny.backend.repository.IBookReposirory;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class BookService {

    private static final Logger LOGGER = Logger.getLogger(BookService.class.getName());
    private IBookReposirory bookReposirory;

    public BookService(IBookReposirory bookReposirory) {
        this.bookReposirory = bookReposirory;
    }

    public List<Book> findAll() {
        return (List<Book>) bookReposirory.findAll();
    }

    public List<Book> findAll(String stringFilter) {
        if (stringFilter == null || stringFilter.isEmpty()) {
            return (List<Book>) bookReposirory.findAll();
        } else {
            return bookReposirory.search(stringFilter);
        }
    }

    public long count() {
        return bookReposirory.count();
    }

    public void delete(Book book) {
        bookReposirory.delete(book);
    }

    public void save(Book book) {
        if (book == null) {
            LOGGER.log(Level.SEVERE,
                    "The book is empty, are you sure it's well written?");
            return;
        }
        bookReposirory.save(book);
    }
}
