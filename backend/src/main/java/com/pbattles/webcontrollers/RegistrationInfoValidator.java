package com.pbattles.webcontrollers;

import com.pbattles.bl.IAccountBL;
import com.pbattles.entity.RegistrationInfo;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Nazar_Sheremeta on 5/29/14.
 */
public class RegistrationInfoValidator implements Validator {

    private IAccountBL accountBL;

    @Override
    public boolean supports(Class<?> aClass) {
        return RegistrationInfo.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        RegistrationInfo info = (RegistrationInfo) o;
        validateForAlreadyExistingUser(info,errors);
        validateForMatchingPasswords(info,errors);
    }

    private void validateForMatchingPasswords(RegistrationInfo info,Errors e) {
        if(!info.getPassword().equals(info.getPasswordRepeat())){
            e.rejectValue("registrationInfo","Password does not match");
        }
    }

    private void validateForAlreadyExistingUser(RegistrationInfo info,Errors e) {
       if(accountBL.accountWithGivenLoginExists(info.getLogin())){
         e.rejectValue("registrationInfo","User with this login already exist");
        }

    }
}
