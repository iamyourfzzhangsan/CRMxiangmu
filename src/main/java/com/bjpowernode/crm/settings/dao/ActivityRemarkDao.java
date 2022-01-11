package com.bjpowernode.crm.settings.dao;

import com.bjpowernode.crm.workbench.domain.ActivityRemark;

import java.util.List;

public interface ActivityRemarkDao {
    int getCountByAids(String[] ids);

    int deleteByAids(String[] ids);

    List<ActivityRemark> getRemarkListById(String activityId);

    int deleteById(String id);

    int saveRemark(ActivityRemark ar);
}
