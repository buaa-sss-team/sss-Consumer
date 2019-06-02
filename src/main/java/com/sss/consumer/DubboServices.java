package com.sss.consumer;

import com.sss.interfaces.IDBService;
import com.sss.interfaces.dao.IHDBdao;

public class DubboServices {
    public IDBService dbService;
    public IHDBdao hdbDAO;
    public final static DubboServices INSTANCE=new DubboServices();

}
