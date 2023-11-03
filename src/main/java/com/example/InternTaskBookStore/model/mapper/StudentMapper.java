package com.example.InternTaskBookStore.model.mapper;

import com.example.InternTaskBookStore.model.dto.request.SignUpRequestDto;
import com.example.InternTaskBookStore.model.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student signUpRequestDtoToStudent(SignUpRequestDto signUpRequestDto);
}
