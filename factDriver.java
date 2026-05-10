

import java.util.Scanner;

class Factorial {
	long[] fact = new long[21];

	long factorial(int x) {
		if (x < 0) {
			throw new IllegalArgumentException(
					"value of x must be positive"
			);
		}
		if(x >= fact.length){
			throw new IllegalArgumentException(
					"result will overflow"
			);
		}
		if(fact[x]!=0){
			return fact[x];
		}
		if(x==0 || x==1){
			fact[x]=1;
			return 1;
		}
		fact[x] = x*factorial(x-1);
		return fact[x];
	}
}

public class factDriver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Factorial f = new Factorial();
        try{
            System.out.println("enter a number: ");
            int x = in.nextInt();
            long result = f.factorial(x);
            System.out.println(x+"! = "+result);
        }catch(IllegalArgumentException e){
            System.out.println("Exception: "+e.getMessage());
        }
    }
}
