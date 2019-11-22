package com.adidyk.transfer.mapper;

import com.adidyk.model.dto.OrderDTO;
import com.adidyk.model.dto.OrderProductDTO;
import com.adidyk.model.dto.ProductDTO;
import com.adidyk.model.dto.UserDTO;
import com.adidyk.model.pojo.Order;
import com.adidyk.model.pojo.OrderProduct;
import com.adidyk.model.pojo.Product;
import com.adidyk.model.pojo.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import java.util.List;

/**
 * Interface OrderMapper.
 */
@Mapper(componentModel = "spring")
public interface OrderMapper {

    /**
     * toOrder - to order.
     * @param orderDTO - orderDTO.
     * @return - order.
     */
    @Mappings({
            @Mapping(target = "id", source = "orderDTO.id"),
            @Mapping(target = "dateCreate", source = "orderDTO.dateCreate"),
            @Mapping(target = "user", source = "orderDTO.user")
    })
    Order toOrder(OrderDTO orderDTO);

    /**
     * toOrderDTO - to orderDTO.
     * @param order - order.
     * @return - return orderDTO.
     */
    OrderDTO toOrderDTO(Order order);

    /**
     * toListProduct - to list product.
     * @param productDTOS - productDTOS.
     * @return - return list product.
     */
    List<Product> toListProduct(List<ProductDTO> productDTOS);

    /**
     * toListOrderProductDTO - to list order product dto.
     * @param orderProducts - orderProduct.
     * @return - return list orderProductDTO.
     */
    List<OrderProductDTO> toListOrderProductDTO(List<OrderProduct> orderProducts);

    /**
     *
     * @param userDTO - user.
     * @return -
     */
    User toUser(UserDTO userDTO);

    /**
     * toListOrderDTO - to list to orderDTO.
     * @param orders - orders.
     * @return - returns list orderDTO.
     */
    List<OrderDTO> toListOrderDTO(List<Order> orders);

}
