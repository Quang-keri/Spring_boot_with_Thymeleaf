package hsf302.mvc.demothymeleaf.controller;


import hsf302.mvc.demothymeleaf.model.BookModel;
import hsf302.mvc.demothymeleaf.service.BookService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

   private final BookService bookService;

   public BookController(BookService bookService) {
      this.bookService= bookService;
   }

   @GetMapping
    public  String getBooks(@RequestParam (required = false,name = "userId") String login,
                            @RequestParam (required = false,name ="email") String email,
                            Model model,
                            HttpServletRequest request) {

       HttpSession session = request.getSession();

       if (login != null && !login.isEmpty()) {
           session.setAttribute("userLogin", login);
       }
      String userLogin = (String) session.getAttribute("userlogin");
       model.addAttribute("userLogin",userLogin);
       System.out.println("User login: " + login);
         List<BookModel> getBookList= bookService.getAllBooksByLogin(login);
      model.addAttribute("userBook", getBookList);
       return "book_page";
   }
}
