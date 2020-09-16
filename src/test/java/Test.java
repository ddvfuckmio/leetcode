import java.lang.reflect.Field;

/**
 * @author : ddv
 * @since : 2020/1/4 10:52 AM
 */

public class Test {
    class A {
        public  String id;
    }

    class B extends A{

	}

    @org.junit.Test
    public void test() throws NoSuchFieldException {
		Class<B> bClass = B.class;
		Field[] declaredFields = bClass.getDeclaredFields();
		for (Field declaredField : declaredFields) {

		}

		Field declaredField = bClass.getDeclaredField("id");
		try {
			bClass.getField("id");
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
	}
}
