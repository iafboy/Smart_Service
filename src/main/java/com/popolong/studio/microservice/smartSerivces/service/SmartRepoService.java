package com.popolong.studio.microservice.smartSerivces.service;

import java.util.List;

import javax.annotation.Resource;

import com.popolong.studio.microservice.smartSerivces.db.dao.AccountDao;
import org.springframework.stereotype.Service;

import com.popolong.studio.microservice.smartSerivces.db.model.AccountModel;
@Service(value="AccountRepoService")

public class SmartRepoService {

	@Resource
	protected AccountDao accountDao;

	public int countAccounts() {
		return accountDao.countAccounts();
	}

	public AccountModel findByNumber(String accountNumber) {
		return accountDao.findByNumber(accountNumber);
	}

	public List<AccountModel> findByOwnerContainingIgnoreCase(String partialName) {
		return accountDao.findByOwnerContainingIgnoreCase(partialName);
	}
	
	
}
