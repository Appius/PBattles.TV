package com.pbattles.dao;

import com.pbattles.entity.UserInfoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created with IntelliJ IDEA.
 * User: noflaxe
 * Date: 02.04.14
 * Time: 0:57
 * To change this template use File | Settings | File Templates.
 */
public interface UserInfoRepository extends MongoRepository<UserInfoEntity,Long>{

    public UserInfoEntity findByUserId(Long userId);
}
