/*
 * Copyright 2017 </>DevStudy.net.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.univer.producer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.inject.Vetoed;
import javax.inject.Inject;

import com.univer.resources.ResourceLoaderManager;

/**
 *
 *
 * @author devstudy
 * @see http://devstudy.net
 */
@Vetoed
abstract class AbstractPropertiesLoader {

    @Inject
    protected Logger logger;

    @Inject
    protected ResourceLoaderManager resourceLoaderManager;

    protected void loadProperties(Properties properties, String resourceName) {
        try {
            try (InputStream in = resourceLoaderManager
                    .getResourceInputStream(resourceName)) {
                properties.load(in);
            }
            logger.log(Level.INFO, "Successful loaded properties from {0}",
                    resourceName);
        } catch (IOException | RuntimeException ex) {
            logger.log(Level.WARNING,
                    "Can't load properties from: " + resourceName, ex);
        }
    }
}
