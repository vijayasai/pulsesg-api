package com.data5.pulsesgapi.repository;

import com.data5.pulsesgapi.model.Task;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CouchbaseRepository<Task, String> {

    List<Task> findAllByOrgIdsLike(String orgId);

}
