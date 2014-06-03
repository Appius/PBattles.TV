package com.pbattles.bl;

import com.pbattles.entity.Account;
import com.pbattles.entity.LoginInfoDTO;
import com.pbattles.entity.RegistrationInfo;
import org.springframework.stereotype.Component;

/**
 * Created by Nazar_Sheremeta on 5/29/14.
 */
@Component
public class AccountBL implements IAccountBL {
    @Override
    public boolean accountWithGivenLoginExists(String name) {
        return false;
    }

    @Override
    public boolean registerAccount(RegistrationInfo info) {
        return false;
    }

    @Override
    public Account getAccountByNameAndPassword(LoginInfoDTO info) {
        return null;
    }
}
