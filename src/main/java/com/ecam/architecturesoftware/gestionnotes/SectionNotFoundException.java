package com.ecam.architecturesoftware.gestionnotes;

public class SectionNotFoundException extends RuntimeException{

    SectionNotFoundException(Long id) {
        super("Could not find section " + id);
    }
}
