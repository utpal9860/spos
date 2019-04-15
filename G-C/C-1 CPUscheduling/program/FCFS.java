import java.io.*; 

class FCFS 

      { 

	
public static void main(String args[]) throws Exception
 
	    { 

		int n,bt[],wt[],tat[]; 

		float awt=0; 

		InputStreamReader isr=new InputStreamReader(System.in); 

		BufferedReader br=new BufferedReader(isr);
 
		System.out.println("Enter no of process"); 

		n=Integer.parseInt(br.readLine()); 
 

		wt=new int[n]; 

		tat=new int[n]; 

		bt=new int[n];

		System.out.println("Enter Burst time for each process\n"); 

		for(int i=0;i<n;i++) 

			{ 

				System.out.println("Process["+(i+1)+"]"); 

				bt[i]=Integer.parseInt(br.readLine()); 

			} 

			System.out.println("\n"); 

			wt[0]=0; 

			for(int i=1;i<n;i++) 

				{ 

					wt[i]=wt[i-1]+bt[i-1]; 

 					awt=awt+wt[i];

				} 

			for(int i=0;i<n;i++) 

				{ 

					tat[i]=wt[i]+bt[i]; 


				} 

			System.out.println("  PROCESS\t\tBURST-TIME\tWAITING-TIME\tTURN AROUND-TIME\n"); 

			for(int i=0;i<n;i++) 

				{

					System.out.println("    "+ i + "\t\t"+bt[i]+"\t"+wt[i]+"\t"+tat[i]);

				} 

					awt=awt/n; 

			System.out.println("\n"); 

			System.out.println("Avg waiting time="+awt+"\n"); 

	    } 

    }