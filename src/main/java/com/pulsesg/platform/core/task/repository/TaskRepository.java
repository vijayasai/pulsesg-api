package com.pulsesg.platform.core.task.repository;

import com.pulsesg.platform.core.task.exception.TaskException;
import com.pulsesg.platform.core.task.model.Task;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Vijayasai Kesanupalli
 */
@Repository
public interface TaskRepository extends CouchbaseRepository<Task, Object> {

    List<Task> findAllByOrgIdLike(String orgId) throws TaskException;

    @Query("UPDATE `generatedata1`.`_default`.`_default` data set approval_comment=$2, updatedBy=$3, " +
            "updatedDate=NOW_MILLIS() where meta().id=$1 RETURNING *")
    Task updateTaskSetApprovalCommentForId(String id, String approvalComment, String updatedBy) throws TaskException;

    @Query("UPDATE `generatedata`.`_default`.`_default` data set assignedUsers=$2, updatedBy=$3, updatedDate=NOW_MILLIS() where meta().id=$1 RETURNING *")
    Task updateTaskSetUsersForId(String id, List<String> users, String updatedBy) throws TaskException;

    @Query("UPDATE `generatedata`.`_default`.`_default` data set status=$2, updatedBy=$3, updatedDate=NOW_MILLIS() where meta().id=$1 RETURNING *")
    Task updateTaskSetStatusForId(String id, String status, String updatedBy) throws TaskException;

    @Query("UPDATE `generatedata`.`_default`.`_default` data set isActive=$2, updatedBy=$3, updatedDate=NOW_MILLIS() where meta().id=$1 RETURNING *")
    Task updateTaskSetIsActiveForId(String id, boolean isActive, String updatedBy) throws TaskException;

    @Query("UPDATE `generatedata`.`_default`.`_default` data set lockedBy=$2, lockedDate=NOW_MILLIS(), updatedBy=$2, updatedDate=NOW_MILLIS() where meta().id=$1 RETURNING *")
    Task updateTaskSetLockForId(String id, String lockedBy) throws TaskException;
}
