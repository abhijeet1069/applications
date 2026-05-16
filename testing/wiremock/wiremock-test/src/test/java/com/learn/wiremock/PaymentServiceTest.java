package com.learn.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * If you don't want __files structure, below code can be used
 * and remove withBodyFile
 * String body = Files.readString(
 *     Path.of("src/test/resources/payment-response.json")
 * );
 *
 * .withBody(body)
 * */

public class PaymentServiceTest {
	static WireMockServer wireMockServer;
	static final int port = 8080;

	@BeforeAll
	static void setup(){
		wireMockServer = new WireMockServer(port);
		wireMockServer.start();
		configureFor("localhost",8080);
	}

	@AfterAll
	static void tearDown(){
		wireMockServer.stop();
	}

	@Test
	void shouldReturnPaymentStatus() throws IOException, InterruptedException {
		// fake API
		wireMockServer.stubFor(
				get(urlEqualTo("/payment/1"))
						.willReturn(
								aResponse()
										.withStatus(200)
										.withHeader("Content-Type", "application/json")
										.withBody("""
                                                {
                                                  "paymentId":1,
                                                  "status":"SUCCESS"
                                                }
                                                """)
						)
		);

		PaymentService service = new PaymentService();
		String response = service.getPaymentStatus(1);
		assertTrue(response.contains("SUCCESS"));

		//was proper http GET request was called
		verify(getRequestedFor(urlEqualTo("/payment/1")));
	}

	@Test
	void shouldReturnPaymentStatusFromFile() throws IOException, InterruptedException {
		wireMockServer.stubFor(
				get(urlEqualTo("/payment/2"))
						.willReturn(
								aResponse()
										.withStatus(200)
										.withHeader("Content-Type", "application/json")
										.withBodyFile("payment-response.json")
						)
		);

		PaymentService service = new PaymentService();
		String response = service.getPaymentStatus(2);
		assertTrue(response.contains("SUCCESSFUL"));
	}
}
