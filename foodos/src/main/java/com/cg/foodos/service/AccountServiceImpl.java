package com.cg.foodos.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.foodos.dto.Account;
import com.cg.foodos.repository.AccountRepository;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountRepository accountRepository;
	
	/**
     * @return
     */
    public List<Account> findAll() {
        
        return null;
    }

    /**
     * @param accountId 
     * @return
     */
    public Account findById(Integer accountId) {
        
        return null;
    }

    /**
     * @param account
     */
    public void delete(Account account) {
        
    }

	@Override
	public void deleteById(Integer accountId) {
		accountRepository.deleteById(accountId);
		return;
	}

	@Override
	public void save(Account account) {
		accountRepository.save(account);
	}

}
