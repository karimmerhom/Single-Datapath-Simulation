import java.util.Vector;


public class Write_Back {
	
	public String WriteBack ( String ALUresult , String ReadData2 , String MemToReg , String RegDst , String rd , String rt , Register_File rf , Vector<String> Memory)
	{
		int dest = 0 ;
		String result = "" ;
		if(RegDst.equals("0"))
		{
			dest = Integer.parseInt(rt,2);
		}
		if(RegDst.equals("1"))
		{
			dest = Integer.parseInt(rd,2);
		}
		if(MemToReg.equals("1"))
		{
			rf.Registers[dest] = ReadData2 ;
			result = ReadData2 ;
			System.out.println("wrote from mem to reg");
		}
		else if (MemToReg.equals("0"))
		{
			rf.Registers[dest]= ALUresult ;
			result = ALUresult ;
			System.out.println("alu result wrote to reg");
		
		}
		return result ;
	}

}
