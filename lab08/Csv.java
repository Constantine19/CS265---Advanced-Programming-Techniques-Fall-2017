import java.io.*;
import java.util.Vector;
import java.util.Scanner;


public class Csv {
	public static class csv {
		public csv(String scanner) {
			fieldsep = ",";
			input = new Scanner(scanner);
		}
		public int getline(String str) {
			String c="";
			for(line = ""; (input.next(c)!=null? true:false) && !(endofline(c)>0? true : false); )
				line+=c;
			split();
			str = line;
			return (input.hasNextLine()? 0:1);
		}
		public String getfield(int n) {
			if (n < 0 || n >= nfield)
				return "";
			else
				return field.elementAt(n);
		}
		public int getnfield() {
			return nfield;
		}


		private Scanner input = null;
		private String line;
		private Vector<String> field = null;
		private int nfield;
		private String fieldsep;
		private int split(){
			String fld="";
			int i, j;

			nfield = 0;
			if (line.length() == 0)
				return 0;
			i = 0;

			do {
				if (i < line.length() && line.charAt(i) == '"')
					j = advquoted(line, fld, ++i);
				else
					j = advplain(line, fld, i);
				if (nfield >= field.size())
					field.addElement(new String(fld));
				else
					field.set(nfield,fld);
				nfield++;
				i = j + 1;
			} while (j < line.length());

			return nfield;
		}
		private int endofline(String s){
			int eol;
			eol = (s=="\r" || s=="\n")? 1:0;
			if(s == "\r"){
				input.next(s);
			}
			return eol;
		}
		private int advplain(String s, String fld, int i){
			int j;

			j = s.indexOf(fieldsep, i);
			if (j > s.length())
				j = s.length();
			fld = s.substring(i, j);
			return j;
		}
		private int advquoted(String s, String fld, int i){
			int j;

			fld = "";
			for (j = i; j < s.length(); j++) {
				if (s.charAt(j) == '"' && s.charAt(++j) != '"') {
					int k = s.indexOf(fieldsep, j);
					if (k > s.length())
						k = s.length();
					for (k -= j; k-- > 0; )
						fld += s.charAt(j++);
					break;
				}
				fld += s.charAt(j);
			}
			return j;
		}
	}

	public static void main(String arg[]) {
		{
		if(arg.length < 1) {
			System.out.print("Enter a filename as an argument.\n");
			System.exit(0);
		}
			
		String file = arg[0];
		String line="";

		csv csvfile = new csv(file);

		while(csvfile.getline(line) !=0 ) {
			System.out.print("line = `" + line + "'\n");
			for(int i = 0; i<csvfile.getnfield(); i++)
				System.out.print("field[" + i + "] = `" + csvfile.getfield(i) + "'\n");
		}
	}
}

