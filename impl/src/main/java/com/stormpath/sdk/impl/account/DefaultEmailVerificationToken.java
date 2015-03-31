/*
 * Copyright 2013 Stormpath, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.stormpath.sdk.impl.account;

import com.stormpath.sdk.account.EmailVerificationToken;
import com.stormpath.sdk.impl.ds.InternalDataStore;
import com.stormpath.sdk.impl.resource.AbstractInstanceResource;
import com.stormpath.sdk.impl.resource.Property;

import java.util.Collections;
import java.util.Map;

/**
 * @since 0.2
 */
public class DefaultEmailVerificationToken extends AbstractInstanceResource implements EmailVerificationToken {

    private static final String TOKEN_DELIMITER = "/emailVerificationTokens/";

    public DefaultEmailVerificationToken(InternalDataStore dataStore) {
        super(dataStore);
    }

    public DefaultEmailVerificationToken(InternalDataStore dataStore, Map<String, Object> properties) {
        super(dataStore, properties);
    }

    @Override
    public Map<String, Property> getPropertyDescriptors() {
        return Collections.emptyMap();
    }

    /* @since 1.0.RC4 */
    @Override
    public String getValue() {
        String href = getHref();
        if (href != null) {
            String token = href.substring(href.indexOf(TOKEN_DELIMITER) + TOKEN_DELIMITER.length());
            return token;
        }
        return null;
    }
}
