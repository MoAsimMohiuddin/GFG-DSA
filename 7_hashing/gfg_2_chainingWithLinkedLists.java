public class gfg_2_chainingWithLinkedLists {
    public static void main(String[] args)
    {
        int[] keys={50,21,58,17,15,49,56,22,23,25};
        LinkedList[] hashTable=hashTableFunction(keys);

        printHashTable(hashTable);
    }

    public static LinkedList[] hashTableFunction(int[] keys)
    {
        LinkedList[] hashTable=new LinkedList[7];
        // The size of the hashTable doesn't always have to be 7. It depends on us to chose the size of the hashTable.
        // Usually, It is a good practice to keep the size of hashTable equal to the number of keys. Because, If the data is uniformly distributed, The load factor is 1. And if the data is uniformly distributed, The search, delete and insert operations can be done in O(1) time complexity
        // The number used in Hash function to divide each element with should be the closest and greater prime number to the size of the hashTable.
        for(int i=0; i<keys.length; i++)
        {
            int index=keys[i]%7;

            LinkedList newNode=new LinkedList();
            newNode.data=keys[i];
            newNode.next=null;

            if(hashTable[index]==null)
            {
                hashTable[index]=newNode;
            }
            else
            {
                LinkedList temp=hashTable[index];

                while(temp.next!=null)
                {
                    temp=temp.next;
                }
                temp.next=newNode;
            }
        }

        return hashTable;
    }

    public static void printHashTable(LinkedList[] hashTable)
    {
        for(LinkedList node:hashTable)
        {
            if(node!=null)
            {
                System.out.print(node.data+", ");
                if(node.next!=null)
                {
                    LinkedList temp=node.next;
                    while(temp!=null)
                    {
                        System.out.print(temp.data+", ");
                        temp=temp.next;
                    }
                }
                System.out.println();
            }
        }
    }

    public static boolean searchInHashTable(int key)
    {
        return false;
    }

    public static void insertInHashTable(int key)
    {

    }

    public static void deleteInHashTable(int key)
    {

    }
}

class LinkedList{
    int data;
    LinkedList next;
}
