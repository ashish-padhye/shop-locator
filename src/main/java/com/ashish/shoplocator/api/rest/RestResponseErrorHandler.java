package com.ashish.shoplocator.api.rest;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;

public class RestResponseErrorHandler extends DefaultResponseErrorHandler{
	private static final Logger logger = LoggerFactory.getLogger(RestResponseErrorHandler.class);
	private static final String DEFAULT_CHARSET = "ISO-8859-1";
	
	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		HttpStatus statusCode = response.getStatusCode();
		switch (statusCode.series()) {
			case CLIENT_ERROR:
				throw new HttpClientErrorException(statusCode, response.getStatusText(),
						response.getHeaders(), getResponseBody(response), getCharset(response));
			case SERVER_ERROR:				
				String responseBody = getResponseBodyAsString(response);
				throw new RuntimeException(responseBody);
			default:
				throw new RestClientException("Unknown status code [" + statusCode + "]");
		}
	}

	private byte[] getResponseBody(ClientHttpResponse response) {
		try {
			InputStream responseBody = response.getBody();
			if (responseBody != null) {
				return FileCopyUtils.copyToByteArray(responseBody);
			}
		}
		catch (IOException ex) {
			// ignore
		}
		return new byte[0];
	}
	
	private Charset getCharset(ClientHttpResponse response) {
		HttpHeaders headers = response.getHeaders();
		MediaType contentType = headers.getContentType();
		return contentType != null ? contentType.getCharset() : null;
	}
	
	private String getResponseBodyAsString(ClientHttpResponse response) {
		try {
			byte[] responseBody = getResponseBody(response);
			Charset charset = getCharset(response);
			String responseCharset = (charset != null ? charset.name() : DEFAULT_CHARSET);
			return new String(responseBody, responseCharset);
		}
		catch (UnsupportedEncodingException ex) {
			// should not occur
			throw new IllegalStateException(ex);
		}
	}
}
