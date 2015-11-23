package org.aiwolf.common.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// TODO 修正中 by ando

/**
 * <div lang="ja">
 *
 * {@code <S>}の昇順に{@code <V>}をソートするCollectionです。
 *
 * </div>
 *
 * <div lang="en">
 *
 * The Collection is sorted {@code <V>} by {@code <S>} in ascending order.
 *
 * </div>
 *
 * @author tori
 *
 * @param <V>
 *
 *            <div lang="ja">ソートされる値</div>
 *
 *            <div lang="en">Sorted value</div>
 *
 * @param <S>
 *
 *
 */
public class Sorter<V, S> implements Map<V, S>, Serializable {

	private static final long serialVersionUID = -8767639922201898076L;

	protected final Map<V, S> itemMap;
	protected Comparator<S> scoreComparator;

	public Sorter() {
		itemMap = new LinkedHashMap<V, S>();
	}

	public Sorter(Comparator<S> comparator) {
		this();
		scoreComparator = comparator;
	}

	/**
	 *
	 * @param map
	 */
	public Sorter(Map<? extends V, ? extends S> map) {
		itemMap = new LinkedHashMap<V, S>(map);
	}

	/**
	 * 新しいアイテムを設定する
	 *
	 * @param v
	 * @param s
	 */
	public void set(V v, S s) {
		itemMap.put(v, s);
	}

	/**
	 * あるアイテムのスコアを取得する
	 *
	 * @param v
	 * @param s
	 */
	public S get(Object v) {
		return itemMap.get(v);
	}

	/**
	 * &lt;S&gt; によって昇順にソートされたリストを返す
	 *
	 * @return 昇順にソートされたリスト
	 */
	public List<V> getSortedList() {
		List<V> list = new ArrayList<V>(itemMap.keySet());
		Collections.sort(list, new ItemComparator());
		return list;
	}

	/**
	 * &lt;S&gt; によって降順にソートされたリストを返す
	 *
	 * @return 降順にソートされたリスト
	 */
	public List<V> getReverseList() {
		List<V> list = new ArrayList<V>(itemMap.keySet());
		Collections.sort(list, new ItemComparator());
		Collections.reverse(list);
		return list;
	}

	final class ItemComparator implements Comparator<V> {
		@SuppressWarnings("unchecked")
		public int compare(V v1, V v2) {
			S s1 = itemMap.get(v1);
			S s2 = itemMap.get(v2);
			if (scoreComparator != null) {
				return scoreComparator.compare(s1, s2);
			} else if (s1 instanceof Comparable) {
				return ((Comparable<S>) s1).compareTo(s2);
			}
			return 0;
		}

	}

	public void clear() {
		itemMap.clear();
	}

	public boolean containsKey(Object key) {
		return itemMap.containsKey(key);
	}

	public boolean containsValue(Object value) {
		return itemMap.containsValue(value);
	}

	public boolean isEmpty() {
		return itemMap.isEmpty();
	}

	/**
	 * ソートされたkeySetを返す
	 */
	public Set<V> keySet() {
		return new LinkedHashSet<V>(getSortedList());
	}

	public S remove(Object key) {
		return itemMap.remove(key);
	}

	public int size() {
		return itemMap.size();
	}

	public Collection<S> values() {
		return itemMap.values();
	}

	public S put(V key, S value) {
		return itemMap.put(key, value);
	}

	public void putAll(Map<? extends V, ? extends S> m) {
		itemMap.putAll(m);

	}

	public Set<java.util.Map.Entry<V, S>> entrySet() {
		return itemMap.entrySet();
	}

	/**
	 * 最初のキーを返す
	 *
	 * @return
	 */
	public V getFirstKey() {
		if (isEmpty()) {
			return null;
		}
		return getSortedList().get(0);
	}

	/**
	 * 最後のキーを返す
	 *
	 * @return
	 */
	public V getLastKey() {
		if (isEmpty()) {
			return null;
		}
		List<V> list = getSortedList();
		return list.get(list.size() - 1);
	}

	/**
	 * sより大きいものだけ取得
	 *
	 * @param s
	 * @return
	 */
	public Sorter<V, S> largerThan(S s) {
		Sorter<V, S> sorter = new Sorter<V, S>();
		for (V v : keySet()) {
			if (compare(get(v), s) > 0) {
				sorter.put(v, get(v));
			}
		}
		return sorter;
	}

	/**
	 * sより小さいものだけ取得
	 *
	 * @param s
	 * @return
	 */
	public Sorter<V, S> smallerThan(S s) {
		Sorter<V, S> sorter = new Sorter<V, S>();
		for (V v : keySet()) {
			if (compare(get(v), s) < 0) {
				sorter.put(v, get(v));
			}
		}
		return sorter;
	}

	/**
	 * s以上ものだけ取得
	 *
	 * @param s
	 * @return
	 */
	public Sorter<V, S> largerEqual(S s) {
		Sorter<V, S> sorter = new Sorter<V, S>();
		for (V v : keySet()) {
			if (compare(get(v), s) >= 0) {
				sorter.put(v, get(v));
			}
		}
		return sorter;
	}

	/**
	 * s以下のものだけ取得
	 *
	 * @param s
	 * @return
	 */
	public Sorter<V, S> smallerEqual(S s) {
		Sorter<V, S> sorter = new Sorter<V, S>();
		for (V v : keySet()) {
			if (compare(get(v), s) <= 0) {
				sorter.put(v, get(v));
			}
		}
		return sorter;
	}

	@SuppressWarnings("unchecked")
	private int compare(S s1, S s2) {
		if (scoreComparator != null) {
			return scoreComparator.compare(s1, s2);
		} else if (s1 instanceof Comparable) {
			return ((Comparable<S>) s1).compareTo(s2);
		}
		return 0;
	}
}
