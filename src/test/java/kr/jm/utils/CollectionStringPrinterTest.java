package kr.jm.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.jm.utils.CollectionStringPrinter;

import org.junit.Test;

public class CollectionStringPrinterTest {
	
	@Test
	public void testCollectionToJSONString() {
		
		List testList = new ArrayList();
		testList.add("test");
		testList.add(12);
		testList.add(0.003f);
		testList.add(23135235l);
		testList.add(Integer.MAX_VALUE);
		testList.add(Long.MIN_VALUE);
		testList.add(new HashMap());
		testList.add(null);
		testList.add("");
		
		
		String listResult = CollectionStringPrinter.CollectionToJSONString(testList);
		
		System.out.println(listResult);
		
		System.out.println(testList);
		
		Map testMap = new HashMap();
		testMap.put("test", "stringtest");
		testMap.put(2341, testList);
		testMap.put("2341", "testList");
		testMap.put(2341.0d, new HashMap());
		testMap.put(2341.034d, "");
		testMap.put(Double.MIN_VALUE, null);
		testMap.put(Double.MIN_NORMAL, null);
		testMap.put(Double.MIN_EXPONENT, null);
		testMap.put(Double.MAX_VALUE, null);
		testMap.put(Double.MIN_VALUE, null);
		
		String mapResult = CollectionStringPrinter.CollectionToJSONString(testMap);
		
		System.out.println(mapResult);		
		
		System.out.println(testMap);
	}

}
