package com.example.Backend.TakeHomeExam.repositories;


import com.example.Backend.TakeHomeExam.DTO.ProductNameListDTO;
import com.example.Backend.TakeHomeExam.models.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<ProductEntity, String> {


    Optional<ProductEntity> findByProductId(String productId);

    ProductEntity findByName(String name);

}
