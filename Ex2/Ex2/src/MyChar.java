public class MyChar implements Comparable<MyChar>{

    private Character c;
    private int charInt;

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
        return cavo.getCharInt();
    }
}
