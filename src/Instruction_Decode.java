import java.util.Vector;


public class Instruction_Decode {
	
      InstructionMemory instMemo ;
	
	
	public Instruction_Decode (InstructionMemory instMemo)
	{
		this.instMemo = instMemo ;
	}
	
	public Vector<String> InstDecode(String inst , String pc)
	{
		Register_File rgf = new Register_File();
		String[] read12im = rgf.decode(inst, instMemo);
		String immediate = read12im[2];
		while(immediate.length()!=16)
		{
			immediate = "0" + immediate;
		}
		System.out.println("immediate: " + immediate);
		String signExtend = SignExtend (immediate);
		System.out.println("SignExtend: " + signExtend);
		String ContUnit = ContUnit(read12im[3]);
		System.out.println("ContUnit: "+ ContUnit);
		Vector<String> result = new Vector<String>() ;
		result.add(ContUnit);
		result.add(read12im[0]);
		result.add(read12im[1]);
		result.add(pc);
		result.add(read12im[4]);
		result.add(read12im[5]);
		result.add(read12im[6]);
		result.add(signExtend);
		System.out.println(pc);
		return result;
	}
	
	public String SignExtend ( String immediate)
	{
		String first = immediate.substring(0,1);
		while(immediate.length()!=32)
		{
			immediate = first + immediate;
		}
		return immediate ;
	}
	
	public String ContUnit (String op)
	{
		String result ="";
		if( op.equals("101011"))
		{
			result = "00x10010x";
			System.out.println("store word instruction" );
		}
		else if (op.equals("100011"))
		{
			
			result = "000111001";
			System.out.println("load word instruction");
			
			
		}
		else if (op.equals("000000"))
		{
			
			result = "101010000";
			System.out.println("R-type instruction" );
			
			
		}
		else if (op.equals("000100"))
		{
			
            result = "01x00001x";
			System.out.println("beq instruction" );
		
			
		}
		return result ;
	}

}
