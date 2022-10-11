package sk.ness.academy.springboothibernate.service;

import sk.ness.academy.springboothibernate.model.Book;

import java.util.List;

public interface BookService {
  List<Book> findAll();
  void save(Book book);
}
