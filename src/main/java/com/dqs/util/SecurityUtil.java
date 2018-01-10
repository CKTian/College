package com.dqs.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * 身份验证token值
 * @author 王天博
 * 2018年1月10日
 */
public class SecurityUtil {
	/**
	 * 
	 * @Title:  身份验证token值
	 * @Description: 将特定的某几个参数一map的数据结构传入， 进行字典序排序以后进行md5加密,32位小写加密； 
	 * @author 王天博
	 * @param @param srcData 约定用来计算token的参数 
	 * @param @return
	 * @param @throws PharosException      
	 * @return String
	 */
	 public static String authentication(Map<String , Object > srcData){  
	        //排序，根据keyde 字典序排序  
	      /*  if(null == srcData){  
	            throw new PharosException("传入参数为空");  
	        }  */
	        List<Map.Entry<String,Object>> list = new ArrayList<Map.Entry<String,Object>>(srcData.entrySet());  
	        Collections.sort(list, new Comparator<Map.Entry<String, Object>>(){  
	            //升序排序  
	            public int compare(Entry<String,Object> o1, Entry<String,Object> o2){  
	                return o1.getKey().compareTo(o2.getKey());  
	            }  
	        });  
	          
	        StringBuffer srcSb = new StringBuffer();  
	        for(Map.Entry<String , Object>srcAtom : list){  
	            srcSb.append(String.valueOf(srcAtom.getValue()));  
	        }  
	        System.out.println("身份验证加密前字符串："+srcSb.toString());  
	        //计算token  
	        String token = MD5Util.md5(srcSb.toString());  
	        System.out.println(token);//for test  
	        return token;  
	    }  
	      
}
