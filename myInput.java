//package my;

import java.util.ArrayList;
import java.io.IOException;

public class myInput {
	//Veriable Diclare
	public static int totalLength=0;
	
	//main method
	public static void main(String[] args) { 
		test();
		System.exit(0);
	}

	private static void test(){
		/* All String Tyepe input */
		// System.out.print("Enter line :\t");
		// System.out.println("Its only take world:\n"+getString());
		// System.out.println("Lenth of word:\t"+totalLength);
		// flush();
		
		// System.out.print("Enter line:\t");
		// System.out.println("Entred Line:\n"+getLine());
		// System.out.println("Lenth of word:\t"+totalLength);

		// System.out.println("Example of python style input class");
		// System.out.println(Input("Enter anyting:\t"));
		// // /* All Numeric input*/

		// System.out.print("Enter Short Number:\t");
		// System.out.println("Enterd Short Number:\t"+getShort());
		
		// flush();
		// System.out.print("Enter Integer number:\t");
		// System.out.println("Entred Number:\t"+getInt());
		// System.out.println("Length of word:\t"+totalLength);

		// System.out.print("Enter Long Number:\t");
		// System.out.println("Entred Number:\t"+getLong());
		
		// System.out.print("Enter floating Number:\t");
		// System.out.println("Entred Floting Numver:\t"+getFloat());
		// System.out.println("Lenth of word:\t"+totalLength);

		// System.out.println("Entre Double Numver:\t");
		// System.out.println("Entred Double Number:\t"+getDouble());

		System.out.print("Enter Intiger Bunch:\t");
		int[] num =getIntBunch();
		System.out.println(num.length);
		for (int n : num){
			System.out.print(n+", ");	
		}
		
		System.out.print("\nEnter Float Bunch:\t");
		float[] fnum =getFloatBunch();
		System.out.println(fnum.length);
		for (float n : fnum){
			System.out.print(n+", ");	
		}
	}
	
	private static ArrayList<Character> rowInput(){
		ArrayList <Character> rowIn = new ArrayList<>();
		char ch;
		try{
			while (true){
				ch=(char)System.in.read();
				if ( ch == '\r' )
					ch=(char)System.in.read();
				if ( ch == '\n' )
					break;
				else
					rowIn.add(ch);
			}
		}
		catch (IOException e){
			System.out.print(e);
		}
		return rowIn;
	}

	public static String getString(){
		ArrayList<Character> rowIn = new ArrayList<>();
		char ch;
		try{
			while(true){
				ch=(char)System.in.read();
				if (ch=='\r')
					ch=(char)System.in.read();
				if ( ch==' ' || ch=='\t' || ch=='\n' )
					break;
				else
					rowIn.add(ch);
			} 
		} catch (IOException e){
			System.out.println(e);
		}
		//copy the the row_input to word size arre
		char[] word =new char[rowIn.size()];
		
		for (int i=0; i<rowIn.size(); i++){	word[i]=rowIn.get(i);}
		
		totalLength = word.length;	//set length of word 	
		return String.valueOf(word);//String.valueOf(word);	//return after convert to String
	}
	
	public static int [] getIntBunch(){
		ArrayList<Character> rowIn=rowInput();
		ArrayList<Integer> rowIntArre=new ArrayList<>();
		rowIn.add('\0');
		ArrayList<Character> num=new ArrayList<>();
		
		for (char ch: rowIn){
			if (ch>='0' && ch<='9')
				num.add(ch);
			else if (num.size()>0){
				rowIntArre.add(Integer.parseInt(String.valueOf(ArrayList2CharArray(num))));
				num.clear();
			}
		}
		int[] intArre=new int[rowIntArre.size()];
		for(int a=0; a<intArre.length; a++){
			intArre[a]=rowIntArre.get(a);
		}
		return intArre;
	}

	public static float [] getFloatBunch(){
		ArrayList<Character> rowIn = rowInput();
		rowIn.add('\0');
		ArrayList<Float> rowFloat=new ArrayList<>();
		ArrayList<Character> num=new ArrayList<>();
		for (int i=0; i<rowIn.size(); i++){
			if (rowIn.get(i)>='0' && rowIn.get(i)<='9' || rowIn.get(i)=='.')
				num.add(rowIn.get(i));
			else if (num.size()>0){
				rowFloat.add(Float.parseFloat(String.valueOf(ArrayList2CharArray(num))));
				num.clear();
			}
		}
		float[] floatArre = new float[rowFloat.size()];
		for (int a=0; a<floatArre.length; a++)
			floatArre[a] = rowFloat.get(a);

		return floatArre;
	}
	
	public static String getLine(){
		ArrayList<Character> rowIn=rowInput();
		
		char[] line =new char[ rowIn.size() ];
		//line=rowIn.toArray(line);
		for (int i = 0 ; i < line.length; i++){	line[i] = rowIn.get(i);}
		
		totalLength = line.length;
		//return String.valueOf(line);
		return new String(line);
	}
	public static short getShort(){
		//check
		return Short.parseShort(getString());
	}
	public static int getInt(){
		return Integer.parseInt(getString());
	}
	public static long getLong(){
		//check
		return Long.parseLong(getString());
	}
	public static float getFloat(){
		return Float.parseFloat(getString());
	}
	
	public static double getDouble(){
		//check
		return Double.parseDouble(getString());
	}
	public static void flush() {
		try{
			while (System.in.available()>0)
				System.in.read();
		}
		catch (IOException e){
			System.out.println(e);
		}
	}
	public static String Input(String arg){
		System.out.print(arg);
		return getLine();//String.valueOf(rowInput());
	}
//=== Add-on Methhod ==========
	private static char[] ArrayList2CharArray(ArrayList<Character> list){
		char[] ch=new char[list.size()];
		for (int i=0; i<ch.length; i++){
			ch[i]=list.get(i);
		}
		return ch;
	}
}