package com.example.springbootControllerAdvicedemo.web;

import com.example.springbootControllerAdvicedemo.pojo.Author;
import com.example.springbootControllerAdvicedemo.pojo.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.Objects;

@Controller
public class TestAdviceController {
    @GetMapping("/mdmap")
    @ResponseBody
    public String hello(Model model) {
        Map<String, Object> map = model.asMap();
        System.out.println(map);
        return "hello controller advice";
    }

    // http://localhost:8080/book?a.name=weimin&a.age=22&b.name=%E4%B8%89%E5%9B%BD%E6%BC%94%E4%B9%89&b.price=100
    @GetMapping("/book")
    @ResponseBody
    public String addBook(@ModelAttribute("b") Book book, @ModelAttribute("a") Author author) {
        System.out.println(book);
        System.out.println(author);
        return "book: " + book.toString() + ", author: " + author.toString();
    }

    @GetMapping("/errorTest")
    @ResponseBody
    public String error(@RequestParam("name") String name) {
        if ("error".equals(name)) {
            throw new RuntimeException("test error!");
        }
        return "hello controller advice";
    }

}
