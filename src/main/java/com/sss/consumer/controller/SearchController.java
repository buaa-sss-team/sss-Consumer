package com.sss.consumer.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sss.consumer.DubboServices;
import javafx.util.Pair;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
public class SearchController extends CommonPageController{
    @RequestMapping(value = "/search")
    public ModelAndView get(ModelMap m, HttpSession session) throws ServletException, IOException {

        ModelAndView mv=super.get(m,"search",session);
        mv.addObject("info","输入关键词开始搜索");
        return mv;
    }
    @RequestMapping(value = "/search/{category}/{keyword}")
    public ModelAndView dosearch(ModelMap m, HttpSession session, @PathVariable String keyword, @PathVariable String category) throws ServletException, IOException {

        ModelAndView mv=super.get(m,"search",session);
//        List<Pair<String, List<Pair<String, Pair<String, String>>>>> limits = new LinkedList<Pair<String, List<Pair<String, Pair<String, String>>>>>();
//        LinkedList<Pair<String, Pair<String, String>>> fir=new LinkedList<Pair<String, Pair<String, String>>>();
//        fir.add(new Pair("instruction",new Pair("matchQuery","Machine")));
//        limits.add(new Pair("abstract",fir));
        if(keyword.length()==0)return mv;
        mv.addObject("category",category);
        mv.addObject("keyword",keyword);
        List<Map<String, Object>> res;
        String index="abstract";
        Gson gson=new Gson();
        if(category.equals("expert")) {
            index = "name";
            res= DubboServices.INSTANCE.esService.FuzzyQuery(category, index, keyword, 100);
            for (int i=0;i<res.size();i++){
                String org="";
                try{
                    org=((JsonArray)gson.fromJson((String)res.get(i).get("orgs"), JsonArray.class)).get(0).getAsString();
                }catch (Exception e){
                    org="";
                }
                res.get(i).put("org",org);
                int pubCount=0;

                try{
                    pubCount=((JsonArray)gson.fromJson((String)res.get(i).get("pubid"), JsonArray.class)).size();
                }catch (Exception e){
                    org="";
                }
                res.get(i).put("pubCount",pubCount);

            }
        }else
            res=DubboServices.INSTANCE.esService.FuzzyQueryString(category,keyword,100);
        if (res == null) {
            mv.addObject("info","无查询结果");
        }else{
            mv.addObject("info","");
            mv.addObject("res",res);
        }
        return mv;
    }






}
