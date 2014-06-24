package org.aiwolf.common.util;

import java.util.Collection;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * カウンタを作成する
 * @author tori
 * @param <V>
 *
 */
public class Counter<V> implements Iterable<V>, Map<V, Integer> {
	Sorter<V, Integer> sorter;
	
	/**
	 * カウンタを作成
	 */
	public Counter() {
		sorter = new Sorter<V, Integer>();
	}
	
	/**
	 * カウントの合計を返す
	 * @return
	 */
	public int getTotalCount(){
		int total = 0;
		for(int v:sorter.values()){
			total += v;
		}
		return total;
	}
	
	/**
	 * カウント量に対して昇順のリストを返す
	 * @return
	 * @see jp.ac.nagoyau.is.ss.kishii.util.Sorter#getSortedList()
	 */
	public List<V> getSortedList() {
		return sorter.getSortedList();
	}



	/**
	 * カウント量に対して降順のリストを返す
	 * @return
	 * @see jp.ac.nagoyau.is.ss.kishii.util.Sorter#getReverseList()
	 */
	public List<V> getReverseList() {
		return sorter.getReverseList();
	}

	/**
	 * min以上の値を持つデータだけ取得<br>
	 * コピーを返す
	 * @param min
	 * @return
	 */
	public Counter<V> getOver(int min){
		Counter<V> c = new Counter<V>();
		for(V v:getReverseList()){
			if(get(v) >= min){
				c.put(v, get(v));
			}
		}
		return c;
	}
	
	/**
	 * max以下の値を持つデータだけ取得<br>
	 * コピーを返す
	 * @param max
	 * @return
	 */
	public Counter<V> getUnder(int max){
		Counter<V> c = new Counter<V>();
		for(V v:getSortedList()){
			if(get(v) <= max){
				c.put(v, get(v));
			}
		}
		return c;
	}
	

	/**
	 * 任意のMapからカウンタを作成
	 * @param map
	 */
	public Counter(Map<? extends V, Integer> map){
		sorter = new Sorter<V, Integer>(map);
	}
	
	/**
	 * 指定したアイテムのカウントをnumだけ増やす
	 * @param v
	 * @param num
	 */
	public void add(V v, int num){
		if(sorter.containsKey(v)){
			sorter.put(v, sorter.get(v)+num);
		}
		else{
			sorter.put(v, num);
		}
	}
	
	/**
	 * 指定したアイテムのカウントを1だけ増やす
	 * @param v
	 * @param num
	 */
	public void add(V v){
		add(v, 1);
	}
	
	/**
	 * 指定したアイテムのカウントを1増やす
	 * @param v
	 */
	public void increment(V v){
		add(v, 1);
	}
	
	/**
	 * 指定したアイテムのカウントを返す
	 * @param v
	 * @return
	 */
	public Integer get(Object v){
		if(sorter.containsKey(v)){
			return sorter.get(v);
		}
		else{
			return 0;
		}	
	}
	
	/**
	 * 最大の値を持つアイテムを返す．<br>
	 * アイテムがなければnullを返す
	 * @return
	 */
	public V getLargest(){
		if(sorter.isEmpty()){
			return null;
		}
		else{
			return sorter.getReverseList().get(0);
		}
	}

	/**
	 * 最小の値を持つアイテムを返す．<br>
	 * アイテムがなければnullを返す
	 * @return
	 */
	public V getSmallest(){
		if(sorter.isEmpty()){
			return null;
		}
		else{
			return sorter.getSortedList().get(0);
		}
	}
	
	public void clear() {
		sorter.clear();
	}

	public boolean containsKey(Object key) {
		return sorter.containsKey(key);
	}

	public boolean isEmpty() {
		return sorter.isEmpty();
	}

	public Set<V> keySet() {
		return sorter.keySet();
	}

	public Integer remove(Object key) {
		return sorter.remove(key);
	}

	public int size() {
		return sorter.size();
	}

	public Integer put(V key, Integer value) {
		return sorter.put(key, value);
	}

	public void putAll(Map<? extends V, ? extends Integer> m) {
		sorter.putAll(m);
	}


	@Override
	public boolean containsValue(Object value) {
		return sorter.containsValue(value);
	}

	@Override
	public Collection<Integer> values() {
		return sorter.values();
	}

	@Override
	public Set<java.util.Map.Entry<V, Integer>> entrySet() {
		return sorter.entrySet();
	}
	
	/**
	 * 昇順イテレータ
	 */
	public Iterator<V> iterator(){
		return sorter.getSortedList().iterator();
	}
	
	/**
	 * 降順イテレータ
	 * @return
	 */
	public Iterator<V> reverseIterator(){
		return sorter.getReverseList().iterator();
	}
	
	/**
	 * 数値の分布を返す
	 * @return
	 */
	public Map<Integer, Integer> toHistogram(){
		Counter<Integer> counter = new Counter<Integer>();
		for(int val:values()){
			counter.add(val, 1);
		}
		return new TreeMap<Integer, Integer>(counter);
	}


	/**
	 * 追加する
	 * @param actionCounter
	 * @return
	 */
	public Counter<V> addAll(Counter<V> actionCounter) {
		for(V v:actionCounter.keySet()){
			add(v, actionCounter.get(v));
		}
		return this;
	}

}
