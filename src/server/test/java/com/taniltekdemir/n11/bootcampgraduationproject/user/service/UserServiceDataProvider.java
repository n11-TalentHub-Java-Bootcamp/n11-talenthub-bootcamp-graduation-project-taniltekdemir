package com.taniltekdemir.n11.bootcampgraduationproject.user.service;

import com.taniltekdemir.n11.bootcampgraduationproject.user.dto.UserDto;
import com.taniltekdemir.n11.bootcampgraduationproject.user.dto.UserSaveEntityDto;
import com.taniltekdemir.n11.bootcampgraduationproject.user.entity.User;
import com.taniltekdemir.n11.bootcampgraduationproject.user.enums.EnumUserType;
import com.taniltekdemir.n11.bootcampgraduationproject.user.mapper.UserMapper;

import java.util.ArrayList;
import java.util.List;

public class UserServiceDataProvider {

    public static List<User> getAllUserList(){

        List<User> userList = new ArrayList<>();

        User user1 = new User();
        user1.setId(1L);
        user1.setName("user-1");
        user1.setSurname("user-1");
        user1.setTckn("35796125996");
        user1.setDateOfBirth("1991-08-05");
        user1.setEmail("user@user.com");
        user1.setUserType(EnumUserType.CUSTOMER);
        user1.setTelephone("5000000000");
        user1.setPassword("$2a$12$w8jf5/ulB2q9K5LFNUCjYe1g9KOFtHolxlSoKB0hVkHLT.pilIPD6");
        userList.add(user1);

        User user2 = new User();
        user2.setId(1L);
        user2.setName("user-2");
        user2.setSurname("user-2");
        user2.setTckn("95019427962");
        user2.setDateOfBirth("1991-08-05");
        user2.setEmail("user@user.com");
        user2.setUserType(EnumUserType.CUSTOMER);
        user2.setTelephone("5000000000");
        user2.setPassword("$2a$12$w8jf5/ulB2q9K5LFNUCjYe1g9KOFtHolxlSoKB0hVkHLT.pilIPD6");
        userList.add(user2);

        return userList;
    }

    public static List<UserDto> convertToUserDto(List<User> userList) {
        return UserMapper.INSTANCE.convertUserListToUserDtoList(userList);
    }

    public static User getUser() {
        User user1 = new User();
        user1.setId(1L);
        user1.setName("user-1");
        user1.setSurname("user-1");
        user1.setTckn("35796125996");
        user1.setDateOfBirth("1991-08-05");
        user1.setEmail("user@user.com");
        user1.setUserType(EnumUserType.CUSTOMER);
        user1.setTelephone("5000000000");
        user1.setPassword("$2a$12$w8jf5/ulB2q9K5LFNUCjYe1g9KOFtHolxlSoKB0hVkHLT.pilIPD6");
        return user1;
    }

    public static UserDto getUserDto() {
        UserDto user1 = new UserDto();
        user1.setId(1L);
        user1.setName("user-1");
        user1.setSurname("user-1");
        user1.setTckn("35796125996");
        user1.setDateOfBirth("1991-08-05");
        user1.setEmail("user@user.com");
        user1.setUserType(EnumUserType.CUSTOMER);
        user1.setTelephone("5000000000");
        user1.setPassword("$2a$12$w8jf5/ulB2q9K5LFNUCjYe1g9KOFtHolxlSoKB0hVkHLT.pilIPD6");
        return user1;
    }

    public static UserDto getUpdateUserDto() {
        UserDto user1 = new UserDto();
        user1.setId(1L);
        user1.setName("user-1");
        user1.setSurname("user-1");
        user1.setTckn("35796125996");
        user1.setDateOfBirth("1991-08-05");
        user1.setEmail("user@user.com");
        user1.setUserType(EnumUserType.CUSTOMER);
        user1.setTelephone("1111111111");
        user1.setPassword("$2a$12$w8jf5/ulB2q9K5LFNUCjYe1g9KOFtHolxlSoKB0hVkHLT.pilIPD6");
        return user1;
    }

    public static UserSaveEntityDto getUserSaveEntityDto() {
        UserSaveEntityDto saveEntityDto = new UserSaveEntityDto();
        saveEntityDto.setName("user-1");
        saveEntityDto.setSurname("user-1");
        saveEntityDto.setTckn("35796125996");
        saveEntityDto.setDateOfBirth("1991-08-05");
        saveEntityDto.setTelephone("5000000000");
        saveEntityDto.setEmail("user@user.com");
        saveEntityDto.setPassword("1");
        saveEntityDto.setUserType(EnumUserType.CUSTOMER);
        return saveEntityDto;
    }

    public static UserDto getUserUpdateEntityDto() {
        UserDto userDto = new UserDto();
        userDto.setName("user-1");
        userDto.setSurname("user-1");
        userDto.setTckn("35796125996");
        userDto.setDateOfBirth("1991-08-05");
        userDto.setTelephone("1111111111");
        userDto.setEmail("user@user.com");
        userDto.setPassword("1");
        userDto.setUserType(EnumUserType.CUSTOMER);
        return userDto;
    }

    public static UserSaveEntityDto getUserSaveEntityDtoForCompulsoryAres() {
        UserSaveEntityDto saveEntityDto = new UserSaveEntityDto();
        saveEntityDto.setName(null);
        saveEntityDto.setSurname("user-1");
        saveEntityDto.setTckn("35796125996");
        saveEntityDto.setDateOfBirth(null);
        saveEntityDto.setTelephone("5000000000");
        saveEntityDto.setEmail("user@user.com");
        saveEntityDto.setPassword("1");
        saveEntityDto.setUserType(EnumUserType.CUSTOMER);
        return saveEntityDto;
    }
}
