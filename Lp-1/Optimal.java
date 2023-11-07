import java.util.*;

public class Optimal {
    public static int getPageFaults(int[] pages, int capacity) {
        HashSet<Integer> set = new HashSet<>(capacity);
        Queue<Integer> indexes = new LinkedList<>();
        int pageFaults = 0;
        
        for (int i = 0; i < pages.length; i++) {
            if (set.size() < capacity) {
                if (!set.contains(pages[i])) {
                    set.add(pages[i]);
                    pageFaults++;
                    indexes.add(pages[i]);
                }
            } else {
                if (!set.contains(pages[i])) {
                    int farthest = -1, val = -1;
                    int currentIndex = 0; // Initialize an index counter
                    for (Integer s : set) {
                        if (indexes.contains(s)) {
                            int temp = currentIndex; // Use the index counter
                            if (temp > farthest) {
                                farthest = temp;
                                val = s;
                            }
                        } else {
                            val = s;
                            break;
                        }
                        currentIndex++; // Increment the index counter
                    }
                    set.remove(val);
                    set.add(pages[i]);
                    indexes.remove(val);
                    indexes.add(pages[i]);
                    pageFaults++;
                }
            }
        }
        
        return pageFaults;
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n;
        System.out.println("Enter the size of string: ");
        n=sc.nextInt();
        int pages[]=new int[n];
        System.out.println("Enter the string: ");
        for(int i=0;i<n;i++)
        {
            pages[i]=sc.nextInt();
        }
        int capacity = 4;
        int faults = getPageFaults(pages, capacity);
        System.out.println("Page Faults: " + faults);
        System.out.println("Page Hit: "+(n-faults));
        sc.close();
    }
}
