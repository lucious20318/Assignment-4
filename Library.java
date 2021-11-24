import java.util.*;
import java.io.*;

public class Library 
{
    private static HashMap<Integer,ArrayList<Integer>> code_store;
    private static HashMap<Integer,String> book_tit;

    public void set_code(int num,ArrayList<Integer> codes)
    {
        code_store.put(num, codes);
    }

    public void set_tit()
    {

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
