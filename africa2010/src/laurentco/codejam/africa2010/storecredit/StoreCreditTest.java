package laurentco.codejam.africa2010.storecredit;
import junit.framework.TestCase;

public class StoreCreditTest extends TestCase {
	
	public void testStoreCredit() {
		long t = System.currentTimeMillis();
		assertEquals("2 3", StoreCredit.select(28, new int[]{30, 20, 8, 45, 27}));
		System.out.println((System.currentTimeMillis() - t) + "ms");
	}
}
