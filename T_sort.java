import java.util.*;
import java.io.*;

public class T_sort<T extends Library>
{
    T ord;

    public void sort_title(Library lib)
    {    

        HashMap<Integer,String> book_titl = new HashMap<>();
        ArrayList<Integer> sort_order = new ArrayList<>();

        book_titl = lib.get_tit();

        List l_list = new LinkedList(book_titl.entrySet());

        Collections.sort(l_list,new Comparator() 
        {
            public int compare(Object l1, Object l2)
            {
                return ((Comparable) ((Map.Entry) (l1)).getValue()).compareTo(((Map.Entry) (l2)).getValue());  
                
                //return (l1.getValue()).compareTo(l2.getValue());
            }
        });

        HashMap all_sorted = new LinkedHashMap();

        for(Iterator trav = l_list.iterator(); trav.hasNext();)
        {
            Map.Entry trav2 = (Map.Entry) trav.next();
            all_sorted.put(trav2.getKey(), trav2.getValue());
        }

        lib.set_tit_sort(all_sorted);

        dis(lib);
    }

    public void dis(Library lib)
    {
        Display<HashMap<Integer,String>> dd = new Display<HashMap<Integer,String>>(lib.get_tit()); 

        Set s = dd.ret().entrySet();

        Iterator trav = s.iterator();  
        while(trav.hasNext())   
        {
            Map.Entry trav2 = (Map.Entry)trav.next();  
            
            Object bno = trav2.getKey();
            HashMap<Integer,ArrayList<Integer>> t_scott = new HashMap<Integer,ArrayList<Integer>>();
            t_scott = lib.get_code();
            
            System.out.println("Book no :"+trav2.getKey()+"     Title:   "+trav2.getValue() + "     ISBN:     "+t_scott.get(bno).get(0) + "     Barcode:    "+t_scott.get(bno).get(1));  
        } 
    }
}