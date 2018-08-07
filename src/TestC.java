import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestC {

	public static void main(String[] args) throws Exception {
		TestA a = new TestA();
		a.setInte(16);
		a.setStr("test");
		List<String> list = new ArrayList<String>();
		list.add("yoo");
		a.setObj(list);

		TestB b = (TestB) mapper(a, TestB.class);

		System.out.println(b.getStr() + "  " + b.getInte());
	}

	public static Object mapper(Object src, Class<? extends Object> dest) throws Exception {
		Object destObj = dest.newInstance();
		Class<? extends Object> srcClass = src.getClass();
		/*Field[] fields = srcClass.getFields();
		for (Field field : fields) {
			Object value = field.get(src);
			dest.getField(field.getName()).set(destObj, value);
		}*/
		Method[] methods = srcClass.getMethods();
		return destObj;
	}

	public static boolean isGetter(Method method) {
		if (!method.getName().startsWith("get"))
			return false;
		if (method.getParameterTypes().length != 0)
			return false;
		if (void.class.equals(method.getReturnType()))
			return false;
		return true;
	}

	public static boolean isSetter(Method method) {
		if (!method.getName().startsWith("set"))
			return false;
		if (method.getParameterTypes().length != 1)
			return false;
		return true;
	}

}
