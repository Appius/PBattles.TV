package com.pbattles.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;


/**
 * Created by Nazar_Sheremeta on 4/3/14.
 */
@Controller(value="/home")
public class HomePageController {

  @RequestMapping(method = RequestMethod.POST,produces = "text/plain")
  @ResponseBody
  public DeferredResult<String> registerAndMoveToTheWaitingRoom() throws InterruptedException {
    final DeferredResult result = new DeferredResult(1000L);
      result.setResult("123");
      System.out.println("wat");
      return result;
  }


  @RequestMapping(method= RequestMethod.GET)
  public String moveToHomePage(){
      return "home";
  }



    private String getStubValue() throws InterruptedException {
        Thread.sleep(10*1000L);
        return "waitingRoomStub";
    }
}
