package hsf302.mvc.demothymeleaf.service;


import hsf302.mvc.demothymeleaf.model.BookModel;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private static List<BookModel> books ;

    static {
        books = new ArrayList<>();
        books.add(new BookModel("Book 1", 2020));
        books.add(new BookModel("Book 2", 2021));
        books.add(new BookModel("Book 3", 2022));
        books.add(new BookModel("Book 4", 1940));
    }

    public  List<BookModel> getAllBooksByLogin(String login) {
         if(login != null){
             return books;
         }

         return books.stream()
                 .filter(book -> book.getYear() > 1961)
                 .toList();
    }

}
