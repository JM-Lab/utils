package kr.jm.utils;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class HttpGetRequesterTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetResponseAsString() {
		String url = "http://aws.amazon.com/ec2/pricing/pricing-on-demand-instances.json";
		String jsonString = HttpGetRequester.getResponseAsString(url);
		System.out.println(jsonString);
		assertTrue(url != null);
	}

}
