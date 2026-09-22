package com.example.demo.ProductStuff.Controller;


import com.example.demo.ProductStuff.DTO.ProductRequest;
import com.example.demo.ProductStuff.DTO.ProductResponse;
import com.example.demo.ProductStuff.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productrequest){
        return new ResponseEntity<ProductResponse>(productService.createproduct(productrequest),
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long id,@RequestBody ProductRequest productrequest){
        return productService.updateproduct(id,productrequest)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
