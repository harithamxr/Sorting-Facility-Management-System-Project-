public class Queue extends LinkedList
{
    public void enqueue(Parcel v){insertAtBack(v);}
    public Parcel dequeue(){return removeFromFront();}
    public Parcel getFront(){return getFirst();}
    
    public Parcel getEnd()
    {
        Parcel v = removeFromBack();
        insertAtBack(v);
        return v;
    }
    
    public boolean isEmpty(){return super.isEmpty();}
}
