package sk.ness.academy.springboothibernate.service.impl;

import org.springframework.stereotype.Service;
import sk.ness.academy.springboothibernate.dao.BookDao;
import sk.ness.academy.springboothibernate.model.Book;
import sk.ness.academy.springboothibernate.service.BookService;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

  @Resource
  private BookDao bookDao;

  @Override
  public List<Book> findAll() {
    return bookDao.findAll();
  }

  @Override
  public void save(final Book book) {
    bookDao.persist(book);
  }

}
