import javax.swing.*;
import java.util.Random;

import static java.lang.System.*;

public class Ex2Thread extends Thread {
    int key;
    final CommonMatrix res;


    Ex2Thread(String name, CommonMatrix res, int key) {
        super(name);
        this.key = key;
        this.res = res;
    }

    @Override
    public void run() {
        out.println(this.getName() + " started");

        for(int i = 0; i < res.m2.length; i++) {
            synchronized (res) {
                res.result += res.m1[i][key] * res.m2[key][i];
            }
        }
        out.println("result = " + res.result);
        out.println(this.getName() + " finished");
    }
}

class CommonMatrix {
    int[][] m1;
    int[][] m2;
    int result = 0;
    private int result1 = 0;

    public CommonMatrix() {
        m1 = new int[10][10];
        m2 = new int[10][10];
        Random rnd = new Random();

        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1.length; j++) {
                m1[i][j] = rnd.nextInt(0, 10);
                m2[i][j] = rnd.nextInt(0, 10);
            }
        }
    }

    public void printmatrix() {

        out.println("Matrix1:");
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1.length; j++) {
                out.print(m1[i][j] + " ");
            }
            out.println();
        }

        out.println("Matrix2:");
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1.length; j++) {
                out.print(m2[i][j] + " ");
            }
            out.println();
        }
    }

    public void printTrueResult() {

        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1.length; j++) {
                result1 += m1[i][j] * m2[j][i];
            }
        }
        out.println("Однопоточный результат: " + result1);
    }
}