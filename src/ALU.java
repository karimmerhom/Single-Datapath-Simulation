
public class ALU {
static int z ;
	
	public static void ALUEvaluator ( String Op, int Operand1 , int Operand2 ) 
	{
		System.out.println("Input:");
		System.out.println("1st Operand: " + Operand1);
		System.out.println("2nd Operand: " + Operand2);
		System.out.println("Operation: " + Op);
		int result = 0;
		if ( Op.equals("0000"))
		{   
			System.out.println("Output:");
			System.out.println("Operation Name: AND" );
			System.out.println("1st Operand: " + Operand1);
			System.out.println("2nd Operand: " + Operand2);
			result = ANDOp(Operand1, Operand2);
			System.out.println("Output: " +result);
		}
		if ( Op.equals("0001"))
		{
			System.out.println("Output:");
			System.out.println("Operation Name: OR" );
			System.out.println("1st Operand: " + Operand1);
			System.out.println("2nd Operand: " + Operand2);
			result = OROp(Operand1, Operand2);
			System.out.println("Output: " +result);
		}
		if ( Op.equals("0010"))
		{
			System.out.println("Output:");
			System.out.println("Operation Name: add" );
			System.out.println("1st Operand: " + Operand1);
			System.out.println("2nd Operand: " + Operand2);
			result = addOp(Operand1, Operand2);
			System.out.println("Output: " +result);
		}
		if ( Op.equals("0110"))
		{    
			System.out.println("Output:");
			System.out.println("Operation Name: sub" );
			System.out.println("1st Operand: " + Operand1);
			System.out.println("2nd Operand: " + Operand2);
			result = subOp(Operand1, Operand2);
			System.out.println("Output: " +result);
		}
		if ( Op.equals("0111"))
		{
			System.out.println("Output:");
			System.out.println("Operation Name: slt" );
			System.out.println("1st Operand: " + Operand1);
			System.out.println("2nd Operand: " + Operand2);
			result = sltOp(Operand1, Operand2);
			System.out.println("Output: " +result);
		}
		if ( Op.equals("1100"))
		{
			System.out.println("Output:");
			System.out.println("Operation Name: NOR" );
			System.out.println("1st Operand: " + Operand1);
			System.out.println("2nd Operand: " + Operand2);
			result = NOR(Operand1, Operand2);
			System.out.println("Output: " +result);
		}
		if (result == 0 )
		{
			z = 1;
		}
		else
		{
			z=0;
		}
		System.out.println("Z-Flag Value: " +z);
	}
	
