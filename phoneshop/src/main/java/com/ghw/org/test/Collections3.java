package com.ghw.org.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sun.xml.internal.ws.util.StringUtils;

/**
 * Collections工具集.
 * 在JDK的Collections和Guava的Collections2后, 命名为Collections3.
 * @author calvin
 * @version 2013-01-15
 */
@SuppressWarnings("rawtypes")
public class Collections3 {
	
	

	public Collections3() {
		super();
	}


	/**
	 * 转换Collection所有元素(通过toString())为String, 中间以 separator分隔。
	 */
	/*public static String convertToString(final Collection collection, final String separator) {
		return StringUtils.join(collection, separator);
	}*/

	/**
	 * 转换Collection所有元素(通过toString())为String, 每个元素的前面加入prefix，后面加入postfix，如<div>mymessage</div>。
	 */
	public static String convertToString(final Collection collection, final String prefix, final String postfix) {
		StringBuilder builder = new StringBuilder();
		for (Object o : collection) {
			builder.append(prefix).append(o).append(postfix);
		}
		return builder.toString();
	}

	/**
	 * 判断是否为空.
	 */
	public static boolean isEmpty(Collection collection) {
		return collection == null || collection.isEmpty();
	}
	
	/**
	 * 判断集合不为空
	 * @author haijiang.mo
	 * @since 2015年12月23日
	 * @param collection
	 * @return
	 */
	public static boolean isNotEmpty(Collection collection){
		return !isEmpty(collection);
	}
	
	/**
	 * 判断集合size
	 * @author haijiang.mo
	 * @since 2016年3月23日
	 * @param collection
	 * @return
	 */
	public static Integer size(Collection collection){
		if(isEmpty(collection)){
			return 0;
		}else{
			return collection.size();
		}
	}
	
	/**
	 * 判断map的size
	 * @author haijiang.mo
	 * @since 2016年3月23日
	 * @param map
	 * @return
	 */
	public static Integer size(Map<?,?> map){
		if(map == null){
			return 0;
		}else{
			return map.size();
		}
	}

	/**
	 * 取得Collection的第一个元素，如果collection为空返回null.
	 */
	public static <T> T getFirst(Collection<T> collection) {
		if (isEmpty(collection)) {
			return null;
		}

		return collection.iterator().next();
	}

	/**
	 * 获取Collection的最后一个元素 ，如果collection为空返回null.
	 */
	public static <T> T getLast(Collection<T> collection) {
		if (isEmpty(collection)) {
			return null;
		}

		//当类型为List时，直接取得最后一个元素 。
		if (collection instanceof List) {
			List<T> list = (List<T>) collection;
			return list.get(list.size() - 1);
		}

		//其他类型通过iterator滚动到最后一个元素.
		Iterator<T> iterator = collection.iterator();
		while (true) {
			T current = iterator.next();
			if (!iterator.hasNext()) {
				return current;
			}
		}
	}

	/**
	 * 返回a+b的新List.
	 */
	public static <T> List<T> union(final Collection<T> a, final Collection<T> b) {
		List<T> result = new ArrayList<>(a);
		result.addAll(b);
		return result;
	}

	/**
	 * 返回a-b的新List.
	 */
	public static <T> List<T> subtract(final Collection<T> a, final Collection<T> b) {
		List<T> list = new ArrayList<>(a);
			
		list.removeAll(b);

		return list;
	}

	/**
	 * 返回a与b的交集的新List.
	 */
	public static <T> List<T> intersection(Collection<T> a, Collection<T> b) {
		List<T> list = new ArrayList<>(a);

		list.retainAll(b);
		
		return list;
	}
}
