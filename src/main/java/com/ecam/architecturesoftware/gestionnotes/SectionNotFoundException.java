package com.ecam.architecturesoftware.gestionnotes;

public class SectionNotFoundException extends RuntimeException{

    SectionNotFoundException(String id) {
        super("Could not find section " + id);
    }
}
