package com.pbattles.platformTest;

import com.pbattles.db.dao.UserInfoDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: noflaxe
 * Date: 02.04.14
 * Time: 1:03
 * To change this template use File | Settings | File Templates.
 */


public class DbTest  {



    public static void main(String[] args) {
      ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
      UserInfoDao dao = (UserInfoDao)ctx.getBean("userInfoDao");
      System.out.println(dao.findById(1));
    }

}
