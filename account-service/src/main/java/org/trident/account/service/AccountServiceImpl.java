package org.trident.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.trident.account.dto.AccountDTO;
import org.trident.account.dto.RoleDTO;
import org.trident.account.entity.Account;
import org.trident.account.entity.Role;
import org.trident.account.exception.ValidationException;
import org.trident.account.repository.AccountRepository;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AccountServiceImpl(final AccountRepository accountRepository, final PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AccountDTO createAccount(final AccountDTO accountDTO) {
        Account account = accountDTO.toEntity();
        account.setPassword(this.passwordEncoder.encode(accountDTO.getPassword()));
        account.setRoles(accountDTO.getRoles().stream().map(RoleDTO::toEntity).collect(Collectors.toSet()));
        account = this.accountRepository.save(account);
        return account.toDto();
    }

    @Override
    public AccountDTO findByAccountId(final Long accountId) {
        Optional<Account> account = this.accountRepository.findById(accountId);
        if (account.isEmpty()) throw new ValidationException("User account does not exist", null);
        AccountDTO accountDTO = account.get().toDto();
        accountDTO.setRoles(account.get().getRoles().stream().map(Role::toDto).collect(Collectors.toSet()));
        return accountDTO;
    }

    @Override
    public void sendTemporaryPassword(final String userId) {
        Optional<Account> account = verifyAccount(userId);
        if(account.isEmpty()) {
            throw new ValidationException("Invalid UserId", null);
        } else {
            account.get().setTemporaryPassword("temp");
            this.accountRepository.save(account.get());
            sendMail(account.get().getEmailId(), account.get().getTemporaryPassword());
        }
    }

    @Override
    @Transactional
    public void updatePassword(final AccountDTO accountDTO) {
        final Optional<Account> account = this.accountRepository.findByUserId(accountDTO.getUserId());
        if (account.isEmpty()) {
            throw new ValidationException("Invalid user id", null);
        }
        if (StringUtils.isEmpty(account.get().getTemporaryPassword())) {
            throw new ValidationException("One time password has expired", null);
        }
        if (account.get().getTemporaryPassword().equals(accountDTO.getTemporaryPassword())) {
            account.get().setPassword(this.passwordEncoder.encode(accountDTO.getPassword()));
            account.get().setTemporaryPassword(null);
        } else {
            throw new ValidationException("One time password is incorrect", null);
        }
    }

    @Override
    public AccountDTO findByUserId(final String userId) {
        final Optional<Account> account = this.accountRepository.findByUserId(userId);
        if (account.isEmpty()) throw new ValidationException("User account does not exist", null);
        return account.get().toDto();
    }

    @Override
    public AccountDTO findByUserId(String userId, boolean isAuthorizationRequest) {
        final Optional<Account> account = this.accountRepository.findByUserId(userId);
        if (account.isEmpty()) throw new ValidationException("User account does not exist", null);
        AccountDTO accountDTO = account.get().toDto();
        accountDTO.setRoles(account.get().getRoles().stream().map(Role::toDto).collect(Collectors.toSet()));
        if (isAuthorizationRequest) {
            accountDTO.setPassword(account.get().getPassword());
        }
        return accountDTO;
    }

    private Optional<Account> verifyAccount(final String userId) {
        return this.accountRepository.findByUserId(userId);
    }

    private void sendMail(final String emailId, final String temporaryPassword) {

    }
}
