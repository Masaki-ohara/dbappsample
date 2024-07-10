package com.example.dbappsample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping; // 修正
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dbappsample.model.Product;
import com.example.dbappsample.repository.ProductRepository; // インポート
import com.example.dbappsample.service.ProductService;

import java.util.List;


@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/add")
    public String addProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "add-product";
    }

    @PostMapping("/add")
    public String addProduct(Product product) {
        // Repositoryのメソッドを呼ぶ処理
        productService.saveProduct(product);
        // 商品登録フォームにリダイレクト
        return "redirect:/products/add";
    }

    @GetMapping
    public String listProducts(Model model) {
        // ここのリストにデータが受け取れれば良い
        List<Product> products = productService.findAllProducts();
        model.addAttribute("products", products);
        return "products";
    }
}
