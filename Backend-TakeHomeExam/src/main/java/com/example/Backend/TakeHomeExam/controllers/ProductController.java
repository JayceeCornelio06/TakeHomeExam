package com.example.Backend.TakeHomeExam.controllers;

import com.example.Backend.TakeHomeExam.API.APIResponce;
import com.example.Backend.TakeHomeExam.DTO.ProductNameListDTO;
import com.example.Backend.TakeHomeExam.DTO.SaveProductDTO;
import com.example.Backend.TakeHomeExam.VO.ResponseTemplateV0;
import com.example.Backend.TakeHomeExam.models.ProductEntity;
import com.example.Backend.TakeHomeExam.repositories.ProductRepository;
import com.example.Backend.TakeHomeExam.services.impl.ProductServiceImpl;
import com.example.Backend.TakeHomeExam.services.intf.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j //logger
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    MongoTemplate mongoTemplate;



    @PostMapping("/insert")
    ResponseEntity<?> insertProduct(@RequestBody SaveProductDTO saveProductDTO) {

        try {
            ProductEntity productEntity = productServiceImpl.insertProduct(saveProductDTO);
            return new ResponseEntity<>(productEntity, HttpStatus.OK);
        }
        catch (Exception e) {
            log.info("Error");
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping("/ProductNames/{field}")
   private APIResponce<List<ProductEntity>> getNameOfAllProductsBySorting(@PathVariable("field") String field) {
        List<ProductEntity> allProduct = productServiceImpl.getNameOfAllProductsBySorting(field);
        return new APIResponce<>(allProduct.size(), allProduct);
    }


    @GetMapping("/{id}")
    public ResponseTemplateV0 getProductWithCategory(@PathVariable("id") String productId) {
        return productServiceImpl.getProductWithCategory(productId);
    }


    @GetMapping("/product/name/{name}")
    public ProductEntity findProductByName(@PathVariable("name") String name) {
        return productRepository.findByName(name);
    }


    @GetMapping("/all")
    public ResponseEntity<?> getAllProductNames(){
        try{
            List<ProductNameListDTO> productNameListDTOS = productService.getAllProducts();
            return new ResponseEntity<>(productNameListDTOS, HttpStatus.OK);
        }catch (Exception e){
            log.info("Error on getting data");
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/category/{category}")
    List<ProductEntity> filterProductByCategory(@PathVariable(value = "category") String category){
        Query query = new Query();
        query.addCriteria(Criteria.where("category").is(category));
        return mongoTemplate.find(query,ProductEntity.class);
    }



    @GetMapping("/SKU/{SKU}")
    List<ProductEntity> findBySKU(@PathVariable(value = "SKU") String SKU){
        Query query = new Query();
        query.addCriteria(Criteria.where("SKU").is(SKU));
        return mongoTemplate.find(query,ProductEntity.class);
    }



}

