package com.example.service;

import com.example.database.NoSQLDatabaseService;
import com.example.dto.CustomerDTO;
import com.example.dto.mapper.CustomerMapper;
import com.example.model.Customer;
import com.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final NoSQLDatabaseService noSQLDatabaseService;

    @Autowired
    public CustomerService(NoSQLDatabaseService noSQLDatabaseService, CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
        this.noSQLDatabaseService = noSQLDatabaseService;
    }

    public List<CustomerDTO> getAllCustomers() {

        try {

            String strkey = "blowfish";
            SecretKeySpec key = null;
            key = new SecretKeySpec(strkey.getBytes(StandardCharsets.UTF_8), "Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");

            cipher.init(Cipher.ENCRYPT_MODE, key);

            String encryptedData = null;
            encryptedData = new String(cipher.doFinal("encrypt".getBytes(StandardCharsets.UTF_8)));

            System.out.println("ENCRYPTES: " + encryptedData);
            System.out.println("ENCRYPTES: " + Base64.getEncoder()
                    .encodeToString(encryptedData.getBytes()));
            System.out.println("ENCRYPTES: " +
                    Arrays.toString(Base64.getEncoder()
                            .encodeToString(encryptedData.getBytes()).getBytes()));
            System.out.println("ENCRYPTES: " + Arrays.toString(encryptedData.getBytes(StandardCharsets.UTF_8)));
            cipher.init(Cipher.DECRYPT_MODE, key);


        } catch (NoSuchAlgorithmException | NoSuchPaddingException
                | BadPaddingException | IllegalBlockSizeException | InvalidKeyException e) {
            e.printStackTrace();
        }

        return customerRepository.findAll().stream()
                .map(customerMapper::customerToDto)
                .collect(Collectors.toList());
    }

        public CustomerDTO createCustomer(CustomerDTO customerDTO, String hashPassword) {
        Customer customer = customerMapper.fromDto(customerDTO);
        customer.setPassword(hashPassword);
        noSQLDatabaseService.putValue(customer.getEmail(), "32487290374928742972938");
        Customer customerCreated = customerRepository.save(customer);
        return customerMapper.customerToDto(customerCreated);
    }

    public void updateCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.fromDto(customerDTO);
        customerRepository.save(customer);
    }

    public CustomerDTO getCustomerById(Long id) {
        //should be try catch!!!!
        Customer customer = customerRepository.getOne(id);
        String hash = noSQLDatabaseService.getValue(customer.getEmail());
        return customerMapper.customerToDto(customer, hash);
    }

    public void customerAuth(String email, String password) {
        //Dunno if needed
    }
}

