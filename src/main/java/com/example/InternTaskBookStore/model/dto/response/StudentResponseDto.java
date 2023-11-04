package com.example.InternTaskBookStore.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseDto {

    Long id;
    String name;
    String email;
    int age;
}
