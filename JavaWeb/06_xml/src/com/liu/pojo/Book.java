package com.liu.pojo;

import java.math.BigDecimal;

/**
 * @author lms
 * @date 2021-03-30 - 11:51
 */
public class Book {
    private String sn;
    private String name;
    private BigDecimal price;
    private String author;

    public Book() {
        super();
    }

    public Book(String sn, String name, BigDecimal price, String author) {
        super();
        this.sn = sn;
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "sn='" + sn + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                '}';
    }
}
