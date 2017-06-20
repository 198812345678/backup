package precipitated.will.cpu;

/**
 * {@link http://ifeve.com/from-javaeye-cpu-cache/}
 *
 * Created by will.wang on 2015/12/21.
 */
public class CachLine {

    private static int RunTimes = 10;
    private static int rows = 1024 * 1024;
    private static int colums = 60;

    private static long[][] arry;

    public static void main(String[] args) {

        arry = new long[rows][colums];
        for (int i = 0; i < rows; i++) {
            arry[i] = new long[colums];
            for (int j = 0; j < colums; j++) {
                arry[i][j] = 0L;
            }
        }

        System.out.println("starting....");
        long s = System.currentTimeMillis();
        long sum = 0L;
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < colums; j++) {
//                sum += arry[i][j];
//            }
//        }

        for (int j = 0; j < colums; j++) {
            for (int i = 0; i < rows; i++) {
                sum += arry[i][j];
            }
        }

        System.out.println("duration = " + String.valueOf(System.currentTimeMillis()-s));
    }
}
