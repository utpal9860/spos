import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class searchAd
{
  int arr_length;
  boolean searchad(String []s_arr,int lc1)  throws IOException 
    { 
        arr_length = s_arr.length;  
        try(FileWriter fw = new FileWriter("assemblertbl/symtbl.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw))
        {
            if(s_arr[1].equalsIgnoreCase("DC")||s_arr[1].equalsIgnoreCase("DS"))
            {
                out.println(s_arr[0]+" "+lc1+" 1");
            }
        }
        catch(Exception e)
        {
        }
        try(FileWriter fw1 = new FileWriter("assemblertbl/optblout.txt", true);
        BufferedWriter bw1 = new BufferedWriter(fw1);
        PrintWriter outop = new PrintWriter(bw1))
        {
            try(FileWriter fw2 = new FileWriter("assemblertbl/symtbl.txt", true);
            BufferedWriter bw2 = new BufferedWriter(fw2);
            PrintWriter outsym = new PrintWriter(bw2))
            {  
              if(arr_length==4)
              {     
                  outsym.println(s_arr[0]+" "+lc1+" 1");
                  BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("assemblertbl/optblin.txt")));
                  String s;   
                while((s=br.readLine())!=null)
                {  
                     StringTokenizer st=new StringTokenizer(s," ",false);
                     String s_arr1[]=new String[st.countTokens()];
                     for(int i=0;i<s_arr1.length;i++)
                        {
                            s_arr1[i]=st.nextToken();
                        }
                     for(int j=0;j<s_arr1.length;j++)
                         {
                            if(s_arr[1].equalsIgnoreCase(s_arr1[j]))
                            {      
                                 outop.println(s_arr1[j]+" "+s_arr1[j+1]+" 1");
                            }
                         }
                } 
              }
              if(arr_length==3||arr_length==2||arr_length==1)
              {
                   BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("assemblertbl/optblin.txt")));
                  String s;   
                while((s=br.readLine())!=null)
                {  
                     StringTokenizer st=new StringTokenizer(s," ",false);
                     String s_arr1[]=new String[st.countTokens()];
                     for(int i=0;i<s_arr1.length;i++)
                        {
                            s_arr1[i]=st.nextToken();
                        }
                     for(int j=0;j<s_arr1.length;j++)
                         {
                            if(s_arr[0].equalsIgnoreCase(s_arr1[j]))
                            {      
                                 outop.println(s_arr1[j]+" "+s_arr1[j+1]+" 1");
                            }
                         }
                } 
              }
            }
            catch (IOException e) 
            {
            }
        }
        catch (IOException e) 
        {
        } 
            return true;
    }
  void varient(String s_arr[],int loc) throws FileNotFoundException, IOException
  {
    int arr_length1=s_arr.length;
    try(FileWriter fw = new FileWriter("assemblertbl/output.txt", true);
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter out = new PrintWriter(bw))
    {   
        if(s_arr[0].equalsIgnoreCase("START"))
        {          
             out.println("AD 01 C "+(loc+1));
        }
        if(s_arr[0].equalsIgnoreCase("END"))
        {
            out.println("AD 02");
        }
        if(arr_length1==1)
        {
            BufferedReader bf1=new BufferedReader(new InputStreamReader(new FileInputStream("assemblertbl/optblout.txt")));
            String s;   
            while((s=bf1.readLine())!=null)
            {  
                  StringTokenizer st=new StringTokenizer(s," ",false);
                  String s_arr1[]=new String[st.countTokens()];
                  for(int i=0;i<s_arr1.length;i++)
                     {
                         s_arr1[i]=st.nextToken();
                     }
                 if(s_arr[0].equalsIgnoreCase(s_arr1[0]))
                 {
                      out.println("IS "+s_arr1[1]);
                 }        
            }
        }
        if(arr_length1==2)
        {
            BufferedReader bf1=new BufferedReader(new InputStreamReader(new FileInputStream("assemblertbl/optblout.txt")));
            String s;   
            while((s=bf1.readLine())!=null)
            {  
                  StringTokenizer st=new StringTokenizer(s," ",false);
                  String s_arr1[]=new String[st.countTokens()];
                  for(int i=0;i<s_arr1.length;i++)
                     {
                         s_arr1[i]=st.nextToken();
                     }
                 if(s_arr[0].equalsIgnoreCase(s_arr1[0]))
                 {
                                     if(s_arr[1].equalsIgnoreCase("AREG"))
                                       {
                                       out.println("IS "+s_arr1[1]+" 1");
                                       }
                                       if(s_arr[1].equalsIgnoreCase("BREG"))
                                       {
                                       out.println("IS "+s_arr1[1]+" 2");
                                       }
                                       if(s_arr[1].equalsIgnoreCase("CREG"))
                                       {
                                       out.println("IS "+s_arr1[1]+" 3");
                                       }
                                       if(s_arr[1].equalsIgnoreCase("DREG"))
                                       {
                                       out.println("IS "+s_arr1[1]+" 4");
                                       }
                     BufferedReader bf2=new BufferedReader(new InputStreamReader(new FileInputStream("assemblertbl/symtbl.txt")));
                    String s2;   
                    while((s2=bf2.readLine())!=null)
                    {  
                          StringTokenizer st2=new StringTokenizer(s2," ",false);
                          String s_arr2[]=new String[st2.countTokens()];
                          for(int i=0;i<s_arr2.length;i++)
                             {
                                 s_arr2[i]=st2.nextToken();
                             }
                            if(s_arr[1].equalsIgnoreCase(s_arr2[0]))
                            {
                                       out.println("IS "+s_arr1[1]+" "+s_arr2[1]);
                            }
                    }
                 }      
            }
        }
        if(arr_length1==3)
        {
            
            if(s_arr[1].equalsIgnoreCase("DS"))
            {
                out.println("DL 02 C "+s_arr[2]);
            }
            if(s_arr[1].equalsIgnoreCase("DC"))
            {
                out.println("DL 01 C "+s_arr[2]);
            }
        }
        if(arr_length1==3)
        {
            BufferedReader bf1=new BufferedReader(new InputStreamReader(new FileInputStream("assemblertbl/optblout.txt")));
            String s;   
            while((s=bf1.readLine())!=null)
            {  
                  StringTokenizer st=new StringTokenizer(s," ",false);
                  String s_arr1[]=new String[st.countTokens()];
                  for(int i=0;i<s_arr1.length;i++)
                     {
                         s_arr1[i]=st.nextToken();
                     }
                 if(s_arr[0].equalsIgnoreCase(s_arr1[0]))
                 {    
                     BufferedReader bf2=new BufferedReader(new InputStreamReader(new FileInputStream("assemblertbl/symtbl.txt")));
                    String s2;   
                    while((s2=bf2.readLine())!=null)
                    {  
                          StringTokenizer st2=new StringTokenizer(s2," ",false);
                          String s_arr2[]=new String[st2.countTokens()];
                          for(int i=0;i<s_arr2.length;i++)
                             {
                                 s_arr2[i]=st2.nextToken();
                             }
                            if(s_arr[2].equalsIgnoreCase(s_arr2[0]))
                            {
                                       if(s_arr[1].equalsIgnoreCase("AREG"))
                                       {
                                       out.println("IS "+s_arr1[1]+" 1"+" S "+s_arr2[1]);
                                       }
                                       if(s_arr[1].equalsIgnoreCase("BREG"))
                                       {
                                       out.println("IS "+s_arr1[1]+" 2"+" S "+s_arr2[1]);
                                       }
                                       if(s_arr[1].equalsIgnoreCase("CREG"))
                                       {
                                       out.println("IS "+s_arr1[1]+" 3"+" S "+s_arr2[1]);
                                       }
                                       if(s_arr[1].equalsIgnoreCase("DREG"))
                                       {
                                       out.println("IS "+s_arr1[1]+" 4"+" S "+s_arr2[1]);
                                       }
                            }
                    }
                }           
            }
        }
        if(arr_length1==4)
        {
            BufferedReader bf1=new BufferedReader(new InputStreamReader(new FileInputStream("assemblertbl/optblout.txt")));
            String s;   
            while((s=bf1.readLine())!=null)
            {  
                  StringTokenizer st=new StringTokenizer(s," ",false);
                  String s_arr1[]=new String[st.countTokens()];
                  for(int i=0;i<s_arr1.length;i++)
                     {
                         s_arr1[i]=st.nextToken();
                     }
                 
                     if(s_arr[1].equalsIgnoreCase(s_arr1[0]))
                    {  
                        BufferedReader bf2=new BufferedReader(new InputStreamReader(new FileInputStream("assemblertbl/symtbl.txt")));
                        String s2;
                        while((s2=bf2.readLine())!=null)
                        {
                           
                            StringTokenizer str2=new StringTokenizer(s2," ",false);
                            String s_arr2[]=new String[str2.countTokens()];
                            for(int j=0;j<s_arr2.length;j++)
                            {
                                s_arr2[j]=str2.nextToken();
                            }
                            
                           if(s_arr[3].equalsIgnoreCase(s_arr2[0]))
                           {
                               if(s_arr[2].equalsIgnoreCase("AREG"))
                               {
                               out.println("IS "+s_arr1[1]+" 1"+" S "+s_arr2[1]);
                               }
                               if(s_arr[2].equalsIgnoreCase("BREG"))
                               {
                               out.println("IS "+s_arr1[1]+" 2"+" S "+s_arr2[1]);
                               }
                               if(s_arr[2].equalsIgnoreCase("CREG"))
                               {
                               out.println("IS "+s_arr1[1]+" 3"+" S "+s_arr2[1]);
                               }
                               if(s_arr[2].equalsIgnoreCase("DREG"))
                               {
                               out.println("IS "+s_arr1[1]+" 4"+" S "+s_arr2[1]);
                               }
                           }
                        }
                    }
                }
        } 
    } 
    catch (IOException e) 
    {
    }   
  }
}

