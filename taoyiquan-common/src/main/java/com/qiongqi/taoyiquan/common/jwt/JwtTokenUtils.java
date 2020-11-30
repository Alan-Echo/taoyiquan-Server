package com.qiongqi.taoyiquan.common.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.*;

/**
 * @description: JWT工具类
 * @author: ※狗尾巴草
 * @date: 2020-11-14 0:07
 **/
public class JwtTokenUtils {

    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";

    public static final String SUBJECT = "淘壹券";

    public static final long EXPIRITION = 1000 * 24 * 60 * 60 * 7; // 7天
//    public static final long EXPIRITION = 1000*60*2 ; //10秒

    public static final String APPSECRET_KEY = "congge_secret";

    private static final String ROLE_CLAIMS = "rol";

    public static String generateJsonWebToken(Map map) {

        if(map.isEmpty()){
            return null;
        }

//        Map<String,Object> Rolmap = new HashMap<>();
//        Rolmap.put(ROLE_CLAIMS, "rol");

        String token = Jwts
                .builder()
                .setSubject(SUBJECT)
//                .setClaims(Rolmap)
                .claim("id", map.get("id"))
                .claim("account", map.get("account"))
                .claim("userName", map.get("userName"))
                .claim("auth",map.get("auth"))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRITION))
                .signWith(SignatureAlgorithm.HS256, APPSECRET_KEY).compact();
        return token;
    }

    /**
     * 生成token
     * @param username
     * @param role
     * @return
     */
    public static String createToken(String username,List<String> role) {
        String token = Jwts
                .builder()
                .setSubject(username)
                .claim(ROLE_CLAIMS,role)
                .claim("username",username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRITION))
                .signWith(SignatureAlgorithm.HS256, APPSECRET_KEY).compact();
        return token;
    }

    public static boolean checkJWT(String token) {
        try {
            final Claims claims = Jwts.parser().setSigningKey(APPSECRET_KEY).parseClaimsJws(token).getBody();
            return true;
        } catch (Exception e) {
//            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取用户名
     * @param token
     * @return
     */
    public static String getUsername(String token){
        Claims claims = Jwts.parser().setSigningKey(APPSECRET_KEY).parseClaimsJws(token).getBody();
        return claims.get("username").toString();
    }

    /**
     * 获取用户角色/权限
     * @param token
     * @return
     */
    public static List<String> getUserRole(String token){
        try {
            Claims claims = Jwts.parser().setSigningKey(APPSECRET_KEY).parseClaimsJws(token).getBody();
            List<String> o = (List<String>) claims.get(ROLE_CLAIMS);
            return o;
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 是否过期
     * @param token
     * @return
     */
    public static boolean isExpiration(String token){
        Claims claims = Jwts.parser().setSigningKey(APPSECRET_KEY).parseClaimsJws(token).getBody();
        return claims.getExpiration().before(new Date());
    }

//    public static void main(String[] args) {
//        String name = "acong";
//        String role = "rol";
//        String token = createToken(name,role);
//        System.out.println(token);
//
//        Claims claims = checkJWT(token);
//        System.out.println(claims.get("username"));
//
//        System.out.println(getUsername(token));
//        System.out.println(getUserRole(token));
//        System.out.println(isExpiration(token));
//
//    }


    /**
     * eyJhbGciOiJIUzI1NiJ9.
     * eyJzdWIiOiJjb25nZ2UiLCJpZCI6IjExMDExIiwibmFtZSI6Im51b3dlaXNpa2kiLCJpbWciOiJ3d3cudW9rby5jb20vMS5wbmciLCJpYXQiOjE1NTQ5OTI1NzksImV4cCI6MTU1NTU5NzM3OX0.
     * 6DJ9En-UBcTiMRldZeevJq3e1NxJgOWryUyim4_-tEE
     *
     * @param args
     */

	/*public static void main(String[] args) {

		Users user = new Users();
		user.setId("11011");
		user.setUserName("nuoweisiki");
		user.setFaceImage("www.uoko.com/1.png");
		String token = generateJsonWebToken(user);

		System.out.println(token);

		Claims claims = checkJWT(token);
		if (claims != null) {
			String id = claims.get("id").toString();
			String name = claims.get("name").toString();
			String img = claims.get("img").toString();

			String rol = claims.get("rol").toString();

			System.out.println("id:" + id);
			System.out.println("name:" + name);
			System.out.println("img:" + img);

			System.out.println("rol:" + rol);



		}

	}*/

}

