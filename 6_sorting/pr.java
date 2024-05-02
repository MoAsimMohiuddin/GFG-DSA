// public class pr {

//     public static void main(String[] args)
//     {
//         String[] strs={"Asim"};
//         String result=longestCommonPrefix(strs);
//         System.out.println(result);
//     }
//     public static String longestCommonPrefix(String[] strs) {
//         if(strs.length==0)
//         {
//             return "";
//         }
//         String str="";
//         int length=0;
//         if(strs.length>=2 && strs[0].length()<strs[1].length())
//         {
//             length=strs[0].length();
//         }
//         else
//         {
//             length=strs[1].length();
//         }
//         int count=0;
//         for(int k=0; k<length; k++)
//         {
//             if(strs[0].charAt(k)==strs[1].charAt(k))
//             {
//                 count++;
//             }
//             else
//             {
//                 break;
//             }
//         }

//         for(int i=1; i<strs.length-1; i++)
//         {
//             int result=comparee(strs[i], strs[i+1], count);
//             if(result<count)
//             {
//                 count=result;
//             }
//         }

//         return strs[0].substring(0, count);
//     }

//     public static int comparee(String str1, String str2, int num)
//     {
//         int count=0;
//         int length=0;
//         if(str1.length()<str2.length())
//         {
//             length=str1.length();
//         }
//         else
//         {
//             length=str2.length();
//         }

//         for(int i=0; i<length; i++)
//         {
//             if(str1.charAt(i)==str2.charAt(i))
//             {
//                 count++;
//             }
//             else
//             {
//                 break;
//             }
//         }

//         if(count<num)
//         {
//             return count;
//         }
//         else
//         {
//             return num;
//         }
//     }
// }