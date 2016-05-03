/**
 * 
 */
package com.arithmaticoperation;


public class arithmatic {
	int a,b,result;
	
	void add(int r,int s)
	{
		a=r;
				b=s;
				result=a+b;
				System.out.println("result is"+result);
	}
	void sub(int g,int h)
	{
		a=g;
				b=h;
				result=a-b;
				System.out.println("result is"+result);
	}
	void mul(int c,int d)
	{
		a=c;
		b=d;
		result=a*b;
		System.out.println("result is"+result);
	}
	void div(int j,int k)
	{
		a=j;
		b=k;
		result=a/b;
		System.out.println("result is"+result);
	}
		
	
	

	
	public static void main(String[] args) {
	arithmatic oa = new arithmatic();
	oa.add(10,2);
	oa.sub(10,2);
	oa.mul(10,2);
	oa.div(10,2);
	
			
	

	}

}
