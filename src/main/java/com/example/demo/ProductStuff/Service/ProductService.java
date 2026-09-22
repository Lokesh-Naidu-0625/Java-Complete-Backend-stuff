package com.example.demo.ProductStuff.Service;


import com.example.demo.ProductStuff.DTO.ProductRequest;
import com.example.demo.ProductStuff.DTO.ProductResponse;
import com.example.demo.ProductStuff.Entity.Product;
import com.example.demo.ProductStuff.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponse createproduct(ProductRequest productRequest){

        Product product = new Product();
        updateProductFromRequest(product,productRequest);
        Product savedProduct = productRepository.save(product);
        return mapToProductResponse(savedProduct);
    }

    private ProductResponse mapToProductResponse(Product savedProduct){
        ProductResponse response = new ProductResponse();

        response.setId(savedProduct.getId());
        response.setName(savedProduct.getName());
        response.setActive(savedProduct.getActive());
        response.setPrice(savedProduct.getPrice());
        response.setCategory(savedProduct.getCategory());
        response.setDescription(savedProduct.getDescription());
        response.setStockquantity(savedProduct.getStockquantity());
        response.setImageURL(savedProduct.getImageURL());

        return response;
    }

    private void updateProductFromRequest(Product product, ProductRequest productRequest){
        product.setName(productRequest.getName());
        product.setActive(productRequest.getActive());
        product.setPrice(productRequest.getPrice());
        product.setCategory(productRequest.getCategory());
        product.setDescription(productRequest.getDescription());
        product.setStockquantity(productRequest.getStockquantity());
        product.setImageURL(productRequest.getImageURL());
    }

    public Optional<ProductResponse> updateproduct(Long id, ProductRequest productrequest) {
        return productRepository.findById(id)
                .map(exisitingproduct -> {
                    updateProductFromRequest(exisitingproduct, productrequest);
                    Product savedproduct = productRepository.save(exisitingproduct);
                    return mapToProductResponse(savedproduct);
                });

    }
}
