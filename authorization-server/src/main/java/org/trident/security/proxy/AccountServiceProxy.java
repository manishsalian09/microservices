package org.trident.security.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.trident.security.dto.AccountDTO;

@FeignClient(name = "account-service")
@RibbonClient(name = "account-service")
public interface AccountServiceProxy {

	@GetMapping("/account-service/accounts/authentication")
	ResponseEntity<AccountDTO> findAccountByUserId(@RequestParam("userId") String userId);
}
