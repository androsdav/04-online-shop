package com.adidyk.transfer.mapper;

import com.adidyk.model.dto.ProductDTO;
import com.adidyk.model.dto.TypeDTO;
import com.adidyk.model.pojo.Product;
import com.adidyk.model.pojo.Type;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    Product toProduct(ProductDTO productDTO);

    ProductDTO toProductDTO(Product product);

    List<Product> toTypeDTOs(List<ProductDTO> productDTOs);
}
