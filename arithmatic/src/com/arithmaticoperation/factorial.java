package com.arithmaticoperation;

public class factorial {

	int n;
	 void fact(int m)
	 {
		 n=m;
		int fact=1;
		 for(int i=1;i<=m;i++)
		 {
		
		fact = fact*i;
		
		 }
		System.out.println("factorial is" +fact);
		 
		 
	 }
	 
	 
	 
	 
	 
	public static void main(String[] args) {
		factorial ob =new factorial();
		ob.fact(5);
		
		
				

	}

}
