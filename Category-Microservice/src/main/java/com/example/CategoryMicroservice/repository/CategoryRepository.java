package com.example.CategoryMicroservice.repository;

import com.example.CategoryMicroservice.models.CategoryEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<CategoryEntity, String> {


    CategoryEntity findByName(String name);
}
