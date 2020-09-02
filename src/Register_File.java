public class Register_File {

  public  static  String [] Registers = new String[32];
  public    boolean writeFlag ;
  public	String ReadRegister1;
  public	String ReadRegister2;
  public    int WriteRegister;
   static int rt;
   static int immediate=0;
   static int rs;
   static int rd=0;
   static int func = 0  ;
  
  public Register_File() {
		this.Registers[0] = "00000000000000000000000000000000";
	}
  
  
  public  String[] decode(String instruction, InstructionMemory instructionMemory) {
	  
	    String op = instruction.substring(0, 6);
	   
		
		
		 
		if( op.equals("101011"))
		{
			
			rs = Integer.parseInt(instruction.substring(6, 11), 2);
			rt = Integer.parseInt(instruction.substring(11, 16), 2);
			immediate = Integer.parseInt(instruction.substring(16, 32), 2);
			ReadRegister1 = Registers[rs];
			ReadRegister2 = "0000000000000000"+instruction.substring(16, 32);
			WriteRegister = rt ;
			System.out.println("store word instruction" +" op: " +op+" rs: " + rs + " rt: "+ rt + " immediate: " + immediate +" Type: I-type");
		}
		else if (op.equals("100011"))
		{
			
			rs = Integer.parseInt(instruction.substring(6, 11), 2);
			rt = Integer.parseInt(instruction.substring(11, 16), 2);
			immediate = Integer.parseInt(instruction.substring(16, 32), 2);
			ReadRegister1 = Registers[rs];
			ReadRegister2 = "0000000000000000"+ instruction.substring(16, 32);
			WriteRegister = rt ;
			System.out.println("load word instruction" +" op: " +op+" rs: " + rs + " rt: "+ rt + " immediate: " + immediate +" Type: I-type" );
			
			
		}
		else if (op.equals("000000"))
		{
			
			func = Integer.parseInt(instruction.substring(26, 32), 2);
			rs = Integer.parseInt(instruction.substring(6, 11), 2);
			rt = Integer.parseInt( instruction.substring(11, 16), 2);
			rd = Integer.parseInt(instruction.substring(16, 21), 2);
			ReadRegister1 = Registers[rs];
			ReadRegister2 = Registers[rt];
			WriteRegister = rd ;
			if (func == 32) {
				
				System.out.println("addition instruction" +" op: " +op+ " fuc: " + func + " rs: " + rs + " rt: " + rt + " rd: "+rd +" Type: R-type" );
			}
			else if (func == 34 )
			{
				
				System.out.println("subtraction instruction" +" op: " +op+ " fuc: " + func + " rs: " + rs + " rt: " + rt + " rd: "+rd +" Type: R-type");
			}
			
			
			
		}
		else if (op.equals("000100"))
		{
			
			rs = Integer.parseInt(instruction.substring(6, 11), 2);
			rt = Integer.parseInt(instruction.substring(11, 16), 2);
			immediate = Integer.parseInt(instruction.substring(16, 32), 2);
			ReadRegister1 = Registers[rs];
			ReadRegister2 = Registers[rt];
			

			System.out.println("beq instruction" +" op: " +op+ " rs: " + rs + " rt: " + rt + " immediate: " + immediate +" Type: Conditional branch");
		
			
		}
		else if (op.equals("000010"))
		{
			immediate = Integer.parseInt(instruction.substring(6, 32), 2);
			System.out.println("jump instruction" +" op: " +op+ " immediate: " + immediate + " Type: J-type branch");
			
		}
		else
		{
			func = Integer.parseInt(instruction.substring(26, 32), 2);
			rs = Integer.parseInt(instruction.substring(6, 11), 2);
			rt = Integer.parseInt( instruction.substring(11, 16), 2);
			rd = Integer.parseInt(instruction.substring(16, 21), 2);
			ReadRegister1 = Registers[rs];
			ReadRegister2 = Registers[rt];
			WriteRegister = rd ;
		}
		
		String[] result = new String[7];
		result[0] = ReadRegister1 ;
		result[1] = ReadRegister2 ;
		System.out.println("ReadReg1: " + ReadRegister1);
		System.out.println("ReadReg2: "+ReadRegister2);
		result[2] = instruction.substring(16, 32);
		result[3] = op;
		result[4] = instruction.substring(16, 21) ;
		result[5] = instruction.substring(11, 16) ;
		result[6] = instruction.substring(26, 32) ;
		return result ;
		
}
	
}
