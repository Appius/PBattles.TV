package com.pbattles.platformTest;

import com.pbattles.dao.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.loader.MainMethodRunner;

/**
 * Created with IntelliJ IDEA.
 * User: noflaxe
 * Date: 02.04.14
 * Time: 1:03
 * To change this template use File | Settings | File Templates.
 */
public class DbTest {

    @Autowired
    private UserInfoRepository repository;

    public static void main(String[] args) {
        MainMethodRunner runner = new MainMethodRunner("com.pbattles.platformTest.DbTest",args);
        runner.run();       //exception is thrown, to finish later
    }

    public void run(){

    }
}
