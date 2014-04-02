package com.pbattles.platformTest;

import com.pbattles.dao.UserInfoDao;
import com.pbattles.dao.UserInfoRepository;
import com.pbattles.entity.UserInfoEntity;
import com.pbattles.javaconfig.SpringMongoConfig;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.loader.MainMethodRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

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
