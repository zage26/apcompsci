
public class Intro {
	
	public static void main(String[] args) {
		
		System.out.println(ret());
		System.out.println(logic(true, true, true));
		stars(5);
		System.out.println(coins(3));
		
	}

	public static int ret() {
		return 17;
	}
	
	public static boolean logic(boolean a, boolean b, boolean c) {
		return (a && b && c);
	}
	
	public static void stars(int n) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
		
	}
	
	public static int coins(int n) {
		
		int num2coins = 0;
		int num5coins = 0;

		if (n==0 || n==1 || n==3) {
			return -1;
		} else if (n==2){
			return 1;
		} else if (n==4) {
			return 2;
		} else if (n>=5) {
			num5coins += n/5;
			n %= 5;
			if (n == 0) {
				return num5coins;
			} else if (n%2 == 0) {
				num2coins = n/2;
				return num2coins + num5coins;
			} else {
				return -1;
			}
		} else {
			return -1;
		}
	}
}
	

