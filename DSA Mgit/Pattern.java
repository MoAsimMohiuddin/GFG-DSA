public class Pattern{
    public static void main(String[] args) {
        cross(5);
    }

    // All Solid Patterns can be derived from Increasing Triangles, Decreasing Triangles and Squres.
    static void sendingPattern(String str) {
        int len=str.length();
        for(int row=0; row<len; row++) {
            for(int col=row; col<len-1; col++) {
                System.out.print("   ");
            }
            for(int col=0; col<row; col++) {
                System.out.print(str.charAt(col));
            }
            System.out.println();
        }
        
        for(int row=0; row<len; row++) {
            for(int col=row; col<len; col++) {
                System.out.print(str.charAt(col));
            }
            System.out.println();
        }
    }

    // All Hollow Patterns can be Derived from Squares.
    static void hollowSquare(int n) {
        for(int row=0; row<n; row++) {
            for(int col=0; col<n; col++) {
                if(row==0 || row==n-1 || col==0 || col==n-1){
                    System.out.print("* ");
                    continue;
                }
                System.out.print("  ");
            }
            System.out.println();
        }
    }

    static void frontSlash(int n) {
        for(int row=0; row<n; row++) {
            for(int col=0; col<n; col++) {
                if(row==col){
                    System.out.print("*"+" ");
                    continue;
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    static void backSlash(int n) {
        for(int row=0; row<n; row++) {
            for(int col=0; col<n; col++) {
                if(row+col==n-1){
                    System.out.print("*"+" ");
                    continue;
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    static void cross(int n) {
        for(int row=0; row<n; row++) {
            for(int col=0; col<n; col++) {
                if(row+col==n-1 || row==col){
                    System.out.print("*"+" ");
                    continue;
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}