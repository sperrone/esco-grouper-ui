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
package org.esupportail.commons.services.ldap;

import org.esupportail.commons.utils.BeanUtils;

/**
 * A class that provides utilities to access LDAP.
 */
public class LdapUtils {

	/**
	 * The name of the LdapUserService bean.
	 */
	private static final String LDAP_SERVICE_BEAN = "ldapUserService";

	/**
	 * No instanciation.
	 */
	private LdapUtils() {
		throw new UnsupportedOperationException();
	}

	/**
	 * @return the LDAP service.
	 */
	public static LdapUserService createLdapService() {
		return (LdapUserService) BeanUtils.getBean(LDAP_SERVICE_BEAN);
	}

}
