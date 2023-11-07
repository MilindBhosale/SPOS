import java.util.*;

class FirstFit {
    public static void firstFit(int blockSize[], int processSize[]) {
        int m = blockSize.length;
        int n = processSize.length;
        int allocation[] = new int[n];
        Arrays.fill(allocation, -1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (blockSize[j] >= processSize[i]) {
                    allocation[i] = j;
                    blockSize[j] -= processSize[i];
                    break;
                }
            }
        }

        System.out.println("Process No. \tProcess Size \tBlock no.");
        for (int i = 0; i < n; i++) {
            System.out.print("   " + (i + 1) + "\t\t" + processSize[i] + "\t\t");
            if (allocation[i] != -1)
                System.out.print(allocation[i] + 1);
            else
                System.out.print("Not Allocated");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        System.out.println("Enter no. of blocks:- ");
        n = sc.nextInt();
        System.out.println("Enter no. of processes:- ");
        m = sc.nextInt();
        int block[] = new int[n];
        int processes[] = new int[m];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the size of " + (i + 1) + " block:- ");
            block[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            System.out.println("Enter the size of " + (i + 1) + " process:- ");
            processes[i] = sc.nextInt();
        }

        firstFit(block, processes);
    }
}
