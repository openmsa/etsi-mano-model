package com.ubiqube.mano.tests;

import org.junit.jupiter.api.Test;

import com.ubiqube.etsi.mano.test.GreenTest;

class BasicTest extends GreenTest {

	@Test
	void testName() {
		runTest("com.ubiqube.etsi.mano.v331");
	}

}
