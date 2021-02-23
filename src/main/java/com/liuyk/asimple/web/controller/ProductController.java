package com.liuyk.asimple.web.controller;

import com.liuyk.asimple.entity.Product;
import com.liuyk.asimple.entity.R;
import com.liuyk.asimple.enums.BizExceptionEnum;
import com.liuyk.asimple.exception.BizException;
import com.liuyk.asimple.http.HttpApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/product")
@RestController
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private HttpApi httpApi;

    @GetMapping("/p/{id}")
    public Product getProduct(@PathVariable("id") Long id) {
        log.info("getProduct id={}", id);
        if (id > 5) {
           throw BizException.throwException(BizExceptionEnum.BAD_REQUEST);
        }
        int a = (int) (10 / id);
        return new Product(111111L, "AAAA");
    }

    @GetMapping("/show/{id}")
    public R<Product> show(@PathVariable("id") Long id) {
        log.info("show id={}", id);
        return httpApi.getProduct(id);
    }

}
