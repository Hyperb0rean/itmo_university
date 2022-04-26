package com.greg.server.util.io;

public interface Writable {
    boolean write(String output);
    boolean error(String errMessage);
}
