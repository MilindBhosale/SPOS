import java.util.*;
 
public class FCFS {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of process: ");
        int n = sc.nextInt();
        int pid[] = new int[n];   
        int AR[] = new int[n];    
        int BT[] = new int[n];   
        int CT[] = new int[n];    
        int TAT[] = new int[n];    
        int WT[] = new int[n];    
        
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter process " + (i+1) + " arrival time: ");
            AR[i] = sc.nextInt();
            System.out.println("enter process " + (i+1) + " brust time: ");
            BT[i] = sc.nextInt();
            pid[i] = i+1;
        }
        
        for(int i = 0 ; i <n; i++)
        {
            for(int  j=0;  j < n-(i+1) ; j++)
            {
                if( AR[j] > AR[j+1] )
                {
                    int temp;
                    temp = AR[j];
                    AR[j] = AR[j+1];
                    AR[j+1] = temp;
                    temp = BT[j];
                    BT[j] = BT[j+1];
                    BT[j+1] = temp;
                    temp = pid[j];
                    pid[j] = pid[j+1];
                    pid[j+1] = temp;
                }
            }
        }
        CT[0] = AR[0] + BT[0];
        for(int  i = 1 ; i < n; i++)
        {
           if( AR[i] > CT[i-1])
            {
                CT[i] = AR[i] + BT[i];
            }
            else
                CT[i] = CT[i-1] + BT[i];
        }
        int avgWT=0,avgTAT=0;
        for(int i=0;i<n;i++)
        {
            TAT[i] = CT[i] - AR[i] ;          
            WT[i] = TAT[i] - BT[i] ;         
            avgWT += WT[i] ;               
            avgTAT += TAT[i] ;   
        }
                          
        System.out.println("\npid\tAT\tBT\tCT\tTAT\tWT");
        for(int  i = 0 ; i< n;  i++)
        {
            System.out.println(pid[i] + "  \t " + AR[i] + "\t" + BT[i] + "\t" + CT[i] + "\t" + TAT[i] + "\t"  + WT[i] ) ;
        }
        sc.close();
        System.out.println("\nAverage waiting time: "+ (avgWT/n));     
        System.out.println("\nAverage turnaround time:"+(avgTAT/n));    
    }
}