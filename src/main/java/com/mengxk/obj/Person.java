package com.mengxk.obj;

public interface Person {
    default String getName() {
        return this.getClass().getName() + "_" + this.hashCode();
    }
}
