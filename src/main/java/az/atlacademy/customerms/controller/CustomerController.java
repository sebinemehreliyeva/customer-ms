package az.atlacademy.customerms.controller;

import az.atlacademy.customerms.model.request.CustomerRequestDto;
import az.atlacademy.customerms.model.response.CustomerResponseDto;
import az.atlacademy.customerms.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDto> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getCustomerById(id));
    }

    @PostMapping
    public ResponseEntity<Void> saveCustomer(@RequestBody CustomerRequestDto dto){
        customerService.saveCustomer(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
