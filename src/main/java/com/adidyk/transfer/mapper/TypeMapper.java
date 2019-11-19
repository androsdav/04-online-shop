package com.adidyk.transfer.mapper;

import com.adidyk.model.dto.TypeDTO;
import com.adidyk.model.pojo.Type;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TypeMapper {

    Type toType(TypeDTO typeDTO);

    TypeDTO toTypeDTO(Type type);

    List<TypeDTO> toListTypeDTO(List<Type> types);

}