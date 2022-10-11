package sk.ness.academy.springboothibernate.dao.impl;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import sk.ness.academy.config.TestDataSourceConfig;
import sk.ness.academy.springboothibernate.dao.BookDao;
import sk.ness.academy.springboothibernate.model.Book;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = { TestDataSourceConfig.class, BookDaoImpl.class })
@Transactional
@Sql({"/initdb.sql"})
class BookDaoImplTest {

  @Autowired
  private BookDao bookDao;

  @Resource(name = "sessionFactory")
  private SessionFactory sessionFactory;

  @BeforeEach
  public void beforeEach() {
    System.out.println("### BeforeEach ###");
  }

  @Test
  void findAllTest() {
    final List<Book> books = bookDao.findAll();
    Assertions.assertEquals(0, books.size());
  }

  @Test
  void persist() {

    Book book = new Book();
    book.setName("New Book");

    long initialSize = getBooksCount();
    bookDao.persist(book);
    long newSize = getBooksCount();

    Assertions.assertTrue(newSize > initialSize, "No new items were added.");
  }

  private long getBooksCount() {
    return this.sessionFactory.getCurrentSession().createQuery("SELECT COUNT(b) FROM Book b", Long.class).getSingleResult();
  }
  
}