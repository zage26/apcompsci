
public class threeSorts {
	
	
	public static void main(String args[]) {
		int[] array = {5, 1, 4, 2, 3};
		bubble(array);
		System.out.println("");
		insertion(array);
		System.out.println("");
		selection(array);
	}
	
	public static void swap(int[] a, int i, int j) {
		int one = a[i];
		int two = a[j];
		a[i] = two;
		a[j] = one;
	}
	
	public static int[] bubble(int[] a) {
		
		int num = 0;
		for (int j = 0; j < a.length; j++) {	
			for (int i = 0; i < a.length - 1; i++) {
				if (a[i+1] < a[i]) {
					swap(a, i, i+1);
				} else {
					num++;
				}
			}
		}
		
		//proof
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		
		return a;
	}
	
	public static int[] insertion(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for(int j = 0; j < i; j++) {
				if (a[j] > a[i]) {
					
					int num = a[i];
					
					for (int k = i; k > j; k--) {
						a[k] = a[k-1];
					}
					
					a[j] = num;
					
					break;
				}
			}
		}
		
		//proof
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		
		return a;
	}

	public static int smallest(int[] a, int i) {
		
		int small = i+1;
		for(int num = i+1; num < a.length; num++) {
			if (a[num] < a[small]) {
			 small = num;
			}	
		}	
		return small;
	}
	
	public static int[] selection(int[] a) {
		
		for(int i = 0; i < a.length - 1; i++) {
			int sm = smallest(a, i);
			if(a[i] > a[sm]) {
				swap(a, sm, i);
			}
		}
		
		//proof
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

		return a;
	}

}
