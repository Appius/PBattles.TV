package com.pbattles.webcontrollers;

import com.pbattles.entity.RegistrationInfo;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private Validator accountValidator;

    @RequestMapping(value="register", method = RequestMethod.GET)
    public String registerAccount(@ModelAttribute RegistrationInfo info,BindingResult result,Model m){
        validateInput(info,result);
        return "dummy";
    }

    /*
        TODO: FORM MAPPING
        DB CONNECTION
        FORM LOGIC ON LOGIN\LOGOUT
        COCKIES
     */
    private void validateInput(RegistrationInfo info,BindingResult result) {
        accountValidator.validate(info,result);
        System.out.println("Validation start!");
        if(result.hasErrors()){
            System.out.println("Validation fail!");
        } else{
            System.out.println("Okay");
        }
    }

    @RequestMapping(value="/home")
    public void fillModelContainer(Model m){
        m.addAttribute("registrationInfo",new RegistrationInfo());
    }
}
