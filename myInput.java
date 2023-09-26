
package my;
import java.io.IOException;
public class myInput {
	//Veriable Diclare
	public static int totalLength=0;
	
	//main method
	//public static void main(String[] args) { test();	}

	private static void test(){
		/* All String Tyepe input */
		System.out.print("Enter line :\t");
		System.out.println("Its only take world:\n"+getString());
		System.out.println("Lenth of word:\t"+totalLength);
		flush();
		
		System.out.print("Enter line:\t");
		System.out.println("Entred Line:\n"+getLine());
		System.out.println("Lenth of word:\t"+totalLength);

		System.out.println("Example of python style input class");
		System.out.println(Input("Enter anyting:\t"));
		/* All Numeric input*/

		System.out.print("Enter Short Number:\t");
		System.out.println("Enterd Short Number:\t"+getShort());

		System.out.print("Enter number:\t");
		System.out.println("Entred Numver:\t"+getInt());
		System.out.println("Lenth of word:\t"+totalLength);

		System.out.print("Enter Long Number:\t");
		System.out.println("Entred Numver:\t"+getLong());

		System.out.print("Enter floating Number:\t");
		System.out.println("Entred Floting Numver:\t"+getFloat());
		System.out.println("Lenth of word:\t"+totalLength);

		System.out.println("Entre Double Numver:\t");
		System.out.println("Entred Double Numver:\t"+getDouble());

		System.out.println("Enter Intiger Bunch:");
		int[] num =getIntBunch();
		System.out.println(num.length);
		for (int n : num){
			System.out.print(n+", ");	
		}
		
		System.out.println("Enter Float Bunch:");
		float[] fnum =getFloatBunch();
		System.out.println(fnum.length);
		for (float n : fnum){
			System.out.print(n+", ");	
		}

	}
	private static char[] rowInput(){
		char[] row_in = new char[100];
		int i=0;
		try{
			do{
				if (i<row_in.length-1){
					row_in[i++]=(char)System.in.read();
				}
				else{
					row_in=reallock(row_in);
					continue;
				}
			}while(row_in[i-1]!='\n');
		}
		catch (IOException e){
			System.out.print(e);
		}
		
		char[] line =new char[i-1];
		for (i=0; i<line.length; i++){	line[i]=row_in[i];}
		totalLength = line.length;
		return line;
		}

	public static String getString(){
		char[] row_in =new char[20];
		int i=0;
		try{
			do{
				if (i<row_in.length-1){
					row_in[i++]=(char)System.in.read();
				} else {
					row_in=reallock(row_in);
				}
			}while(row_in[i-1]!='\n' && row_in[i-1]!='\t' && row_in[i-1]!=' ');//row_in[i-1]!='\0' && 
		}
		catch (IOException e){
			System.out.println(e);
		}
		
		/*copy the the row_input to word size arre*/
		char[] word =new char[i-1];
		
		for (i=0; i<word.length; i++){	word[i]=row_in[i];}
			
		totalLength = word.length;	//set length of word 
		return String.valueOf(word);	//return after convert to String
	}

	public static int [] getIntBunch(){
		char[] get_string =rowInput();
		/*Addig a char in last*/
		char[] row_string =new char[get_string.length+1];
        System.arraycopy(get_string, 0, row_string, 0, get_string.length);
		row_string[row_string.length-1]='\0';
		int[] row_int_arre =new int[10];
		int char_count=0;
		char[] num;
		int k =0;
		for (int i=0; i<row_string.length; i++){
			if (row_string[i]>='0' && row_string[i]<='9')
				char_count++; //cont the total num char in row_string
			
			else if (char_count>0)
			{
				num=new char[char_count];
				for (int z=0, j=i-char_count; j<i; j++){
					num[z++]=row_string[j];
				}
				/*if arre length less for taking input then increse the size*/
				if(k==row_int_arre.length-1)
					row_int_arre=reallock(row_int_arre);
				
				row_int_arre[k++]=Integer.parseInt(String.valueOf(num)); //converction process[char => string => int ]
				char_count=0; //reset char count
			}
		}
		int[] int_arre =new int[k];
        System.arraycopy(row_int_arre, 0, int_arre, 0, int_arre.length);
		
		return int_arre;
	}
	public static float [] getFloatBunch(){
		char[] get_string =rowInput();
		/*Addig a char in last*/
		char[] row_string =new char[get_string.length+1];
        System.arraycopy(get_string, 0, row_string, 0, get_string.length);
		row_string[row_string.length-1]='\0';
		float[] row_int_arre =new float[10];
		int char_count=0;
		char[] num;
		int k =0;
		for (int i=0; i<row_string.length; i++){
			if ((row_string[i]>='0' && row_string[i]<='9') || row_string[i]=='.')
				char_count++; //cont the total num char in row_string
			
			else if (char_count>0)
			{
				num=new char[char_count];
				for (int z=0, j=i-char_count; j<i; j++){
					num[z++]=row_string[j];
				}
				/*if arre length less for taking input then increse the size*/
				if(k==row_int_arre.length-1)
					row_int_arre=reallock(row_int_arre);
				
				row_int_arre[k++]=Float.parseFloat(String.valueOf(num)); //converction process[char => string => int ]
				char_count=0; //reset char count
			}
		}
		float[] int_arre =new float[k];
        System.arraycopy(row_int_arre, 0, int_arre, 0, int_arre.length);
		
		return int_arre;
	}

			
	public static String getLine(){
		return String.valueOf(rowInput());
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
		return String.valueOf(rowInput());
	}
/*Sub method */	
	private static char[] reallock(char[] old){
		char[] new_arre =new char[old.length*2];
		/*Copy the arre*/
        System.arraycopy(old, 0, new_arre, 0, old.length);
		return new_arre;
	}
	private static int[] reallock(int[] old){
		int[] new_arre =new int[old.length*2];
		/*Copy the arre*/
        System.arraycopy(old, 0, new_arre, 0, old.length);
		return new_arre;
	}
	private static float[] reallock(float[] old){
		float[] new_arre =new float[old.length*2];
		/*Copy the arre*/
        System.arraycopy(old, 0, new_arre, 0, old.length);
        /* for (int i=0; i<old.length; i++){	new_arre[i]=old[i];}*/
		return new_arre;
	}
}