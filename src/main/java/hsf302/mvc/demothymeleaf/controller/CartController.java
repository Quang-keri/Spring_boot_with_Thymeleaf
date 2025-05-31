//package hsf302.mvc.demothymeleaf.controller;
//
//import hsf302.mvc.demothymeleaf.shopping.Cart;
//import hsf302.mvc.demothymeleaf.shopping.Product;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//
//@Controller
//@RequestMapping("/cart")
//public class CartController {
//
//    @GetMapping
//    public String viewCart(HttpSession session, Model model) {
//        Cart cart = (Cart) session.getAttribute("cart");
//        if (cart == null) cart = new Cart();
//        model.addAttribute("cart", cart);
//        return "cart";
//    }
//
//    @PostMapping("/add")
//    public String addToCart(@RequestParam Long productId,
//                            @RequestParam String productName,
//                            @RequestParam double price,
//                            @RequestParam(defaultValue = "1") int quantity,
//                            HttpSession session) {
//        Cart cart = (Cart) session.getAttribute("cart");
//        if (cart == null) cart = new Cart();
//        cart.addItem(new CartItem(productId, productName, quantity, price));
//        session.setAttribute("cart", cart);
//        return "redirect:/cart";
//    }
//
//    @PostMapping("/remove")
//    public String removeFromCart(@RequestParam Long productId, HttpSession session) {
//        Cart cart = (Cart) session.getAttribute("cart");
//        if (cart != null) {
//            cart.removeItem(productId);
//            session.setAttribute("cart", cart);
//        }
//        return "redirect:/cart";
//    }
//}