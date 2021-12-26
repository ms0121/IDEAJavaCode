package com.liu.test;

import com.liu.dao.ProvinceDao;
import com.liu.entity.Province;

/**
 * @author lms
 * @date 2021-04-23 - 19:57
 */
public class ProvinceDaoTest {
    public static void main(String[] args) {

        ProvinceDao provinceDao = new ProvinceDao();
        Province province = provinceDao.queryProById(1);
        System.out.println("province = " + province);
    }
}
