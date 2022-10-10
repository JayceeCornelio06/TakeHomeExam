package com.example.CategoryMicroservice.services.impl;

import com.example.CategoryMicroservice.DTO.CategoryDTO;
import com.example.CategoryMicroservice.DTO.SaveCategoryDTO;
import com.example.CategoryMicroservice.models.CategoryEntity;
import com.example.CategoryMicroservice.repository.CategoryRepository;
import com.example.CategoryMicroservice.services.intf.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public CategoryEntity insertCategory(SaveCategoryDTO saveCategoryDTO) {
        //set value of category entity
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(saveCategoryDTO.getName());
        categoryEntity.setCreatedBy("ADMIN");
        categoryEntity.setCreatedDate(new Date());

        return categoryRepository.save(categoryEntity);
    }


    @Override
    public List<CategoryDTO> getAllCategory(){

        List<CategoryEntity> categoryEntityList = categoryRepository.findAll();

        //map to DTO
        List<CategoryDTO> categoryDTOS = new ArrayList<>();

        for(CategoryEntity categoryEntity: categoryEntityList){

            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setId(categoryEntity.getId());
            categoryDTO.setName(categoryEntity.getName());
            categoryDTOS.add(categoryDTO);

        }

        return categoryDTOS;

    }


    public List<CategoryEntity> getNameOfAllProductsBySorting(String field) {
        return categoryRepository.findAll(Sort.by(Sort.Direction.ASC,field));
    }
}
