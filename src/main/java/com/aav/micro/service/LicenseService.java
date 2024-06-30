package com.aav.micro.service;

import com.aav.micro.model.License;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class LicenseService {

		public License getLicense(String licenseId, String organizationId) {
				License license = new License();
				license.setId(new Random().nextInt(1000));
				license.setLicenseId(licenseId);
				license.setOrganizationId(organizationId);
				license.setDescription("Software License");
				license.setProductName("GR-Soft");
				license.setLicenseType("full");
				return license;
		}

		public String createLicense(License license, String organizationId) {
				String responseMessage = null;
				if (license != null) {
						license.setOrganizationId(organizationId);
						responseMessage = String.format("Successfully created a new license with ID: %s", license.toString());
				}
				return responseMessage;
		}

		public String updateLicense(License license, String organizationId) {
				String responseMessage = null;
				if (license != null) {
						license.setOrganizationId(organizationId);
						responseMessage = String.format("Successfully updated a license with ID: %s", license.toString());
				}
				return responseMessage;
		}

		public String deleteLicense(String licenseId, String organizationId) {
				String responseMessage = null;
				responseMessage = String.format("Successfully deleted a license with ID: %s", licenseId);
				return responseMessage;
		}
}
