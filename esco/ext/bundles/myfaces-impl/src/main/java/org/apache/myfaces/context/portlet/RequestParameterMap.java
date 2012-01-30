/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.myfaces.context.portlet;

import java.util.Enumeration;
import javax.portlet.PortletRequest;

import org.apache.myfaces.context.servlet.AbstractAttributeMap;

/**
 * PortletRequest parameters as Map.
 *
 * @author  Stan Silvert (latest modification by $Author: grantsmith $)
 * @version $Revision: 472618 $ $Date: 2006-11-08 21:06:54 +0100 (Mi, 08 Nov 2006) $
 */
public class RequestParameterMap extends AbstractAttributeMap
{
    private final PortletRequest _portletRequest;

    RequestParameterMap(PortletRequest portletRequest)
    {
        _portletRequest = portletRequest;
    }

    protected Object getAttribute(String key)
    {
        return _portletRequest.getParameter(key);
    }

    protected void setAttribute(String key, Object value)
    {
        throw new UnsupportedOperationException(
            "Cannot set PortletRequest Parameter");
    }

    protected void removeAttribute(String key)
    {
        throw new UnsupportedOperationException(
            "Cannot remove PortletRequest Parameter");
    }

    protected Enumeration getAttributeNames()
    {
        return _portletRequest.getParameterNames();
    }
}