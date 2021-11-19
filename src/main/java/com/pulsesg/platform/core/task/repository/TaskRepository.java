package com.pulsesg.platform.core.task.repository;

import com.pulsesg.platform.core.task.model.Task;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Vijayasai Kesanupalli
 */
@Repository
public interface TaskRepository extends CouchbaseRepository<Task, String> {

    List<Task> findAllByOrgIdLike(String orgId);

}
