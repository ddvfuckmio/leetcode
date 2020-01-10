package user;

/**
 * @author : ddv
 * @date : 2018/11/2 上午10:19
 */
public class User {
    /** 成员变量都会存储到堆区💕 static修饰的也是如此 */
    private String name;

    private int age;
    private static boolean sign;

    public void setName(String name) { // ---> 栈区
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", age=" + age + '}';
    }

    public static void main(String[] args) {
        /** main线程会开拥有独立的线程栈区 */
        int b = 0;
        int num = 0; // --->基本类型存储在栈区
        User user = new User(); // --->user引用存储在栈区 user引用的对象本身存储在堆区
    }
}
