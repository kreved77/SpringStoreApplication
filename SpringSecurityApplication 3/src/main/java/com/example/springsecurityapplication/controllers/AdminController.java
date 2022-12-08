package com.example.springsecurityapplication.controllers;

import com.example.springsecurityapplication.models.Image;
import com.example.springsecurityapplication.models.Order;
import com.example.springsecurityapplication.models.Person;
import com.example.springsecurityapplication.models.Product;
import com.example.springsecurityapplication.repositories.CategoryRepository;
import com.example.springsecurityapplication.repositories.OrderRepository;
import com.example.springsecurityapplication.security.PersonDetails;
import com.example.springsecurityapplication.services.OrderService;
import com.example.springsecurityapplication.services.PersonService;
import com.example.springsecurityapplication.services.ProductService;
import com.example.springsecurityapplication.util.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
//@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
public class AdminController {

    @Value("${upload.path}")
    private String uploadPath;

    private final ProductValidator productValidator;
    private final ProductService productService;

    private final CategoryRepository categoryRepository;

    private final OrderRepository orderRepository;

    private final OrderService orderService;
    private final PersonService personService;

    @Autowired
    public AdminController(ProductValidator productValidator, ProductService productService, CategoryRepository categoryRepository, OrderRepository orderRepository, OrderService orderService, PersonService personService) {
        this.productValidator = productValidator;
        this.productService = productService;
        this.categoryRepository = categoryRepository;
        this.orderRepository = orderRepository;
        this.orderService = orderService;
        this.personService = personService;
    }

    //    @PreAuthorize("hasRole('ROLE_ADMIN') and hasRole('')")
//@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('')")

    // Метод по отображению главной страницы администратора с выводом товаров
    @GetMapping()
    public String admin(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();

        String role = personDetails.getPerson().getRole();

        if(role.equals("ROLE_USER")){
            return "redirect:/index";
        }
        // addseller
        if(role.equals("ROLE_SELLER")){
            return "redirect:/seller";
        }
        // addseller end
        model.addAttribute("products", productService.getAllProduct());
        return "admin/admin";
    }

    // Метод по отображению формы добавление
    @GetMapping("/product/add")
    public String addProduct(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("category", categoryRepository.findAll());
//        System.out.println(categoryRepository.findAll().size());
        return "product/addProduct";
    }

