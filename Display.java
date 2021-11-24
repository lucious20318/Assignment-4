import java.util.*;
import java.io.*;

public class Display <P>
{
    //HashMap<Integer,String> disp;

    P disp;

    public Display(P disp)
    {
        this.disp = disp;
    }

    public P ret()
    {
        return this.disp;
    }

}
