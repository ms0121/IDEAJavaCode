package com.liu.controller;

import com.liu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author lms
 * @date 2021-05-07 - 9:46
 */

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

}
