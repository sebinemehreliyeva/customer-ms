package az.atlacademy.customerms.mapper;

import az.atlacademy.customerms.dao.entity.CustomerEntity;
import az.atlacademy.customerms.model.request.CustomerRequestDto;
import az.atlacademy.customerms.model.response.CustomerResponseDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CustomerMapper {
    CustomerMapper CUSTOMER_MAPPER = Mappers.getMapper(CustomerMapper.class);

    CustomerResponseDto buildCustomerResponse(CustomerEntity entity);

    @Mapping(target = "id", ignore = true)
    CustomerEntity buildCustomerEntity(CustomerRequestDto dto);
}


