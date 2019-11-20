package com.adidyk.transfer.mapper;

import com.adidyk.model.dto.UserDTO;
import com.adidyk.model.pojo.User;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserDTO userDTO);

    UserDTO toUserDTO(User user);

    List<UserDTO> toListUserDTO(List<User> users);
}
