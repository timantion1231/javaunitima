public class MyChar implements Comparable<MyChar>{

    private final Character c;
    private final Integer charInt;

    public int getCharInt() {
        return charInt;
    }

    public Character getC(){
        return this.c;
    }

    public MyChar(Character c){
        this.c = c;
        this.charInt = (int) c;
    }

    public int compareTo(MyChar cavo) {
        return charInt.compareTo(cavo.getCharInt());
    }
}
