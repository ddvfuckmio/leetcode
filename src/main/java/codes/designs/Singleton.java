package codes.designs;

public class Singleton {
    //静态内部类
    private static final Singleton instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return Singleton.instance;
    }
}

