package com.example.InternTaskBookStore.model.mapper;

import com.example.InternTaskBookStore.model.dto.request.BookRequestDto;
import com.example.InternTaskBookStore.model.dto.response.BookResponseDto;
import com.example.InternTaskBookStore.model.entity.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book bookRequestDtoToBook(BookRequestDto bookRequestDto);
    BookResponseDto bookToBookResponseDto(Book book);
}
