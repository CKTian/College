package com.dqs.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * �����֤tokenֵ
 * @author ���첩
 * 2018��1��10��
 */
public class SecurityUtil {
	/**
	 * 
	 * @Title:  �����֤tokenֵ
	 * @Description: ���ض���ĳ��������һmap�����ݽṹ���룬 �����ֵ��������Ժ����md5����,32λСд���ܣ� 
	 * @author ���첩
	 * @param @param srcData Լ����������token�Ĳ��� 
	 * @param @return
	 * @param @throws PharosException      
	 * @return String
	 */
	 public static String authentication(Map<String , Object > srcData){  
	        //���򣬸���keyde �ֵ�������  
	      /*  if(null == srcData){  
	            throw new PharosException("�������Ϊ��");  
	        }  */
	        List<Map.Entry<String,Object>> list = new ArrayList<Map.Entry<String,Object>>(srcData.entrySet());  
	        Collections.sort(list, new Comparator<Map.Entry<String, Object>>(){  
	            //��������  
	            public int compare(Entry<String,Object> o1, Entry<String,Object> o2){  
	                return o1.getKey().compareTo(o2.getKey());  
	            }  
	        });  
	          
	        StringBuffer srcSb = new StringBuffer();  
	        for(Map.Entry<String , Object>srcAtom : list){  
	            srcSb.append(String.valueOf(srcAtom.getValue()));  
	        }  
	        System.out.println("�����֤����ǰ�ַ�����"+srcSb.toString());  
	        //����token  
	        String token = MD5Util.md5(srcSb.toString());  
	        System.out.println(token);//for test  
	        return token;  
	    }  
	      
}
