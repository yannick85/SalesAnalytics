/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.salesbetou.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Yannick
 */
public class CryptUtil {
    public static String md5 (String input) {
        byte[] uniqueKey = input.getBytes();
        byte[] hash = null;
        try {
            hash = MessageDigest.getInstance("MD5").digest(uniqueKey);
        } catch (NoSuchAlgorithmException e) {
            throw new Error("no MD5 support in this VM");
        }
        StringBuilder hashString = new StringBuilder();
        for ( int i = 0; i < hash.length; ++i ) {
            String hex = Integer.toHexString(hash[i]);
            if ( hex.length() == 1 ) {
                hashString.append('0');
                hashString.append(hex.charAt(hex.length()-1));
            } else {
                hashString.append(hex.substring(hex.length()-2));
            }
        }
        return hashString.toString(); 
    }
}
