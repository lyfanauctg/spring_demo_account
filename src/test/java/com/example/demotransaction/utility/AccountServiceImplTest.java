package com.example.demotransaction.utility;


import com.example.demotransaction.entity.model.Account;
import com.example.demotransaction.repository.AccountRepository;
import com.example.demotransaction.service.impl.AccountServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountServiceImplTest {

    private static final Logger log =
            LoggerFactory.getLogger(AccountServiceImplTest.class);

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountServiceImpl accountService;


    @Test
    void transfer_success(){

        Account from = new Account(4L,"Test", 1000.0);
        Account to = new Account(5L, "Test 2", 2000.0);

        log.info("Before transfer from balance: {}", from.getBalance());

        // mock repository
        when(accountRepository.findById(4L)).thenReturn(java.util.Optional.of(from));
        when(accountRepository.findById(5L)).thenReturn(java.util.Optional.of(to));

        accountService.transfer(4L,5L,-200000);

        log.info("After transfer from balance: {}", from.getBalance());
    }

    @Test
    void get_account_success(){
        accountService.findAccountById(3L);
    }
}