	public static String ALUEvaluator ( String Op, String Operand1 , String Operand2 ) 
	{
		System.out.println("Input:");
		System.out.println("1st Operand: " + Operand1);
		System.out.println("2nd Operand: " + Operand2);
		System.out.println("Operation: " + Op);
		String result = "";
		if ( Op.equals("0000"))
		{
			result = ANDOp(Operand1, Operand2);
			System.out.println("Output:");
			System.out.println("Operation Name: AND" );
			System.out.println("1st Operand: " + Operand1);
			System.out.println("2nd Operand: " + Operand2);
			System.out.println("Output: " +result);
		}
		if ( Op.equals("0001"))
		{
			result = OROp(Operand1, Operand2);
			System.out.println("Output:");
			System.out.println("Operation Name: OR" );
			System.out.println("1st Operand: " + Operand1);
			System.out.println("2nd Operand: " + Operand2);
			System.out.println("Output: " +result);
		}
		if ( Op.equals("0010"))
		{
			result = addOp(Operand1, Operand2);
			System.out.println("Output:");
			System.out.println("Operation Name: add" );
			System.out.println("1st Operand: " + Operand1);
			System.out.println("2nd Operand: " + Operand2);
			System.out.println("Output: " +result);
		}
		if ( Op.equals("0110"))
		{
			result = subOp(Operand1, Operand2);
			System.out.println("Output:");
			System.out.println("Operation Name: sub" );
			System.out.println("1st Operand: " + Operand1);
			System.out.println("2nd Operand: " + Operand2);
			System.out.println("Output: " +result);
		}
		if ( Op.equals("0111"))
		{
			result = sltOp(Operand1, Operand2);
			System.out.println("Output:");
			System.out.println("Operation Name: slt" );
			System.out.println("1st Operand: " + Operand1);
			System.out.println("2nd Operand: " + Operand2);
			System.out.println("Output: " +result);
		}
		if ( Op.equals("1100"))
		{
			result = NOR(Operand1, Operand2);
			System.out.println("Output:");
			System.out.println("Operation Name: NOR" );
			System.out.println("1st Operand: " + Operand1);
			System.out.println("2nd Operand: " + Operand2);
			System.out.println("Output: " +result);
		}
		int bits = (int) Long.parseLong(result, 2);
		if (bits == 0 )
		{
			z = 1;
		}
		else
		{
			z=0;
		}
		System.out.println("Z-Flag value: " +z);
		return result;
	}
	
	
	public static String ANDOp ( String operand1 , String operand2)
	{
		String result = "";
		char[] arr1 = operand1.toCharArray();
		char[] arr2 = operand2.toCharArray();
		for(int i=0 ; i<operand1.length() ; i++ )
		{
			
			if((arr1[i]=='1') &&( arr2[i]=='1')){
				
				result+="1";
			}
			else
			{
				result+=0;
			}
		}
		
		return result;
	}
	public static int ANDOp ( int operand1 , int operand2)
	{
		String result = "";
		String operand11 = Integer.toBinaryString(operand1);
		String operand22 = Integer.toBinaryString(operand2);
		char[] arr1 = new char[32];
		char[] arr2 = new char[32];
		int j = 31 ;
		for(int i=operand11.length()-1; i>=0;i--)
		{
			
			arr1[j]=operand11.charAt(i);
			j--;
		}
		j=31;
		for(int i=0; i<arr1.length;i++)
		{
		       if(arr1[i]!= '0' && arr1[i]!= '1' ){
				arr1[i]='0';}
			
		}
		for(int i=operand22.length()-1; i>=0;i--)
		{
			
			arr2[j]=operand22.charAt(i);
			j--;
		}
	
		for(int i=0; i<arr2.length;i++)
		{
		       if(arr2[i]!= '0' && arr2[i]!= '1' ){
				arr2[i]='0';}
			
		}


		for(int i=0 ; i<32 ; i++ )
		{
			
			if((arr1[i]=='1') &&( arr2[i]=='1')){
				
				result+="1";
			}
			else
			{
				result+=0;
			}
		}
		
		int bits = (int) Long.parseLong(result, 2);
		return bits;
	}
	public static String OROp ( String operand1 , String operand2)
	{
		String result = "";
		char[] arr1 = operand1.toCharArray();
		char[] arr2 = operand2.toCharArray();
		for(int i=0 ; i<operand1.length() ; i++ )
		{
			
			if((arr1[i]=='1') || ( arr2[i]=='1')){
				
				result+="1";
			}
			else
			{
				result+=0;
			}
		}
		
		return result;
	}
	public static int  OROp ( int operand1 , int operand2)
	{
		String result = "";
		String operand11 = Integer.toBinaryString(operand1);
		String operand22 = Integer.toBinaryString(operand2);
		char[] arr1 = new char[32];
		char[] arr2 = new char[32];
		int j = 31 ;
		for(int i=operand11.length()-1; i>=0;i--)
		{
			
			arr1[j]=operand11.charAt(i);
			j--;
		}
		j=31;
		for(int i=0; i<arr1.length;i++)
		{
		       if(arr1[i]!= '0' && arr1[i]!= '1' ){
				arr1[i]='0';}
			
		}
		for(int i=operand22.length()-1; i>=0;i--)
		{
			
			arr2[j]=operand22.charAt(i);
			j--;
		}
	
		for(int i=0; i<arr2.length;i++)
		{
		       if(arr2[i]!= '0' && arr2[i]!= '1' ){
				arr2[i]='0';}
			
		}


		for(int i=0 ; i<32 ; i++ )
		{
			
			if((arr1[i]=='1') || ( arr2[i]=='1')){
				
				result+="1";
			}
			else
			{
				result+=0;
			}
		}

		
		int bits = (int) Long.parseLong(result, 2);
		return bits;
	}
	public static String addOp ( String operand1 , String operand2)
	{
		String result = "";
		int sum = Integer.parseInt(operand1 , 2) +  Integer.parseInt(operand2 , 2);
		String sum1 = Integer.toBinaryString(sum);
		char[] arr1 = new char[32];
		int j = 31 ;
		for(int i= sum1.length()-1 ; i>=0 ; i-- )
		{
			arr1[j] = sum1.charAt(i);
			j--;
		}
		for(int i=0 ; i<arr1.length ; i++ )
		{
			if(arr1[i]!= '0' && arr1[i]!='1')
			arr1[i] = '0';
			result+=arr1[i];
		}
		
		
		
		return result;
	}
	public static int addOp ( int operand1 , int operand2)
	{
		
		return operand1 + operand2;
	}
	public static String subOp ( String operand1 , String operand2)
	{
		String result = "";
		int sum = Integer.parseInt(operand1 , 2) -  Integer.parseInt(operand2 , 2);
		String sum1 = Integer.toBinaryString(sum);
		char[] arr1 = new char[32];
		int j = 31 ;
		for(int i= sum1.length()-1 ; i>=0 ; i-- )
		{
			arr1[j] = sum1.charAt(i);
			j--;
		}
		for(int i=0 ; i<arr1.length ; i++ )
		{
			if(arr1[i]!= '0' && arr1[i]!='1')
			arr1[i] = '0';
			result+=arr1[i];
		}
		
		

		return result;
	}
	public static int subOp ( int operand1 , int operand2)
	{

	
		return operand1 - operand2;
	}
	public static String sltOp ( String operand1 , String operand2)
	{
		String result = "00000000000000000000000000000000";
		int operand11 = Integer.parseInt(operand1,2);
		int operand22 = Integer.parseInt(operand2,2);
		if(operand11<operand22)
		{
			result = "011111111111111111111111111111111" ;
		}
		return result;
	}
	public static int sltOp ( int operand1 , int operand2)
	{
		int res = 0 ;
	
		if(operand1<operand2)
		{
			res=1;
		}
		
		return res;
	}
	
