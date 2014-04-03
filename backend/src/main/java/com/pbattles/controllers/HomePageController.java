package com.pbattles.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/**
 * Created by Nazar_Sheremeta on 4/3/14.
 */
@Controller
public class HomePageController {

  @RequestMapping(value = "/register",method = RequestMethod.POST)
  public String registerAndMoveToTheWaitingRoom(){
      // TODO: REGISTRATING LOGIC, read deferredResult and servlet 3.0 specification
      return "waitingRoomStub";
  }


  @RequestMapping(value="/home",method= RequestMethod.GET)
  public String moveToHomePage(){
      return "home";
  }
}
