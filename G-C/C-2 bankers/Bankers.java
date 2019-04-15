import java.util.*;
public class Bankers {

 public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter number Of Process:");
    int n = sc.nextInt();
    System.out.println("Enter number Of Resources:");
    int m = sc.nextInt();
    System.out.println("\n==============================  ");
 int available[] = new int[m];
 int max[][] = new int[n][m];
 int allocation[][] = new int[n][m];
 int need[][] = new int[n][m];
 String sequence = "";
 
 //Allocoation
for(int i = 0; i < n; i++)
 {
	 for(int j = 0; j < m; j++)
	 {
		 System.out.println("Allocation P" + (i) + " for R " + (j) + ":");
		 allocation[i][j] = sc.nextInt();
		 
		 //calcultaiong available
		 available[j]+=allocation[i][j];
	 }
 }

System.out.println("\n==============================  ");
//Displaying Available
for(int i=0;i<m;i++) {
	System.out.println("Available for Resource R"+i);
	System.out.println(available[i]+"  ");
}
System.out.println("\n==============================  ");
//Max and Needs
 for(int i = 0; i < n; i++)
 {
	 for(int j = 0; j < m; j++)
	 {
		 System.out.println("Max P" + (i) + " for R " + (j) + ":");
		 max[i][j] = sc.nextInt();
		 need[i][j] = max[i][j] - allocation[i][j];
	 }
 }
 System.out.println("\n==============================  ");
int work[] = available;
boolean finish[] = new boolean[n];
for(int i = 0; i < n; i++)
 {
	finish[i] = false;
 }
 
boolean check = true;
	 while(check)
	 {
	 	check = false;
	 	for(int i = 0; i < n; i++)
	 	{
			 if(!finish[i])
			 {
				 int j;
				 for(j = 0; j < m; j++)
				 {
					 if(need[i][j] > work[j])
					 {
						 break;
					 }
				 }
				 if(j == m)
				 {
					 for(j=0; j < m; j++)
					 {
					 work[j] = work[j] + allocation[i][j];
					 }
					 finish[i] = true;
					 check = true;
					 sequence += i + ", ";
				 }
			}
	 	}
	 }

	int i;
	for(i = 0; i < n; i++)
	{
		if(!finish[i])
			break;
	}
	 
	if(i==n)
	{
		System.out.println("SAFE And Sequence is:"+sequence);
	}
	else
	{
		System.out.println("unsafe");
	}

 
 }
}
