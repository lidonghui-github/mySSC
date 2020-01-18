package cn.hd.utils;

import cn.hd.common.CommonService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

public class CommonServiceUtil implements CommonService {
    Logger logger= Logger.getLogger(CommonServiceUtil.class);
    @Override
    public boolean checkSession(HttpSession session) {
        if (session.getAttribute("username") == null) {
            return false;
        }
        return true;
    }

    public void methodBefore(){
        logger.error("目标方法执行前执行了此方法。。。。"+DateUtil.getCurrentDateTime());
        System.out.println("目标方法执行前执行了此方法。。。。"+DateUtil.getCurrentDateTime());
    }

    public void methodAfter(){
        logger.error("目标方法执行后执行了此方法。。。。"+DateUtil.getCurrentDateTime());
        System.out.println("目标方法执行后执行了此方法。。。。"+DateUtil.getCurrentDateTime());
    }
}
