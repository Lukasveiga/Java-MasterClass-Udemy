package com.masterclass.oldcontent.section09.challenges.savefilemedium;

import java.util.List;

public interface ISaveable {

    List<String> write();
    void read(List<String> saveable);
    
}
