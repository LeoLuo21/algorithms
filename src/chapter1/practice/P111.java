package chapter1.practice;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class P111 {
    public static void main(String[] args) {
        /*
         * 给出下列表达式的值
         * */

        //a. (0+15)/2
        System.out.println((0 + 15) / 2);
        //b. 2.06e-6 * 100000000.1
        System.out.println(2.06e-6 * 100000000.1);
        //c. true && false || true && true
        System.out.println(true && false || true && true);


        /*
         * 给出以下表达式的类型和值
         * */

        //a.(1 + 2.236)/2
        System.out.println((1 + 2.236) / 2);
        //b. 1+2+3+4.0
        System.out.println(1 + 2 + 3 + 4.0);
        //c. 4.1 >= 4
        System.out.println(4.1 >= 4);
        //d .1+2 + "3"
        System.out.println(1 + 2 + "3");


        /*
         * 编写一个程序，从命令行得到三个整数参数。如果它们都相等则打印equal， 否则打印 not equal
         * */

        if (args[0].equals(args[1]) && args[1].equals(args[2])) {
            System.out.println("equal");
        } else
            System.out.println("not equal");

        /*
         * 编写一段程序，如果double类型的变量x和y都严格位于0和1之间则打印true，否则打印false
         * */

        double x = 0.1;
        double y = 0.2;
        if ((x > 0 && x < 1) && (y > 0 && y < 1))
            System.out.println(true);
        else
            System.out.println(false);
        /*
         * 斐波那契数列
         * */
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++) {
            StdOut.println(f);
            f = f + g;
            g = f - g;
        }

        /*
         * 下列语句会打印出什么结果？给出解释
         * */

        System.out.println('b');
        System.out.println('b' + 'c');
        System.out.println((char) ('a' + 4));//byte char short int的混合运算会转换成int


        /*
         * 编写一段代码，将一个正整数N用二进制表示并转换为一个String类型的值 s
         * */
        int N = 10;
        String s = "";
        for (int n = N; n > 0; n /= 2)
            s = (n % 2) + s;
        StdOut.println(s);
        System.out.println(Integer.toBinaryString(10));


        /*
         * 编写一段代码，打印出一个M行N列的二维数组的转置（交换行和列）
         * */

        int row = 10;
        int column = 10;
        int[][] matrix = new int[row][column];
        matrix[2][1] = 1;
        int[][] A_1 = new int[column][row];
        for (int i = 0; i < column; i++)
            for (int j = 0; j < row; j++) {
                A_1[i][j] = matrix[j][i];
            }
        System.out.println(A_1[1][2]);

        /*
         * 编写一个静态方法lg(),接受一个整形参数N，返回不大于log2N的最大整数，不要使用Math类
         * */

        System.out.println(lg(32));

        int[] histogram = histogram(new int[]{1, 2, 3}, 5);
        System.out.println(Arrays.toString(histogram));

        int[][] a = new int[10][10];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[i].length; j++) {

            }
    }

    /*
     * 编写一个静态方法histogram()，接受一个整型数组a[]和一个整数M为参数并返回一个大小为M的数组，
     * 其中第i个元素的值为整数i在参数数组中出现的次数。如果a[]的值都在 0 到 M-1之间，返回数组中
     * 所有元素之和应该和a.length相等
     * */
    private static int[] histogram(int[] a, int m) {
        int[] result = new int[m];
        for (int i = 0; i < result.length; i++) {
            int count = 0;
            for (int j : a) {
                if (j == i) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }

    /*
     * 编写一个静态方法lg(),接受一个整形参数N，返回不大于log2N的最大整数，不要使用Math类
     * */

    private static int lg(int n) {
        int i = 1;
        int count = 0;
        while (i <= n) {
            i = i * 2;
            count++;
        }
        return count - 1;
    }
}
