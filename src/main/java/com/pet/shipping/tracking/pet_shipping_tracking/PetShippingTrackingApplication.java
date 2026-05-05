package com.pet.shipping.tracking.pet_shipping_tracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.security.Security;

@SpringBootApplication
public class PetShippingTrackingApplication {

	static {
		try {
			Security.insertProviderAt(
				(java.security.Provider) Class.forName("oracle.security.pki.OraclePKIProvider")
					.getConstructor().newInstance(), 3);
		} catch (Exception ignored) {}
	}

	public static void main(String[] args) {
		SpringApplication.run(PetShippingTrackingApplication.class, args);
	}

}
