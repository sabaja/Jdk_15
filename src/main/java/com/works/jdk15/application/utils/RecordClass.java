package com.works.jdk15.application.utils;

import java.util.Objects;

/**
 * record is a 14-Jdk private key for declaring Immutable class
 */
public record RecordClass(String name, String address) {

    public static final String UNKNOWN = "Unknown";

    public RecordClass(String name) {
        this(name, UNKNOWN);
    }

    public RecordClass {
        Objects.requireNonNull(name);
        Objects.requireNonNull(address);
    }
}
