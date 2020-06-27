/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Huffman;

/**
 *
 * @author Kaden Arabic
 */
public class TreeNode implements Comparable{
    public Entry1 entry;
    public TreeNode left,right;
    public TreeNode(Entry1 e)
    {
        entry=e;
        left=right=null;
    }

    @Override
    public int compareTo(Object o) {
        return entry.weight-((TreeNode)o).entry.weight;
    }
    
    
}