    // Метод по добавлению объекта с формы в таблицу product
    @PostMapping("/product/add")
    public String addProduct(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult, @RequestParam("file_one") MultipartFile file_one, @RequestParam("file_two") MultipartFile file_two, @RequestParam("file_three") MultipartFile file_three, @RequestParam("file_four") MultipartFile file_four, @RequestParam("file_five") MultipartFile file_five) throws IOException {

        productValidator.validate(product, bindingResult);
        if(bindingResult.hasErrors()){
            return "product/addProduct";
        }
        // Проверка на пустоту файла
        if(file_one != null){
            // Дирректория по сохранению файла
            File uploadDir = new File(uploadPath);
            // Если данной дирректории по пути не сущетсвует
            if(!uploadDir.exists()){
                // Создаем данную дирректорию
                uploadDir.mkdir();
            }
            // Создаем уникальное имя файла
            // UUID представляет неищменный универсальный уникальный идентификатор
            String uuidFile = UUID.randomUUID().toString();
            // file_one.getOriginalFilename() - наименование файла с формы
            String resultFileName = uuidFile + "." + file_one.getOriginalFilename();
            // Загружаем файл по указаннопу пути
            file_one.transferTo(new File(uploadPath + "/" + resultFileName));
            Image image = new Image();
            image.setProduct(product);
            image.setFileName(resultFileName);
            product.addImageProduct(image);
        }

        // Проверка на пустоту файла
        if(file_two != null){
            // Дирректория по сохранению файла
            File uploadDir = new File(uploadPath);
            // Если данной дирректории по пути не сущетсвует
            if(!uploadDir.exists()){
                // Создаем данную дирректорию
                uploadDir.mkdir();
            }
            // Создаем уникальное имя файла
            // UUID представляет неищменный универсальный уникальный идентификатор
            String uuidFile = UUID.randomUUID().toString();
            // file_one.getOriginalFilename() - наименование файла с формы
            String resultFileName = uuidFile + "." + file_two.getOriginalFilename();
            // Загружаем файл по указаннопу пути
            file_two.transferTo(new File(uploadPath + "/" + resultFileName));
            Image image = new Image();
            image.setProduct(product);
            image.setFileName(resultFileName);
            product.addImageProduct(image);
        }

        // Проверка на пустоту файла
        if(file_three != null){
            // Дирректория по сохранению файла
            File uploadDir = new File(uploadPath);
            // Если данной дирректории по пути не сущетсвует
            if(!uploadDir.exists()){
                // Создаем данную дирректорию
                uploadDir.mkdir();
            }
            // Создаем уникальное имя файла
            // UUID представляет неищменный универсальный уникальный идентификатор
            String uuidFile = UUID.randomUUID().toString();
            // file_one.getOriginalFilename() - наименование файла с формы
            String resultFileName = uuidFile + "." + file_three.getOriginalFilename();
            // Загружаем файл по указаннопу пути
            file_three.transferTo(new File(uploadPath + "/" + resultFileName));
            Image image = new Image();
            image.setProduct(product);
            image.setFileName(resultFileName);
            product.addImageProduct(image);
        }

        // Проверка на пустоту файла
        if(file_four != null){
            // Дирректория по сохранению файла
            File uploadDir = new File(uploadPath);
            // Если данной дирректории по пути не сущетсвует
            if(!uploadDir.exists()){
                // Создаем данную дирректорию
                uploadDir.mkdir();
            }
            // Создаем уникальное имя файла
            // UUID представляет неищменный универсальный уникальный идентификатор
            String uuidFile = UUID.randomUUID().toString();
            // file_one.getOriginalFilename() - наименование файла с формы
            String resultFileName = uuidFile + "." + file_four.getOriginalFilename();
            // Загружаем файл по указаннопу пути
            file_four.transferTo(new File(uploadPath + "/" + resultFileName));
            Image image = new Image();
            image.setProduct(product);
            image.setFileName(resultFileName);
            product.addImageProduct(image);
        }

        // Проверка на пустоту файла
        if(file_five != null){
            // Дирректория по сохранению файла
            File uploadDir = new File(uploadPath);
            // Если данной дирректории по пути не сущетсвует
            if(!uploadDir.exists()){
                // Создаем данную дирректорию
                uploadDir.mkdir();
            }
            // Создаем уникальное имя файла
            // UUID представляет неищменный универсальный уникальный идентификатор
            String uuidFile = UUID.randomUUID().toString();
            // file_one.getOriginalFilename() - наименование файла с формы
            String resultFileName = uuidFile + "." + file_five.getOriginalFilename();
            // Загружаем файл по указаннопу пути
            file_five.transferTo(new File(uploadPath + "/" + resultFileName));
            Image image = new Image();
            image.setProduct(product);
            image.setFileName(resultFileName);
            product.addImageProduct(image);
        }

        productService.saveProduct(product);
        return "redirect:/admin";
    }

    // Метод по удалению товара по id
    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id){
        productService.deleteProduct(id);
        return "redirect:/admin";
    }

    // Метод по получению товара по id и отображение шаблона редактирования
    @GetMapping("/product/edit/{id}")
    public String editProduct(@PathVariable("id") int id, Model model){
        model.addAttribute("editProduct", productService.getProductId(id));
        model.addAttribute("category", categoryRepository.findAll());
        return "product/editProduct";
    }

    @PostMapping("/product/edit/{id}")
    public String editProduct(@ModelAttribute("editProduct") Product product, @PathVariable("id") int id){
        productService.updateProduct(id, product);
        return "redirect:/admin";
    }




// ORDER


    @GetMapping("/orders")
    public String ordersAdmin(Model model){
        List<Order> orderList = orderService.getAllOrders();
        model.addAttribute("orders", orderList);

//   VER 2 - MapList
        Map<String, List<Order>> orderMapList = orderList.stream().collect(Collectors.groupingBy(Order::getNumber));
        model.addAttribute("ordersMap", orderMapList);

        return "/admin/orders";
    }

    @PostMapping("/orders/search")
    public String orderSearch(@RequestParam("search_value") String search, Model model){
        System.out.println(search);
        // Если строка поиска не пустая
        if(!search.isEmpty()) {
            model.addAttribute("search_order", orderService.getOrderByNumberEndingWith(search));
        }
        model.addAttribute("person", personService.getAllPerson());
        model.addAttribute("search_value", search);
        model.addAttribute("orders", orderRepository.findAll());
        return "/admin/orders";
    }


    // Метод возвращает страницу с подробной информацией о заказе
    @GetMapping("/order/info/{id}")
    public String infoOrder(@PathVariable("id") int id, Model model){
        model.addAttribute("order", orderService.getOrderById(id));
//        model.addAttribute("person", personService.getPersonById(id_person));
        return "admin/orderInfo";
    }

    @PostMapping("/orders/status1/{id}")
    public String editOrderStatus1(@ModelAttribute("editOrder") Order order, @PathVariable("id") int id){
        Order order_status = orderService.getOrderById(id);
        orderService.updateOrderStatus1(order_status);
        return "redirect:/admin/order/info/{id}";
    }

    @PostMapping("/orders/status2/{id}")
    public String editOrderStatus2(@ModelAttribute("editOrder") Order order, @PathVariable("id") int id){
        Order order_status = orderService.getOrderById(id);
        orderService.updateOrderStatus2(order_status);
        return "redirect:/admin/order/info/{id}";
    }

    @PostMapping("/orders/status3/{id}")
    public String editOrderStatus3(@ModelAttribute("editOrder") Order order, @PathVariable("id") int id){
        Order order_status = orderService.getOrderById(id);
        orderService.updateOrderStatus3(order_status);
        return "redirect:/admin/order/info/{id}";
    }

    @PostMapping("/orders/cancel/{id}")
    public String editOrderCancel(@ModelAttribute("editOrder") Order order, @PathVariable("id") int id){
        Order order_status = orderService.getOrderById(id);
        orderService.updateOrderCancel(order_status);
        return "redirect:/admin/order/info/{id}";
    }




