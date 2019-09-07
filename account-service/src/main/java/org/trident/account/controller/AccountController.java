package org.trident.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.trident.account.dto.AccountDTO;
import org.trident.account.exception.ValidationException;
import org.trident.account.service.AccountService;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("{accountId}")
    public ResponseEntity<?> findByAccountId(@PathVariable("accountId") Long accountId) {
        final AccountDTO accountDTO = this.accountService.findByAccountId(accountId);
        return ResponseEntity.status(HttpStatus.OK).body(accountDTO);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody AccountDTO accountDTO, Errors errors) throws URISyntaxException {
        if (errors.hasErrors()) throw new ValidationException("Field Validation Errors", errors);
        final Long accountId = this.accountService.createAccount(accountDTO).getAccountId();
        final URI location = new URI("/accounts/" + accountId);
        return ResponseEntity.created(location).build();
    }

    @GetMapping("authentication/otp")
    public ResponseEntity<?> sendTemporaryPassword(@RequestParam("userId") String userId) {
        this.accountService.sendTemporaryPassword(userId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("authentication")
    public ResponseEntity<?> updatePassword(@RequestBody AccountDTO accountDTO) {
        if (StringUtils.isEmpty(accountDTO.getUserId())
                || StringUtils.isEmpty(accountDTO.getPassword())
                || StringUtils.isEmpty(accountDTO.getTemporaryPassword())) {
            throw new ValidationException("Fields cannot be blank", null);
        }
        this.accountService.updatePassword(accountDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("authentication")
    public ResponseEntity<?> findAccountByUserId(@RequestParam("userId") String userId) {
        final AccountDTO accountDTO = this.accountService.findByUserId(userId, true);
        return ResponseEntity.status(HttpStatus.OK).body(accountDTO);
    }
}
