package com.pbattles.webcontrollers;


import com.pbattles.entity.Room;
import com.pbattles.entity.UserInfo;
import com.pbattles.response.ResponseHandler;
import com.pbattles.usercollection.IUserContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Random;


/**
 * Created by Nazar_Sheremeta on 4/3/14.
 */
@Controller
public class HomePageController {

    /*
        METHODS AND CONTROLLER WRITEN FOR DEMO PURPOSES, HARD TIGHT COUPLING AND POLLING IN CODE BELOW.
        REPLACE WHEN STABLE WEB VIEW IS CREATED
     */
    @RequestMapping(value="/home", method = RequestMethod.GET)
    public String redirectToHome(){
        return "index";
    }

    @Autowired
    private IUserContainer container;

    @Qualifier("webViewReponseHandler")
    @Autowired
    private ResponseHandler responseHandler;

/*
 * TODO: RETURN METHOD TO POST ONLY, GET SUPPORT TURNED ON ONLY FOR DEMO PURPOSES
 */
    @RequestMapping(value = "findPartners"/*, method = RequestMethod.POST*/)
    public String registerAndMoveToTheWaitingRoom(Model model) throws InterruptedException {
        Long randomId = new Random().nextLong();
        model.addAttribute("userId", randomId);
        addUserInfoToContainer(randomId);
        Room chosenRoom = responseHandler.delivedRoomByUserId(randomId);
        while(chosenRoom == null){
            Thread.sleep(1000L);
            chosenRoom = responseHandler.delivedRoomByUserId(randomId);
            System.out.println("Still waiting.... ");
        }
        model.addAttribute("roomMembers",chosenRoom.getCurrentUsers());
        return "room";
    }

    private void addUserInfoToContainer(Long randomId) {
        UserInfo userInfo = new UserInfo();
        userInfo.setAccountName("asdasdasd");
        userInfo.setSessionId(randomId);
        userInfo.setUserId(randomId);
        container.addUser(userInfo);
    }


    public void setContainer(IUserContainer container) {
        this.container = container;
    }

    public void setResponseHandler(ResponseHandler responseHandler) {
        this.responseHandler = responseHandler;
    }
}
