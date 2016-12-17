package com.tmasuda.fc.ctrl;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.tmasuda.fc.model.Account;
import com.tmasuda.fc.util.SenarioProvider;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class AccountCtrlTest extends SenarioProvider {

	@Autowired
	private AccountCtrl accountCtrl;

	@Test
	public void createNewAccount() {
		String snsId = "createNewAccount";
		createNewAccount(snsId);

		Account existing = accountCtrl.findAccountBySnsId(snsId);
		assertThat(existing, is(notNullValue(Account.class)));
	}

}
