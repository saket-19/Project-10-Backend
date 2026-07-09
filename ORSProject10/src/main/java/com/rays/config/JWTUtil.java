package com.rays.config;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Utility class for creating, validating, and parsing JWT tokens.
 * Implements a custom JWT mechanism using HMAC-SHA256 signature.
 *
 * @author Saket
 */
@Component
public class JWTUtil {

	@Value("${jwt.secret}")
	private String jwtSecret;

	@Value("${jwt.expiration}")
	private long jwtExpiration; // in milliseconds

	private static final ObjectMapper objectMapper = new ObjectMapper();

	/**
	 * Generates a JWT token for the given user details.
	 *
	 * @param userId  User ID
	 * @param loginId Login ID (used as subject)
	 * @param role    User role
	 * @return Signed JWT token string
	 * @throws Exception if token generation fails
	 */
	public String generateToken(Long userId, String loginId, String role) throws Exception {
		long nowMillis = System.currentTimeMillis();
		long expMillis = nowMillis + jwtExpiration;

		// JWT Header
		Map<String, Object> header = new HashMap<>();
		header.put("alg", "HS256");
		header.put("typ", "JWT");

		// JWT Payload (claims)
		Map<String, Object> payload = new HashMap<>();
		payload.put("sub", loginId); // loginId as subject
		payload.put("userId", userId); // numeric user id
		payload.put("role", role); // user role
		payload.put("iat", nowMillis); // issued at
		payload.put("exp", expMillis); // expiration

		String headerBase64 = encodeUrl(objectMapper.writeValueAsString(header));
		String payloadBase64 = encodeUrl(objectMapper.writeValueAsString(payload));
		String signatureBase64 = sign(headerBase64 + "." + payloadBase64, jwtSecret);

		return String.join(".", headerBase64, payloadBase64, signatureBase64);
	}

	/**
	 * Validates a JWT token and checks signature, subject, and expiration.
	 *
	 * @param token           JWT token
	 * @param expectedLoginId Expected login ID to match
	 * @return true if token is valid
	 * @throws Exception if validation fails
	 */
	public boolean validateToken(String token, String expectedLoginId) throws Exception {
		String[] parts = token.split("\\.");
		if (parts.length != 3) {
			throw new Exception("Invalid JWT token");
		}

		String payloadJson = decode(parts[1]);
		String tokenLoginId = extractField(payloadJson, "sub");
		String expectedSignature = sign(parts[0] + "." + parts[1], jwtSecret);

		if (!expectedSignature.equals(parts[2])) {
			throw new Exception("JWT signature does not match");
		}

		if (!expectedLoginId.equals(tokenLoginId)) {
			throw new Exception("JWT subject (loginId) does not match");
		}

		if (isTokenExpired(payloadJson)) {
			throw new Exception("JWT token has expired");
		}

		return true;
	}

	/**
	 * Extracts login ID (subject) from JWT token.
	 *
	 * @param token JWT token
	 * @return login ID
	 */
	public String extractLoginId(String token) {
		return extractField(decode(token.split("\\.")[1]), "sub");
	}

	/**
	 * Extracts user ID from JWT token.
	 *
	 * @param token JWT token
	 * @return user ID
	 */
	public Long extractUserId(String token) {
		return Long.parseLong(extractField(decode(token.split("\\.")[1]), "userId"));
	}

	/**
	 * Extracts role from JWT token.
	 *
	 * @param token JWT token
	 * @return user role
	 */
	public String extractRole(String token) {
		return extractField(decode(token.split("\\.")[1]), "role");
	}

	/**
	 * Checks whether token is expired based on "exp" claim.
	 *
	 * @param payloadJson decoded JWT payload
	 * @return true if expired
	 */
	private boolean isTokenExpired(String payloadJson) {
		long exp = Long.parseLong(extractField(payloadJson, "exp"));
		return exp < (System.currentTimeMillis() / 1000);
	}

	/**
	 * Extracts a field value from JSON string.
	 *
	 * @param json  JSON payload
	 * @param field field name
	 * @return value as String
	 */
	private String extractField(String json, String field) {
		try {
			Map<String, Object> map = objectMapper.readValue(json, Map.class);
			return String.valueOf(map.get(field));
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Generates HMAC-SHA256 signature.
	 *
	 * @param data data to sign
	 * @param key  secret key
	 * @return base64 encoded signature
	 * @throws Exception if signing fails
	 */
	private String sign(String data, String key) throws Exception {
		Mac mac = Mac.getInstance("HmacSHA256");
		mac.init(new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
		return encodeUrl(mac.doFinal(data.getBytes(StandardCharsets.UTF_8)));
	}

	/**
	 * Encodes string into Base64 URL-safe format.
	 *
	 * @param data input string
	 * @return encoded string
	 */
	private String encodeUrl(String data) {
		return Base64.getUrlEncoder().withoutPadding()
				.encodeToString(data.getBytes(StandardCharsets.UTF_8));
	}

	/**
	 * Encodes byte array into Base64 URL-safe format.
	 *
	 * @param data input bytes
	 * @return encoded string
	 */
	private String encodeUrl(byte[] data) {
		return Base64.getUrlEncoder().withoutPadding().encodeToString(data);
	}

	/**
	 * Decodes Base64 URL-safe string.
	 *
	 * @param data encoded string
	 * @return decoded string
	 */
	private String decode(String data) {
		return new String(Base64.getUrlDecoder().decode(data), StandardCharsets.UTF_8);
	}
}