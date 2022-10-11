package sk.ness.academy.springboothibernate;

import net.bytebuddy.utility.RandomString;
import org.springframework.stereotype.Component;
import sk.ness.academy.springboothibernate.model.Book;
import sk.ness.academy.springboothibernate.service.BookService;

import java.util.List;

@Component
public class AcademySpringHibernateApplicationRunMe {

  private final BookService bookService;

  public AcademySpringHibernateApplicationRunMe(final BookService bookService) {
    this.bookService = bookService;
  }

  public void run() {

//    final Book book = new Book();
//    book.setName(RandomString.make());
//    bookService.save(book);

    final List<Book> books = bookService.findAll();
    books.forEach(System.out::println);
  }
}
