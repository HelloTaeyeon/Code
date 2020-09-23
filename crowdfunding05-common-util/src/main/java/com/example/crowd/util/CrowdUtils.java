package com.example.crowd.util;

import com.example.crowd.constants.CrowdConstant;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CrowdUtils {
    public static String md5(String resource){
        if(resource==null || resource.length()==0){
            throw  new RuntimeException(CrowdConstant.MESSAGE_STRING_INVALIABLE);
        }
        /*String algorithmName = "md5";
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName(algorithmName);
        credentialsMatcher.setHashIterations(1);*/
        String algorithm = "md5";
        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            byte[] input = resource.getBytes();
            byte[] output = digest.digest(input);
            int signum = 1;
            BigInteger bigInteger = new BigInteger(signum,output);
            int radix = 16;
            String encode = bigInteger.toString(radix).toUpperCase();
            return encode;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static boolean JudgeRequestType(HttpServletRequest request){
        String acceptHeader = request.getHeader("Accept");
        String xRequestedHeader = request.getHeader("X-Requested-With");
        return (acceptHeader!=null&&acceptHeader.contains("application/json")
                || (xRequestedHeader!=null&& xRequestedHeader.equals("XMLHttpRequest")));
    }
}
