package com.example.CategoryMicroservice.services.intf;

import com.example.CategoryMicroservice.DTO.CategoryDTO;
import com.example.CategoryMicroservice.DTO.SaveCategoryDTO;
import com.example.CategoryMicroservice.models.CategoryEntity;

import java.util.List;

public interface CategoryService {

    CategoryEntity insertCategory(SaveCategoryDTO saveCategoryDTO);

    List<CategoryDTO> getAllCategory();


}
