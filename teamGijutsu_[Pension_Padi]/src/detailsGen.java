/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.security.MessageDigest;
import java.util.*;

/**
 *
 * @author Timmy
 */
public class detailsGen {
/***class to set and get all user details 
 * 
 */
private String nameOfWorker;
private String contactOfWorker;
private String mailOfWorker;
private double salaryOfWorker;
private double gratuityOfWorker;
private int levelOfWorker;
private Date dateOfBirth;
private String genesisHash;
private String nextOfKin;

    
    //methods to get the details
    public String getName(){
       return this.nameOfWorker; 
    }
   public void setName(String name){
       this.nameOfWorker = name;
    }
    //methods to get the details
    public Date getDOB(){
       return this.dateOfBirth; 
    }
    public void setDOB(Date date){ 
        this.dateOfBirth = date;
    }
    //methods to get the details
    public String getNextOfKin(){
       return this.nameOfWorker; 
    }
    public void setNextOfKin(String nok){
       this.nextOfKin = nok; 
    }
    //methods to get the details
    public String getContact(){
       return this.contactOfWorker; 
    }
    public void setContact(String contact){
       this.contactOfWorker = contact; 
    }
    //methods to get the details
    public String getMail(){
       return this.mailOfWorker; 
    }
    public void setMail(String mail){
       this.mailOfWorker = mail; 
    }
    public void setSalary(double salary){
       this.salaryOfWorker = salary; 
    }
    //methods to get the details
    public double getSalary(){
       return this.salaryOfWorker; 
    }
    
    
    //methods to get the details
    public double getGratuity(){
       return this.gratuityOfWorker; 
    }
    //methods to get the details
    public int getLevel(){
       return this.levelOfWorker; 
    }
    private void calcGratuity(){
        gratuityOfWorker = 25*16*getSalary();
    }
    //create new hash upon creating a new block
    public String generateHash(String input){	
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");	        
			//Applies sha256 to our input, 
			byte[] hash = digest.digest(input.getBytes("UTF-8"));	        
			StringBuffer hexString = new StringBuffer(); // This will contain hash as hexidecimal
			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1) hexString.append('0');
				hexString.append(hex);
			}
			return hexString.toString();
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}

    }
  
    public void setGenesisHash(){
        genesisHash = generateHash("Genesis");
    }
     public String getGenesisHash(){
        return genesisHash;
    }
   public HashMap<String, List<String>>[] getData(){
        HashMap<String, List<String>>[] maps = new HashMap[9];
        for(int i=1;i<=5;i++){
        try{
            String[] otherData = {getName(),getNextOfKin(),getContact(),getMail(),String.valueOf(getLevel())};
            HashMap<String, List<String>> setMap = new HashMap<>();
            setMap.put("Details: ", Arrays.asList(otherData));
            maps[i-1] = setMap;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
       
        }
        return maps;
    }
   /////////////////////////////////////////////////////////////////////////////////////////////////////////////
   ///                                                                                                       //
   //                                                                                                       ///
   //                                                                                                       //
   ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    
}
