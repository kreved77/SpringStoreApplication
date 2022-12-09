package com.example.springsecurityapplication.repositories;

import com.example.springsecurityapplication.enumm.Status;
import com.example.springsecurityapplication.models.Order;
import com.example.springsecurityapplication.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByPerson(Person person);
    List<Order> findAllByStatusEquals(Status status);

    List<Order> findByNumberEndingWithIgnoreCase(String number);

    // Поиск по части наименования заказа
//    @Query(value = "select * from orders where (lower(number) LIKE '%?1') order by date_time DESC" , nativeQuery = true)
//    List<Order> findByNumberLastOrderByDateDesc(String number);

}
