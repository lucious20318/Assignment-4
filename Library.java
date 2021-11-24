import java.util.*;
import java.io.*;

public class Library 
{
    private static HashMap<Integer,ArrayList<Integer>> code_store = new HashMap<>();
    private static HashMap<Integer,String> book_tit = new HashMap<>();

    public void set_code(int num,ArrayList<Integer> codes)
    {
        code_store.put(num, codes);
    }

    public void set_tit(int num, String title)
    {
        book_tit.put(num, title);
    }

    public HashMap get_code()
    {
        return code_store;
    }

    public HashMap get_tit()
    {
        return book_tit;
    }

}
