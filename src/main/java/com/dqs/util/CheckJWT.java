package com.dqs.util;
import javax.xml.bind.DatatypeConverter;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import java.lang.String;
/**
 * 
 * ����ǰ̨����ͷ��ȡ��token--���н���
 * @author ���첩
 * 2018��1��12��
 */
public class CheckJWT {
	public static Claims parseJWT(String jwt) {
		Claims claims = Jwts.parser()        
	   .setSigningKey(DatatypeConverter.parseBase64Binary("wtbwtb"))
	   .parseClaimsJws(jwt).getBody();
		//System.out.println("ID:"+claims.get("password"));
		//System.out.println("Issuer: " + claims.getIssuer());
		//System.out.println("Expiration: " + claims.getExpiration());
		return claims;
	}
	
}
