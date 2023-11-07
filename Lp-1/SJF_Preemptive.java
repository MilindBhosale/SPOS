import java.util.*;
public class SJF_Preemptive 
{
    public static void main (String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println ("Enter the no of process:");
        int n= sc.nextInt();
        int pid[] = new int[n]; 
        int AT[] = new int[n];
        int BT[] = new int[n]; 
        int CT[] = new int[n]; 
        int TAT[] = new int[n];
        int WT[] = new int[n]; 
        int f[] = new int[n];  
        int k[]= new int[n];   
        int i, st=0, tot=0;
        float avgwt=0, avgTAT=0;
        for (i=0;i<n;i++){
            pid[i]= i+1;
            System.out.println ("enter process " +(i+1)+ " arrival time:");
            AT[i]= sc.nextInt();
            System.out.println("enter process " +(i+1)+ " burst time:");
            BT[i]= sc.nextInt();
            k[i]= BT[i];
            f[i]= 0;
        }    
        while(true){
            int min=99,c=n;
            if (tot==n)
                break;
            for ( i=0;i<n;i++){
                if ((AT[i]<=st) && (f[i]==0) && (BT[i]<min))
                {
                    min=BT[i];
                    c=i;
                }
            }
            if (c==n)
                st++;
            else
            {
                BT[c]--;
                st++;
                if (BT[c]==0){
                    CT[c]= st;
                    f[c]=1;
                    tot++;
                }
            }
        }
        for(i=0;i<n;i++){
            TAT[i] = CT[i] - AT[i];
            WT[i] = TAT[i] - k[i];
            avgwt+= WT[i];
            avgTAT+= TAT[i];
        }
        System.out.println("pid\tAT\tBT\tCT\tTAT\tWT");
        for(i=0;i<n;i++)
            System.out.println(pid[i] +"\t"+ AT[i]+"\t"+ k[i] +"\t"+ CT[i] +"\t"+ TAT[i] +"\t"+ WT[i]);
            
        System.out.println("\nAverage TATT ="+ (float)(avgTAT/n));
        System.out.println("Average WT ="+ (float)(avgwt/n));
        sc.close();
    }
}