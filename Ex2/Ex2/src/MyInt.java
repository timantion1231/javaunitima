public class MyInt implements Comparable<MyInt>{
    private int anInt;

    public int getAnInt() {
        return anInt;
    }

    public MyInt(int anInt){
        this.anInt = anInt;
    }


    public int compareTo(MyInt o) {
        return o.getAnInt();
    }
}
