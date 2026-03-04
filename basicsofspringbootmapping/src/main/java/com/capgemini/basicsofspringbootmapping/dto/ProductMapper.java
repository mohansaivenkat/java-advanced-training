package com.capgemini.basicsofspringbootmapping.dto;

import com.capgemini.basicsofspringbootmapping.entity.Product;

public class ProductMapper {

    // Convert ProductDto to Product Entity (for create operation)
    public static Product toEntity(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setCostPrice(productDto.getCostPrice());
        product.setSellingPrice(productDto.getSellingPrice());
        return product;
    }

    // Convert Product Entity to ProductDto (for find/response operation)
    public static ProductDto toDto(Product product) {
        ProductDto dto = new ProductDto();
        dto.setName(product.getName());
        dto.setCostPrice(product.getCostPrice());
        dto.setSellingPrice(product.getSellingPrice());
        return dto;
    }

}
