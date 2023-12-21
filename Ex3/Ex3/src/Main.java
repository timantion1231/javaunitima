import java.util.Scanner;

import static java.lang.System.*;

//нить- поток
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int programNum = -1;
        String inputLine;
        while (programNum != 0) {
            out.println("\nВведите номер программы: 1, 2, 3, 4\n0: Выход");
            inputLine = in.nextLine();
            if (chkNum(inputLine)) programNum = Integer.parseInt(inputLine);
            else {
                out.println("Неверный формат номера");
                programNum = -1;
            }
            switch (programNum) {
                case 1 -> ex1();
                case 2 -> ex2();
                case 3 -> ex3();
            }
        }
    }

    public static void ex1() {
        out.println("Main thread started");
        CommonArray res = new CommonArray();
        int sum1 = 0;
        Thread nose = new MyThread("nose", res, true);
        Thread tail = new MyThread("tail", res, false);

        for (Integer item : res.mas1) out.print(item + " ");
        for (Integer item : res.mas1) sum1 += item;
        out.println("\nТочный результат: " + sum1);

        nose.start();
        tail.start();
        try {
            nose.join();
            tail.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        out.println("Многопоотчный результат:" + res.sum);
        if (sum1 == res.sum) out.println("True");
        else out.println("False");
        out.println("Main thread finished");
    }


    public static void ex2() {
        out.println("main thread started");
        CommonMatrix res = new CommonMatrix();
        res.printmatrix();
        Ex2Thread[] threads = new Ex2Thread[res.m1.length];
        for (int key = 0; key < res.m2.length; key++) {
            threads[key] = new Ex2Thread("Thread" + key, res, key);
            threads[key].start();
            try {
                threads[key].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        res.printTrueResult();
        out.println("Многопоточный результат: " + res.result);
        out.println("main thread finished");
    }

    public static void ex3() {
        out.println(Thread.currentThread().getName() + " started");
        CurrTrhead currThread = new CurrTrhead();
        Ex3Thread evenThread = new Ex3Thread("evenThread", true, currThread);
        Ex3Thread notEvenThread = new Ex3Thread("notEvenThread", false, currThread);
        evenThread.start();
        notEvenThread.start();

        try {
            evenThread.join();
            notEvenThread.join();
        } catch (Exception ignored) {
        }

        out.println(Thread.currentThread().getName() + " finished");
    }


    public static boolean chkNum(String str) {
        boolean b;
        try {
            Integer.parseInt(str);
            b = true;
        } catch (Exception ex) {
            b = false;
        }
        return b;
    }


}