public class Stack extends LinkedList
{
    public Stack()
    {
        
    }
    
    public void push(Parcel o)
    {
        insertAtFront(o);
    }
    
    public Parcel pop()
    {
        return removeFromFront();
    }
    
    public Parcel peek()
    {
        return getFirst();
    }
    
    public boolean isEmpty()
    {
        return super.isEmpty();
    }
}