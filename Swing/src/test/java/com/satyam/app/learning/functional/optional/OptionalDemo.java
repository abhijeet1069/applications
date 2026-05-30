package com.satyam.app.learning.functional.optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OptionalDemo {

    private int lengthWithoutOptional(String str){
        if(str == null)
            return 0;
        return str.length();
    }

    private int lengthWithOptional(String str){
        Optional<String> checkNum = Optional.ofNullable(str);
        if(checkNum.isPresent())
            return str.length();
        else
            return 0;
    }

    @Test
    public void checkStringLength(){
        assertEquals(5,lengthWithOptional("Hello"));
        assertEquals(0,lengthWithOptional(null));
    }
}
