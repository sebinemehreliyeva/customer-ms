package az.atlacademy.customerms.service;

import az.atlacademy.customerms.model.request.CustomerRequestDto;
import az.atlacademy.customerms.model.response.CustomerResponseDto;


public interface CustomerService {
    void saveCustomer(CustomerRequestDto dto);
    CustomerResponseDto getCustomerById(Long id);


}