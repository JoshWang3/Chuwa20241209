// static inner class.

public class SingleTon {
    private SingleTon(){}

    private static class SingleTonHolder{   // When the first time calling getInstance(), this staic class will be initizlied once.
        //
        private static final SingleTon instance = new SingleTon(); // final
    }

    public static SingleTon getInstance() {
        return SingleTonHolder.instance; //
    }
}