import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    private static Scanner sc = new Scanner(System.in);
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) 
    {
        System.out.print("Enter the number of books :");
        int N = sc.nextInt();
        
        System.out.print("Enter the number of racks :");
        int K = sc.nextInt();

        float r = N%K;
        
        //System.out.println(r);

        Library lib = new Library();

        if(r != 0)
        {
            System.out.println("N is not a multiple of K,  Exiting.....");
            System.exit(0);
        }

        for(int i=0; i<N; i++)
        {
            int j = i+1;

            System.out.print("Enter the title of the book no. " + j + " :");
            String title = scan.next();

            System.out.print("Enter the ISBN of the book no. " + j + " :");
            int isbn = sc.nextInt();

            System.out.print("Enter the Barcode of the book no. " + j + " :");
            int barcode = sc.nextInt();

            ArrayList<Integer> codes = new ArrayList<>();
            codes.add(isbn);
            codes.add(barcode);

            lib.set_code(j, codes);

            lib.set_tit(j, title);

            System.out.println();
        }

        T_sort title_sor = new T_sort();

        title_sor.sort_title(lib);
    }
}