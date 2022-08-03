package projeodevi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class TestNerdleGame { //Test edilen metodlar generateEquation metodu içerisinde kullanýlan metodlardýr.
	
	@Test
	public void testCheckEquation(){
		assertTrue(NerdleGame.checkEquation("666666"));
		assertTrue(NerdleGame.checkEquation("1010101010"));
		assertTrue(NerdleGame.checkEquation(""));
	}
	
	@Test
	public void testCheckEquation_false() {
		assertFalse(NerdleGame.checkEquation("7777777"));
		assertFalse(NerdleGame.checkEquation("88888888"));
		assertFalse(NerdleGame.checkEquation("999999999"));
	}
	
	@Test
	public void testCalculateEquation() {
		assertEquals(10,NerdleGame.calculateEquation('+', 8, 2));
		assertEquals(6,NerdleGame.calculateEquation('-', 8, 2));
		assertEquals(16,NerdleGame.calculateEquation('*', 8, 2));
		assertEquals(4,NerdleGame.calculateEquation('/', 8, 2));
		assertEquals(-5,NerdleGame.calculateEquation('+', 0, -5));
		assertEquals(5,NerdleGame.calculateEquation('-', 0, -5));
		assertEquals(0,NerdleGame.calculateEquation('c', 0, 2));
		assertEquals(102,NerdleGame.calculateEquation('+', 'd', 2)); //ASCII
	}
	
	@Test
	public void testGetUserEquation() {
		NerdleGame.setUserEquation("1+2+3=6");
		String s = NerdleGame.getUserEquation();
		assertEquals("1+2+3=6",s);
	}
	
	@Test
	public void testCheckGuess() {
		NerdleGame.setUserEquation("1+2+3=6");
		NerdleGame.setEquation("1+3+4=8");
		int[] array = { 2,2,0,2,1,2,0 };
		int[] array2 = NerdleGame.checkGuess();
		for(int i = 0; i<7 ; i++) {
			assertEquals(array[i],array2[i]);
		}
	}
	
	@Test
	public void testEquationResult() {
		int[] nums = {2,4,5};
		char[] ops = { '+','-' };
		String s = NerdleGame.equationResult(nums,ops,3);
		assertEquals("2+4-5=1",s);
	}
}
