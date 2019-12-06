package com.adidyk.transfer;

import com.adidyk.model.dto.OrderDTO;
import com.adidyk.model.dto.OrderProductDTO;
import com.adidyk.model.dto.ProductDTO;
import com.adidyk.model.dto.UserDTO;
import com.adidyk.model.pojo.Order;
import com.adidyk.model.pojo.OrderProduct;
import com.adidyk.model.pojo.Product;
import com.adidyk.service.OrderService;
import com.adidyk.transfer.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * Class OrderTransfer.
 */
@Service
public class OrderTransfer {

    /**
     * @param service - service.
     */
    private final OrderService service;

    /**
     * @param mapper - mapper.
     */
    private final OrderMapper mapper;


    /**
     * OrderTransfer - constructor.
     * @param service - service.
     * @param mapper - mapper.
     */
    @Autowired
    public OrderTransfer(OrderService service, OrderMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    /**
     * toOrder - to order.
     * @param order - order.
     * @param products - products.
     * @return - return order.
     */
    private Order toOrder(Order order, List<Product> products) {
        List<OrderProduct> orderProducts = new ArrayList<>();
        for (Product product : products) {
            orderProducts.add(new OrderProduct(order, product, product.getQuantity()));
        }
        order.setOrderProduct(orderProducts);
        return order;
    }

    /**
     * toOrderDTO - to orderDTO.
     * @param orderDTO - orderDTO.
     * @param orderProductDTOS - orderProductDTOS.
     * @return - orderDTO.
     */
    private OrderDTO toOrderDTO(OrderDTO orderDTO, List<OrderProductDTO> orderProductDTOS) {
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (OrderProductDTO orderProductDTO : orderProductDTOS) {
            ProductDTO productDTO = orderProductDTO.getProduct();
            productDTO.setQuantity(orderProductDTO.getCount());
            productDTOS.add(productDTO);
        }
        orderDTO.setProducts(productDTOS);
        return orderDTO;
    }

    /**
     * save - save.
     * @param orderDTO - orderDTO.
     */
    public void save(OrderDTO orderDTO) {
        this.service.save(this.toOrder(this.mapper.toOrder(orderDTO), this.mapper.toListProduct(orderDTO.getProducts())));
    }

    /**
     * findById - find by id.
     * @param orderDTO - orderDTO.
     * @return - return orderDTO.
     */
    public OrderDTO findById(OrderDTO orderDTO) {
        Order order = this.service.findById(this.mapper.toOrder(orderDTO));
        return this.toOrderDTO(this.mapper.toOrderDTO(order), this.mapper.toListOrderProductDTO(order.getOrderProduct()));
    }

    /**
     * findAllByUser - find all by user.
     * @param userDTO - userDTO.
     * @return - return list orderDTO.
     */
    public List<OrderDTO> findAllByUser(UserDTO userDTO) {
        return this.mapper.toListOrderDTO(this.service.findAllByUser(this.mapper.toUser(userDTO)));
    }

}
