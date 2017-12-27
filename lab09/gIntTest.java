/**
 * Konstantin Zelmanovich
 * CS 265
 * Lab 9
 * 12/03/2017
 * java version "1.8.0_144" on tux4.cs.drexel.edu
 */

import junit.framework.*;

public class gIntTest extends TestCase {
	private gInt add1;
	private gInt add2;
	private gInt mul1;
	private gInt mul2;
	private gInt normed;

	public static Test suite() {
		return new TestSuite( gIntTest.class );
	}
	protected void setUp(){ 
		add1 = new gInt(6, 9);
		add2 = new gInt(7, 4);
		mul1 = new gInt(2, 8);
		mul2 = new gInt(5, 3);
		normed = new gInt(3, 1);
	}

	public gIntTest( String name ) {
		super(name);
	}

	public void testAdd() {
		gInt addcheck = new gInt(13, 13);
		assertNotNull( addcheck );
		
		gInt added = add1.add(add2);
		assertNotNull( added );
		assertEquals( added, addcheck );

	}

	public void testMultiply() {
		gInt mulcheck = new gInt(-14, 46);
		assertNotNull( mulcheck );

		gInt mulled = mul1.multiply(mul2);
		assertNotNull(mulled);
		assertEquals(mulled, mulcheck);
	}
	
	public void testNorm() {
		float norm1 = 10;
		assertNotNull( norm1 );

		float normed1 = normed.norm();
		assertNotNull(normed1);
		assertEquals(norm1,normed1);
	}

        public static void main( String args[] ) {
		String[] caseName = { gIntTest.class.getName() };
		junit.textui.TestRunner.main( caseName );
	}
}

