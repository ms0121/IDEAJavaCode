package com.liu.boot.beans;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @author lms
 * @date 2021-05-09 - 16:54
 */
@Component
@ToString
@Data
public class Pet {
    private String name;
    private Double weight;
}