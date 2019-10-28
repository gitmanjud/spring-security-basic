package com.abc.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.abc.entity.UserEntity;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {
	
	UserEntity findByUserName(String name);

}
