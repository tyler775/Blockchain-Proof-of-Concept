/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicblockchain;

import java.util.*;

/**
 *
 * @author Tyler McFadden
 */
public class BasicBlockchain {
    //Private declaration of number representing level of difficulty. 

    private int diff;
    //Private declaration of ArrayList holding blocks in blockchain
    private ArrayList<Block> bchain;
    //Use constructor to create a blockchain

    public BasicBlockchain() {
        //Initializes ArrayList holding blocks in blockchain
        bchain = new ArrayList<Block>();
        //Statement below adds first block of blockchain, 
        //a.k.a. the Genesis Block.
        bchain.add(new Block(0, "Genesis Block"));
        //Sets current level of difficulty
        diff = 5;

    }

    /**
     * @param args the command line arguments
     * Creates block chain for testing and allows testers to add block
     * or Wallet (still in development, currently produces public and private
     * addresses.
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BasicBlockchain c12 = new BasicBlockchain();
        c12.addablock(new Block(1, "Block 1 Data"));
        c12.addablock(new Block(2, "Block 2 Data"));
        c12.addablock(new Block(3, "Block 3 Data"));
        c12.addablock(new Block(4, "Block 4 Data"));
        //Wallet t0 = new Wallet();
    }
//Method adds block to the blockchain and provides chance to mine the new block
    public void addablock(Block bn) {
        bn.blasthash = getlastblock().getbhash();
        bn.miner(diff);
        bchain.add(bn);
    }
//Gets lastblock (or current block) in the blockchain
    private Block getlastblock() {
        return bchain.get(bchain.size() - 1);
    }
//Method for lowering difficulty within program
    private int sub_diff(int d0) {
        int da = 0;
        da = diff - d0;
        if (da < 0) {
            da = 0;
        }
        return da;
    }
//Method for raising difficulty within program
    private int add_diff(int d0) {
        int da = 0;
        da = diff + d0;
        if (da < 0 || d0 < 0) {
            da = 0;
        }
        return da;
    }
}
