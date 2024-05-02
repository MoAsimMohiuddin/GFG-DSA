public class gfg_6_mergingTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 8 };
        int[] arr2 = { 4, 5, 6, 7 };
        mergeTwoSortedArrays(arr1, arr2);
    }

    static void mergeTwoSortedArrays(int[] arr1, int[] arr2)
    {
        int i=0, j=0, size1=arr1.length, size2=arr2.length;

        while(i<size1 && j<size2)
        {
            if(arr1[i]<arr2[j])
            {
                System.out.print(arr1[i++]+", ");
            }
            else
            {
                System.out.print(arr2[j++]+", ");
            }
        }

        while(i<size1)
        {
            System.out.print(arr1[i++]+", ");
        }

        while(j<size2)
        {
            System.out.print(arr2[j++]);
        }

        System.out.println();
    }

    public static void mergingArrays(int[] arr1, int[] arr2) {
        int i = 0, j = 0;

        while (i < arr1.length || j < arr2.length) {
            if (i == arr1.length && j < arr2.length) {
                while (j < arr2.length) {
                    System.out.print(arr2[j++] + ", ");
                }
                break;
            }

            if (j == arr2.length && i < arr1.length) {
                while (i < arr1.length) {
                    System.out.print(arr1[i++] + ", ");
                }
                break;
            }

            if (arr1[i] <= arr2[j]) {
                System.out.print(arr1[i++] + ", ");
            } else {
                System.out.print(arr2[j++] + ", ");
            }
        }
    }

    public static int medianOfTwoSortedArrays(int[] arr1, int[] arr2) {
        int count = 0, i = 0, j = 0, median = 0, totalSize = arr1.length + arr2.length, flag = 0;

        while (i < arr1.length || j < arr2.length) {
            if (i == arr1.length && j < arr2.length) {
                while (j < arr2.length) {
                    count++;
                    if ((totalSize) % 2 == 1) {
                        if (count == totalSize + 1) {
                            median = arr2[j];
                            break;
                        }
                    } else {
                        if (count == totalSize || count == totalSize + 1) {
                            median += arr2[j];
                            flag = 1;
                        }
                    }
                    j++;
                }
                break;
            } 
            else if(j==arr2.length && i<arr1.length){
                while (i < arr1.length) {
                    count++;
                    if ((totalSize) % 2 == 1) {
                        if (count == totalSize + 1) {
                            median = arr1[i];
                            break;
                        }
                    } else {
                        if (count == totalSize || count == totalSize + 1) {
                            median += arr1[i];
                            flag = 1;
                        }
                    }
                    i++;
                }
                break;
            }
            if (arr1[i] <= arr2[j]) {
                count++;
                if ((totalSize) % 2 == 1) {
                    if (count == totalSize + 1) {
                        median = arr1[i];
                        break;
                    }
                }
                else {
                    if (count == totalSize || count == totalSize + 1) {
                        median += arr1[i];
                        flag = 1;
                    }
                }
                i++;
            }
            else {
                count++;
                if ((totalSize) % 2 == 1) {
                    if (count == totalSize + 1) {
                        median = arr2[j];
                        break;
                    }
                }
                else {
                    if (count == totalSize || count == totalSize + 1) {
                        median += arr2[j];
                        flag = 1;
                    }
                }
                j++;
            }

        }
        if (flag == 0) {
            return median;
        }
        else {
            return median / 2;
        }
    }
}