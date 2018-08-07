import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestObjectArrayToClass {
	
	private <T> List<T> convertObjetListToClassList(List<Object[]> res, Map<Object, Integer> keyMap, Class<?> cls)
			throws Exception{
		List<T> r = new ArrayList<>();
		for(Object[] obj: res){
			Object object = cls.getConstructor().newInstance();
			Field[] fs =cls.getDeclaredFields();
			for(Field f: fs){
				f.setAccessible(true);
				String keyName = f.getName();
				Integer index = keyMap.get(keyName);
				if(index != null){
					f.set(object, obj[index]);
				}
			}
			r.add((T) object);	
		}
		System.out.println(((3+2)<<2)*31);
		return r;
	}

	public static void main(String[] args) {
		TestObjectArrayToClass t = new TestObjectArrayToClass();
		Map<Object, Integer> keyMap = new HashMap<Object, Integer>();
		keyMap.put("str", 0);
		keyMap.put("in", 1);
		List<Object[]> res = new ArrayList<>();
		Object[] arr1 = new Object[]{"test1", 3};
		Object[] arr2 = new Object[]{"test2", 7};
		res.add(arr1);
		res.add(arr2);
		try {
			List<TestD> r = t.convertObjetListToClassList(res, keyMap, TestD.class);
			System.out.println(r.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
