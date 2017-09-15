import java.util.ArrayList;

public class TruthAssignment {
	
	//Variables
	private ArrayList<PropositionConstant> pca;
	private ArrayList<Boolean> ba;
	
	//Initializes variables
	public TruthAssignment() {
		pca = new ArrayList<PropositionConstant>();
		ba = new ArrayList<Boolean>();
	}
	
	//Takes information (a propositional constant and boolean)
	//and places them into an appropriate array 
	public void put(PropositionConstant pc, boolean b) {
		pca.add(pc);
		ba.add(b);
	}
	
	//Get the index of where the propositional is in the given 
	//prop. constant array and find corresponding boolean value 
	public boolean getb(PropositionConstant pc) {
		int bi = pca.indexOf(pc);
		return ba.get(bi);
	}
}