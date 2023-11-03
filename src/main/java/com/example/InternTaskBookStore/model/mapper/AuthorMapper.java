package com.example.InternTaskBookStore.model.mapper;

import com.example.InternTaskBookStore.model.dto.request.SignUpRequestDto;
import com.example.InternTaskBookStore.model.dto.response.AuthorResponseDto;
import com.example.InternTaskBookStore.model.entity.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    Author signUpRequestDtoToAuthor(SignUpRequestDto signUpRequestDto);
    AuthorResponseDto authorToAuthorResponseDto(Author author);
}
