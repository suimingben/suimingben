package cn.tjuscs.st;

public class Calculate {
	 int [] array= {50,20,5,5,1,1,1};
	public String Money(int a)
	{
		for (int i=0;i<array.length;i++)
		{
			a=a-array[i];
			if(a>0)
			{
				continue;
			}
			else if(a==0)
			{
				break;
			}
			else
			{
				a=a+array[i];
				continue;
			}
		}
		if(a==0)
		{
			return "Congradulations.";
		}
		else
		{
			return "The number is wrong.";
		}
	}
	/*public String Money (int a)
	 {
		 if(a>83)
		 {
			 return "The money is not enough.";
		 }
		 else if(a<0)
		 {
			 return "The number is wrong.";
		 }
		 else if(a%5==4||a>13&a<20||a>33&a<50||a>63&a<70)
		 {
			 return "The money is not correct.";
		 }
		 else
			 return "Congradulations";
			 
	 }*/
	/*public int add(int a,int b)
	{
		return a+b;
	}*/
	//还有一种方法：用余数相减得到所要得到的结果。
	 
}
