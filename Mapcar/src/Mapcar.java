import java.util.LinkedList; 
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

public abstract class Mapcar<T1, T2> {
	
	private Collection<T1> coll;
		 
	protected Mapcar() {}
		
	protected Mapcar(Collection<T1> coll) {
		this.coll = coll;
	}
		
	public List<T2> run() { 
		return run(coll);
	}
		
	public List<T2> run(Collection<T1> coll) {
		List<T2> res = new ArrayList<T2>();
		if (coll != null) {
			for (T1 x : coll) {
				T2 t2 = lambda(x);
				if (t2 != null) {
					res.add(t2);
				}
			}
		}
		return res;
	}
	
	public abstract T2 lambda(T1 x);
}

