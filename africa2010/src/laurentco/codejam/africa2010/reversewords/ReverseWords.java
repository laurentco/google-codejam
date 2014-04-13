package laurentco.codejam.africa2010.reversewords;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReverseWords {
	
	public static void main(String[] args) throws IOException {
		InputStream in = System.in;
		OutputStream out = System.out;
		if(args.length > 0) {
			in  = new FileInputStream(args[0]);
			out = new FileOutputStream(args[0].replace(".in", ".out"));
		}
		long t = System.currentTimeMillis();
		reverse(in, out);
		System.out.println((System.currentTimeMillis() - t) + "ms");
	}

	private static void reverse(InputStream in, OutputStream out) throws IOException {
		Scanner scan = new Scanner(in); 
		PrintWriter writer = new PrintWriter(out);
		int lines = scan.nextInt();
		scan.nextLine();
		for(int i=1 ; i<=lines ; i++) {
			writer.print("Case #" + i + ": ");
			reverseLine(scan.nextLine(), writer);
			writer.println();
		}
		scan.close();
		writer.close();
	}

	private static void reverseLine(String line, PrintWriter out) {
		int index = line.length()-1;
		while(index>=0) {
			int last = index;
			while(index>=0 && line.charAt(index)!=' ')
				index--;
			out.append(line.substring(index+1, last+1));
			if(index>0) {
				out.append(' ');
				index--;
			}
		}
	}
}