class one
{
    public static void main(String a[]) throws IOException
    {
        searchAd search=new searchAd();
        int lc1 = 0;
        PrintWriter outsym =new PrintWriter(new FileWriter ("assemblertbl/symtbl.txt"),true);
        PrintWriter out2 =new PrintWriter(new FileWriter ("assemblertbl/output2.txt"),true);
        PrintWriter out =new PrintWriter(new FileWriter ("assemblertbl/output.txt"),true);
        PrintWriter optbl =new PrintWriter(new FileWriter ("assemblertbl/optblout.txt"),true);
        BufferedReader input=new BufferedReader(new InputStreamReader(new FileInputStream("assemblertbl/input.txt")));
        BufferedReader input2=new BufferedReader(new InputStreamReader(new FileInputStream("assemblertbl/optblin.txt")));
         String s;   
        try(FileWriter fw12 = new FileWriter("assemblertbl/optblout.txt", true);
        BufferedWriter bw12 = new BufferedWriter(fw12);
        PrintWriter outop2 = new PrintWriter(bw12))
        { 
            outop2.println("opname    opcode       Length");
        }catch(Exception e)
        {
        }
        try(FileWriter fw12 = new FileWriter("assemblertbl/symtbl.txt", true);
        BufferedWriter bw12 = new BufferedWriter(fw12);
        PrintWriter outop2 = new PrintWriter(bw12))
        { 
            outop2.println("SymName    Address       Length");
        }catch(Exception e)
        {
        }
        while((s=input .readLine())!=null)
        {
             StringTokenizer st=new StringTokenizer(s,"     ",false);
             String s_arr[]=new String[st.countTokens()];
             for(int i=0;i<s_arr.length;i++)
             {
                 s_arr[i]=st.nextToken();
             }
             if(s_arr[0].equalsIgnoreCase("START"))
             {
             lc1=Integer.parseInt(s_arr[1]);
             --lc1;  
             } 
             search.searchad(s_arr,lc1);
             lc1++;
        }
         BufferedReader input3=new BufferedReader(new InputStreamReader(new FileInputStream("assemblertbl/input.txt")));
        lc1=0;
        while((s=input3 .readLine())!=null)
        {
             StringTokenizer st=new StringTokenizer(s," ",false);
             String s_arr[]=new String[st.countTokens()];
             for(int i=0;i<s_arr.length;i++)
             {
                 s_arr[i]=st.nextToken();
             }
             if(s_arr[0].equalsIgnoreCase("START"))
             {
             lc1=Integer.parseInt(s_arr[1]);
             --lc1;  
             } 
             search.varient(s_arr,lc1);
             lc1++;
        }
       
         BufferedReader bf1=new BufferedReader(new InputStreamReader(new FileInputStream("assemblertbl/input.txt")));
        String s1;
        System.out.println("\n*********************Pass 1******************\n");
        System.out.println("\nInput Table(Assembler Program):\n");
        while((s1=bf1.readLine())!=null)
        {
            System.out.println(s1);
        }
        System.out.println("\n***************************************\n");
        BufferedReader bf2=new BufferedReader(new InputStreamReader(new FileInputStream("assemblertbl/optblout.txt")));
        String s2;
        System.out.println("\nOpcode Table:\n");
        while((s2=bf2.readLine())!=null)
        {
            System.out.println(s2);
        }
         System.out.println("\n***************************************\n");
         BufferedReader bf3=new BufferedReader(new InputStreamReader(new FileInputStream("assemblertbl/symtbl.txt")));
        String s3;
        System.out.println("\nSymbol Table:\n");
        while((s3=bf3.readLine())!=null)
        {
            System.out.println(s3);
        }
         System.out.println("\n***************************************\n");
        BufferedReader bf4=new BufferedReader(new InputStreamReader(new FileInputStream("assemblertbl/output.txt")));
        String s4;
        System.out.println("\nIntermediate Code Generated:\n");
        while((s4=bf4.readLine())!=null)
        {
            System.out.println(s4);
        }
    }
}