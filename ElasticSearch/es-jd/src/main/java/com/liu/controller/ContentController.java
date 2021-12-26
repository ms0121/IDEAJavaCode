package com.liu.controller;

import com.liu.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author lms
 * @date 2021-10-31 - 16:41
 */
@Controller
public class ContentController {

    @Autowired
    private ContentService contentService;

    @GetMapping("parse/{keyword}")
    @ResponseBody
    public boolean parse(@PathVariable("keyword") String keyword) throws Exception {
        return contentService.parseContent(keyword);
    }

    @GetMapping("search/{keyword}/{pageNo}/{pageSize}")
    @ResponseBody
    public List<Map<String, Object>> search(@PathVariable("keyword")String keyword,
                                            @PathVariable("pageNo")int pageNo,
                                            @PathVariable("pageSize") int pageSize) throws Exception {
        // return contentService.searchPage(keyword, pageNo, pageSize);
        return contentService.searchPageHighLight(keyword, pageNo, pageSize);
    }



}
