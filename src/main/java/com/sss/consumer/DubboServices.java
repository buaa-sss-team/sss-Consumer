package com.sss.consumer;

import com.sss.interfaces.IDBService;
import com.sss.interfaces.dao.IHDBdao;
import com.sss.interfaces.service.AuthorizationService;
import com.sss.interfaces.service.CheckService;
import com.sss.interfaces.service.InquireService;
import com.sss.interfaces.service.RequestService;

public class DubboServices {
    public IDBService dbService;
    public IHDBdao hdbDAO;
    public AuthorizationService authorization;
    public RequestService requestService;
    public CheckService checkService;
    public InquireService inquireService;
    public final static DubboServices INSTANCE=new DubboServices();

}
