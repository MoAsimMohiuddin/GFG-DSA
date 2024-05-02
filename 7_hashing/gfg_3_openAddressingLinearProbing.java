import java.util.Scanner;

public class gfg_3_openAddressingLinearProbing {
    public static void main(String[] args)
    {
        System.out.println("Enter hashTable size : ");
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();

        int[] arr=new int[size];

        int[] keys={48,42,50,55,53};

        for(int i=0; i<keys.length; i++)
        {
            int index=keys[i]%7;
            if(arr[index]==0 || arr[index]==-2)
            {
                arr[index]=keys[i];
                System.out.println(keys[i]+" inserted");
            }
            else
            {
                int temp=index;
                if(index==arr.length-1)
                {
                    index=0;
                }
                else
                {
                    index++;
                }

                while(arr[index]!=0 && arr[index]!=-2)
                {
                    index++;
                    if(index==arr.length)
                    {
                        index=0;
                    }
                    if(index==temp)
                    {
                        break;
                    }
                }
                if(index!=temp)
                {
                    arr[index]=keys[i];
                    System.out.println(keys[i]+" inserted");
                }
            }
        }

        printHashTable(arr);
        System.out.println(search(arr, 55));
        delete(arr, 55);
        System.out.println(search(arr, 55));
        printHashTable(arr);
        sc.close();
    }

    public static boolean search(int[] arr, int key)
    {
        int index=key%7;

        if(arr[index]==key)
        {
            return true;
        }
        else
        {
            int temp=index++;
            while(true)
            {
                if(index==arr.length)
                {
                    index=0;
                }
                if(index==temp)
                {
                    return false;
                }
                if(arr[index]==key)
                {
                    return true;
                }
                else if(arr[index]==0)
                {
                    return false;
                }
                index++;
            }
        }
    }

    public static void delete(int[] arr, int key)
    {
        int index=key%7;

        if(arr[index]==key)
        {
            arr[index]=-2;
        }
        else
        {
            int temp=index++;

            while(true)
            {
                if(index==arr.length)
                {
                    index=0;
                }
                if(index==temp)
                {
                    return;
                }
                if(arr[index]==key)
                {
                    arr[index]=-2;
                    return;
                }
                else if(arr[index]==0)
                {
                    return;
                }
                index++;
            }
        }
    }
    public static void printHashTable(int[] arr)
    {
        for(int k:arr)
        {
            System.out.print(k+", ");
        }
        System.out.println();
    }
}


class hash{
    int[] arr;
    int capacity, size;
    public hash(int capacity, int size)
    {
        this.capacity=capacity;
        this.size=0;
        arr=new int[size];
    }

    int hashKey(int key)
    {
        return key%7;
    }

    boolean search(int key)
    {
        int index=hashKey(key);
        int i=index;

        while(arr[i]!=0)
        {
            if(arr[i]==key)
            {
                return true;
            }
            i++;
            if(i==index)
            {
                return false;
            }
            if(index==arr.length-1)
            {
                index=0;
            }
        }
        return false;
    }

    void insert(int key)
    {
        if(size==capacity)
        {
            return;
        }

        int index=hashKey(key);

        while(arr[index]!=0 && arr[index]!=-2 && arr[index]!=key)
        {
            index++;
        }
        if(arr[index]==key)
        {
            return;
        }
        else
        {
            arr[index]=key;
            size++;
        }
    }

    void delete(int key)
    {
        int index=hashKey(key);
        int i=index;
        
        while(arr[i]!=key && arr[i]!=0)
        {
            i++;
            if(i==index)
            {
                return;
            }
            if(arr[i]==0)
            {
                return;
            }
        }
        arr[i]=-2;
    }
}