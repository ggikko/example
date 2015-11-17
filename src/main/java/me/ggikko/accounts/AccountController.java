package me.ggikko.accounts;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Park Ji Hong, ggikko.
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService service;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(value = "/accounts", method = RequestMethod.POST)
    public ResponseEntity createAccount(@RequestBody @Valid AccountDto.Create create, BindingResult result) {
        if(result.hasErrors()){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        Account newAccount = service.createAccount(create);
        return new ResponseEntity(modelMapper.map(newAccount, AccountDto.Response.class), HttpStatus.CREATED);
    }
}
