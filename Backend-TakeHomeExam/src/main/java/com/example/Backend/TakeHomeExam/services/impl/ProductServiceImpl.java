package com.example.Backend.TakeHomeExam.services.impl;

import com.example.Backend.TakeHomeExam.DTO.ProductNameListDTO;
import com.example.Backend.TakeHomeExam.DTO.SaveProductDTO;
import com.example.Backend.TakeHomeExam.VO.Category;
import com.example.Backend.TakeHomeExam.VO.ResponseTemplateV0;
import com.example.Backend.TakeHomeExam.models.ProductEntity;
import com.example.Backend.TakeHomeExam.repositories.ProductRepository;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.mappers.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductServiceImpl implements com.example.Backend.TakeHomeExam.services.intf.ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductEntity insertProduct(SaveProductDTO saveProductDTO) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(saveProductDTO.getName());
        productEntity.setSKU(saveProductDTO.getSku());
        productEntity.setDescription(saveProductDTO.getDescription());
        productEntity.setSellingPrice(saveProductDTO.getPrice());
        productEntity.setCost(saveProductDTO.getCost());
        productEntity.setTags(saveProductDTO.getTags());
        productEntity.setCategory(saveProductDTO.getCategory());
        return productRepository.save(productEntity);
    }


    @Override
    public List<ProductEntity> getNameOfAllProductsBySorting(String field){
        return productRepository.findAll(Sort.by(Sort.Direction.ASC,field)); //dati name
        }



    @Override
    public List<ProductNameListDTO> getAllProducts() {

        List<ProductEntity> productEntityList = productRepository.findAll();
        List<ProductNameListDTO> productNameListDTOS = new ArrayList<>();

        for(ProductEntity productEntity: productEntityList){

            ProductNameListDTO productNameListDTO = new ProductNameListDTO();
            productNameListDTO.setName(productEntity.getName());
            productNameListDTOS.add(productNameListDTO);

        }
        return productNameListDTOS;
    }


    public ResponseTemplateV0 getProductWithCategory(String productId) {

        ResponseTemplateV0 vo = new ResponseTemplateV0();

        Optional<ProductEntity> product = productRepository.findByProductId(productId);
        ProductEntity productEntity = product.get();

        String cat=
                restTemplate.getForObject("http://localhost:8083/api/v1/category/" + productEntity.getCategory(),String.class);
        System.out.println(cat);

        //GSON - used to convert JSON String into an Object
     Category targetObject = new Gson().fromJson(cat, Category.class);

        vo.setProduct(productEntity);
        vo.setCategory(targetObject);
        return vo;

    }


}


