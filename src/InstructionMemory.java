
import java.util.Vector;

public class InstructionMemory {

	private Vector <String> Instructions ;
	public static String programCounter;
	
	public InstructionMemory() {
		programCounter = "00000000000000000000000000000000";
		
		
	}

	public void LoadInstructions(Vector<String> instructions)
	{
		this.Instructions= instructions;
		System.out.println("Instructions loaded");
	}
	public Vector <String> getInstructions() {
		return Instructions;
		
	}
	
	
	

}
