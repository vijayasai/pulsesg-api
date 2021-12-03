package com.pulsesg.platform.core.task.repository;

import com.pulsesg.platform.core.task.exception.TaskException;
import com.pulsesg.platform.core.task.model.SubmittedMetrics;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Vijayasai Kesanupalli
 */
@Repository
public interface SubmittedMetricsRepository extends CouchbaseRepository<SubmittedMetrics, String> {

    @Query("select meta(a).id _id, a.*, meta(t).id _tid, t.*, s.*, d.*\n" +
            "from `masterdata` a\n" +
            "join masterdata t on meta(t).id=a.standardIndustryTopic\n" +
            "join masterdata s on meta(s).id=t.standards[0]\n" +
            "join generatedata d on d.metricid=a.metricId\n" +
            "where d.cycleId=$1 and d.orgId=$2\n" +
            "and d.cycleId in ( select raw max(cycleId) from generatedata dm where dm._class=\"com.pulsesg.platform.core.task.model.SubMetric\" and dm.orgId=$2 )")
    List<SubmittedMetrics> listTaskSubmittedMetricsByCycleIdOrgId(int cycleId, String orgId) throws TaskException;


    @Query("select meta(a).id _id, a.*, meta(t).id _tid, t.*, s.*, d.*\n" +
            "from `masterdata` a\n" +
            "join masterdata t on meta(t).id=a.standardIndustryTopic\n" +
            "join masterdata s on meta(s).id=t.standards[0]\n" +
            "join generatedata d on d.metricid=a.metricId\n" +
            "where d.orgId=$1\n" +
            "and d.cycleId in ( select raw max(cycleId) from generatedata dm where dm._class=\"com.pulsesg.platform.core.task.model.SubMetric\" and dm.orgId=$1 )")
    SubmittedMetrics aggregateTasksByOrdId(String orgId) throws TaskException;

    @Query("select meta(a).id _id, a.*, meta(t).id _tid, t.*, s.*, d.*\n" +
            "from `masterdata` a\n" +
            "join masterdata t on meta(t).id=a.standardIndustryTopic\n" +
            "join masterdata s on meta(s).id=t.standards[0]\n" +
            "join generatedata d on d.metricid=a.metricId\n" +
            "where d.cycleId=$1 \n" +
            "and d.orgId in ( select raw max(orgId) from generatedata dm where dm._class=\"com.pulsesg.platform.core.task.model.SubMetric\" and dm.cycleId=$1 )")
    List<SubmittedMetrics> listTaskSubmittedMetricsByCycleId(int cycleId) throws TaskException;


    @Query("select meta(a).id _id, a.*, meta(t).id _tid, t.*, s.*, d.*\n" +
            "from `masterdata` a\n" +
            "join masterdata t on meta(t).id=a.standardIndustryTopic\n" +
            "join masterdata s on meta(s).id=t.standards[0]\n" +
            "join generatedata d on d.metricid=a.metricId\n" +
            "where d.orgId=$1\n" +
            "and d.cycleId in ( select raw max(cycleId) from generatedata dm where dm._class=\"com.pulsesg.platform.core.task.model.SubMetric\" and dm.orgId=$1 )")
    List<SubmittedMetrics> listTaskSubmittedMetricsByOrgId(String orgId) throws TaskException;


}
