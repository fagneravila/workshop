package com.fagner.workshop.repository;

import com.fagner.workshop.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UseRepository extends MongoRepository<User, String> {
}
