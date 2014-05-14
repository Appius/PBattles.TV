package com.pbattles.webcontrollers;


import com.pbattles.entity.Room;
import com.pbattles.entity.UserInfo;
import com.pbattles.response.ResponseHandler;
import com.pbattles.roomlogic.RandomRoomService;
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

    @Autowired
    private IUserContainer container;

    @Qualifier("webViewReponseHandler")
    @Autowired
    private ResponseHandler responseHandler;

    @Autowired
    private RandomRoomService roomService;

    @RequestMapping(value="/home", method = RequestMethod.GET)
    public String redirectToHome(){
        return "index";
    }

    @RequestMapping(value = "room", method = RequestMethod.GET)
    public String registerAndMoveToTheWaitingRoom(Model model) throws InterruptedException {
        Room room = roomService.getRandomRoom();
        model.addAttribute("room",room);
        return "room";
    }


    public void setContainer(IUserContainer container) {
        this.container = container;
    }

    public void setResponseHandler(ResponseHandler responseHandler) {
        this.responseHandler = responseHandler;
    }
}
