package com.carnival.matchcube.controller;

import com.carnival.matchcube.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/category", method= RequestMethod.GET)
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    // Category API
    @PostMapping
    public ResponseEntity category() throws Exception {
        return categoryService.category();
    }
}
