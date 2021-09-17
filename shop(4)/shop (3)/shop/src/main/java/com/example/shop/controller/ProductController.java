package com.example.shop.controller;
import com.example.shop.Entity.Product;
import com.example.shop.dto.ProductDto;
import com.example.shop.service.imp.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductServiceImp productServiceImp;

    @Autowired
    public ProductController(ProductServiceImp productServiceImp) {
        this.productServiceImp = productServiceImp;
    }

    @PostMapping
    public void addProduct(@RequestBody ProductDto productDto){
        productServiceImp.addNewProduct(productDto);

    }

    @GetMapping
    public List<ProductDto> getAllProduct(){
        return productServiceImp.getAllProducts();
    }

    @PutMapping
    public ResponseEntity<String> updateProduct(@RequestBody ProductDto productDto)  {
            productServiceImp.modifiedNewProduct(productDto);
            return new ResponseEntity<>("updated the product", HttpStatus.OK);

    }
    @PutMapping("/{productId}/{quantity}")
    public ResponseEntity<String> updateProductQuan(@PathVariable Integer productId,@PathVariable Integer quantity)  {
        productServiceImp.modifiedQuantityOfTheProduct(productId,quantity);
        return new ResponseEntity<>("updated the product", HttpStatus.OK);

    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable Integer productId) {
        productServiceImp.deleteProductsBYid(productId);

    }

    @GetMapping("/{productId}")
    public ProductDto getProductById(@PathVariable Integer productId) {
        return productServiceImp.getProductsById(productId);
    }
    @GetMapping("/productPack/{productIds}")
    public List<ProductDto> getProductPack(@PathVariable Integer [] productIds) {
        return productServiceImp.productPack(productIds);
    }
}
