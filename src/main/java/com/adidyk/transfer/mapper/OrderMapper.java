package com.adidyk.transfer.mapper;

import com.adidyk.model.dto.OrderDTO;
import com.adidyk.model.pojo.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order toOrder(OrderDTO orderDTO);

    OrderDTO toOrderDTO(Order order);
}
