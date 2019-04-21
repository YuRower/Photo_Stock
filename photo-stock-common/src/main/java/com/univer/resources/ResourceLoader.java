package com.univer.resources;

import java.io.IOException;
import java.io.InputStream;

import javax.enterprise.inject.Vetoed;

/**
 *
 *
 * @author devstudy
 * @see http://devstudy.net
 */
@Vetoed
public interface ResourceLoader {

    boolean isSupport(String resourceName);

    InputStream getInputStream(String resourceName) throws IOException;
}
