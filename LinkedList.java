class LinkedList
{   private Node first;     // reference to the first node in the list
    private Node current;       // reference to the current node
    private Node last;      // reference to the last node

    public LinkedList()
    {
         first = null;
         last = null;
         current = null;
    }

    public boolean isEmpty()
    {
     return (first==null);
    }
    
    public void insertAtFront(Parcel insertItem)
    {
            Node newNode = new Node(insertItem);

        if (isEmpty())
        {   first = newNode;
            last = newNode;
        }
        else
        {
            newNode.next = first;
            first = newNode;
        }
    }

      public void insertAtBack(Parcel insertItem)
     {
         Node newNode = new Node(insertItem);

         if (isEmpty())
         {       first = newNode;
             last = newNode;
         }
         else
         {
                last.next = newNode;
                last = newNode;
         }
    }

 
        
        public Parcel removeFromFront()
        {   
         Parcel removeItem = null;
         if (isEmpty())
         {   
                return removeItem;
          }
         
            removeItem = first.data;
            if ( first == last)
         {   
                 first = null;
                 last = null;
               }
         else
                first = first.next;
            
         return removeItem;
     }
    
     public Parcel removeFromBack()
        {   
          Parcel removeItem = null;
          if (isEmpty())
          {   
                return removeItem;
         }
            removeItem = last.data;
         if ( first == last)
         {   

               first = null;
                last = null;
        }
         else
            {
                current = first;
             while (current.next != last)
                    current = current.next;
             
             last = current;
             last.next = null;
            }         
         return removeItem;
    }

    public Parcel getFirst()
    {   
        if (isEmpty())
            return null;
        else
        {   current = first;
            return current.data;
        }
    }
    
    public Parcel getNext()
    {   
        if (current == last)
            return null;
        else
        {   current = current.next;
            return current.data;
        }               
    }
}