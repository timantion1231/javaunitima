public class MyInt implements Comparable<MyInt>{
    private Integer val;

    public int getVal() {
        return val;
    }

    public MyInt(int value){
        this.val = value;
    }

    public int compareTo(MyInt o) {
        return val.compareTo(o.getVal());
    }
}
