import java.util.ArrayList;
import java.util.Random;

import static java.lang.System.*;

public class MyThread extends Thread {

    private ArrayList<Integer> mas;
    private boolean key;
    private final CommonArray res;

    public MyThread(String name, CommonArray res, boolean key) {
        super(name);
        this.key = key;
        this.res = res;
        this.mas = res.mas1;

    }

    @Override
    public void run() {
        out.println(this.getName() + " started");
        if (this.key) {
            if (this.mas.size() / 2 == 0)
                synchronized (res) {
                    for (int i = 0; i <= this.mas.size() / 2; res.sum += this.mas.get(i), i++) ;
                }
            else
                synchronized (res) {
                    for (int i = 0; i <= (this.mas.size() - 1) / 2; res.sum += this.mas.get(i), i++) ;
                }

        } else {
            if (this.mas.size() / 2 == 0)
                synchronized (res) {
                    for (int i = this.mas.size() / 2; i < this.mas.size(); res.sum += this.mas.get(i), i++) ;
                }

            else
                synchronized (res) {
                    for (int i = (this.mas.size() + 1) / 2; i < this.mas.size(); res.sum += this.mas.get(i), i++) ;
                }
        }
        out.println(this.getName() + " finished");
    }
}


class CommonArray {
    ArrayList<Integer> mas1 = new ArrayList<>();
    int sum = 0;

    public CommonArray() {
        Random rnd = new Random();
        for (int i = 0; i < 1000; this.mas1.add(rnd.nextInt(0, 100)), i++) ;
    }
}