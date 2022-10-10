package com.example.Backend.TakeHomeExam.API;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIResponce <T>{
//this class is for Sorting
    int recordCount;
    T response;

}
