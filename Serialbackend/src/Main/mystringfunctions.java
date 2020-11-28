package Main;

public class mystringfunctions {
	
	static int lastCommandLength = 0;
	
	public static void outputstring (String str){
		System.out.println(str);
		
	}

	public static int toAscii(char ch) {
		int castAscii = (int) ch;
		
		return castAscii;
	}
	
	public static void outputstringascii(String str) {
		
		// length of the string used for the loop
		int strLength = str.length();
		
		for (int i = 0; i < strLength ; i++) {
			
			// start on the first character
			char character = str.charAt(i);
		
			//convert the first character to asci value 
			int ascii = (int) character;
		
		    //int i = toAscii(ch[i]);
		    outputstring(character + " is Ascii value " + String.valueOf(ascii));
		    //System.out.println("Ascii value of " + (char)i + " = " + i);
		    	   
		}
	}
	
		
	public static String LastCommand(String str) {
		String ret = "";
		int index;
		
		if (str.length() > lastCommandLength) { 
		
			if(str.length()>0 ) {
			
		
				char ch = str.charAt(str.length()-1);
		
				if(ch == (char) 10) {
		
					index = str.lastIndexOf((char) 10, str.length() -2);
				
					if (index == -1) { 
						index = -1; 
					}
				
					ret = str.substring(index +1, str.length() - 1);
				}
		//char ch = str.substring(beginIndex, endIndex);
			}		
		}
		
		lastCommandLength = str.length();
		
		//String res = SendAndReceive(newValue.toUpperCase().substring(newValue.length() - 1, newValue.length()))
		return ret;
		
		}
	
	}


