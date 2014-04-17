package laurentco.codejam.africa2010.t9spelling;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

import junit.framework.TestCase;

public class T9SpellingTest extends TestCase {
	
	public void testT9() throws Exception {
		long t = System.currentTimeMillis();
		assertEquals("2", T9Spelling.t9('a'));
		assertEquals("22", T9Spelling.t9('b'));
		assertEquals("222", T9Spelling.t9('c'));
		assertEquals("3", T9Spelling.t9('d'));
		assertEquals("33", T9Spelling.t9('e'));
		assertEquals("333", T9Spelling.t9('f'));
		assertEquals("0", T9Spelling.t9(' '));
		System.out.println((System.currentTimeMillis() - t) + "ms");
	}
	
	public void testT9Seq() throws Exception {
		StringWriter sw = new StringWriter();
		T9Spelling.process(new Scanner("1\nyes"), new PrintWriter(sw));
		sw.close();
		System.out.println(sw.toString());
		assertEquals("Case #1: 999337777", sw.toString());
	}
	
	public void testT92Seq() throws Exception {
		StringWriter sw = new StringWriter();
		T9Spelling2.process(new Scanner("1\nyes"), new PrintWriter(sw));
		sw.close();
		System.out.println(sw.toString());
		assertEquals("Case #1: 999337777", sw.toString());
	}
}
