package com.cg.foodos.service;

import java.util.List;
import com.cg.foodos.dto.Account;

public interface AccountService {
	public List<Account> findAll();
	public Account findById(Integer accountId);
	public void delete(Account account);
	public void deleteById(Integer accountId);
	public void save(Account account);
}
