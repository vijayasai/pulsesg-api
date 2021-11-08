package com.data5.pulsesgapi.model;

import com.data5.pulsesgapi.model.enums.StatusEnum;
import lombok.Data;

import java.util.List;

@Data
public class Task {
    public String _id;
    public String _type;
    public StatusEnum status;
    public String description;
    public int cycleId;
    public String orgId;
    public String tenantId;
    public List<CatalogMetric> metricIds;
    public String metricType;
    public List<String> assignedUsers;
    public List<String> assignedRoles;
    public String lockedBy;
    public String lockedDate;
    public String expectedDate;
    public String createdBy;
    public String createdDate;
    public String updatedBy;
    public String updatedDate;
    public boolean isActive;
    public String approval_status;
    public String approvedBy;
    public List<String> approvalAssignedUsers;
    public List<String> approvalAssignedRoles;
    public String approval_comment;
    public List<String> notifyUsers;
    public String link;
}
