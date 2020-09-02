import java.util.Vector;


public class Instruction_Fetch {
	
	InstructionMemory instMemo ;
	
	
	public Instruction_Fetch(InstructionMemory instMemo)
	{
		this.instMemo = instMemo ;
	}

	public String InstFetch (String pc)
	{
		int i = Integer.parseInt(pc, 2);
		String inst = instMemo.getInstructions().get(i);
		ProgCount();
		
		System.out.println(inst);
		return inst ;
	}
	
	public void ProgCount ()
	{
		System.out.println("pc before : "+ instMemo.programCounter );
		int pc = Integer.parseInt((instMemo.programCounter), 2);
		pc++ ;
		String pcFinal = Integer.toBinaryString(pc);
		while(pcFinal.length()!=32)
		{
			pcFinal = "0" + pcFinal;
		}
		instMemo.programCounter = pcFinal;
		System.out.println("pc after : "+ pcFinal );
	}
}