	public static String NOR ( String operand1 , String operand2)
	{
		String result = "";
		char[] arr1 = operand1.toCharArray();
		char[] arr2 = operand2.toCharArray();
		for(int i=0 ; i<operand1.length() ; i++ )
		{
			
			if((arr1[i]=='1') || ( arr2[i]=='1')){
				
				result+="0";
			}
			else
			{
				result+=1;
			}
		}
	
		return result;
	}
	public static int  NOR ( int operand1 , int operand2)
	{
		String result = "";
		String operand11 = Integer.toBinaryString(operand1);
		String operand22 = Integer.toBinaryString(operand2);
		char[] arr1 = new char[32];
		char[] arr2 = new char[32];
		int j = 31 ;
		for(int i=operand11.length()-1; i>=0;i--)
		{
			
			arr1[j]=operand11.charAt(i);
			j--;
		}
		j=31;
		for(int i=0; i<arr1.length;i++)
		{
		       if(arr1[i]!= '0' && arr1[i]!= '1' ){
				arr1[i]='0';}
			
		}
		for(int i=operand22.length()-1; i>=0;i--)
		{
			
			arr2[j]=operand22.charAt(i);
			j--;
		}
	
		for(int i=0; i<arr2.length;i++)
		{
		       if(arr2[i]!= '0' && arr2[i]!= '1' ){
				arr2[i]='0';}
			
		}


		for(int i=0 ; i<32 ; i++ )
		{
			
			if((arr1[i]=='1') || ( arr2[i]=='1')){
				
				result+="0";
			}
			else
			{
				result+=1;
			}
		}
		int bits = (int) Long.parseLong(result, 2);
		return bits;
	}

//	public static void main(String[]args)
//	{
//		ALU test = new ALU();
//        test.ALUEvaluator("0000",5,13);
//        test.ALUEvaluator("0000","00000000000000000000000000000101","00000000000000000000000000001101");
//        test.ALUEvaluator("0001",9,25);
//        test.ALUEvaluator("0001","00000000000000000000000000001001","00000000000000000000000000011001");
//        test.ALUEvaluator("1100",8,8);
//        test.ALUEvaluator("1100","00000000000000000000000000001000","00000000000000000000000000001000");
//        test.ALUEvaluator("0010",8,8);
//        test.ALUEvaluator("0010","00000000000000000000000000001000","00000000000000000000000000001000");
//        test.ALUEvaluator("0111",9,12);
//        test.ALUEvaluator("0111","00000000000000000000000000001001","00000000000000000000000000001100");
//        test.ALUEvaluator("0110",27,18);
//        test.ALUEvaluator("0110","00000000000000000000000000011011","00000000000000000000000000010010");
//        
//	}
}
