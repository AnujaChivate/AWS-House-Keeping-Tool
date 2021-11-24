package com.housekeepingtool.test;

public class TempTEst {

	public static void main(String[] args) {

		String s= "07:05:45AM";
		String ll[] =s.split(":");
		if(ll[2].contains("PM"))
		{
		System.out.print((Integer.valueOf(ll[0])+12)+" : "+ll[1]+" :"+ll[2].substring(0, 2));
		}else
		{
			System.out.print(ll[0]+" : "+ll[1]+" :"+ll[2].substring(0, 2));
				
		}
	}

}
