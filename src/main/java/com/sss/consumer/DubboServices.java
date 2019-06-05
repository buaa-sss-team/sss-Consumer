package com.sss.consumer;

import com.sss.interfaces.IDBService;
import com.sss.interfaces.IESService;
import com.sss.interfaces.dao.IHDBdao;
import com.sss.interfaces.service.*;

public class DubboServices {

    public IDBService dbService;
    public IHDBdao hdbDAO;/*
    public AuthorizationService authorization;
    public RequestService requestService;
    public CheckService checkService;
    public InquireService inquireService;*/
    public IESService esService;
    public CommonService commonService;
    public final static DubboServices INSTANCE=new DubboServices();

}
