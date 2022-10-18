package com.exam.portal.exception;

public class PackageNotFoundException  extends Exception{
    public PackageNotFoundException(String string) {
        super("Package not found !! try with different");
    }
}
