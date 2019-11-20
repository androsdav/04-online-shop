package com.adidyk.transfer;

import com.adidyk.model.dto.UserDTO;
import com.adidyk.service.UserService;
import com.adidyk.transfer.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Class UserTransfer.
 */
@Service
public class UserTransfer {

    /**
     * @param service - service.
     */
    private UserService service;

    /**
     * @param mapper - mapper.
     */
    private UserMapper mapper;

    /**
     * UserTransfer - constructor.
     * @param service - service.
     * @param mapper - mapper.
     */
    @Autowired
    public UserTransfer(UserService service, UserMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    /**
     * save - save new product.
     * @param userDTO - product.
     */
    public UserDTO save(UserDTO userDTO) {
        return this.mapper.toUserDTO(this.service.save(this.mapper.toUser(userDTO)));
    }

    /**
     * saveSmartPhone - find smart phone by id.
     * @param userDTO - smart phone.
     */
    public UserDTO findByLoginAndPassword(UserDTO userDTO) {
        return this.mapper.toUserDTO(this.service.findByLoginAndPassword(this.mapper.toUser(userDTO)));
    }

    /**
     * saveSmartPhone - find smart phone by id.
     * @param userDTO - smart phone.
     */
    public UserDTO findById(UserDTO userDTO) {
        return this.mapper.toUserDTO(this.service.findById(this.mapper.toUser(userDTO)));
    }

}