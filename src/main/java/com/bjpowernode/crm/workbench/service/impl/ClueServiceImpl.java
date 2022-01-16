package com.bjpowernode.crm.workbench.service.impl;

import com.bjpowernode.crm.utils.SqlSessionUtil;
import com.bjpowernode.crm.utils.UUIDUtil;
import com.bjpowernode.crm.workbench.dao.ClueActivityRelationDao;
import com.bjpowernode.crm.workbench.dao.ClueDao;
import com.bjpowernode.crm.workbench.domain.Clue;
import com.bjpowernode.crm.workbench.domain.ClueActivityRelation;
import com.bjpowernode.crm.workbench.service.ClueService;

public class ClueServiceImpl implements ClueService {
    private ClueDao clueDao = SqlSessionUtil.getSqlSession().getMapper(ClueDao.class);
    private ClueActivityRelationDao clueActivityRelationDao = SqlSessionUtil.getSqlSession().getMapper(ClueActivityRelationDao.class);

    public boolean save(Clue c) {
        boolean flag = true;
        int count = clueDao.save(c);
        if (count!=1){
            flag=false;
        }
        return flag;
    }

    public Clue detail(String id) {
        Clue c = clueDao.detail(id);
        return c;
    }

    public boolean unbund(String id) {
        boolean flag = true;
        int count = clueActivityRelationDao.unbund(id);
        if (count!=1){
            flag = false;
        }
        return flag;
    }

    public boolean bund(String cid, String[] aids) {
        boolean flag = true;
        for (String aid:aids){
            ClueActivityRelation car= new ClueActivityRelation();
            car.setId(UUIDUtil.getUUID());
            car.setActivityId(aid);
            car.setClueId(cid);
//            添加关系表中的记录
            int count = clueActivityRelationDao.bund(car);
            if (count!=1){
                flag=false;
            }
        }
        return flag;
    }
}
