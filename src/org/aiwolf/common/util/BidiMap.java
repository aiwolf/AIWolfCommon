package org.aiwolf.common.util;

import java.util.HashMap;
import java.util.Map;

public class BidiMap<K, V> extends HashMap<K, V>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	Map<V, K> inverseMap;
	
	public BidiMap() {
		super();
		inverseMap = new HashMap<V, K>();
	}

	public BidiMap(int arg0, float arg1) {
		super(arg0, arg1);
		inverseMap = new HashMap<V, K>();
	}

	public BidiMap(int arg0) {
		super(arg0);
		inverseMap = new HashMap<V, K>();
	}

	public BidiMap(Map<? extends K, ? extends V> arg0) {
		super(arg0);
		inverseMap = new HashMap<V, K>();
		putAll(arg0);
	}
	
	

	/* (非 Javadoc)
	 * @see java.util.HashMap#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public V put(K key, V value) {
		K k = removeValue(value);
		remove(k);
		inverseMap.put(value, key);
		return super.put(key, value);
	}

	/* (非 Javadoc)
	 * @see java.util.HashMap#putAll(java.util.Map)
	 */
	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		for(K k:m.keySet()){
			put(k, m.get(k));
		}
	}

	public K getKey(V value){
		return inverseMap.get(value);
	}
	
	public K removeValue(V value){
		K key = getKey(value);
		remove(key);
		return inverseMap.remove(value);
	}

	/* (非 Javadoc)
	 * @see java.util.HashMap#clear()
	 */
	@Override
	public void clear() {
		inverseMap.clear();
		super.clear();
	}

	
}
