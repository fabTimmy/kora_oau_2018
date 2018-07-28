import java.util.ArrayList;
import com.google.gson.GsonBuilder;

public class mainClass {
    /***
     * main block chain class, responsible for creating blocks for workers
     */
public static ArrayList<Block> blockchain = new ArrayList<Block>(); // array list containing all blockchains
	public static int difficulty = 10;
      static detailsGen dg = new detailsGen(); 
      static GUI g = new GUI();
	public static void main(String[] args) {	
		//add our blocks to the blockchain ArrayList:
		
		System.out.println("\nBlockchain is Valid: " + isChainValid()); 
                
                
		blockchain.add(new Block(g.getMyData(), "0"));
		System.out.println("Trying to Mine block 1... ");
		blockchain.get(0).mineBlock(difficulty);
		
		blockchain.add(new Block(g.getMyData(),blockchain.get(blockchain.size()-1).hash));
		System.out.println("Trying to Mine block 2... ");
		blockchain.get(1).mineBlock(difficulty);
		
		blockchain.add(new Block(g.getMyData(),blockchain.get(blockchain.size()-1).hash));
		System.out.println("Trying to Mine block 3... ");
		blockchain.get(2).mineBlock(difficulty);	
		
		System.out.println("\nother list is : " + blockchain);
		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
		System.out.println("\nThe block chain: ");
		System.out.println(blockchainJson);
	}
/***
 * method to check validity of a new block
 * @return boolean valid or not
 */
        // check the validity of the chain 
        public static Boolean isChainValid() {
	Block currentBlock; 
		Block previousBlock;
		String hashTarget = new String(new char[difficulty]).replace('\0', '0');
		
		//loop through blockchain to check hashes:
		for(int i=1; i < blockchain.size(); i++) {
			currentBlock = blockchain.get(i);
			previousBlock = blockchain.get(i-1);
			//compare registered hash and calculated hash:
			if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
				System.out.println("Current Hashes not equal");			
				return false;
			}
			//compare previous hash and registered previous hash
			if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
				System.out.println("Previous Hashes not equal");
				return false;
			}
			//check if hash is solved
			if(!currentBlock.hash.substring( 0, difficulty).equals(hashTarget)) {
				System.out.println("This block hasn't been mined");
				return false;
			}
		}
return true;
}
        
	
}