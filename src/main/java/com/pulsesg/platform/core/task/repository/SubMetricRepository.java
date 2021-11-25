package com.pulsesg.platform.core.task.repository;

import com.pulsesg.platform.core.task.exception.SubMetricException;
import com.pulsesg.platform.core.task.model.SubMetric;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Varalakshmi Sravanthi Kavi
 */
@Repository
public interface SubMetricRepository extends CouchbaseRepository<SubMetric, String> {

    List<SubMetric> findAllByOrgIdLike(String orgId) throws SubMetricException;


}
