package com.tmasuda.fc.handler;

import com.tmasuda.fc.ctrl.AccountCtrl;
import com.tmasuda.fc.ctrl.CategoryCtrl;
import com.tmasuda.fc.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/account")
@Controller
public class AccountHandler {

    @Autowired
    private AccountCtrl accountCtrl;

    @Autowired
    private CategoryCtrl categoryCtrl;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public Account create(@RequestAttribute(value = "SNS_ID") String snsId) throws Exception {
        Account newAccount = accountCtrl.createAccount(snsId);

        if (categoryCtrl.findCategoriesByHouseHold(newAccount.houseHold).size() == 0) {
            categoryCtrl.createDefaultCategories(newAccount.houseHold);
        }

        return newAccount;
    }

}
