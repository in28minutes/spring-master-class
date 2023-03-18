package com.in28minutes.spring.basics.springin5steps.cdi;

import javax.inject.Inject;
import javax.inject.Named;

import java.util.Arrays;

import org.springframework.stereotype.Component;

@Named
@Component
public class SomeCdiBusiness {

    @Inject
    SomeCdiDao someCdiDao;

    public SomeCdiDao getSomeCDIDAO() {
        return someCdiDao;
    }

    public void setSomeCDIDAO(SomeCdiDao someCdiDao) {
        this.someCdiDao = someCdiDao;
    }

    public int findGreatest() {
        int greatest = Integer.MIN_VALUE;
        int[] data = someCdiDao.getData();
        var result = Arrays.stream(data).max();

        if (result.isPresent()) {
            greatest = result.getAsInt();
        }

        return greatest;
    }

}
