package com.adidyk.restful;

import com.adidyk.model.dto.UserDTO;
import com.adidyk.transfer.UserTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class UserAPI.
 */
@RestController
public class UserAPI {

    /**
     * @param transfer - transfer.
     */
    private final UserTransfer transfer;

    /**
     * UserAPI - constructor.
     * @param transfer - service.
     */
    @Autowired
    public UserAPI(UserTransfer transfer) {
        this.transfer = transfer;
    }

    /**
     * saveUser - save user.
     * @param userDTO - userDTO.
     * @return - userDTO.
     */
    @RequestMapping(value = "/save_user", method = RequestMethod.POST)
    public UserDTO saveUser(@RequestBody UserDTO userDTO) {
        return this.transfer.save(userDTO);
    }

    /**
     * saveSmartPhone - find smart phone by id.
     * @param userDTO - smart phone.
     */
    @RequestMapping(value = "/find_user_by_login_and_password", method = RequestMethod.POST)
    public UserDTO findUserByLoginAndPassword(@RequestBody UserDTO userDTO) {
        //System.out.println();
        //System.out.println(userDTO);
        //System.out.println();
        return this.transfer.findByLoginAndPassword(userDTO);
    }

    /**
     * findUserById - find user by id.
     * @param userDTO - user.
     * @return - return.
     */
    @RequestMapping(value = "/find_user_by_id", method = RequestMethod.POST)
    public UserDTO findUserById(@RequestBody UserDTO userDTO) {
        return this.transfer.findById(userDTO);
    }

}