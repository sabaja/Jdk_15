package com.works.jdk15.application.utils;

/*
https://www.baeldung.com/java-sealed-classes-interfaces
* */
public sealed abstract class SealedClassAndClass permits NonSealedClassExtends, SealedClass {

    protected final String registrationNumber;

    public SealedClassAndClass(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}

/*obbligo final*/
final class SealedClass extends SealedClassAndClass {

    public SealedClass(String registrationNumber) {
        super(registrationNumber);
    }
}

non-sealed class NonSealedClassExtends extends SealedClassAndClass{

    public NonSealedClassExtends(String registrationNumber) {
        super(registrationNumber);
    }
}
