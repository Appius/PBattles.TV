package com.pbattles.bl;

import com.pbattles.entity.Account;
import com.pbattles.entity.LoginInfoDTO;
import com.pbattles.entity.RegistrationInfo;

/**
 * Created by Nazar_Sheremeta on 5/29/14.
 */
public class AccountBL implements IAccountBL {
    @Override
    public boolean accountWithGivenLoginExists(String name) {
        return true;
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
