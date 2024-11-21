package com.example.labax.nonactivityclasses;

import java.io.Serializable;

public enum Priority implements Serializable {
    High,
    Medium,
    Low;
    public static Priority valueOf(int ordinal){
        for (Priority item: values()){
            if(item.ordinal() == ordinal){
                return item;
            }
        }
        throw new IllegalArgumentException();
    }
}
