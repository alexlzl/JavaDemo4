package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

public class WeakHashMapTest1 {
	public static void main(String[] args) throws Exception {
		List<WeakHashMap<byte[][], byte[][]>> maps = new ArrayList<WeakHashMap<byte[][], byte[][]>>();
		for (int i = 0; i < 2000; i++) {
		WeakHashMap<byte[][], byte[][]> d = new WeakHashMap<byte[][], byte[][]>();
		d.put(new byte[1000][1000], new byte[1000][1000]);
		maps.add(d);
		System.gc();
		System.err.println(i);
		}
		}
}
