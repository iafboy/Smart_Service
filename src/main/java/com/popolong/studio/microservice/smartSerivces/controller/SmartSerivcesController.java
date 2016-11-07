package com.popolong.studio.microservice.smartSerivces.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;

import com.popolong.studio.microservice.smartSerivces.db.model.AccountModel;
import com.popolong.studio.microservice.smartSerivces.service.SmartRepoService;
import com.popolong.studio.microservice.exceptions.TaskNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SmartSerivcesController {

	protected Logger logger = Logger.getLogger(SmartSerivcesController.class
			.getName());

	@Resource(name="AccountRepoService")
	protected SmartRepoService accountService;
	
	@RequestMapping("/smartSerivces/{accountNumber}")
	public AccountModel byNumber(@PathVariable("accountNumber") String accountNumber) {
		logger.info("smartSerivces-service total: " + accountService.countAccounts());
		logger.info("smartSerivces-service byNumber() invoked: " + accountNumber);
		AccountModel account = accountService.findByNumber(accountNumber);
		logger.info("smartSerivces-service byNumber() found: " + account);

		if (account == null)
			throw new TaskNotFoundException(accountNumber);
		else {
			return account;
		}
	}

	
	@RequestMapping("/smartSerivces/owner/{name}")
	public List<AccountModel> byOwner(@PathVariable("name") String partialName) {
		logger.info("smartSerivces-service byOwner() invoked: "
				+ accountService.getClass().getName() + " for "
				+ partialName);

		List<AccountModel> accounts = accountService
				.findByOwnerContainingIgnoreCase(partialName);
		logger.info("smartSerivces-service byOwner() found: " + accounts);

		if (accounts == null || accounts.size() == 0)
			throw new TaskNotFoundException(partialName);
		else {
			return accounts;
		}
	}
	@RequestMapping("/smartSerivces/updateAccountEligibility/{accountNumber}")
	public boolean updateAccountEligibility(@PathVariable("accountNumber") String accountNumber){
		return false;
	}

}
