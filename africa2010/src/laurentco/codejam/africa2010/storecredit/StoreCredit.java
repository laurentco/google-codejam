package laurentco.codejam.africa2010.storecredit;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class StoreCredit {

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
			int credit = in.nextInt();
			in.nextLine();
			int count = in.nextInt();
			in.nextLine();
			int[] prices = new int[count];
			for(int j=0;j<count;j++)
				prices[j] = in.nextInt();
			out.println("Case #" + i + ": " + select(credit, prices));
		}
	}

	public static String select(int credit, int[] items) {
		for(int i=0 ; i<items.length ; i++)
			for(int j=i+1 ; j<items.length ; j++)
				if(items[i]+items[j] == credit)
					return (i+1) + " " + (j+1);
		return "";
	}
}
