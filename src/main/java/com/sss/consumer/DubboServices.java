package com.sss.consumer;

import com.sss.interfaces.IDBService;
import com.sss.interfaces.dao.IHDBdao;
import com.sss.interfaces.service.Authorization;

public class DubboServices {
    public IDBService dbService;
    public IHDBdao hdbDAO;
    public Authorization authorization;
    public final static DubboServices INSTANCE=new DubboServices();

}
