public class SetMatrixZeros {
    public static void main(String[] args) {
        int[][] matrix={
            {1, 1, 1, 0},
            {1, 1, 1, 1},
            {0, 1, 1, 1}
        };

        System.out.println("Before");
        printMatrix(matrix);

        method(matrix);

        System.out.println("After");
        printMatrix(matrix);
    }

    static void method(int[][] matrix) {
        int n=matrix.length, m=matrix[0].length;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(matrix[i][j]==0) {
                    helperFunction(matrix, i, j);
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(matrix[i][j]==-1) {
                    matrix[i][j]=0;
                }
            }
        }
    }

    static void helperFunction(int[][] matrix, int i, int j) {
        int n=matrix.length, m=matrix[0].length;

        for(int k=0; k<m; k++) {
            matrix[i][k]=-1;
        }

        for(int k=0; k<n; k++) {
            matrix[k][j]=-1;
        }
    }

    static void printMatrix(int[][] matrix) {
        int n=matrix.length, m=matrix[0].length;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                System.out.print(matrix[i][j]+" ");
            }

            System.out.println();
        }
    }
}
