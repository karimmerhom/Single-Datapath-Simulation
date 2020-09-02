import java.util.Vector;

public class Execute {
	
	public Vector<String> Execute (String ALUOp , String ALUSrc , String ReadData1 , String ReadData2 , String SignExtend , String pc , String func , InstructionMemory instmem )
	{
		String op = "" ;
		String flagz ="" ;
		String BranchResult ="0";

		if(ALUSrc.equals("1")) {
			ReadData2 = SignExtend;
			System.out.println(SignExtend + "readdata2");
		}
		if( ALUOp.equals("00"))
		{
			op = "0010";
			System.out.println("LW/SW");
		}
		else if( ALUOp.equals("01"))
		{
			op = "0110";
			System.out.println("BEQ");
		}
		
		else if( ALUOp.equals("10"))
		{
			System.out.println("R-TYPE");
			
			if ( func.equals("100000"))
			{
				op = "0010";
				System.out.println("ADD");
			}
			else if ( func.equals("100010"))
			{
				op = "0110";
				System.out.println("SUB");
			}
			else if ( func.equals("100100"))
			{
				op = "0000";
				System.out.println("AND");
			}
			else if ( func.equals("100101"))
			{
				op = "0001";
				System.out.println("OR");
			}
			else if ( func.equals("101010"))
			{
				op = "0111";
				System.out.println("Set-on-less-than");
			}
			
		}
		ALU alu = new ALU() ;
		String aluresult = alu.ALUEvaluator(op,ReadData1, ReadData2);
		int bits = (int) Long.parseLong(aluresult, 2);
		if (bits == 0 )
		{
			flagz = "1";
		}
		else
		{
			flagz="0";
		}
		System.out.println("Z-Flag value: " +flagz);
		System.out.println("ALUResult: " + aluresult);
		if(ALUOp.equals("01"))
		{
		int intpc = (int) Long.parseLong(pc,2);
		int intReadData2 = (int) Long.parseLong(ReadData2,2);
	    BranchResult = Integer.toBinaryString(intpc+intReadData2);
		while( BranchResult.length()!=32)
		{
			BranchResult = "0"+BranchResult;
		}
		Register_File a = new  Register_File() ;
		if(a.rt == a.rs)
		{
			instmem.programCounter= BranchResult;
		}
		
		System.out.println("BranchResult: "+BranchResult);
		System.out.println("ReadData2: "+ReadData2);
		System.out.println("pc: "+instmem.programCounter);
		}
		Vector<String> result = new Vector<String>() ;
		result.add(aluresult);
		result.add(flagz);
		result.add(BranchResult);
		result.add(ReadData2);
		result.add(instmem.programCounter);
		
		return result ;
	}
	

	
}
