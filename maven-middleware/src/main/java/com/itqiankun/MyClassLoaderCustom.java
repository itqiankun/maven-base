package com.itqiankun;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: ma_qiankun
 * @date: 2023/8/30
 **/
public class MyClassLoaderCustom extends ClassLoader {

	private ClassLoader jdkClassLoader;

	private Map<String, String> classPathMap = new HashMap<>();

	public MyClassLoaderCustom(ClassLoader jdkClassLoader) {
		this.jdkClassLoader = jdkClassLoader;
		classPathMap.put("DemoVersion-1.0-SNAPSHOT", "/Users/mqk/Desktop/mqk-worker/mqk-code/maven-base/maven-conflict/1.0-SNAPSHOT/DemoVersion.class");
		classPathMap.put("DemoVersion-2.0-SNAPSHOT", "/Users/mqk/Desktop/mqk-worker/mqk-code/maven-base/maven-conflict/2.0-SNAPSHOT/DemoVersion.class");
	}

	@Override
	protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
		Class result = null;
		try {
			//这里要使用 JDK 的类加载器加载 java.lang 包里面的类
			result = jdkClassLoader.loadClass(name);
		} catch (Exception e) {
			//忽略
		}
		if (result != null) {
			return result;
		}
		String classPath = classPathMap.get(name);
		File file = new File(classPath);
		if (!file.exists()) {
			throw new ClassNotFoundException();
		}

		byte[] classBytes = getClassData(file);
		if (classBytes == null || classBytes.length == 0) {
			throw new ClassNotFoundException();
		}
		return defineClass(classBytes, 0, classBytes.length);
	}


	private byte[] getClassData(File file) {
		try (InputStream ins = new FileInputStream(file); ByteArrayOutputStream baos = new
				ByteArrayOutputStream()) {
			byte[] buffer = new byte[4096];
			int bytesNumRead = 0;
			while ((bytesNumRead = ins.read(buffer)) != -1) {
				baos.write(buffer, 0, bytesNumRead);
			}
			return baos.toByteArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new byte[] {};
	}
}
