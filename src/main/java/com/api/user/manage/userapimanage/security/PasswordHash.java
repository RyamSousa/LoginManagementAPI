package com.api.user.manage.userapimanage.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class PasswordHash {

    public static String passwordToHash(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        // Cria algoritmo hash
        MessageDigest hashAlgoritm = MessageDigest.getInstance("SHA-256");

        // Cria a senah hash
        byte updateArray[] = hashAlgoritm.digest(password.getBytes("UTF-8"));

        // Cria string que irá receber o formato Hexadecimal
        StringBuilder newString = new StringBuilder();

        // Cria a mascara hexadecimal
        for (byte charactere: updateArray) {
            newString.append(String.format("%02X", 0xFF & charactere));
        }

        String passwordHash = newString.toString();

        return passwordHash;
    }

}
