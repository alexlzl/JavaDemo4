package cn.bluerhino.driver.utils;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader.ImageCache;

/**
 * Describe:
 * 
 * Date:2015-7-20
 * 
 * Author:liuzhouliang
 */
public class LruImageCache implements ImageCache {

	private static LruCache<String, Bitmap> mMemoryCache;

	private static LruImageCache lruImageCache;

	private LruImageCache() {
		// Get the Max available memory
		int maxMemory = (int) Runtime.getRuntime().maxMemory();
		int cacheSize = maxMemory / 8;
		mMemoryCache = new LruCache<String, Bitmap>(cacheSize) {
			@Override
			protected int sizeOf(String key, Bitmap bitmap) {
				return bitmap.getRowBytes() * bitmap.getHeight();
			}
		};
	}

	public static LruImageCache instance() {
		if (lruImageCache == null) {
			lruImageCache = new LruImageCache();
		}
		return lruImageCache;
	}

	@Override
	public Bitmap getBitmap(String arg0) {
		return mMemoryCache.get(arg0);
	}

	@Override
	public void putBitmap(String arg0, Bitmap arg1) {
		if (getBitmap(arg0) == null) {
			mMemoryCache.put(arg0, arg1);
		}
	}

}
