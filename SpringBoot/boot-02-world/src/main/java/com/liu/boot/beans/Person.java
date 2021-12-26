package com.liu.boot.beans;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author lms
 * @date 2021-05-09 - 16:54
 */
//扫描配置文件中以person开头的信息
@ConfigurationProperties(prefix = "person")
@Component  // 将bean组件添加到组件中
@Data
@ToString
public class Person {

    private String userName;
    private Boolean boss;
    private Date birth;
    private Integer age;
    private Pet pet;
    private String[] interests;
    private List<String> animal;
    private Map<String, Object> score;
    private Set<Double> salarys;
    private Map<String, List<Pet>> allPets;
}
