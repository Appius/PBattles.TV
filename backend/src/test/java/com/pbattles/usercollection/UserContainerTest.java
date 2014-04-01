package com.pbattles.usercollection;

import com.pbattles.entity.UserInfo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.List;

/**
 * Created by Nazar_Sheremeta on 3/25/14.
 */
public class UserContainerTest {

    private UserContainer container;

    @Before
    public void init() {
        container = new UserContainer();
    }

    @Test
    public void addIsNotFailing() {
        addUserInfoToContainer("");
    }

    @Test
    public void addIsNotFailingOnNull() {
        container.addUser(null);
    }

    @Test
    public void addIsNotFailingOnRepeatableAdd() {
        addUserInfoToContainer("", "");
    }

    @Test
    public void getAllReturnOnNoElements() {
        List result = container.getAll();
        assertListSize(result, 0);
    }

    @Test
    public void getAllReturnOnOneElement(){
        addUserInfoToContainer("SESSIONID");
        List result = container.getAll();
        assertListSize(result, 1);
    }

    @Test
    public void getAllReturnOnLotsOfElements(){
        addUserInfoToContainer("SESSIONID","SESSIONID2","SESSIONID3","SESSIONID4","SESSIONID5");
        List result = container.getAll();
        assertListSize(result, 5);
    }

    @Test
    public void getAllReturnOnAddNull(){
        container.addUser(null);
        List result = container.getAll();
        assertListSize(result, 0);
    }

    @Test
    public void getAllReturnOnLotsOfElementsAndNull(){
        addUserInfoToContainer("SESSIONID","SESSIONID2","SESSIONID3","SESSIONID4","SESSIONID5");
        container.addUser(null);
        List result = container.getAll();
        assertListSize(result, 5);
    }

    @Test
    public void removeUserOnNotExisting(){
        removeUserInfoFomContainer("SESSIONID");
        List result = container.getAll();
        assertListSize(result, 0);
    }

    @Test
    public void removeUserOnExistingElement(){
        addUserInfoToContainer("SESSIONID");
        removeUserInfoFomContainer("SESSIONID");
        List result = container.getAll();
        assertListSize(result, 0);
    }

    @Test
    public void removeUserOnExistingElements(){
        addUserInfoToContainer("SESSIONID","SESSIONID2");
        removeUserInfoFomContainer("SESSIONID");
        List result = container.getAll();
        assertListSize(result, 1);
    }

    @Test
    public void removeUserOnNotExistingElements(){
        addUserInfoToContainer("SESSIONID","SESSIONID2");
        removeUserInfoFomContainer("SESSIONID3");
        List result = container.getAll();
        assertListSize(result, 2);
    }

    @Test
    public void removeNullOnExistingElements(){
        addUserInfoToContainer("SESSIONID","SESSIONID2");
        container.removeUser(null);
        List result = container.getAll();
        assertListSize(result, 2);
    }

    // CHANGE LIST TO SET, ADD UNIQUALITY. check for remove null

    private void assertListSize(List result, int expectedSize) {
        int realSize = result.size();
        assertEquals(expectedSize, realSize);
    }

    private void removeUserInfoFomContainer(String... sessionIds) {
        for (String sessionId : sessionIds) {
            UserInfo info = buildUserInfo(sessionId);
            container.removeUser(info);
        }
    }

    private void addUserInfoToContainer(String... sessionIds) {
        for (String sessionId : sessionIds) {
            UserInfo info = buildUserInfo(sessionId);
            container.addUser(info);
        }
    }

    private UserInfo buildUserInfo(String sessionId) {
        UserInfo info = new UserInfo();
        info.setSessionId(sessionId);
        return info;
    }
}
