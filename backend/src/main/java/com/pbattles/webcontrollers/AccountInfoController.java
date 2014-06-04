package com.pbattles.webcontrollers;

import com.pbattles.bl.IAccountBL;
import com.pbattles.entity.Account;
import com.pbattles.entity.LoginInfoDTO;
import com.pbattles.entity.RegistrationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Nazar_Sheremeta on 5/29/14.
 */

@Controller
public class AccountInfoController {

    @Autowired
    private Validator accountValidator;

    @Autowired
    private IAccountBL accountBL;

    @RequestMapping(value="register", method = RequestMethod.POST)
    public void registerAccount(@ModelAttribute RegistrationInfo info,BindingResult result,Model m){
        if(validateInput(info,result)){
            accountBL.registerAccount(info);
        }
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(@ModelAttribute LoginInfoDTO loginInfo,HttpServletResponse response, Model m){
        Account account = accountBL.getAccountByNameAndPassword(loginInfo);
        System.out.println("Login DTO: "+loginInfo);
        System.out.println("Account found: "+account);
        if(account == null){
            //handle error
        } else {
            //notify ok
           response.addCookie(new Cookie("account",account.getName()));
        }
        return "index";
    }

    @RequestMapping(value="/home")
    public void fillModelContainer(@ModelAttribute Account account,Model m){
        m.addAttribute("registrationInfo", new RegistrationInfo());
        m.addAttribute("loginInfo", new LoginInfoDTO());
    }

    /*

        FORM LOGIC ON LOGIN\LOGOUT
        BALANCER
     */
    private boolean validateInput(RegistrationInfo info,BindingResult result) {
        accountValidator.validate(info, result);
        System.out.println("Validation start!");
        if(result.hasErrors()){
            System.out.println("Validation fail!");
            return false;
        } else{
            System.out.println("Okay");
            return true;
        }
    }
}
