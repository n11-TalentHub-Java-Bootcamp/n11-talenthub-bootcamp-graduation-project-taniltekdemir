package com.taniltekdemir.n11.bootcampgraduationproject.user.service;

import com.taniltekdemir.n11.bootcampgraduationproject.common.exception.CommonException;
import com.taniltekdemir.n11.bootcampgraduationproject.user.dto.UserDto;
import com.taniltekdemir.n11.bootcampgraduationproject.user.dto.UserSaveEntityDto;
import com.taniltekdemir.n11.bootcampgraduationproject.user.entity.User;
import com.taniltekdemir.n11.bootcampgraduationproject.user.mapper.UserMapper;
import com.taniltekdemir.n11.bootcampgraduationproject.user.repository.UserRepository;
import com.taniltekdemir.n11.bootcampgraduationproject.user.service.entityService.UserEntityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserEntityService userEntityService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;

    @Test
    void shouldfindAllWhenExist() {

        List<User> userList = UserServiceDataProvider.getAllUserList();
        List<UserDto> userDtoList = UserServiceDataProvider.convertToUserDto(userList);

        when(userEntityService.findAll()).thenReturn(userList);

        List<UserDto> userDtos = userService.findAll();

        assertArrayEquals(userDtoList.toArray(), userDtos.toArray());
    }

    @Test
    void shouldfindAllWhenNotExist() {

        List<User> userList = new ArrayList<>();
        List<UserDto> userDtoList = UserServiceDataProvider.convertToUserDto(userList);

        when(userEntityService.findAll()).thenReturn(userList);

        List<UserDto> userDtos = userService.findAll();

        assertArrayEquals(userDtoList.toArray(), userDtos.toArray());
    }

    @Test
    void shouldfindByIdWhenExist() {
        User user = UserServiceDataProvider.getUser();

        when(userEntityService.getById(any())).thenReturn(user);

        User userData = userService.findById(1L);

        assertEquals(user, userData);
    }

    @Test
    void shouldfindByIdWhenNotExist() {

        when(userEntityService.getById(0L)).thenThrow(new RuntimeException());

        assertThrows(RuntimeException.class, () -> userService.findById(0L));
    }

    @Test
    void shouldfindByIdWhenNotExist2() {
        try {
            userService.findById(0L);
        } catch (Exception ex){
            assertTrue(ex instanceof RuntimeException);
            assertEquals("Kullancı bulunamadı", ex.getMessage());
        }
    }

    @Test
    void save() {
        UserSaveEntityDto userSaveEntityDto = UserServiceDataProvider.getUserSaveEntityDto();
        UserDto userDto = UserServiceDataProvider.getUserDto();
        User user = UserServiceDataProvider.getUser();

        when(userEntityService.save(ArgumentMatchers.any(User.class))).thenReturn(user);

        UserDto result = userService.save(userSaveEntityDto);

        assertEquals(userDto, result);
        assertEquals(1L, result.getId());
    }

    @Test
    void validationForSaveUserForCompulsoryAreas() {
        UserSaveEntityDto saveEntityDto = UserServiceDataProvider.getUserSaveEntityDtoForCompulsoryAres();
        try {
            userService.validationForSaveUser(saveEntityDto);
        }catch (Exception ex){
            assertTrue(ex instanceof CommonException);
            assertEquals("Boş bırakılmış zorunlu alanlar var.", ex.getMessage());
        }
    }

    @Test
    void update() {
        UserDto userUpdateDto = UserServiceDataProvider.getUserUpdateEntityDto();
        User user = UserMapper.INSTANCE.convertUserDtoToUser(userUpdateDto);
        UserDto userDto = UserServiceDataProvider.getUpdateUserDto();
        when(userEntityService.save(ArgumentMatchers.any(User.class))).thenReturn(user);
        UserDto result = userService.update(userUpdateDto);
        assertEquals("1111111111", result.getTelephone());
    }

    @Test
    void shouldDeleteWhenExist() {
        User user = UserServiceDataProvider.getUser();
        when(userEntityService.getById(anyLong())).thenReturn(user);
        userService.delete(1L);

        verify(userEntityService).getById(anyLong());
        verify(userEntityService).delete(user);
    }

    @Test
    void shouldDeleteWhenNotExist() {
        when(userEntityService.getById(0L)).thenThrow(new RuntimeException("Kullancı bulunamadı"));

        assertThrows(RuntimeException.class, () -> userService.delete(0L));
        verify(userEntityService).getById(anyLong());
    }

    @Test
    void shouldConfirmUserInfo() {
        User user = UserServiceDataProvider.getUser();

        when(userRepository.findFirstByTcknAndAndDateOfBirth(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(user);
        Long id = userService.confirmUserInfo("35796125996", "1991-08-05");

        assertEquals(1L, id);
    }

    @Test
    void shouldNotConfirmUserInfo() {
        User user = null;
        when(userRepository.findFirstByTcknAndAndDateOfBirth(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(user);
        assertThrows(RuntimeException.class, () -> userService.confirmUserInfo("35796125991", "1991-08-05"));
    }
}