package org.trident.account.service;

import org.trident.account.dto.AccountDTO;

public interface AccountService {

    AccountDTO createAccount(final AccountDTO accountDTO);
    AccountDTO findByAccountId(final Long accountId);
    void sendTemporaryPassword(final String userId);
    void updatePassword(final AccountDTO accountDTO);
    AccountDTO findByUserId(final String userId);
    AccountDTO findByUserId(final String userId, final boolean isAuthorizationRequest);
}
