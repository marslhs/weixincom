package com.mars.common.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mars.common.control.utils.WeixinUtil;

@Controller
public class WexinControl {
    
    public static final Logger logger = LoggerFactory.getLogger(WexinControl.class);

    public static final String token = "HosenIsRight";

    @ResponseBody
    @RequestMapping("/verify")
    public long verifyWeixin(HttpServletRequest request, HttpServletResponse response) {
        String signature = request.getParameter("signature");
        String echostr = request.getParameter("echostr");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        if (WeixinUtil.isFromWeixin(timestamp, nonce, token, signature)) {
            logger.info("verify:" + echostr);
            return Long.parseLong(echostr);
        }
        return 0;
    }
    
    @RequestMapping("/dingshui")
    public ModelAndView orderWater(HttpServletRequest request, HttpServletResponse response) {
    	 ModelAndView mv = new ModelAndView();  
         mv.addObject("message", "Hello World!");  
         mv.setViewName("dingshui");  
         return mv;  
    }
}
