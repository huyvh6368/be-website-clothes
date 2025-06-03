package web.clothes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.clothes.dto.request.CustomerRequest;
import web.clothes.dto.response.CustomerResponse;
import web.clothes.entity.Account;
import web.clothes.entity.Customer;
import web.clothes.mapper.AccountMapper;
import web.clothes.mapper.CustomerMapper;
import web.clothes.repository.AccountRepository;
import web.clothes.repository.CustomerRepository;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;

    public CustomerResponse create(CustomerRequest customerRequest) {
        Account account = accountRepository.findById(customerRequest.getAccountId())
                .orElseThrow(() -> new RuntimeException("account not found"));
        Customer customer = CustomerMapper.addRequestToEntity(customerRequest, account);
        customerRepository.save(customer);
        return CustomerMapper.entityToResponse(customer, AccountMapper.entityToResponse(account));
    }

    public CustomerResponse update(CustomerRequest customerRequest, Long id) {
        Account account = accountRepository.findById(customerRequest.getAccountId())
                .orElseThrow(() -> new RuntimeException("account not found"));
        Customer customer = CustomerMapper.updateRequestToEntity(customerRequest, account, id);
        customerRepository.save(customer);
        return CustomerMapper.entityToResponse(customer, AccountMapper.entityToResponse(account));
    }
}
