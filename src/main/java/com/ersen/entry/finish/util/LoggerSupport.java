package com.ersen.entry.finish.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface LoggerSupport {

    default Logger getLogger() {
        return LoggerFactory.getLogger(getClass().getName());
    }
}