// PERSON
    // Метод возвращает страницу с выводом пользователей и кладет объект пользователя в модель
    @GetMapping("/person")
    public String person(Model model){;
        model.addAttribute("person", personService.getAllPerson());
        return "person/person";
    }

    // Метод возвращает страницу с подробной информацией о пользователе
    @GetMapping("/person/info/{id}")
    public String infoPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personService.getPersonById(id));
        return "person/personInfo";
    }

    // Метод возвращает страницу с формой редактирования пользователя и помещает в модель объект редактируемого пользователя по id
    @GetMapping("/person/edit/{id}")
    public String editPerson(@PathVariable("id")int id, Model model){
        model.addAttribute("editPerson", personService.getPersonById(id));
        return "person/editPerson";
    }

    // Метод принимает объект с формы и обновляет пользователя
    @PostMapping("/person/edit/{id}")
    public String editPerson(@ModelAttribute("editPerson") @Valid Person person, BindingResult bindingResult, @PathVariable("id") int id){
        if(bindingResult.hasErrors()){
            return "person/editPerson";
        }
        personService.updatePerson(id, person);
        return "redirect:/admin/person";
    }

    // Метод принимает объект с формы и обновляет РОЛЬ пользователя
    @PostMapping("/person/editrole/{id}")
    public String editPersonRole(@ModelAttribute("editPerson") @Valid Person person, BindingResult bindingResult, @RequestParam("role") String role, @PathVariable("id") int id){
        Person person_role = personService.getPersonById(id);
//        person_role.setRole(role);
        personService.updatePersonRole(role, person_role);

        return "redirect:/admin/person";
    }

    // Метод по удалению пользователей
    @GetMapping("/person/delete/{id}")
    public String deletePerson(@PathVariable("id") int id){
        personService.deletePerson(id);
        return "redirect:/admin/person";
    }

    // Метод по изменению пароля любому пользователю
    @GetMapping("/password/change")
    public String changePassword(Model model){
        model.addAttribute("person", new Person());
        return "password";
    }

    @PostMapping("/password/change")
    public String changePassword(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult){

//        personValidator.findUser(person, bindingResult);
//        if(bindingResult.hasErrors()){
//            return "password";
//        }

        Person person_db = personService.getPersonFindByLogin(person);

        int id = person_db.getId();
        String password = person.getPassword();
        personService.changePassword(id, password);

        return "redirect:/index";
    }

    // Метод по нажатию на кнопку поиска и сортировки и отображение шаблона
    @GetMapping("/person/sorting_and_searching_and_filters")
    public String sorting_and_searching_and_filters(){
        return "person/SortingAndSearchingAndFilters";
    }

    @PostMapping("/person/sorting_and_searching_and_filters")
    public String sorting_and_searching_and_filters(@RequestParam("SortingAndSearchingAndFiltersOptions") String sortingAndSearchingAndFiltersOptions, @RequestParam("value") String value, Model model){
        if(sortingAndSearchingAndFiltersOptions.equals("login")) {
            model.addAttribute("person", personService.getPersonLogin(value));
        } else if (sortingAndSearchingAndFiltersOptions.equals("role")){
            model.addAttribute("person", personService.getPersonRole(value));
        } else if (sortingAndSearchingAndFiltersOptions.equals("email")){
            model.addAttribute("person",personService.getPersonEmail(value));
        } else if (sortingAndSearchingAndFiltersOptions.equals("phone_number")) {
            model.addAttribute("person",personService.getPersonPhoneNumber(value));
        } else if (sortingAndSearchingAndFiltersOptions.equals("last_name_start")) {
            model.addAttribute("person",personService.getPersonLastNameStartingWith(value));
        }
        return "person/SortingAndSearchingAndFilters";
    }
}
