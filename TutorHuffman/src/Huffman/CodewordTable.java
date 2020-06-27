/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Huffman;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.InputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

/**
 *
 * @author Kaden Arabic
 */
public class CodewordTable extends HashMap<Integer, Entry1>{
    public static String ID="TVS-PURE-HUFFMAN";
    public int totalSymbols=0;
    public int minCodeLength=100;
    public int maxCodeLength=0;
    public CodewordTable()
    {
        super();
    }
    public String toString()
    {
        String result="";
        result+="ID"+ID+"\n";
        result+="Number of symbols:"+totalSymbols+"\n";
        result+="Table size:"+this.size()+"\n";
        result+="Avg.Huff.Code Lenght:"+this.avgCodeLen()+"\n";
        result+="Entropy:" +this.entropy()+"\n";
        result+="min Code Length:"+this.minCodeLength+"\n";
        result+="max code length:"+this.maxCodeLength+"\n";
        result+="<symbol:weight:codeword>\n";
        Object[] entries=this.values().toArray();
        Arrays.sort(entries);
        for(int i=entries.length-1;i>=0;i--)
        {
            Entry1 entry=(Entry1) entries[i];
            result+="<"+entry.symbol+":"+entry.weight+":"+entry.codeword+">\n";
        }
        return result;
    }
    public double entropy()
    {
        double result=0.0;
        double probability=0.0;
        Iterator it=this.keySet().iterator();
        while(it.hasNext())
        {
            Integer symbol=(Integer)(it.next());
            Entry1 entry=this.get(symbol);
            
        }
        return result;
    }
    public double avgCodeLen()
    {
        double result=0.0;
        double probability=0.0;
        Iterator it=this.keySet().iterator();
        while(it.hasNext())
        {
            Integer symbol=(Integer)(it.next());
            Entry1 entry=this.get(symbol);
            probability=((double)entry.weight)/totalSymbols;
            result+=probability*entry.codeword.length();
            
        }
        return result;
    }
    public boolean readFromFile(DataInputStream dis)
    {
        this.clear();
        this.totalSymbols=0;
        minCodeLength=100;
        maxCodeLength=0;
        try {
            int L=dis.readInt();
            byte[] data=new byte[L];
            dis.read(data);
            String tableInfo=new String(data);
            String S="";
            StringTokenizer stk=new StringTokenizer(tableInfo,"\n");
            S=stk.nextToken();
            String IDread=S.substring(4);
            if(!IDread.equals(ID))
            {
                System.out.println("The file format is invalid");
                return false;
            }
            S=stk.nextToken();
            totalSymbols=Integer.parseInt(S.substring(19));
            S=stk.nextToken();
            int tableSize=Integer.parseInt(S.substring(12));
            S=stk.nextToken();
            S=stk.nextToken();
            S=stk.nextToken();
            minCodeLength=Integer.parseInt(S.substring(17));
            S=stk.nextToken();
            maxCodeLength=Integer.parseInt(S.substring(17));
            S=stk.nextToken();
            int symbol,weight;
            String code;
            for(int i=0;i<tableSize;i++)
            {
                S=stk.nextToken();
                StringTokenizer stk2=new StringTokenizer(S,"<:>");
                symbol=Integer.parseInt(stk2.nextToken());
                weight=Integer.parseInt(stk.nextToken());
                code=stk2.nextToken();
                Entry1 entry=new Entry1(symbol,weight,code);
                this.put(symbol, entry);
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return false;
    }
    public boolean writeToFile(DataOutputStream dos)
    {
        String tableInfo=this.toString();
        int L=tableInfo.length();
        try {
            dos.writeInt(L);
            dos.writeBytes(tableInfo);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    public boolean buildFromSource(InputStream source)
    {
        this.clear();
        this.totalSymbols=0;
        try {
            if(source==null||source.available()==0)
            {
                System.out.println("Source is empty!");
                return false;
            }
            int data;
            Integer symbol=null;
            Entry1 entry=null;
            while((data=source.read())!=-1)
            {
                symbol=new Integer(data);
                entry=(Entry1) this.get(symbol);
                if(entry==null)
                    this.put(symbol, new Entry1(data));
                else
                    entry.weight+=1;
                    totalSymbols++;
            }
            return true;
        } catch (Exception e) 
        {
            System.out.println(e);
            return false;
        }
    }
    public double log2(double d)
    {
        return Math.log(d) / Math.log(2.0);
    }
    
    
}
