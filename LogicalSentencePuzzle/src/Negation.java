public class Negation extends LogicalSentence{
	
	//Variables
	private LogicalSentence logS;

	//Super constructor from Logical Sentence class
	public Negation(LogicalSentence logS) {
		super(logS);
	}
	
	//Super the evaluate method from the Logical Sentence class
	//Returns negated truth value 
	public boolean evaluate(TruthAssignment ta) {
		return !super.evaluate(ta);
	}
}