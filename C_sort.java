import java.util.*;
import java.io.*;

public class C_sort <C extends Library>
{
    C ord;

    public void sort_codes(Library lib)
    {
        HashMap<Integer,ArrayList<Integer>> book_codes = new HashMap<>();
        HashMap<Integer,String> book_titles = new HashMap<>();

        book_codes = lib.get_code();
        book_titles = lib.get_tit();

        int len = book_codes.size();
        
        for(int k=0; k<4; k++)
        {
            for(int i=1; i<len+1; i++)
            {
                for(int j=i+1; j<len; j++)
                {
                    //System.out.println(book_titles.get(i));
                    //System.out.println(book_titles.get(j));

                    if(book_titles.get(i).equals(book_titles.get(j)))
                    {
                        if(book_codes.get(i).get(0) == book_codes.get(j).get(0))
                        {
                            if(book_codes.get(i).get(1) > book_codes.get(j).get(1))
                            {
                                int temp;

                                temp = book_codes.get(i).get(1);
                                book_codes.get(i).set(1, book_codes.get(j).get(1));
                                book_codes.get(j).set(1, temp);
                            }

                            else
                            {
                                continue;
                            }
                        }

                        else if(book_codes.get(i).get(0) > book_codes.get(j).get(0))
                        {
                            //swaps ISBN
                            int temp;

                            temp = book_codes.get(i).get(0);
                            book_codes.get(i).set(0, book_codes.get(j).get(0));
                            book_codes.get(j).set(0, temp);

                            //swaps Barcode
                            int temp2;

                            temp2 = book_codes.get(i).get(1);
                            book_codes.get(i).set(1, book_codes.get(j).get(1));
                            book_codes.get(j).set(1, temp2);
                        }

                        else
                        {
                            continue;
                        }
                    }   
                }
            }
        }

        lib.set_cod_sort(book_codes);

        dis(lib);
    }

    public void dis(Library lib)
    {
        Display<HashMap<Integer,String>> dd = new Display<HashMap<Integer,String>>(lib.get_tit()); 

        Set s = dd.ret().entrySet();

        Iterator trav = s.iterator();  

        System.out.println("After sorting ISBN and Barcodes :");
        while(trav.hasNext())   
        {
            Map.Entry trav2 = (Map.Entry)trav.next();  
            
            Object bno = trav2.getKey();
            HashMap<Integer,ArrayList<Integer>> t_scott = new HashMap<Integer,ArrayList<Integer>>();
            t_scott = lib.get_code();
            
            System.out.println("Title:   "+trav2.getValue() + "     ISBN:     "+t_scott.get(bno).get(0) + "     Barcode:    "+t_scott.get(bno).get(1));  
        } 
    }
}
