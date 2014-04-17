package laurentco.codejam.africa2010.t9spelling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Second solution: index (t9speller) pre-computed based on dialer keys configuration input
 * 
 * @author Laurent
 *
 */
public class T9Spelling2 {
	
	private static final char[][] dialer = { 
		{ ' ' },
		{ },
		{ 'a','b','c' },
		{ 'd','e','f' },
		{ 'g','h','i' },
		{ 'j','k','l' },
		{ 'm','n','o' },
		{ 'p','q','r','s' },
		{ 't','u','v' },
		{ 'w','x','y', 'z' }
	};
	
	private static Map<Character, String> t9speller = initSpeller(dialer);

	public static void main(String[] args) throws IOException {
		InputStream in = System.in;
		OutputStream out = System.out;
		if(args.length > 0) {
			in  = new FileInputStream(args[0]);
			out = new FileOutputStream(args[0].replace(".in", ".out"));
		}
		Scanner scanner = new Scanner(in);
		PrintWriter writer = new PrintWriter(out);
		process(scanner, writer);
		scanner.close();
		writer.close();
	}

	public static void process(Scanner in, PrintWriter out) throws IOException {
		int cases = in.nextInt();
		in.nextLine();
		for(int i=1 ; i<=cases ; i++) {
			String msg = in.nextLine();
			out.print("Case #" + i + ": ");
			char last = '#';
			for(int j=0;j<msg.length();j++) {
				String s = t9speller.get(msg.charAt(j));
				if(last == s.charAt(0))
					out.print(' ');
				out.print(s);
				last = s.charAt(s.length()-1);
			}
			if(i<cases)
				out.println();
		}
	}
	
	private static Map<Character, String> initSpeller(char[][] dial) {
		Map<Character, String> speller = new HashMap<Character,String>();
		StringBuilder keys = new StringBuilder();
		for(int i=0 ; i<dial.length ; i++) {
			keys.setLength(0);
			for(int j=0 ; j<dial[i].length ; j++) {
				char c = dial[i][j];
				keys.append(i);
				speller.put(c, keys.toString());
			}
		}
		return speller;
	}
}
