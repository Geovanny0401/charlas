package com.gmail.geovanny.backend.repository;

import com.gmail.geovanny.backend.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBookReposirory extends CrudRepository<Book, Long> {

    @Query("select b from Book b " +
            "where lower(b.title) like lower(concat('%', :searchBook, '%'))" +
            "or lower(b.author) like lower(concat('%', :searchBook, '%'))")
    List<Book> search(@Param("searchBook") String searchBook);

}
