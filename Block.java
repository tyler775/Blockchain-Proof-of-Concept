/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicblockchain;

import java.security.*;
import java.security.MessageDigest;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tyler McFadden
 */
public class Block {

    private int bindex;
    private long bonce;
    private String bdata;
    private String bhash;
    private long bdate;
    public String blasthash;

    public Block(int indexenter, String dataenter) {
        bindex = indexenter;
        bdata = dataenter;
        bonce = -1;
        blasthash = "";
        bdate = new Date().getTime();
        bhash = calchash();
    }

    /**
     *
     * @return bhash, a.k.a hash in block
     */
    public String getbhash() {

        return bhash;

    }

    //Method containing algorithm for mining the blockchain with input integer
    //diff used to determine difficulty of mining process (larger number = more
    //difficulty)
    public void miner(int diff) {

        String a1;
        a1 = new String(new char[diff]).replace('\0', '0');
        while (!bhash.substring(0, diff).equals(a1)) {
            bonce = bonce + 1;
            bhash = calchash();
            //System.out.println(bhash);

        }
        String a = "Mining complete of block:" + bhash;
        System.out.println(a);

    }
//Turns values of a blockchain into a hash using SHA-256 encryption

    private String calchash() {
        String a0 = String.valueOf(bindex);
        a0 += String.valueOf(bdate);
        a0 += bdata;
        a0 += String.valueOf(bonce);
        a0 += blasthash;
        String a1;
        a1 = "";
        try {
            a1 = sha256(a0);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Block.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a1;

    }
//Method that turns string input into an encrypted hash using StringBuffer

    static String sha256(String in) throws NoSuchAlgorithmException {
        MessageDigest encrypt = MessageDigest.getInstance("SHA-256");
        byte[] encrypt0 = encrypt.digest(in.getBytes());
        StringBuffer a;
        String r0;
        a = new StringBuffer();
        int bytelength = encrypt0.length;
        int i = 0;
        while (i < bytelength) {
            a.append(Integer.toString((encrypt0[i] & 0xff) + 0x100, 16).substring(1));
            i++;
        }
        r0 = a.toString();
        return r0;
    }

}
