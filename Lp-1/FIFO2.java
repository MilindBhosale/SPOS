import java.util.LinkedList;
import java.util.Scanner;

public class FIFO2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of pages: ");
        int n = input.nextInt();
        
        System.out.print("Enter the capacity: ");
        int capacity = input.nextInt();
        
        int[] pages = new int[n];
        
        System.out.println("Enter the page numbers: ");
        for (int i = 0; i < n; i++) {
            pages[i] = input.nextInt();
        }

        int pageFaults = 0;
        LinkedList<Integer> frame = new LinkedList<>();
        boolean found;
        
        for (int i = 0; i < n; i++) {
            found = false;
            
            for (int j = 0; j < frame.size(); j++) {
                if (frame.get(j) == pages[i]) {
                    found = true;
                    break;
                }
            }
            
            if (!found) {
                if (frame.size() == capacity) {
                    frame.removeFirst();
                }
                frame.addLast(pages[i]);
                pageFaults++;
            }
        }

        System.out.println("Total Page Faults: " + pageFaults);
        System.out.println("Total Page Hits: "+(n-pageFaults));
        input.close();
    }
}