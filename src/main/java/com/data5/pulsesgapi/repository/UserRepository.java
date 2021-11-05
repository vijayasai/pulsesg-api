package com.data5.pulsesgapi.repository;

import com.data5.pulsesgapi.document.User;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CouchbaseRepository<User, String> {

   List<User> findAllByEmail(String email);
   List<User> findAll();
}
