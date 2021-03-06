import java.util.*;
 
public class sjfalgo {
	public static void main (String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println ("enter no of process:");
		int n= sc.nextInt();
		int p[] = new int[n];   // it takes pid of process
		int at[] = new int[n];  // at means arrival time
		int bt[] = new int[n];  // bt means burst time
		int ct[] = new int[n];  // ct means complete time
		int ta[] = new int[n];  // ta means turn around time
		int wt[] = new int[n];  // wt means waiting time
		int f[] = new int[n];   // f means it is flag it checks process is completed or not
		int k[]= new int[n];    // it is also stores brust time
	    int i, st=0, tot=0;
	    float awt=0, ata=0;
 
	    for (i=0;i<n;i++)
	    {
	    	p[i]= i+1;
	    	System.out.println ("enter process " +(i+1)+ " arrival time:");
	    	at[i]= sc.nextInt();
	    	System.out.println("enter process " +(i+1)+ " burst time:");
	    	bt[i]= sc.nextInt();
	    	k[i]= bt[i];
	    	f[i]= 0;
	    }
	    
	    while(true){
	    	int min=99,c=n;
	    	if (tot==n)     //total 
	    		break;
	    	
	    	for ( i=0;i<n;i++)  
	    	{
	    		if ((at[i]<=st) && (f[i]==0) && (bt[i]<min))  //if arrival time less than equal to st(first time 0 then 1 & so on & process not completed & burst time < min(99 assumed)
	    		{	
	    			min=bt[i];  //burst time of that process saved in min
	    			c=i;        // index of that process is stored in c
	    		}
	    	}
	    	
	    	if (c==n)   //if no process's arrival time is 0
	    		st++;  //st incremented
	    	else
	    	{
	    		bt[c]--;   //burst time decremented by 1(since it executed for 1 msec)
	    		st++;      // st incremented
	    		if (bt[c]==0)   //it burst time of that process is 0
	    		{
	    			ct[c]= st;  
	    			f[c]=1;    //completed
	    			tot++;	   //total updated
	    		}
	    	}
	    }
	    
	    for(i=0;i<n;i++)
	    {
	    	ta[i] = ct[i] - at[i];
	    	wt[i] = ta[i] - k[i];
	    	awt+= wt[i]; //total waiting time calculated
	    	ata+= ta[i];  //total turn around time calculated
	    }
	    
	    System.out.println("p  arrival  burst  complete turn waiting");
	    for(i=0;i<n;i++)
	    {
	    	System.out.println(p[i] +"\t"+ at[i]+"\t"+ k[i] +"\t"+ ct[i] +"\t"+ ta[i] +"\t"+ wt[i]);
	    }
	    
	    System.out.println("\naverage tat is "+ (float)(ata/n));
	    System.out.println("average wt is "+ (float)(awt/n));
	    sc.close();
	}
}