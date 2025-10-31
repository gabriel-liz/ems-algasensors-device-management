package com.algaworks.algasensors.device.management;

import com.algaworks.algasensors.device.management.commom.IdGenerator;
import io.hypersistence.tsid.TSID;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class TSIDTest {

    @Test
    void shouldGenerateTSID(){

        TSID tsid = IdGenerator.generateTSID();

//        System.out.println(tsid);
//        System.out.println(tsid.toLong());
//        System.out.println(tsid.getInstant());

        Assertions.assertThat(tsid.getInstant())
                .isCloseTo(Instant.now(), Assertions.within(1, ChronoUnit.MINUTES));
































        System.out.println(tsid);
        System.out.println(tsid.toLong());
        System.out.println(tsid.getInstant());
    }
}
