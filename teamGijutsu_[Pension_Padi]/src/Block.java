
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Oluwaseun
 */
public class Block {
    public String hash;
    public int nonce;
           
	public String previousHash;
	private List<String> data; //our data is all the details of the worker whose block is to be created 
	private long timeStamp; //as number of milliseconds since 1/1/1970.

	//Block Constructor.
	public Block(List<String> data,String previousHash ) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
                this.hash = this.calculateHash(); //Making sure we do this after we set the other values.
                
                
}
        public String calculateHash() {
	String calculatedhash = StringUtil.applySha256(previousHash + Long.toString(timeStamp) + data.toArray() );
	return calculatedhash;
}
        public void mineBlock(int difficulty) {
		String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0" 
		while(!hash.substring( 0, difficulty).equals(target)) {
			nonce ++;
			hash = calculateHash();
		}
		System.out.println("Block Mined!!! : " + hash);
}
        
}
