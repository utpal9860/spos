import java.util.Scanner;

public class round 
  {
        
    public static void main(String args[]) 
           {
             Scanner s = new Scanner(System.in);
 
             int wt[],bt[],rt[],tat[],num,quantum,total;
 
          wt = new int[10];
          bt = new int[10];
          rt = new int[10];
 	  tat = new int[10];
 
System.out.print("Enter number of processes(MAX 10): ");
num = s.nextInt();
System.out.print("Enter burst time");
for(int i=0;i<num;i++) 
 { 
	System.out.print("\nP["+(i+1)+"]: "); 
	bt[i] = s.nextInt(); 
	rt[i] = bt[i]; 
	wt[i]=0; 
 } 
System.out.print("\n\nEnter quantum: "); 
quantum = s.nextInt(); 
int rp = num; 
int i=0; 
int time=0; 
System.out.print("0"); 
wt[0]=0; 
while(rp!=0)   //while no. of processes are not 0
	{ 
		if(rt[i]>quantum)	//if burst time is > quantum
 			{
   				rt[i]=rt[i]-quantum;    //burst time of that process updated
   				System.out.print(" | P["+(i+1)+"] | ");
   				time+=quantum;   //time updated
   				System.out.print(time);
   			rp--;
			}
 		else if(rt[i]<=quantum && rt[i]>0)   //if burst time is > 0 but less than quantum
 			{
				time+=rt[i];            //time updated(time + burst time)
  				rt[i]=rt[i]-rt[i];    //burst time of that process is updated(it will be 0)
  				System.out.print(" | P["+(i+1)+"] | ");
  				rp--;   // no. of processes updated(since current process completed its execution)
				System.out.print(time);
 			}
 
				i++;    //go to next process
				if(i==num)    //if last process then goes to first process(cycle repeats)
					{
						i=0;
					}
 
	}
 
 
     }
}
