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
public class SLL <T>{
    protected  SLLNode<T> head, tail;
    public  SLL(){
        head = tail = null;
    }

    public SLLNode<T> getHead() {
        return head;
    }

    public void setHead(SLLNode<T> head) {
        this.head = head;
    }

    public SLLNode<T> getTail() {
        return tail;
    }

    public void setTail(SLLNode<T> tail) {
        this.tail = tail;
    }
    public boolean isEmpty(){
        return head == null;
    }
    public void addToHead(T el){
        head = new SLLNode<T>(el, head);
        if (tail == null){
            tail = head;
        }
    }
    public void addToTail(T el){
        if (!isEmpty()){
            tail.next = new SLLNode<T>(el);
            tail = tail.next;
        }else{
            head = tail = new SLLNode<T>(el);
        }
    }
    public T deleteFromHead(){
        if (!isEmpty()){
            return null;
        }
        T el = head.info;
        if ( head == tail){
            head = tail = null;
        }else{
            head = head.next;
        }
        return el;
    }
    public T deletaFromTail(){
        if (!isEmpty()){
            return null;
        }
        T el  = tail.info;
        if (head == tail){
            head = tail = null;
        }else{
            SLLNode<T> tmp;
            for (tmp = head; tmp.next != tail; tmp = tmp.next) {
                tail = tmp;
                tail.next = null;
            }
        }
        return el;
    }
    public void delete(T el){
        if (!isEmpty())
            if (head == tail && el.equals(head.info))
                head = tail = null;
            else if (el.equals(head.info))
                head = tail.next;
            else{
                SLLNode<T> pred, tmp;
                for (pred = head, tmp = head.next; 
                        tmp != null && !(tmp.info.equals(el));
                        pred = pred.next,
                        tmp = tmp.next);
                if (tmp != null){
                    pred.next = tmp.next;
                    if (tmp == tail)
                        tail = pred;
                }
            }
    }
    public void printAll(){
        for (SLLNode<T>  tmp = head; tmp != null ; tmp = tmp.next){
            System.out.println(tmp.info);
        }
    }
    public boolean isList(T el){
        SLLNode<T> tmp;
        for (tmp = head; tmp != null && !tmp.info.equals(el); tmp = tmp.next);
            return tmp !=null;
    }
}
