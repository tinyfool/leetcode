package CLRS.DivideAndConquer;

public class SquareMatrixMultiply {

    double[][] multiply(double[][] A,double[][] B) {

        int n = A.length;
        double[][] C = new double[n][n];
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<n;j++) {

                C[i][j] = 0;
                for(int k=0;k<n;k++) {
                    C[i][j] += A[i][k]*B[k][j];
                }
            }
        }
        return C;
    }

    double[][] multiplyRecursive(double[][] A,double[][] B) {

        int n = A.length;
        double[][] C = new double[n][n];
        if(n==1)
            C[0][0] = A[0][0]*B[0][0];
        else {

            double[][] A11 = split(A,0,0);
            double[][] A12 = split(A,0,1);
            double[][] A21 = split(A,1,0);
            double[][] A22 = split(A,1,1);

            double[][] B11 = split(B,0,0);
            double[][] B12 = split(B,0,1);
            double[][] B21 = split(B,1,0);
            double[][] B22 = split(B,1,1);

            int half = n/2;
            double[][] C11 = add(multiplyRecursive(A11,B11), multiplyRecursive(A12,B21));
            double[][] C12 = add(multiplyRecursive(A11,B12), multiplyRecursive(A12,B22));
            double[][] C21 = add(multiplyRecursive(A21,B11), multiplyRecursive(A22,B21));
            double[][] C22 = add(multiplyRecursive(A21,B12), multiplyRecursive(A22,B22));

            merge(C, half, C11, C12, C21, C22);
        }
        return C;
    }

    double[][] multiplyRecursiveStrassen(double[][] A,double[][] B) {

        int n = A.length;
        double[][] C = new double[n][n];
        if(n==1)
            C[0][0] = A[0][0]*B[0][0];
        else {

            double[][] A11 = split(A,0,0);
            double[][] A12 = split(A,0,1);
            double[][] A21 = split(A,1,0);
            double[][] A22 = split(A,1,1);

            double[][] B11 = split(B,0,0);
            double[][] B12 = split(B,0,1);
            double[][] B21 = split(B,1,0);
            double[][] B22 = split(B,1,1);

            double[][] S1  = minus(B12,B22);
            double[][] S2  = add(A11,A12);
            double[][] S3  = add(A21,A22);
            double[][] S4  = minus(B21,B11);
            double[][] S5  = add(A11,A22);
            double[][] S6  = add(B11,B22);
            double[][] S7  = minus(A12,A22);
            double[][] S8  = add(B21,B22);
            double[][] S9  = minus(A11,A21);
            double[][] S10 = add(B11,B12);

            double[][] P1 = multiplyRecursiveStrassen(A11,S1);
            double[][] P2 = multiplyRecursiveStrassen(S2,B22);
            double[][] P3 = multiplyRecursiveStrassen(S3,B11);
            double[][] P4 = multiplyRecursiveStrassen(A22,S4);
            double[][] P5 = multiplyRecursiveStrassen(S5,S6);
            double[][] P6 = multiplyRecursiveStrassen(S7,S8);
            double[][] P7 = multiplyRecursiveStrassen(S9,S10);


            double[][] C11 = add(minus(add(P5,P4),P2),P6);
            double[][] C12 = add(P1,P2);
            double[][] C21 = add(P3,P4);
            double[][] C22 = minus(minus(add(P5,P1),P3),P7);

            int half = n/2;
            merge(C, half, C11, C12, C21, C22);
        }
        return C;
    }
    private void merge(double[][] c, int half, double[][] c11, double[][] c12, double[][] c21, double[][] c22) {
        for(int i=0;i<half;i++) {
            for(int j=0;j<half;j++) {

                c[i][j] = c11[i][j];
                c[i][j+half] = c12[i][j];
                c[i+half][j] = c21[i][j];
                c[i+half][j+half] = c22[i][j];
            }
        }
    }

    double[][] add(double[][]A,double[][]B) {

        double[][] ret = new double[A.length][A.length];
        for(int i = 0;i<A.length;i++) {
            for(int j = 0;j<A.length;j++) {
                ret[i][j] = A[i][j]+B[i][j];
            }
        }
        return ret;
    }

    double[][] minus(double[][]A,double[][]B) {

        double[][] ret = new double[A.length][A.length];
        for(int i = 0;i<A.length;i++) {
            for(int j = 0;j<A.length;j++) {
                ret[i][j] = A[i][j]-B[i][j];
            }
        }
        return ret;
    }

    double[][] split(double[][] A,int m,int n) {

        int half = A.length/2;
        double[][] C = new double[half][half];

        for (int i=0;i<half;i++) {
            for (int j=0;j<half;j++) {
                C[i][j] = A[i+m*half][j+n*half];
            }
        }
        return C;
    }

    public static void main(String[] args) {

        double[][] A = {

            {0.8147,    0.6324,    0.9575,    0.9572},
            {0.9058,    0.0975,    0.9649,    0.4854},
            {0.1270,    0.2785,    0.1576,    0.8003},
            {0.9134,    0.5469,    0.9706,    0.1419}
        };


        double[][] B = {

            {0.4218,    0.6557,    0.6787,    0.6555},
            {0.9157,    0.0357,    0.7577,    0.1712},
            {0.7922,    0.8491,    0.7431,    0.7060},
            {0.9595,    0.9340,    0.3922,    0.0318}
        };

//        A*B
//        2.5996    2.2639    2.1191    1.3488
//        1.7015    1.8701    1.5961    1.3071
//        1.2013    0.9745    0.7282    0.2677
//        1.7911    1.5751    1.8113    1.3821

        SquareMatrixMultiply squareMatrixMultiply = new SquareMatrixMultiply();
        double[][] C = squareMatrixMultiply.multiply(A,B);
        System.out.println(C);
        double[][] D = squareMatrixMultiply.multiplyRecursive(A,B);
        System.out.println(D);
        double[][] E = squareMatrixMultiply.multiplyRecursiveStrassen(A,B);
        System.out.println(E);

        A = new double[][]{
            {0.8147, 0.1270},
            {0.9058, 0.9134}
        };

        B = new double[][]{
            {0.6324,0.2785},
            {0.0975,0.5469}
        };

//        0.5276    0.2963
//        0.6619    0.7518

        C = squareMatrixMultiply.multiply(A,B);
        D = squareMatrixMultiply.multiplyRecursive(A,B);

        System.out.println(D);
    }
}

