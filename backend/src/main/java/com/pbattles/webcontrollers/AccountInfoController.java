package com.pbattles.webcontrollers;

import com.pbattles.entity.RegistrationInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Nazar_Sheremeta on 5/29/14.
 */

@Controller
public class AccountInfoController {

    private Validator accountValidator;

    @RequestMapping(value="register", method = RequestMethod.POST)
    public String registerAccount(@ModelAttribute RegistrationInfo info,BindingResult result,Model m){
        validateInput(info,result);
        return "dummy";
    }

    private void validateInput(RegistrationInfo info,BindingResult result) {
        accountValidator.validate(info,result);
        //TO FINISH LATER
    }

    @RequestMapping(value="/home")
    public void fillModelContainer(Model m){
        m.addAttribute("registrationInfo",new RegistrationInfo());
    }
}
