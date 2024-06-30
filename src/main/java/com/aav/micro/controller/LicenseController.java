package com.aav.micro.controller;

import com.aav.micro.model.License;
import com.aav.micro.service.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "gr/organization/{organizationId}/license")
public class LicenseController {

		@Autowired
		private LicenseService licenseService;

		@GetMapping(value = "/{licenseId}")
		public ResponseEntity<License> getLicense(
						@PathVariable("organizationId") String organizationId,
						@PathVariable("licenseId") String licensedId) {
				License license = licenseService.getLicense(licensedId, organizationId);
				return ResponseEntity.ok(license);
		}

		@PutMapping
		public ResponseEntity<String> updateLicense(
						@PathVariable("organizationId")
						String organizationId,
						@RequestBody License request) {
				return ResponseEntity.ok(licenseService.updateLicense(request, organizationId));
		}

		@PostMapping
		public ResponseEntity<String> createLicense(
						@PathVariable("organizationId") String organizationId,
						@RequestBody License request) {
				return ResponseEntity.ok(licenseService.createLicense(request, organizationId));
		}

		@DeleteMapping(value = "/{licenseId}")
		public ResponseEntity<String> deleteLicense(
						@PathVariable("organizationId") String organizationId,
						@PathVariable("licenseId") String licensedId) {
				return ResponseEntity.ok(licenseService.deleteLicense(licensedId, organizationId));
		}
}
