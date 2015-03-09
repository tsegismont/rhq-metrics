/*
 * Copyright 2014-2015 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hawkular.metrics.api.jaxrs.callback;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE;

import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class SimpleDataCallback<T> extends NoDataCallback<T> {

    public SimpleDataCallback(AsyncResponse response) {
        super(response);
    }

    @Override
    public void onSuccess(Object responseData) {
        if (responseData == null) {
            response.resume(Response.status(Status.NO_CONTENT).type(APPLICATION_JSON_TYPE).build());
        } else {
            response.resume(Response.ok(responseData).type(APPLICATION_JSON_TYPE).build());
        }
    }
}