package com.eny.springproject.converter;

import com.eny.springproject.dto.request.UpdateUserDto;
import com.eny.springproject.model.UserEntity;
import com.eny.springproject.dto.response.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends Converter<UpdateUserDto, UserEntity, UserResponse> {
    UserResponse toResource(UserEntity entity);

    UserEntity toEntity(UpdateUserDto dto);
}