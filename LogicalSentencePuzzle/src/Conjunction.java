public class Conjunction extends LogicalSentence{
	
	//Super constructor created in LogicalSentence class
	public Conjunction(LogicalSentence conjFirst, LogicalSentence conjSecond) {
		super(conjFirst, conjSecond);
	}
	
	//Checks boolean value of conjFirst and conjSecond 
	public boolean evaluate(TruthAssignment ta) {
		return (getConjFirst().evaluate(ta) && getConjSecond().evaluate(ta));
	}
	
}