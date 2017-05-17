package com.merchant.domain;

import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GalaxyNumberShould {

    @Test
    public void returnStringOfGalaxyanNumber() {
        GalaxyNumber galaxyNumber = new GalaxyNumber("pish tegj glob glob", 42.0, Optional.empty());

        String string = galaxyNumber.toString();

        assertThat(string, is("pish tegj glob glob is 42"));
    }

    @Test
    public void returnStringOfGalaxyanNumberWithUnits() {
        GalaxyNumber galaxyNumber = new GalaxyNumber("glob prok Silver", 68.0, Optional.of("Credits"));

        String string = galaxyNumber.toString();

        assertThat(string, is("glob prok Silver is 68 Credits"));
    }
}
