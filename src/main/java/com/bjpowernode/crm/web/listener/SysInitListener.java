package com.bjpowernode.crm.web.listener;

import com.bjpowernode.crm.settings.domain.DicValue;
import com.bjpowernode.crm.settings.service.DicService;
import com.bjpowernode.crm.settings.service.impl.DicServiceImpl;
import com.bjpowernode.crm.utils.ServiceFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SysInitListener implements ServletContextListener {
//    该方法是用来监听上下文域对象的方方法的。当服务器启动，上下文域创建完毕后，马上执行该方法
//    even：该方法可以取得监听的对象
//    监听什么对象，就可以通过该方法取得什么对象
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("上下文域对象创建了");
        System.out.println("服务器缓存处理数据字典开始");
        ServletContext application = event.getServletContext();

        DicService ds = (DicService) ServiceFactory.getService(new DicServiceImpl());

        Map<String, List<DicValue>> map = ds.getAll();
//        将Map解析为上下文域对象中保存的键值对
        Set<String> set = map.keySet();
        for (String key:set){
            application.setAttribute(key,map.get(key));
        }
        System.out.println("服务器缓存处理数据字典结束");
//        application.setAttribute();

    }
}
