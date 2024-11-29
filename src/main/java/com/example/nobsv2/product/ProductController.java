package com.example.nobsv2.product;

import com.example.nobsv2.exceptions.ProductNotFoundException;
import com.example.nobsv2.product.model.ErrorResponse;
import com.example.nobsv2.product.model.Product;
import com.example.nobsv2.product.model.ProductDTO;
import com.example.nobsv2.product.model.UpdateProductCommand;
import com.example.nobsv2.product.services.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final CreateProductService createProductService;

    private final GetProductsService getProductsService;

    private final UpdateProductService updateProductService;

    private final DeleteProductService deleteProductService;

    private final GetProductService getProductService;

    public ProductController(CreateProductService createProductService,
                             GetProductsService getProductsService,
                             UpdateProductService updateProductService,
                             DeleteProductService deleteProductService,
                             GetProductService getProductService) {
        this.createProductService = createProductService;
        this.getProductsService = getProductsService;
        this.updateProductService = updateProductService;
        this.deleteProductService = deleteProductService;
        this.getProductService = getProductService;
    }



    @PostMapping("/product")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody Product product){
        return createProductService.execute(product);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getProducts(){
        return getProductsService.execute(null);
    }

    //new get mapping for find by Id

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer id){
        return getProductService.execute(id);
    }



    @PutMapping("/product/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Integer id, @RequestBody Product product){
        // need to pass in both id & product together
        return updateProductService.execute(new UpdateProductCommand(id, product));
    }


    @DeleteMapping("/product/{id}") // id here must match
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id){
        return deleteProductService.execute(id);
    }


}
