package com.example.CategoryMicroservice.controllers;

import com.example.CategoryMicroservice.API.APIResponce;
import com.example.CategoryMicroservice.DTO.CategoryDTO;
import com.example.CategoryMicroservice.DTO.SaveCategoryDTO;
import com.example.CategoryMicroservice.models.CategoryEntity;
import com.example.CategoryMicroservice.repository.CategoryRepository;
import com.example.CategoryMicroservice.services.impl.CategoryServiceImpl;
import com.example.CategoryMicroservice.services.intf.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/category")
@RestController
@Slf4j
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    CategoryServiceImpl categorserviceimpl;



    @PostMapping("/")
    public ResponseEntity<?> insertCategory(@RequestBody SaveCategoryDTO saveCategoryDTO){
      try{
          CategoryEntity category = categoryService.insertCategory(saveCategoryDTO);
          return new ResponseEntity<>(category, HttpStatus.OK);
      }catch (Exception e){
          log.info("Error on saving");
          return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }


    @GetMapping("/all")
    public ResponseEntity<?> getAllCategory(){
        try{
            List<CategoryDTO> categoryDTOList = categoryService.getAllCategory();
            return new ResponseEntity<>(categoryDTOList, HttpStatus.OK);
        }catch (Exception e){
            log.info("Error on getting data");
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/{name}")
    public CategoryEntity findCategoryByName(@PathVariable("name") String name) {
        System.out.print("Hello");
        return categoryRepository.findByName(name);
    }


    @GetMapping("/ProductNames/{field}")
    private APIResponce<List<CategoryEntity>> getNameOfAllCompanyBySorting(@PathVariable("field") String field) {
        List<CategoryEntity> allProduct = categorserviceimpl.getNameOfAllProductsBySorting(field);
        return new APIResponce<>(allProduct.size(), allProduct);
    }


    //I have No Sort By Date

}
