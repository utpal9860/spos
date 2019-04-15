/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sposassignment;
/**
 *
 * @author Lonkar
 */
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
class pass2
{
    void target()
    {
        PrintWriter out = null;
        try {
            int arr_length;
            out = new PrintWriter(new FileWriter("assemblertbl/output2.txt"));
            BufferedReader bf= new BufferedReader(new InputStreamReader(new FileInputStream("assemblertbl/output.txt")));
            String s;
            while((s=bf.readLine())!=null)
            {

                StringTokenizer str=new StringTokenizer(s," ",false);
                String s_arr[]=new String[str.countTokens()];
                for(int i=0;i< s_arr.length;i++)
                {
                    s_arr[i]=str.nextToken();
                }
                arr_length=s_arr.length;
                if(s_arr[0].equalsIgnoreCase("AD") ||s_arr[0].equalsIgnoreCase("DL"))
                {
                    continue;
                }
                else if(arr_length==5)
                {
                    out.println("+ "+s_arr[1] +" "+s_arr[2]+ " "+s_arr[4]);
                }
                else if(arr_length==3)
                {
                    out.println("+ "+s_arr[1]+" "+s_arr[2]+" 000");
                }
                else if(arr_length==2)
                {
                    out.println("+ "+s_arr[1]+" 0"+" 000");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(pass2.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
    }
}
class passtwooftheassembler
{
    public static void main(String a[]) throws IOException
    {
        pass2 p2 =new pass2();
        p2.target();
        BufferedReader bf5=new BufferedReader(new InputStreamReader(new FileInputStream("assemblertbl/output2.txt")));
        String s5;
        System.out.println("\n*********************Pass 2******************\n");
        System.out.println("\nTarget Programm:\n");
        while((s5=bf5.readLine())!=null)
        {
            System.out.println(s5);
        }
         System.out.println("\n***************************************\n");
    }
}