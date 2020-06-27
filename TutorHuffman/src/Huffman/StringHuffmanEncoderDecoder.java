/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Huffman;

import java.io.ByteArrayInputStream;

/**
 *
 * @author Kaden Arabic
 */
public class StringHuffmanEncoderDecoder {
    HuffmanCodeGenerator generator=null;
    String inputStr;
    String encodeStr;
    String decodeStr;

    public HuffmanCodeGenerator getGenerator() {
        return generator;
    }

    public String getInputStr() {
        return inputStr;
    }

    public String getEncodeStr() {
        return encodeStr;
    }

    public String getDecodeStr() {
        return decodeStr;
    }
    
    public StringHuffmanEncoderDecoder(String inputStr)
    {
        this.inputStr=inputStr;
        CodewordTable table=new CodewordTable();
        try {
             byte[] symbols=inputStr.getBytes();
             ByteArrayInputStream is=new ByteArrayInputStream(symbols);
             table.buildFromSource(is);
             generator=new HuffmanCodeGenerator(table);
             generator.generateCodewords();
             
        } catch (Exception e) 
        {
            System.out.println(e);
        }
    }
    public boolean encode()
    {
        encodeStr="";
        CodewordTable table=generator.getTable();
        int n1=table.totalSymbols;
        int n2=0;
        byte[] bSource=inputStr.getBytes();
        for(int i=0;i<bSource.length;i++)
        {
            int data=(int)bSource[i];
            Integer symbol=data;
            Entry1 entry=table.get(symbol);
            encodeStr+=entry.codeword;
            n2++;
            
        }
        return n1==n2;
    }
    public boolean decode()
    {
        decodeStr="";
        CodewordTable table=generator.getTable();
        int n1=table.totalSymbols;
        int n2=0;
        TreeNode root=generator.getRoot();
        TreeNode p=root;
        for(int i=0;i<encodeStr.length();i++)
        {
            char c=encodeStr.charAt(i);
            if(c=='0') p=p.left;
            else p=p.right;
            if(p.left==null&& p.right==null)
            {
                Integer symbol=p.entry.symbol;
                byte[] bytes=new byte[1];
                bytes[0]=(byte)(symbol.intValue());
                String S=new String(bytes);
                decodeStr+=S;
                n2++;
                p=root;
                
            }
        }
        return n1==n2;
    }
}
