package com.dqs.util;

import java.util.UUID;
/**
 * 
 * 生成uuid
 * @author 王天博
 * 2018年1月22日
 */
public class CreateUUID {
	public static String getUUID(){
        UUID uuid=UUID.randomUUID();
        String str = uuid.toString(); 
        String uuidStr=str.replace("-", "");
        return uuidStr;
      }
}
