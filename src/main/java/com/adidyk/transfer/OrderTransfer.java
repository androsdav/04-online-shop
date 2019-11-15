package com.adidyk.transfer;

import com.adidyk.model.dto.OrderDTO;
import com.adidyk.model.dto.ProductDTO;
import com.adidyk.model.dto.UserDTO;
import com.adidyk.model.pojo.Order;
import com.adidyk.model.pojo.OrderProduct;
import com.adidyk.model.pojo.Product;
import com.adidyk.model.pojo.User;
import com.adidyk.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderTransfer {

    private final OrderService service;


    @Autowired
    public OrderTransfer(OrderService service) {
        this.service = service;
    }

    private User transferDtoToPojo (UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getLogin(), userDTO.getPassword(), userDTO.getFirstName(), userDTO.getSecondName(), userDTO.getPhoneNumber());
    }

    private Product transferDtoToPojo(ProductDTO productDTO) {
        return new Product(productDTO.getId(), productDTO.getCompany(), productDTO.getModel(), productDTO.getDescription(), productDTO.getQuantity(), productDTO.getPrice());
    }

    private List<Product> transferDtoListToPogoList(List<ProductDTO> productDTOS) {
        List<Product> products = new ArrayList<>();
        for (ProductDTO productDTO : productDTOS) {
            products.add(this.transferDtoToPojo(productDTO));
        }
        return products;
    }

    private Order transferDtoToPojo(OrderDTO orderDTO) {
        Order order = new Order(orderDTO.getId(), orderDTO.getDateCreate());
        return order;
    }

    /**
     * save - save new order.
     *
     * @param orderDTO - order.
     */
    public void save(OrderDTO orderDTO) {
         User user = this.transferDtoToPojo(orderDTO.getUser());
         List<Product> products = this.transferDtoListToPogoList(orderDTO.getProducts());
         Order order = this.transferDtoToPojo(orderDTO);
         order.setUser(user);

         List<OrderProduct> orderProducts = new ArrayList<>();

         for (Product product : products) {
             OrderProduct orderProduct = new OrderProduct(order, product, product.getQuantity());
             orderProducts.add(orderProduct);
         }
         order.setOrderProduct(orderProducts);

         for (Product product : products) {
             product.setOrderProduct(orderProducts);
         }
         this.service.save(order);
    }

    /*
    public void findById(OrderDTO orderDTO) {
        Order order = this.transferDtoToPojo(orderDTO);
        System.out.println(this.service.findById(order));
    }
    */

    public Order findById(Order order) {
        return this.service.findById(order);
    }

    /**
     *
     * @return
     */
    public void findAllByUser(UserDTO userDTO) {
        User user = this.transferDtoToPojo(userDTO);
        System.out.println();
        System.out.println("check point");
        System.out.println();
        List<Order> orderList = this.service.findAllByUser(user);
        System.out.println(orderList);
        //return null;
    }
}
