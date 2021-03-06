package me.ggikko.accounts;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by Park Ji Hong, ggikko.
 */
@Service
@Transactional
public class AccountService {

    @Autowired
    private AccountRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public Account createAccount(AccountDto.Create dto) {

        Account account = modelMapper.map(dto, Account.class);

        String username = dto.getUsername();
        if(repository.findByUsername(username) != null){
            throw new UserDuplicatedException();
        }

        Date date = new Date();
        account.setJoined(date);
        account.setUpdated(date);

        return repository.save(account);
    }

}
