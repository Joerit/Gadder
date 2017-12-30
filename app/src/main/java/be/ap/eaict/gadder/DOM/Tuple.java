package be.ap.eaict.gadder.DOM;

/**
 * Created by joeri on 28/12/2017.
 */

public class Tuple<A, B> {
    public A a;
    public B b;

    public Tuple(){

    }

    public Tuple(A a, B b){
        this.a = a;
        this.b = b;
    }

    public A getA() {
        return a;
    }

    public B getB() {
        return b;
    }

    public void setA(A a) {
        this.a = a;
    }

    public void setB(B b) {
        this.b = b;
    }
}
