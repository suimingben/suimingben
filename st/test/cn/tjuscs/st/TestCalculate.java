package cn.tjuscs.st;

import org.junit.Assert;
import org.junit.Test;



public class TestCalculate {
	@Test
	//≤‚ ‘add
	/* public void testAdd()
	 {
		Calculate c= new Calculate();
		int result = c.add(1, 2);
		Assert.assertEquals(result,3);
	 }*/
	public void testMoney()
	{
		Calculate m=new Calculate();
		String result1=m.Money(85);
		String result2=m.Money(-1);
		String result3=m.Money(54);
		String result4=m.Money(33);
		String result5=m.Money(66);
		String result6=m.Money(83);
		Assert.assertEquals(result1,"The number is wrong." );
		Assert.assertEquals(result2,"The number is wrong." );
		Assert.assertEquals(result3,"The number is wrong." );
		Assert.assertEquals(result4,"Congradulations." );
		Assert.assertEquals(result5,"The number is wrong.");
		Assert.assertEquals(result6,"Congradulations.");
	}

}
