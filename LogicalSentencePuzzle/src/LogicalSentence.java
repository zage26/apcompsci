import java.util.ArrayList;

public class LogicalSentence {

	//Variables
	private PropositionConstant propConst;
	private LogicalSentence logS;
	private LogicalSentence conjFirst;
	private LogicalSentence conjSecond;

	//General Logical Sentence Constructor
	public LogicalSentence(PropositionConstant propConst) {
		this.propConst = propConst;
	}
	
	//Constructor used for Negation class
	public LogicalSentence(LogicalSentence logS) {
		this.logS = logS;
		this.propConst = logS.propConst;
	}
	
	//Constructor used for Conjunction class
	public LogicalSentence(LogicalSentence conjFirst, LogicalSentence conjSecond) {
		this.conjFirst = conjFirst;
		this.conjSecond = conjSecond;
	}
	
	//Getter methods for Conjunction class
	public LogicalSentence getConjFirst() {
		return conjFirst;
	}
	
	public LogicalSentence getConjSecond() {
		return conjSecond;
	}
	
	//Getter for propositional constant
	public PropositionConstant getPropConst() {
		return propConst;
	}
	
	//Takes in a TruthAssignment that contains two proposition constants and two booleans
	public boolean evaluate(TruthAssignment ta1) {
		return ta1.getb(propConst);
	}
}