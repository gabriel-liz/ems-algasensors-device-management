package com.algaworks.algasensors.device.management.commom;

import io.hypersistence.tsid.TSID;

import java.util.Optional;

public class IdGenerator {

    private static final TSID.Factory tsidFactory;

    static {
        Optional.ofNullable(System.getenv("tsid.node"))
                        .ifPresent(tsidNode -> System.getProperty("tsid.node", tsidNode));

        Optional.ofNullable(System.getenv("tsid.node"))
                .ifPresent(tsidNodeCount -> System.getProperty("tsid.node.count", tsidNodeCount));


//        System.setProperty("tsid.node", "2");
//        System.setProperty("tsid.node.count", "32");
        tsidFactory = TSID.Factory.builder().build();
    }

    private IdGenerator() {

    }

    public static TSID generateTSID(){
        return tsidFactory.generate();
    }
}
