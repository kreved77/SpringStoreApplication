package com.example.springsecurityapplication.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Логин не может быть пустым")
    @Size(min = 5, max = 50, message = "Логин должен быть от 5 до 50 символов")
    @Column(name = "login")
    private String login;

    @NotEmpty(message = "Пароль не может быть пустым")
    @Column(name = "password")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$", message = "Пароль должен содержать не менее 6 символов, хотя бы одну цифру, спец символ, букву в верхнем и нижнем регистре ")
    private String password;

    @Column(name = "role")
    private String role;

    @NotEmpty(message = "Фамилия не может быть пустой")
    @Size(min = 2, max = 30, message = "Фамилия должна быть в диапазоне от 2 до 30 символов")
    @Column(name = "lastname", length = 30, nullable = false, unique = false, columnDefinition = "text")
    private String lastname;

    @NotEmpty(message = "Имя не может быть пустым")
    @Size(min = 2, max = 30, message = "Имя должно быть в диапазоне от 2 до 30 символов")
    @Column(name = "firstname", length = 30, nullable = false, unique = false, columnDefinition = "text")
    private String firstname;

    @NotEmpty(message = "Email пользователя не может быть пустым")
    @Email(message = "Вы ввели не email")
    @Column(name = "email", length = 40, nullable = false, unique = true, columnDefinition = "text")
    private String email;

    @NotEmpty(message = "Номер телефона не может быть пустым")
    @Pattern(regexp = "^((\\+7|7|8)+([0-9]){10})$", message = "Норме телефона должен быть в формате +7/7/89991112233")
    @Column(name = "phoneNumber", length = 12, nullable = false, unique = true, columnDefinition = "text")
    private String phoneNumber;

    @ManyToMany()
    @JoinTable(name = "product_cart", joinColumns = @JoinColumn(name = "person_id"),inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    @OneToMany(mappedBy = "person")
    private List<Order> orderList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person() {
    }

    public Person(String login, String password, String lastname, String firstname, String email, String phoneNumber) {
        this.login = login;
        this.password = password;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
