package com.dqs.util;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import com.dqs.entity.User;

import java.security.Key;
import java.util.Date;
import io.jsonwebtoken.*;
/**
 * 
 * 生成token
 * @author 王天博
 * 2018年1月12日
 */
public class JWTUtil {
	public static String createJWT(User user, long ttlMillis) {
		
		//The JWT signature algorithm we will be using to sign the token
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		 
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		 
		//We will sign our JWT with our ApiKey secret
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("wtbwtb");
		
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
		 
		  //Let's set the JWT Claims
		JwtBuilder builder = Jwts.builder().claim("account",user.getAccount())
										.claim("password", user.getPassword())
										.claim("role_id", user.getrole_id())
		                                .signWith(signatureAlgorithm, signingKey);
		 
		//if it has been specified, let's add the expiration
		if (ttlMillis >= 0) {
		    long expMillis = nowMillis + ttlMillis;
		    Date exp = new Date(expMillis);
		    builder.setExpiration(exp);
		}
		 
		//Builds the JWT and serializes it to a compact, URL-safe string
		return builder.compact();
	}
}
