package com.liu.boot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liu.boot.bean.User;
import com.liu.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author lms
 * @date 2021-05-18 - 15:11
 */
@Controller
public class TableController {

    @Autowired
    private UserService userService;


    @GetMapping("/basic_table")
    public String basic_table() {
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
                                Model model) {
//        List<User> users = Arrays.asList(new User("zhangsan", "1256"),
//                new User("hdjs", "893829"),
//                new User("yyds", "87873"),
//                new User("hjh", "325651")
//        );
//        model.addAttribute("users", users);

        // 分页查询数据
        Page<User> userPages = new Page<>(pn, 2);
        // 分页查询的结果数据
        Page<User> page = userService.page(userPages, null);
        model.addAttribute("page", page);

//       查询数据库中的所有数据信息
        List<User> list = userService.list();
//        model.addAttribute("users", list);
        return "table/dynamic_table";

    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,
                             @RequestParam(value = "pn", defaultValue = "1") Integer pn,
                             RedirectAttributes re
    ) {
        userService.removeById(id);
        // 表示在重定向中需要携带的参数
        re.addAttribute("pn", pn);
        return "redirect:/dynamic_table";
    }


    @GetMapping("/editable_table")
    public String editable_table() {
        return "table/editable_table";
    }

    @GetMapping("/pricing_table")
    public String pricing_table() {
        return "table/pricing_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table() {
        return "table/responsive_table";
    }
}
