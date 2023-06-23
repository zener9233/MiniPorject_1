package com.bit.mini_album.controller;

import com.bit.mini_album.entity.ProductEntity;
import com.bit.mini_album.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/miniroom")
    public String saveProduct(ProductEntity productEntity, MultipartFile file) throws Exception {

        productService.saveProduct(productEntity, file);

        return "redirect:/miniroom";
    }

    @GetMapping("/miniroom")
    public String findAllProduct(Model model) {

        List<ProductEntity> productEntityList = productService.findAllProduct();

        model.addAttribute("productList", productEntityList);

        return "miniroom";
    }

}
