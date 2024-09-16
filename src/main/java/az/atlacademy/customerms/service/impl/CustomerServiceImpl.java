package az.atlacademy.customerms.service.impl;

import az.atlacademy.customerms.dao.entity.CustomerEntity;
import az.atlacademy.customerms.dao.repository.CustomerRepository;
import az.atlacademy.customerms.model.request.CustomerRequestDto;
import az.atlacademy.customerms.model.response.CustomerResponseDto;
import az.atlacademy.customerms.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static az.atlacademy.customerms.mapper.CustomerMapper.CUSTOMER_MAPPER;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public void saveCustomer(CustomerRequestDto dto) {
        CustomerEntity entity = CUSTOMER_MAPPER.buildCustomerEntity(dto);
        customerRepository.save(entity);
    }

    @Override
    public CustomerResponseDto getCustomerById(Long id) {
        var entity = fetchCustomerById(id);
        return CUSTOMER_MAPPER.buildCustomerResponse(entity);
    }



    private CustomerEntity fetchCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(
                () -> new RuntimeException("CUSTOMER_NOT_FOUND")
        );
    }
}