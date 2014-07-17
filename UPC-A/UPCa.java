import java.io.*;
import java.lang.String;
import java.util.Scanner;


public class UPCa {

	public static void main(String[] args) throws IOException {
		if (args.length==0) {
			System.out.println("Usage: java -jar <filename>.jar <infile> [<outfile>]");
			return;
		}
		FileInputStream inFile = new FileInputStream(args[0]);
		Scanner scanner = new Scanner(inFile);
		BufferedWriter outFile = new BufferedWriter(openForFile(null));
		if (args.length > 1) {
			outFile = new BufferedWriter(openForFile(args[1]));
		}
		String [] Lpat = {"   || |","  ||  |","  |  ||"," |||| |"," |   ||"," ||   |"," | ||||"," ||| ||"," || |||","   | ||"};
		String [] Rpat = invert(Lpat);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine().replaceAll("[^0-9]", "");
			if (line.length()<12){
				outFile.write(String.format("Invalid UPC-A Code: %s\n",line));
				outFile.flush();
				continue;
			}
			else if (line.length()>12){
				line = line.substring(0, 12);
			}
			if (!(validCD(line))){
				outFile.write(String.format("Invalid UPC-A Code (Invalid Check Digit): %s\n",line));
				outFile.flush();
				continue;
			}
			String result = "| |";
			for (int i = 0; i < line.length()/2; i++){
				result += Lpat[Character.getNumericValue(line.charAt(i))];
			}
			result += " | | ";
			for (int i = 6; i < line.length(); i++){
					result += Rpat[Character.getNumericValue(line.charAt(i))];
			}
			result += "| |";
			outFile.write(result);
			outFile.write("\n");
			outFile.flush();
		}
		scanner.close();
		inFile.close();
		outFile.close();

	}


	static Writer openForFile(String fileName) {
		if (fileName != null)
			try {
				return new PrintWriter(fileName);
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		return new OutputStreamWriter(System.out);
	}
	
	static String [] invert(String [] pattern) {
		String [] retPat = new String [pattern.length];
		for (int i = 0; i < pattern.length;i++) {
			String string = "";
			for (int j = 0; j < pattern[i].length(); j++) {
				if (pattern[i].charAt(j) == '|'){
					string += " ";
				}
				else {
					string += "|";
				}
			}
			retPat[i] = string;
		}
		return retPat;
		
	}
	
	static boolean validCD(String code){
		int CD = Character.getNumericValue(code.charAt(code.length()-1));
		code = code.substring(0, 11);
		int result = 0;
		for (int i = 0; i < code.length(); i += 2){
			result += Character.getNumericValue(code.charAt(i));
		}
		result *= 3;
		for (int i = 1; i < code.length(); i += 2){
			result += Character.getNumericValue(code.charAt(i));
		}
		result = result % 10;
		if (result != 0){
			result = 10 - result;
			if (result != CD){
				return false;
			}
		}
		else
			if (CD != 0)
				return false;
		return true;
		
	}

}