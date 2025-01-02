import java.util.Arrays;
import java.util.Scanner;

class Main {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
		int[] arr = new int[size];
		for(int i=0;i<size;i++)
		{
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int sum=0;
		
		for(int i=1;i<size;i++)
		{
			arr[i] = arr[i] + arr[i-1];
		}
		for(int i=0;i<size;i++ )
		{
			sum+=arr[i];
		}
		sc.close();
		
		System.out.println(sum);
	}

}