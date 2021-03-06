/**
 * Copyright (C) 2009 GIP RECIA http://www.recia.fr
 * @Author (C) 2009 GIP RECIA <contact@recia.fr>
 * @Contributor (C) 2009 SOPRA http://www.sopragroup.com/
 * @Contributor (C) 2011 Pierre Legay <pierre.legay@recia.fr>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * ESUP-Portail Commons - Copyright (c) 2006-2009 ESUP-Portail consortium.
 */
package org.esupportail.commons.services.urlGeneration; 

import java.util.HashMap;
import java.util.Map;

import org.esupportail.commons.services.authentication.AuthUtils;
import org.esupportail.commons.utils.strings.StringUtils;

/**
 * An abstract class that implements UrlGenerator.
 */
@SuppressWarnings("serial")
public abstract class AbstractUrlGenerator implements UrlGenerator {

	/**
	 * The separator between parameters.
	 */
	public static final String PARAMS_SEPARATOR = "&";
	
	/**
	 * The separator between name and value.
	 */
	public static final String NAME_VALUE_SEPARATOR = "=";
	
	/**
	 * Bean constructor.
	 */
	protected AbstractUrlGenerator() {
		super();
	}
	
	/**
	 * Encode parameters into an argument.
	 * @param params
	 * @return the argument
	 */
	public static String encodeParamsToArg(
			final Map<String, String> params) {
		if (params == null || params.isEmpty()) {
			return null;
		}
		String arg = "";
		String separator = "";
		for (String name : params.keySet()) {
			arg = arg + separator + name + NAME_VALUE_SEPARATOR 
			+ StringUtils.utf8UrlEncode(params.get(name));
			separator = PARAMS_SEPARATOR;
		}
		String encodedArg;
		encodedArg = arg;
		return encodedArg;
	}

	/**
	 * Decode arguments into parameters.
	 * @param arg
	 * @return the parameters
	 */
	public static Map<String, String> decodeArgToParams(
			final String arg) {
		if (arg == null) {
			return null;
		}
		String decodedArg;
		decodedArg = arg;
		Map<String, String> params = new HashMap<String, String>(); 
		for (String param : decodedArg.split(PARAMS_SEPARATOR)) {
			String[] nameValueArray = param.split(NAME_VALUE_SEPARATOR, 2);
			if (nameValueArray.length == 2) {
				params.put(nameValueArray[0], StringUtils.utf8UrlDecode(nameValueArray[1]));
			} else {
				params.put(nameValueArray[0], "");
			}
		}
		return params;
	}

	/**
	 * @param authType
	 * @param params 
	 * @return a link to the application with parameters.
	 */
	protected abstract String url(
			final String authType,
			final Map<String, String> params);

	/**
	 * @see org.esupportail.commons.services.urlGeneration.UrlGenerator#guestUrl(java.util.Map)
	 */
	public String guestUrl(
			final Map<String, String> params) {
		return url(AuthUtils.APPLICATION, params);
	}

	/**
	 * @see org.esupportail.commons.services.urlGeneration.UrlGenerator#guestUrl()
	 */
	public String guestUrl() {
		return guestUrl(null);
	}

	/**
	 * @see org.esupportail.commons.services.urlGeneration.UrlGenerator#casUrl(java.util.Map)
	 */
	public String casUrl(
			final Map<String, String> params) {
		return url(AuthUtils.CAS, params);
	}

	/**
	 * @see org.esupportail.commons.services.urlGeneration.UrlGenerator#casUrl()
	 */
	public String casUrl() {
		return casUrl(null);
	}

	/**
	 * @see org.esupportail.commons.services.urlGeneration.UrlGenerator#shibbolethUrl(java.util.Map)
	 */
	public String shibbolethUrl(
			final Map<String, String> params) {
		return url(AuthUtils.SHIBBOLETH, params);
	}

	/**
	 * @see org.esupportail.commons.services.urlGeneration.UrlGenerator#shibbolethUrl()
	 */
	public String shibbolethUrl() {
		return shibbolethUrl(null);
	}

}
