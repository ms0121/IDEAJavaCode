package com.liu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lms
 * @date 2021-10-31 - 16:02
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Content {
    private String name;
    private String price;
    private String img;
}
