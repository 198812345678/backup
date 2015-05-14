package precipitated.will.dynamicProgramming;

import Jama.Matrix;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by will.wang on 2015/4/30.
 */
public class MatrixMultiplication {
    private final double NAN = Double.POSITIVE_INFINITY;

    private List<Matrix> matrixes;

    private Matrix m;

    private Matrix s;

    public MatrixMultiplication(List<Matrix> matrixes) {
        this.matrixes = matrixes;
        m = new Matrix(matrixes.size(), matrixes.size());
        s = new Matrix(matrixes.size(), matrixes.size());
    }

    public void initTable() {
        int n = matrixes.size();
        for (int i = 0; i < n; i++) {
            m.set(i, i, 0);
        }

        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                int j = l + i - 1;
                m.set(i, j, NAN);
                for (int k = i; k < j; k++) {
                    double q = m.get(i, k) + m.get(k+1, j) + matrixes.get(i).getRowDimension() * matrixes.get(k).getColumnDimension() * matrixes.get(j).getColumnDimension();
                    if(q < m.get(i, j)) {
                        m.set(i, j, q);
                        s.set(i, j, k);
                    }
                }
            }
        }
    }

    public Matrix getM() {
        return m;
    }

    public void setM(Matrix m) {
        this.m = m;
    }

    public Matrix getS() {
        return s;
    }

    public void setS(Matrix s) {
        this.s = s;
    }

    public static void main(String[] args) {
        double[][] valsA = {{1.,2.,3},{4.,5.,6.},{7.,8.,10.}};
        double[][] valsB = {{1.,2.,3},{4.,5.,6.},{7.,8.,10.}};
        double[][] valsC = {{1.,2.,3},{4.,5.,6.},{7.,8.,10.}};
        Matrix matrixA = new Matrix(valsA);
        Matrix matrixB = new Matrix(valsB);
        Matrix matrixC = new Matrix(valsC);

        List<Matrix> matrixes = Lists.newArrayList();
        matrixes.add(matrixA);
        matrixes.add(matrixB);
        matrixes.add(matrixC);

        MatrixMultiplication matrixMultiplication = new MatrixMultiplication(matrixes);
        matrixMultiplication.initTable();
        Matrix m = matrixMultiplication.getM();
        Matrix s = matrixMultiplication.getS();

        m.print(3, 1);
        System.out.println("=================");
        s.print(3, 0);
    }
}
