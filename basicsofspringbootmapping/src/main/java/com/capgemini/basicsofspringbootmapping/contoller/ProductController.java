package com.capgemini.basicsofspringbootmapping.contoller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.basicsofspringbootmapping.dto.ProductDto;
import com.capgemini.basicsofspringbootmapping.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService service;

    public ProductController(ProductService service) {
        super();
        this.service = service;
    }

    // Create a product using DTO
    @PostMapping("/create")
    public ProductDto addProduct(@RequestBody ProductDto productDto) {
        return service.createProduct(productDto);
    }

    // Find a product by ID - returns DTO
    @GetMapping("/find/{id}")
    public ProductDto getProductById(@PathVariable Integer id) {
        return service.getProductById(id);
    }

    // Find all products - returns list of DTOs
    @GetMapping("/findAll")
    public List<ProductDto> getAllProducts() {
        return service.getAllProducts();
    }

}
