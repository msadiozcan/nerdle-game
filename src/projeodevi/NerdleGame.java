package projeodevi;
import java.io.*;
import java.lang.Math;

public class NerdleGame {
	public static int i,total;
	public static String equation = null;
	public static String userEquation = null;
	public static String testEquation = null;

	public static String generateEquation(){
    	char ops[]= new char[5];
    	int[] nums = new int[4];
    	total = (int)(Math.random()*3)+2;
    	
    	for(i=0;i<3;i++) {
    	int e = (int)(Math.random()*4);
    	if(e==0)
    		ops[i]= '+';
    	if(e==1)
    		ops[i]= '-';
    	if(e==2)
    		ops[i] = '*';
    	if(e==3)
    		ops[i]= '/';
    	}
    
    	int sonuc,sonucb;
		do{
			nums[0] = randomNumber(total);
	    	nums[1] = randomNumber(total);
	    	nums[2] = randomNumber(total);
	    	nums[3] = randomNumber(total);
    		sonuc=0;
    		sonucb=0;
    		for(i=0;i<3;i++) {
    			if(ops[i]=='/')
    				nums[i+1] = intTodivide(nums[i]);
    	    
    		}
    		equation="";
    		if(total==2) {
    			equation+= String.valueOf(nums[0]);
    			equation+= ops[0];
    			equation+= String.valueOf(nums[1]);
    			equation+= "=";
    			testEquation = equation;
    			sonuc = calculateEquation(ops[0],nums[0],nums[1]);
    			equation+= String.valueOf(sonuc);
    		}
    		if(total==3) {
    			equation+= String.valueOf(nums[0]);
    			equation+= ops[0];
    			equation+= String.valueOf(nums[1]);
    			equation+= ops[1];
    			equation+= String.valueOf(nums[2]);
    			testEquation = equation;
    			if(ops[0]=='*'||ops[0]=='/') {
    				sonuc = calculateEquation(ops[0],nums[0],nums[1]);
    				sonuc = calculateEquation(ops[1],sonuc,nums[2]);
    			}
    			else {
    				if(ops[1]=='*'||ops[1]=='/') {
    					sonuc = calculateEquation(ops[1],nums[1],nums[2]);
        				sonuc = calculateEquation(ops[0],nums[0],sonuc);	
    				}
    				else {
    					sonuc = calculateEquation(ops[0],nums[0],nums[1]);
        				sonuc = calculateEquation(ops[1],sonuc,nums[2]);
    				}
    				
    			}
    			equation+= "=";
    			equation+= String.valueOf(sonuc);
    		}
    		if(total==4){
    			equation+= String.valueOf(nums[0]);
    			equation+= ops[0];
    			equation+= String.valueOf(nums[1]);
    			equation+= ops[1];
    			equation+= String.valueOf(nums[2]);
    			equation+= ops[2];
    			equation+= String.valueOf(nums[3]);
    			testEquation = equation;
    			if(ops[0]=='*' || ops[0]=='/') {
    				sonuc = calculateEquation(ops[0],nums[0],nums[1]);
    				if(ops[1]=='*' || ops[1]=='/') {
    					sonucb = calculateEquation(ops[1],sonuc,nums[2]);
    					sonuc = calculateEquation(ops[2],sonucb,nums[3]);
    				}
    				else {
    					if(ops[2]=='*' || ops[2]=='/') {
    						sonucb = calculateEquation(ops[2],nums[2],nums[3]);
    						sonuc = calculateEquation(ops[1],sonuc,sonucb);
    					}
    					else{
    						sonucb = calculateEquation(ops[1],sonuc,nums[2]);
        					sonuc = calculateEquation(ops[2],sonucb,nums[3]);
    					}
    				}
    			}
    			else {
    				if(ops[1]=='*' || ops[1]=='/') {
    					sonuc = calculateEquation(ops[1],nums[1],nums[2]);
    					if(ops[2]=='*' || ops[2]=='/') {
    						sonucb = calculateEquation(ops[2],sonuc,nums[3]);
        					sonuc = calculateEquation(ops[0],nums[0],sonucb);	
    					}
    					else {
    						sonucb = calculateEquation(ops[0],nums[0],sonuc);
    						sonuc = calculateEquation(ops[2],sonucb,nums[3]);
    					}
    				}
    				else {
    					if(ops[2] == '*' || ops[2] == '/') {
    					sonuc = calculateEquation(ops[2],nums[2],nums[3]);
    					sonucb = calculateEquation(ops[0],nums[0],nums[1]);
    					sonuc = calculateEquation(ops[1],sonucb,sonuc);
    					}
    					else {
    						sonuc = calculateEquation(ops[0],nums[0],nums[1]);
        					sonucb = calculateEquation(ops[1],sonuc,nums[2]);
        					sonuc = calculateEquation(ops[2],sonucb,nums[3]);
    					}
    				}
    			}
    			equation+= "=";
    			equation+= String.valueOf(sonuc);
    			}
    	}while(checkEquation(equation));
		
		return equation;
     }
	
	public static boolean checkEquation(String s) {
		if(s.length()<7 || s.length()>9)
				return true;
		return false;
	}
	public static int calculateEquation(char s,int a,int b){
		switch(s){
			case '+':
				return a+b;
			case '-':
				return a-b;
			case '*':
				return a*b;
			case '/':
				return (int)(a/b);
		}
		return 0;
	}
	
