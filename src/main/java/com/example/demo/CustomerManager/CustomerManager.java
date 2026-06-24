package com.example.demo;

import com.example.demo.Branch.Branch;
import com.example.demo.CustomerResponseDto.CustomerResponseDto;
import com.example.demo.repository.CustomerRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.example.demo.Customers.Customers;
import com.example.demo.BranchRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerManager {

    private final CustomerRepository customerRepository;
    private final BranchRepository branchRepository;
    private final RedisTemplate <String,Object> redisTemplate;

    public CustomerManager(CustomerRepository customerRepository, BranchRepository branchRepository,  RedisTemplate <String,Object> redisTemplate) {
        this.customerRepository = customerRepository;
        this.branchRepository = branchRepository;
        this.redisTemplate = redisTemplate;
    }

    public void addCustomer(Customers customer) {
         String departmentID = customer.getDepartmentId();
        if (branchRepository.existsById(departmentID)) {
            customerRepository.save(customer);
        }
        else {
            throw new RuntimeException("Error: Department does not exist.");
        }

    }

    public void deleteCustomerById(String id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
        }
    }

    public List<CustomerResponseDto> getAllCustomers() {

        List<CustomerResponseDto> dtoList = new ArrayList<>();

        for (Customers customer : customerRepository.findAll()) {
            String depid = customer.getDepartmentId();
            String depaddress = (String) redisTemplate.opsForValue().get("Branch:" + depid);

            if (depaddress == null) {
                Branch branch = branchRepository.findById(depid).orElse(null);
                if (branch != null) {
                    depaddress = branch.getDepartmentadress();
                    redisTemplate.opsForValue().set("Branch:" + depid, depaddress);
                }
            }

            CustomerResponseDto dto = new CustomerResponseDto();
            dto.setCustomerId(customer.getCustomerId());
            dto.setCustomerName(customer.getCustomerName());
            dto.setDepartmentId(customer.getDepartmentId());
            dto.setDepartmentAdress(depaddress);

            dtoList.add(dto);
        }

        return dtoList;
    }

    public void updateCustomer(String id, String newName, String newLastname, String newdepartmentId) {

        if (customerRepository.existsById(id) && branchRepository.existsById(newdepartmentId)) {

            Customers dbCustomer = customerRepository.findById(id).orElseThrow();

            dbCustomer.setCustomerName(newName);
            dbCustomer.setCustomerLastname(newLastname);
            dbCustomer.setDepartmentId(newdepartmentId);

            customerRepository.save(dbCustomer);

        } else {
            throw new RuntimeException("Error: There is no such Customer with the ID or Department ID.");
        }
    }

}
