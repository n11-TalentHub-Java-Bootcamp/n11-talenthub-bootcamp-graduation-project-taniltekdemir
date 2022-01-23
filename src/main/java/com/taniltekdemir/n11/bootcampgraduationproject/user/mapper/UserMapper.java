package com.taniltekdemir.n11.bootcampgraduationproject.user.mapper;

import com.taniltekdemir.n11.bootcampgraduationproject.user.dto.UserDto;
import com.taniltekdemir.n11.bootcampgraduationproject.user.dto.UserSaveEntityDto;
import com.taniltekdemir.n11.bootcampgraduationproject.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto convertUserToUserDto(User user);

    List<UserDto> convertUserListToUserDtoList(List<User> userList);

    User convertUserSaveEntityDtoToUser(UserSaveEntityDto userSaveEntityDto);

    User convertUserDtoToUser(UserDto userDto);
}
