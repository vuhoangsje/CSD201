/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked_list;

/**
 *
 * @author vuhoa
 */
public class SLLNode <T>{
    T info;
    SLLNode<T> next;

    public SLLNode(){
        next = null;
    }
    public SLLNode(T el){
        info = el;
        next = null;
    }
    public  SLLNode(T el, SLLNode<T> afterEle){
        info = el;
        next = afterEle;
    }
}
