package com.example.springsecurityapplication.controllers;

// addseller
import com.example.springsecurityapplication.security.PersonDetails;
import com.example.springsecurityapplication.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/seller")
public class SellerController {

    private final ProductService productService;

    @Autowired
    public SellerController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public String seller(Model model){

        // Получае объект аутентификации - > c помощью SecurityContextHolder обращаемся к контексту и на нем вызываем метод аутентификации. По сути из потока для текущего пользователя мы получаем объект, который был положен в сессию после аутентификации пользователя
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Преобразовываем объект аутентификации в специальный объект класса по работе с пользователями
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();

        String role = personDetails.getPerson().getRole();
        if(role.equals("ROLE_ADMIN")){
            return "redirect:/admin";
        }
        if(role.equals("ROLE_USER")){
            return "redirect:/index";
        }
        model.addAttribute("products", productService.getAllProduct());
        return "seller/seller";
    }



//    // Метод по отображению формы добавление
//    @GetMapping("/product/add")
//    public String addProduct(Model model){
//        model.addAttribute("product", new Product());
//        return "product/addProduct";
//    }
//
//    // Обработка формы добавления и сохранения объекта с формы
//    @PostMapping("/product/add")
//    public String addProduct(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult){
//        if(bindingResult.hasErrors()){
//            return "product/addProduct";
//        }
//        productService.saveProduct(product);
//        return "redirect:/product";
//    }
//
//    // Метод по удалению товара по id
//    @GetMapping("/product/delete/{id}")
//    public String deleteProducts(@PathVariable("id") int id){
//        productService.deleteProduct(id);
//        return "redirect:/seller";
//    }
//
//    // Метод по получению товара по id и отображение шаблона редактирования
//    @GetMapping("/product/edit/{id}")
//    public String editProducts(@PathVariable("id") int id, Model model){
//        model.addAttribute("editProduct", productService.getProductId(id));
//        return "product/editProduct";
//    }
//
//    @PostMapping("/product/edit/{id}")
//    public String editProduct(@ModelAttribute("editProduct") Product product, @PathVariable("id") int id){
//        productService.updateProduct(id, product);
//        return "redirect:/seller";
//    }
}
