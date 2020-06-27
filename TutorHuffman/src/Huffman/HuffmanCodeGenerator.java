/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Huffman;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Kaden Arabic
 */
public class HuffmanCodeGenerator {
    protected TreeNode root=null;
    protected CodewordTable table=new CodewordTable();
    public HuffmanCodeGenerator(CodewordTable table)
    {
        this.table=table;
    }

    public TreeNode getRoot() {
        return root;
    }

    public CodewordTable getTable() {
        return table;
    }
    private boolean buildTree()
    {
        ArrayList<TreeNode> nodeList=new ArrayList<TreeNode>();
        Object[] entries=(table.values().toArray());
        Arrays.sort(entries);
        for(int i=0;i<entries.length;i++)
            nodeList.add(new TreeNode((Entry1)entries[i]));
        reduce(nodeList);
        return true;
    }
    private void reduce(ArrayList<TreeNode> nodeList)
    {
        while(nodeList.size()>1)
        {
            TreeNode t1=nodeList.get(0);
            TreeNode t2=nodeList.get(1);
            nodeList.remove(t1);
            nodeList.remove(t2);
            TreeNode newNode=new TreeNode(new Entry1(Entry1.INTERIOR));
            newNode.left=t1;
            newNode.right=t2;
            int newWeight=t1.entry.weight+t2.entry.weight;
            newNode.entry.weight=newWeight;
            int i=0, size=nodeList.size();
            while(i<size&&nodeList.get(i).entry.weight<newWeight) i++;
            nodeList.add(i,newNode);
        }
        root=nodeList.get(0);
    }
    private void generateCodewords(TreeNode p,String codeInited)
    {
        if(p!=null)
        {
            int L=codeInited.length();
            if(p.left==null&&p.right==null)
            {
                p.entry.codeword=codeInited;
                if(L<table.minCodeLength) table.minCodeLength=L;
                if(L>table.maxCodeLength) table.maxCodeLength=L;
            }
            generateCodewords(p.left, codeInited+"0");
            generateCodewords(p.right, codeInited+"1");
        }
    }
    public void generateCodewords()
    {
        this.buildTree();
        generateCodewords(root,"");
    }
    
}
