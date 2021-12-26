package com.liu.service;

import com.liu.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lms
 * @date 2021-05-07 - 9:47
 */

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public void print() {
        System.out.println("bookDao = " + bookDao);
    }
}
