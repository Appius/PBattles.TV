package com.pbattles.dao;

import com.pbattles.entity.UserInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * Created by Nazar_Sheremeta on 4/2/14.
 */
public class UserInfoDao implements IUserInfoDao {

    @Autowired
    private MongoOperations mongoTemplate;

    @Override
    public void insert(UserInfoEntity entity) {
        mongoTemplate.save(entity);
    }

    @Override
    public UserInfoEntity findById(Object id) {
        Query searchQuery = createSearchQueryByUserId(id);
        return mongoTemplate.findOne(searchQuery,UserInfoEntity.class); //TODO - remove hardcoded class value
    }

    @Override
    public void update(UserInfoEntity entity) {
        throw new UnsupportedOperationException("Not sure how to do this optimally yet");
    }

    @Override
    public void remove(UserInfoEntity entity) {
        Long id = entity.getUserId();
        Query searchQuery = createSearchQueryByUserId(id);
        mongoTemplate.remove(searchQuery,UserInfoEntity.class); // TODO - remove hardcoded class value
    }

    private Query createSearchQueryByUserId(Object id) {
        return new Query(Criteria.where("userId").is(id));
    }

    public void setMongoTemplate(MongoOperations mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
}
