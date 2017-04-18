package kr.jm.utils;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * The Class HttpGetRequesterTest.
 */
public class HttpGetRequesterTest {

	/**
	 * Sets the up.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test get response as string.
	 */
	@Test
	public void testGetResponseAsString() {
		String url =
				"http://aws.amazon.com/ec2/pricing/pricing-on-demand-instances.json";
		String jsonString = HttpGetRequester.getResponseAsString(url);
		System.out.println(jsonString);
		assertTrue(jsonString != null);
	}

}
