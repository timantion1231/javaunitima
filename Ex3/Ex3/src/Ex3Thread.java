import javax.swing.undo.CannotUndoException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.lang.System.*;

public class Ex3Thread extends Thread {

    private boolean key;
    CurrTrhead res;

    public Ex3Thread(String name, boolean key, CurrTrhead res) {
        super(name);
        this.key = key;
        this.res = res;
    }

    @Override
    public void run() {
        out.println(getName() + " started");
        int linesCount = 0;
        int startIndex;

        try {
            linesCount = Files.readAllLines(Paths.get("textfile.txt")).size();//.get(номер строки)
            if (key) startIndex = 0;
            else startIndex = 1;
            synchronized (res) {
            for (int i = startIndex; i < linesCount; i += 2) {

                    out.println(Files.readAllLines(Paths.get("textfile.txt")).get(i));
                    res.notify();
                    res.wait();
                }
                res.notifyAll();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        out.println(getName() + " finished");

    }
}


class CurrTrhead {
    boolean currThread;
}