	public static String equationResult(int[] nums, char[] ops,int total){ //Sadece test için kullanýlmaktadýr. Bu kodun aynýsý generateEquation
		int sonuc = 0,sonucb=0;									// metodu içinde bulunmaktadýr.
		testEquation="";
		if(total==2) {
			testEquation+= String.valueOf(nums[0]);
			testEquation+= ops[0];
			testEquation+= String.valueOf(nums[1]);
			sonuc = calculateEquation(ops[0],nums[0],nums[1]);
		}
		if(total==3) {
			testEquation+= String.valueOf(nums[0]);
			testEquation+= ops[0];
			testEquation+= String.valueOf(nums[1]);
			testEquation+= ops[1];
			testEquation+= String.valueOf(nums[2]);
			if(ops[0]=='*'||ops[0]=='/') {
				sonuc = calculateEquation(ops[0],nums[0],nums[1]);
				sonuc = calculateEquation(ops[1],sonuc,nums[2]);
			}
			else {
				if(ops[1]=='*'||ops[1]=='/') {
					sonuc = calculateEquation(ops[1],nums[1],nums[2]);
    				sonuc = calculateEquation(ops[0],nums[0],sonuc);	
				}
				else {
					sonuc = calculateEquation(ops[0],nums[0],nums[1]);
    				sonuc = calculateEquation(ops[1],sonuc,nums[2]);
				}
				
			}
			testEquation+= "=";
			testEquation+= String.valueOf(sonuc);
		}
		if(total==4){
			testEquation+= String.valueOf(nums[0]);
			testEquation+= ops[0];
			testEquation+= String.valueOf(nums[1]);
			testEquation+= ops[1];
			testEquation+= String.valueOf(nums[2]);
			testEquation+= ops[2];
			testEquation+= String.valueOf(nums[3]);
			if(ops[0]=='*' || ops[0]=='/') {
				sonuc = calculateEquation(ops[0],nums[0],nums[1]);
				if(ops[1]=='*' || ops[1]=='/') {
					sonucb = calculateEquation(ops[1],sonuc,nums[2]);
					sonuc = calculateEquation(ops[2],sonucb,nums[3]);
				}
				else {
					if(ops[2]=='*' || ops[2]=='/') {
						sonucb = calculateEquation(ops[2],nums[2],nums[3]);
						sonuc = calculateEquation(ops[1],sonuc,sonucb);
					}
					else{
						sonucb = calculateEquation(ops[1],sonuc,nums[2]);
    					sonuc = calculateEquation(ops[2],sonucb,nums[3]);
					}
				}
			}
			else {
				if(ops[1]=='*' || ops[1]=='/') {
					sonuc = calculateEquation(ops[1],nums[1],nums[2]);
					if(ops[2]=='*' || ops[2]=='/') {
						sonucb = calculateEquation(ops[2],sonuc,nums[3]);
    					sonuc = calculateEquation(ops[0],nums[0],sonucb);	
					}
					else {
						sonucb = calculateEquation(ops[0],nums[0],sonuc);
						sonuc = calculateEquation(ops[2],sonucb,nums[3]);
					}
				}
				else {
					if(ops[2] == '*' || ops[2] == '/') {
					sonuc = calculateEquation(ops[2],nums[2],nums[3]);
					sonucb = calculateEquation(ops[0],nums[0],nums[1]);
					sonuc = calculateEquation(ops[1],sonucb,sonuc);
					}
					else {
						sonuc = calculateEquation(ops[0],nums[0],nums[1]);
    					sonucb = calculateEquation(ops[1],sonuc,nums[2]);
    					sonuc = calculateEquation(ops[2],sonucb,nums[3]);
					}
				}
			}
			testEquation+= "=";
			testEquation+= String.valueOf(sonuc);
			}
		return testEquation;
	}
	
	public static int randomNumber(int son) {
		int var=0,sayi=0;
		if(son==2) {
			sayi = (int)(Math.random()*100);
		}
		if(son==3) {
			var = (int)(Math.random()*3);
			if(var==0 || var ==1) {
			sayi = (int)(Math.random()*9)+1;
			}
			if(var==2) {
			sayi = (int)(Math.random()*100);
			}
		}
		if(son==4) {
			sayi = (int)(Math.random()*9)+1;
		}
		return sayi;
	}
	
	public static int getLength(){
		int x = equation.length();
		return x;
	}
	
	public static int intTodivide(int x){
		for(int i=2;i<x;i++) {
			if(x % i ==0)
				return i;
		}
		if(Math.random()*2==1){
		return 1;}
		return x;
	}
	public static void setEquation(String s){
		equation = s;
	}
	
	public static String getUserEquation(){
		return userEquation;
	}
	
	public static String getTestEquation(){
		return testEquation;
	}
	public static void setUserEquation(String s){
		userEquation = s;
	}
	
	public static int[] checkGuess() {
		//0 = yanlýþ tahmin ;;; 1 = doðru tahmin, yanlýþ yer ;;; 2= doðru tahmin, doðru yer
		int[] colors = new int[getLength()];
		String[] chars = userEquation.split("");
		String[] truechars = equation.split("");
		for (int i = 0; i < chars.length; i++) {
            if(truechars[i].equals(chars[i])) {
                colors[i] = 2;}
            for(int j=0 ; j<truechars.length;j++) {
            	if(colors[i] != 2 && chars[i].equals(truechars[j]) && i!=j) {
            		colors[i] = 1;
            	}
            }
            if(colors[i] != 1 && colors[i] != 2) {
            	colors[i] = 0;
            }
        }
		return colors;
	} 
    
}
