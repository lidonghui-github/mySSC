package cn.hd.utils;

import cn.hd.common.CommonService;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
@Component
public class CommonServiceUtil implements CommonService {
    @Override
    public boolean checkSession(HttpSession session) {
        if (session.getAttribute("username") == null) {
            return false;
        }
        return true;
    }
}
