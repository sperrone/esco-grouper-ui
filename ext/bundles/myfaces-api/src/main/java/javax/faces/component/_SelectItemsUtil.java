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
package javax.faces.component;

import java.util.Arrays;
import java.util.Iterator;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

/**
 * @author Mathias Broekelmann (latest modification by $Author: grantsmith $)
 * @version $Revision: 472555 $ $Date: 2006-11-08 18:30:58 +0100 (Mi, 08 Nov 2006) $
 */
class _SelectItemsUtil
{
    public static interface _ValueConverter
    {
        Object getConvertedValue(FacesContext context, String value);
    }
    
    /**
     * @param value the value to check
     * @param selectItemsIter contains instances of SelectItem
     * @return if the value of a selectitem is equal to the given value
     */
    public static boolean matchValue(Object value,
                    Iterator selectItemsIter)
    {
        while (selectItemsIter.hasNext())
        {
            SelectItem item = (SelectItem) selectItemsIter.next();
            if (item instanceof SelectItemGroup)
            {
                SelectItemGroup itemgroup = (SelectItemGroup) item;
                SelectItem[] selectItems = itemgroup.getSelectItems();
                if (selectItems != null
                                && selectItems.length > 0
                                && matchValue(value, Arrays.asList(
                                                selectItems).iterator()))
                {
                    return true;
                }
            }
            else
            {
                Object itemValue = item.getValue();
                if (value==itemValue || value.equals(itemValue))
                {
                    return true;
                }
            }
        }
        return false;
    }
}
