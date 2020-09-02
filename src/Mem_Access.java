import java.util.Vector;


public class Mem_Access {
	static Vector<String> memory ; 
	
	public void setMemory (Vector<String> Mem)
	{
		this.memory = Mem ;
	}
	
	public Vector<String> MemAccess (String ALUResult , String ReadData2 , String SignExtend , String ZeroFlag , String BranchAddressResult , String MemWrite , String MemRead , String Branch )
	{
		if( MemWrite.equals("1"))
		{
			int add = Integer.parseInt(ALUResult ,2 );
			Register_File rgf = new Register_File() ;
			int f = rgf.rt;
			memory.add(add,rgf.Registers[f]);
			System.out.println("wrote to memory " +rgf.Registers[f]+ " at pos "+ add);
		}
		if( MemRead.equals("1"))
		{
			int add = (int) Long.parseLong(ALUResult ,2 );
			ReadData2 = memory.elementAt(add);
			System.out.println("read from memory " + ReadData2);
		}
		
		Vector<String> result = new Vector<String>();
		result.add(ALUResult);
		result.add(ReadData2);
		return result ;
	}
	

}
