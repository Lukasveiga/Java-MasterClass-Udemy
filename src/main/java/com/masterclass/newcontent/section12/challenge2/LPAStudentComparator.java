package com.masterclass.newcontent.section12.challenge2;

import java.util.Comparator;

public class LPAStudentComparator implements Comparator<LPAStudent> {

    @Override
    public int compare(LPAStudent o1, LPAStudent o2) {
        return Double.compare(o1.getScore(),o2.getScore());
    }
}
