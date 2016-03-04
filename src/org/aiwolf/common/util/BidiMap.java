package org.aiwolf.common.util;

import java.util.HashMap;
import java.util.Map;

/**
 * <div lang="ja">双方向マップです。</div>
 *
 * <div lang="en">Bidimap.</div>
 *
 * @param <K>
 *            <div lang="ja">キー</div>
 *
 *            <div lang="en">Key</div>
 * @param <V>
 *            <div lang="ja">値</div>
 *
 *            <div lang="en">Value</div>
 */
public class BidiMap<K, V> extends HashMap<K, V> {

	private static final long serialVersionUID = 998600781640480300L;

	Map<V, K> inverseMap;

	/**
	 * <div lang="ja">新しいBidiMapを構築します。</div>
	 *
	 * <div lang="ja">Create new BidiMap.</div>
	 */
	public BidiMap() {
		super();
		inverseMap = new HashMap<V, K>();
	}

	/**
	 * <div lang="ja">
	 *
	 * 指定された初期容量と負荷係数を持つ、
	 *
	 * 空のBidiMapを作成します。
	 *
	 * </div>
	 *
	 * <div lang="en">
	 *
	 * Constructs an empty BidiMap with the specified
	 *
	 * initial capacity and load factor.
	 *
	 * </div>
	 *
	 * @param initialCapacity
	 *
	 *            <div lang="ja">初期容量</div>
	 *
	 *            <div lang="en">The initial capacity</div>
	 *
	 * @param loadFactor
	 *
	 *            <div lang="ja">負荷係数</div>
	 *
	 *            <div lang="en">The load factor</div>
	 */
	public BidiMap(int initialCapacity, float loadFactor) {
		super(initialCapacity, loadFactor);
		inverseMap = new HashMap<V, K>();
	}

	/**
	 * <div lang="ja">
	 *
	 * 指定された初期容量とデフォルトの負荷係数(0.75)を持つ、
	 *
	 * 空のBidiMapを作成します。
	 *
	 * </div>
	 *
	 * <div lang="en">
	 *
	 * Constructs an empty HashMap with the specified
	 *
	 * initial capacity and the default load factor (0.75).
	 *
	 * </div>
	 *
	 * @param initialCapacity
	 *
	 *            <div lang="ja">初期容量</div>
	 *
	 *            <div lang="en">The initial capacity</div>
	 *
	 */
	public BidiMap(int initialCapacity) {
		super(initialCapacity);
		inverseMap = new HashMap<V, K>();
	}

	/**
	 * <div lang="ja">
	 *
	 * 指定されたMapと同じマッピングで新しいBidiMapを
	 *
	 * 作成します。デフォルトの負荷係数(0.75)、および指定
	 *
	 * されたMapのマッピングを保持するのに十分な初期容量で、
	 *
	 * BidiMapは作成されます。
	 *
	 * </div>
	 *
	 * <div lang="en">
	 *
	 * Constructs a new BidiMap with the same mappings as
	 *
	 * the specified Map. The BidiMap is created with default
	 *
	 * load factor (0.75) and an initial capacity sufficient to
	 *
	 * hold the mappings in the specified Map.
	 *
	 * </div>
	 *
	 * @param m
	 *
	 *            <div lang="ja">マッピングがこのマップに配置されるマップ</div>
	 *
	 *            <div lang="en">
	 *
	 *            The map whose mappings are to be placed in
	 *
	 *            this map
	 *
	 *            </div>
	 *
	 * @throws NullPointerException
	 *
	 *             <div lang="ja">指定されたマップがnullの場合</div>
	 *
	 *             <div lang="en">If the specified map is null</div>
	 */
	public BidiMap(Map<? extends K, ? extends V> m) {
		super(m);
		inverseMap = new HashMap<V, K>();
		putAll(m);
	}

	// TODO コメントアウトされたJavaDoc
	/*
	 * (非 Javadoc)
	 *
	 * @see java.util.HashMap#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public V put(K key, V value) {
		K k = removeValue(value);
		remove(k);
		inverseMap.put(value, key);
		return super.put(key, value);
	}

	// TODO コメントアウトされたJavaDoc
	/*
	 * (非 Javadoc)
	 *
	 * @see java.util.HashMap#putAll(java.util.Map)
	 */
	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		for (K k : m.keySet()) {
			put(k, m.get(k));
		}
	}

	/**
	 * <div lang="ja">
	 *
	 * 指定された値に関連付けられたキーを返します。
	 *
	 * </div>
	 *
	 * <div lang="en">
	 *
	 * Get the key.
	 *
	 * </div>
	 *
	 * @param value
	 *            <div lang="ja">値</div>
	 *
	 *            <div lang="en">Value</div>
	 * @return
	 *
	 * 		<div lang="ja">キー</div>
	 *
	 *         <div lang="en">Key</div>
	 */
	public K getKey(V value) {
		return inverseMap.get(value);
	}

	/**
	 * <div lang="ja">
	 *
	 * 指定された値とそのキーを削除します。
	 *
	 * </div>
	 *
	 * <div lang="en">
	 *
	 * Remove the value and key.
	 *
	 * </div>
	 *
	 * @param value
	 *            <div lang="ja">値</div>
	 *
	 *            <div lang="en">Value</div>
	 *
	 * @return
	 *
	 * 		<div lang="ja">値に以前関連付けられていたキー</div>
	 *
	 *         <div lang="en">Key that related to the value</div>
	 */
	public K removeValue(V value) {
		K key = getKey(value);
		remove(key);
		return inverseMap.remove(value);
	}

	// TODO コメントアウトされたJavaDoc
	/*
	 * (非 Javadoc)
	 *
	 * @see java.util.HashMap#clear()
	 */
	@Override
	public void clear() {
		inverseMap.clear();
		super.clear();
	}

}
