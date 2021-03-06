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
package javax.faces.render;

import java.io.IOException;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;

/**
 * see Javadoc of <a href="http://java.sun.com/j2ee/javaserverfaces/1.1_01/docs/api/index.html">JSF Specification</a>
 *
 * @author Manfred Geiler (latest modification by $Author: grantsmith $)
 * @version $Revision: 472558 $ $Date: 2006-11-08 18:36:53 +0100 (Mi, 08 Nov 2006) $
 */
public abstract class Renderer
{
    public void decode(FacesContext context,
                       UIComponent component)
    {
        if (context == null) throw new NullPointerException("context");
        if (component == null) throw new NullPointerException("component");
    }

    public void encodeBegin(FacesContext context,
                            UIComponent component)
            throws IOException
    {
        if (context == null) throw new NullPointerException("context");
        if (component == null) throw new NullPointerException("component");
    }

    public void encodeChildren(FacesContext context,
                               UIComponent component)
            throws IOException
    {
        if (context == null) throw new NullPointerException("context");
        if (component == null) throw new NullPointerException("component");
        
        List children = component.getChildren();
        for (int i=0; i<children.size(); i++) 
        {
            UIComponent child = (UIComponent) children.get(i);
            
            if (!child.isRendered())
            {
                continue;
            }

            child.encodeBegin(context);
            if (child.getRendersChildren())
            {
                child.encodeChildren(context);
            }
            child.encodeEnd(context);
        }
    }

    public void encodeEnd(FacesContext context,
                          UIComponent component)
            throws IOException
    {
        if (context == null) throw new NullPointerException("context");
        if (component == null) throw new NullPointerException("component");
    }

    public String convertClientId(FacesContext context,
                                  String clientId)
    {
        if (context == null) throw new NullPointerException("context");
        if (clientId == null) throw new NullPointerException("clientId");
        return clientId;
    }

    public boolean getRendersChildren()
    {
        return false;
    }

    public Object getConvertedValue(FacesContext context,
                                    UIComponent component,
                                    Object submittedValue)
            throws ConverterException
    {
        if (context == null) throw new NullPointerException("context");
        if (component == null) throw new NullPointerException("component");
        return submittedValue;
    }

}
