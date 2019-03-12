/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicblockchain;

import java.security.*;
import java.security.spec.*;
import java.util.Random;

/**
 *
 * @author Tyler McFadden
 */
public class Wallet {

    /**
     * Public and private keys for Wallet of block chain
     */
    public PrivateKey prk;
    public PublicKey puk;
//Use constructor to create keys for Wallet

    public Wallet() {

        createkeys();
    }
//Method uses RSA encryption algorithm and random object to create a private key
    //and a public key for wallet

    public void createkeys() {
        try {
            String kPG0, random0;
            kPG0 = "RSA";
            //kPG1 = "Sun";
            random0 = "SHA1PRNG";

            KeyPairGenerator kPG = KeyPairGenerator.getInstance(kPG0);
            SecureRandom random;
            random = SecureRandom.getInstance(random0);
            // Initialize the key generator and generate a KeyPair
            kPG.initialize(1024, random);
            //initializes KeyPair Object
            KeyPair keyPair = kPG.generateKeyPair();
            // Set the public and private keys from the keyPair
            prk = keyPair.getPrivate();
            puk = keyPair.getPublic();
            System.out.println(prk);
            System.out.println(puk);
        } catch (Exception f) {
            throw new RuntimeException(f);
        }
  //Methods below to be completed later to complete Wallet class
        //public float getAmount(){};
        //public Transaction sendFunds (PublicKey receive, float sentamount){};
    }
}
