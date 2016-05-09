package com.mars.common.control.utils;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


public class WeixinVerify {
    /**
     * 校验微信的签名。
     * @param timestamp
     * @param nonce
     * @param token
     * @param signature
     * @return
     */
    public static boolean isFromWeixin(String timestamp, String nonce, String token, String signature){
        Set<String> weixinParamSet = new TreeSet<String>();
        weixinParamSet.add(token);
        weixinParamSet.add(nonce);
        weixinParamSet.add(timestamp);
        
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = weixinParamSet.iterator();
        while(it.hasNext()){
            sb.append(it.next());
        }
        String sigCal = Tools.sha1Hex(sb.toString());
        if(signature.equals(sigCal)){
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        String signature="05ab0b1910c2de31cc26b3b41d454ae41f00a4c2";
        String echostr="763388167271472026";
        String        timestamp="1461768832";
        String nonce="2074281942";
        String token = "HosenIsRight";
        System.out.println(isFromWeixin(timestamp, nonce, token, signature));
//        System.out.println(getSHA1(token, timestamp, nonce));
    }

}
