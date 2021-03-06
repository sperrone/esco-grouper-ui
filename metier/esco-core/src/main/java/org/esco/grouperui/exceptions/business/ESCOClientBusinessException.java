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
package org.esco.grouperui.exceptions.business;

import org.esco.grouperui.domaine.beans.Response;
import org.esco.grouperui.domaine.beans.Responses;
import org.esco.grouperui.exceptions.ESCOBusinessException;

/**
 * Logical business exceptions.
 * 
 * @author SopraGroup
 */
public class ESCOClientBusinessException extends ESCOBusinessException {

    /** UID. */
    private static final long serialVersionUID = -8740530765329819935L;

    /** The response bean. Use it to have the details of errors. **/
    private Responses         responses;

    /**
     * default constructor.
     */
    public ESCOClientBusinessException() {

    }

    /**
     * Construct an ESCOClientBusinessException.
     * 
     * @param theCode
     *            String
     */
    public ESCOClientBusinessException(final String theCode) {
        super(theCode);
    }

    /**
     * Construct an ESCOClientBusinessException.
     * 
     * @param theResponse
     *            : the response, contains the collection of response for each
     *            entry of the service transaction, allowing to know for each
     *            entry the result of the service execution.
     */
    public ESCOClientBusinessException(final Responses theResponse) {
        super();
        this.responses = theResponse;
    }

    /**
     * Construct an ESCOClientBusinessException.
     * 
     * @param theCode
     *            String
     * @param theCause
     *            Throwable
     */
    public ESCOClientBusinessException(final String theCode, final Throwable theCause) {
        super(theCode, theCause);
    }

    /**
     * Construct an ESCOClientBusinessException.
     * 
     * @param theCode
     *            : the code of the exception.
     * @param theCause
     *            : the cause of the exception.
     * @param theResponse
     *            : the response, contains the collection of response for each
     *            entry of the service transaction, allowing to know for each
     *            entry the result of the service execution.
     */
    public ESCOClientBusinessException(final String theCode, final Throwable theCause, final Responses theResponse) {
        super(theCode, theCause);
        this.responses = theResponse;
    }

    /**
     * Construct an ESCOClientBusinessException.
     * 
     * @param theCode
     *            : the code of the exception.
     * @param theCause
     *            : the cause of the exception.
     * @param theResponse
     *            : the response, contains the collection of response for each
     *            entry of the service transaction, allowing to know for each
     *            entry the result of the service execution.
     */
    public ESCOClientBusinessException(final String theCode, final Throwable theCause, final Response theResponse) {
        super(theCode, theCause);

        if (this.responses == null) {
            this.responses = new Responses();
        }

        this.responses.add(theResponse);
    }

    /**
     * Construct an exception from it code, it cause, it responses.
     * 
     * @param theResponse
     *            : the collection of response of the service.
     */
    public ESCOClientBusinessException(final Response theResponse) {
        super();

        if (this.responses == null) {
            this.responses = new Responses();
        }

        this.responses.add(theResponse);
    }

    /**
     * Getter for attribute <b>response</b>.
     * 
     * @return the response
     */
    public Responses getResponses() {
        return this.responses;
    }

    /**
     * Setter for attribute <b>response</b>.
     * 
     * @param theResponse
     *            the response to set
     */
    public void setResponses(final Responses theResponse) {
        this.responses = theResponse;
    }

    /**
     * Add a new response to the exception.
     * 
     * @param response
     *            : the response of the service.
     */
    public void add(final Response response) {
        if (this.responses == null) {
            this.responses = new Responses();
        }
        this.responses.add(response);
    }
}
