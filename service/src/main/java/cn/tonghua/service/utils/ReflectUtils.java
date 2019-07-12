package cn.tonghua.service.utils;

import java.lang.reflect.Field;
import java.util.*;

import com.alibaba.fastjson.JSONObject;

/**
 * 反射相关工具类
 * 
 * @author xusonghui
 *
 */
public class ReflectUtils {

	public static <T> List<Map<String, Object>> listToListMap(List<T> list) {
		List<Map<String, Object>> listMap = new ArrayList<>();
		for (Object obj : list) {
			listMap.add(beanToMap(obj));
		}
		return listMap;
	}

	/**
	 * bean对象转化为map
	 * 
	 * @param obj
	 * @return
	 */
	public static Map<String, Object> beanToMap(Object obj) {
		Map<String, Object> map = new HashMap<>(16);
		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			try {
				map.put(field.getName(), field.get(obj));
			} catch (Exception e) {
				e.printStackTrace();
				map.put(field.getName(), null);
			}
		}
		return map;
	}

	public static void main(String[] args) {
//		ReserveProject project = new ReserveProject();
//		project.setOwnerName("sdfasdf");
//		ReserveProjectVo reserveProjectVo = new ReserveProjectVo();
//		beanCopy(project, reserveProjectVo);
//		System.out.println(JSONObject.toJSONString(reserveProjectVo));
	}
	/**
	 * java对象文件copy
	 *
	 * @param p
	 * @param c
	 * @return
	 */
	public static <P, C extends P> C beanCopy(P p, C c) {
		Field[] cfs = getFs(c);
		Field[] pfs = getFs(p);
		Map<String, Field> map = getMapByFields(cfs);
		for (Field pf : pfs) {
			pf.setAccessible(true);
			try {
				Field cf = map.get(pf.getName());
				if(cf != null){
					cf.set(c, pf.get(p));
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return c;
	}

	private static Field[] getFs(Object o){
		List<Field> fieldList = new ArrayList<>();
		Field[] cfs = o.getClass().getDeclaredFields();
		fieldList.addAll(Arrays.asList(cfs));
		Class<?> cls = o.getClass().getSuperclass();
		while(cls != null){
			List<Field> fields = Arrays.asList(cls.getDeclaredFields());
			if(fields.isEmpty()){
				break;
			}
			fieldList.addAll(fields);
			cls = cls.getSuperclass();
		}
		return fieldList.toArray(new Field[]{});
	}

	private static Map<String, Field> getMapByFields(Field[] fields) {
		Map<String, Field> map = new HashMap<>(16);
		for (Field field : fields) {
			field.setAccessible(true);
			map.put(field.getName(), field);
		}
		return map;
	}

	/**
	 * 将list数据类型转换为Map
	 * 
	 * @param ts
	 * @param key
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <K, T> Map<K, T> listToMap(List<T> ts, String key) {
		Map<K, T> mapT = new HashMap<>(16);
		for (T t : ts) {
			K k = (K) getVal(t, key);
			if(k == null){
				continue;
			}
			mapT.put(k, t);
		}
		return mapT;
	}
	/**
	 * 将list数据类型转换为Map
	 *
	 * @param ts
	 * @param key
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <K, V, T> Map<K, V> listToMap(List<T> ts, String key,String val) {
		Map<K, V> mapT = new HashMap<>(16);
		for (T t : ts) {
			mapT.put((K) getVal(t, key), (V) getVal(t, val));
		}
		return mapT;
	}


	/**
	 * 获取list对象中指定列数据
	 * 
	 * @param list
	 * @param key
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> getList(List<? extends Object> list, String key) {
		if(list.isEmpty()){
			return new ArrayList<>();
		}
		List<T> ts = new ArrayList<>();
		for (Object obj : list) {
			Object o = getVal(obj, key);
			if(o == null){
				continue;
			}
			ts.add((T) o);
		}
		return ts;
	}

	/**
	 * 
	 * @param lists
	 * @param cls
	 * @return
	 */
	public static <T> List<T> mapsToBeans(List<Map<String, Object>> lists, Class<? extends T> cls) {
		List<T> ts = new ArrayList<>();
		for (Map<String, Object> map : lists) {
			ts.add(mapToBean(map, cls));
		}
		return ts;
	}

	/**
	 * map转换为bean
	 * 
	 * @param map
	 * @param cls
	 * @return
	 */
	public static <T> T mapToBean(Map<String, Object> map, Class<? extends T> cls) {
		String json = JSONObject.toJSONString(map);
		return JSONObject.parseObject(json, cls);
	}

	/**
	 * list转mapList（分组）
	 * 
	 * @param ts
	 * @param key
	 * @return 2018年6月6日 上午11:02:22
	 */
	@SuppressWarnings("unchecked")
	public static <T, K> Map<K, List<T>> listToMapList(List<T> ts, String key) {
		Map<K, List<T>> ml = new HashMap<>(16);
		for (T t : ts) {
			K val = (K) getVal(t, key);
			if (ml.get(val) == null) {
				ml.put(val, new ArrayList<>());
			}
			ml.get(val).add(t);
		}
		return ml;
	}

	/**
	 * list转mapList（分组）
	 * 
	 * @param ts
	 * @param key
	 * @return 2018年6月6日 下午7:57:37
	 */
	public static <K, T> Map<K, List<Map<String, Object>>> listToMapList2(List<T> ts, String key) {
		Map<K, List<T>> map = listToMapList(ts, key);
		return mapToMap(map);
	}

	/**
	 * map转换
	 * 
	 * @param map
	 * @return 2018年6月6日 上午11:30:32
	 */
	public static <K, T> Map<K, List<Map<String, Object>>> mapToMap(Map<K, List<T>> map) {
		Map<K, List<Map<String, Object>>> mapReq = new HashMap<>(16);
		for (Map.Entry<K, List<T>> entry : map.entrySet()) {
			mapReq.put(entry.getKey(), listToListMap(entry.getValue()));
		}
		return mapReq;
	}

	public static Object getVal(Object obj, String key) {
		Map<String, Object> listMap = beanToMap(obj);
		return listMap.get(key);
	}

	/**
	 * 集合数据转换
	 * @param bs
	 * @param <A>
	 * @param <B>
	 * @return
	 */
	public static <A,B> List<A> listToList(List<B> bs){
		List<A> as = new ArrayList<>();
		for(B b : bs){
			try{
				as.add((A) b);
			}catch (Exception e){
				//强转失败
			}
		}
		return as;
	}
}
