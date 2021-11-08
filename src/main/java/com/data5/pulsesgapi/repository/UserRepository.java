package com.data5.pulsesgapi.repository;

import com.data5.pulsesgapi.document.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

   List<User> findAllByEmailLike(String email);


}
