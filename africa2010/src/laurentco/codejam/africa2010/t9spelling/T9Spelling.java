package laurentco.codejam.africa2010.t9spelling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

public class T9Spelling {

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
				String s = t9(msg.charAt(j));
				if(last == s.charAt(0))
					out.print(' ');
				out.print(s);
				last = s.charAt(s.length()-1);
			}
			if(i<cases)
				out.println();
		}
	}
	
	public static String t9(char letter) {
		switch(letter) {
			case ' ': return "0";
			case 's': return "7777";
			case 't': return "8";
			case 'u': return "88";
			case 'v': return "888";
			case 'w': return "9";
			case 'x': return "99";
			case 'y': return "999";
			case 'z': return "9999";
			default:
				int diff = letter - 'a';
				int number = 2 + (diff / 3);
				switch(diff % 3) {
					case 0: return number + "";
					case 1: return number + "" + number;
					case 2: return number + "" + number + "" + number;
					default: return "";
				}
		}
	}
}
