package com.chesapeaketechnology.unitconversion;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FrequencyUnitTest
{
    private static final double DELTA = 1e16;

    @Test
    public void testHz()
    {
        // Should round up for rounded hz.
        final double frequencyInHz = 1_234_567.89;

        assertEquals(1_234_568, FrequencyUnit.HZ.toHzRounded(frequencyInHz));
        assertEquals(frequencyInHz, FrequencyUnit.HZ.toHz(frequencyInHz), DELTA);
        assertEquals(frequencyInHz, FrequencyUnit.HZ.toKhz(frequencyInHz), DELTA);
        assertEquals(frequencyInHz, FrequencyUnit.HZ.toMhz(frequencyInHz), DELTA);
        assertEquals(frequencyInHz, FrequencyUnit.HZ.toGhz(frequencyInHz), DELTA);
        assertEquals(frequencyInHz, FrequencyUnit.HZ.toHz(frequencyInHz), DELTA);
    }

    @Test
    public void testKhz()
    {
        // Should round down for rounded hz.
        final double frequencyInHz = 1_234_567.49;
        final double frequencyInKhz = frequencyInHz / 1_000;

        assertEquals(1_234_567, FrequencyUnit.KHZ.toHzRounded(frequencyInKhz));
        assertEquals(frequencyInHz, FrequencyUnit.KHZ.toHz(frequencyInKhz), DELTA);
        assertEquals(frequencyInHz, FrequencyUnit.KHZ.toKhz(frequencyInKhz), DELTA);
        assertEquals(frequencyInHz, FrequencyUnit.KHZ.toMhz(frequencyInKhz), DELTA);
        assertEquals(frequencyInHz, FrequencyUnit.KHZ.toGhz(frequencyInKhz), DELTA);
        assertEquals(frequencyInHz, FrequencyUnit.KHZ.toHz(frequencyInKhz), DELTA);
    }

    @Test
    public void testMhz()
    {
        // .5 should round up for rounded hz.
        final double frequencyInHz = 1_234_567.5;
        final double frequencyInMhz = frequencyInHz / 1_000_000;

        assertEquals(1_234_568, FrequencyUnit.MHZ.toHzRounded(frequencyInMhz));
        assertEquals(frequencyInHz, FrequencyUnit.MHZ.toHz(frequencyInMhz), DELTA);
        assertEquals(frequencyInHz, FrequencyUnit.MHZ.toKhz(frequencyInMhz), DELTA);
        assertEquals(frequencyInHz, FrequencyUnit.MHZ.toMhz(frequencyInMhz), DELTA);
        assertEquals(frequencyInHz, FrequencyUnit.MHZ.toGhz(frequencyInMhz), DELTA);
        assertEquals(frequencyInHz, FrequencyUnit.MHZ.toHz(frequencyInMhz), DELTA);
    }

    @Test
    public void testGhz()
    {
        final double frequencyInHz = 1_234_567.5;
        final double frequencyInGhz = frequencyInHz / 1_000_000_000;

        assertEquals(1_234_568, FrequencyUnit.GHZ.toHzRounded(frequencyInGhz));
        assertEquals(frequencyInHz, FrequencyUnit.GHZ.toHz(frequencyInGhz), DELTA);
        assertEquals(frequencyInHz, FrequencyUnit.GHZ.toKhz(frequencyInGhz), DELTA);
        assertEquals(frequencyInHz, FrequencyUnit.GHZ.toMhz(frequencyInGhz), DELTA);
        assertEquals(frequencyInHz, FrequencyUnit.GHZ.toGhz(frequencyInGhz), DELTA);
        assertEquals(frequencyInHz, FrequencyUnit.GHZ.toHz(frequencyInGhz), DELTA);
    }

    @Test
    public void testSourceUnitParameters()
    {
        final double frequencyHz = 53_279_168_382.1;
        final double frequencyKhz = FrequencyUnit.HZ.toKhz(frequencyHz);
        final double frequencyMhz = FrequencyUnit.HZ.toMhz(frequencyHz);
        final double frequencyGhz = FrequencyUnit.HZ.toGhz(frequencyHz);

        assertEquals(frequencyHz, FrequencyUnit.HZ.convert(frequencyHz, FrequencyUnit.HZ), DELTA);
        assertEquals(frequencyHz, FrequencyUnit.HZ.convert(frequencyKhz, FrequencyUnit.KHZ), DELTA);
        assertEquals(frequencyHz, FrequencyUnit.HZ.convert(frequencyMhz, FrequencyUnit.MHZ), DELTA);
        assertEquals(frequencyHz, FrequencyUnit.HZ.convert(frequencyGhz, FrequencyUnit.GHZ), DELTA);

        assertEquals(frequencyKhz, FrequencyUnit.KHZ.convert(frequencyHz, FrequencyUnit.HZ), DELTA);
        assertEquals(frequencyKhz, FrequencyUnit.KHZ.convert(frequencyKhz, FrequencyUnit.KHZ), DELTA);
        assertEquals(frequencyKhz, FrequencyUnit.KHZ.convert(frequencyMhz, FrequencyUnit.MHZ), DELTA);
        assertEquals(frequencyKhz, FrequencyUnit.KHZ.convert(frequencyGhz, FrequencyUnit.GHZ), DELTA);

        assertEquals(frequencyMhz, FrequencyUnit.MHZ.convert(frequencyHz, FrequencyUnit.HZ), DELTA);
        assertEquals(frequencyMhz, FrequencyUnit.MHZ.convert(frequencyKhz, FrequencyUnit.KHZ), DELTA);
        assertEquals(frequencyMhz, FrequencyUnit.MHZ.convert(frequencyMhz, FrequencyUnit.MHZ), DELTA);
        assertEquals(frequencyMhz, FrequencyUnit.MHZ.convert(frequencyGhz, FrequencyUnit.GHZ), DELTA);

        assertEquals(frequencyGhz, FrequencyUnit.GHZ.convert(frequencyHz, FrequencyUnit.HZ), DELTA);
        assertEquals(frequencyGhz, FrequencyUnit.GHZ.convert(frequencyKhz, FrequencyUnit.KHZ), DELTA);
        assertEquals(frequencyGhz, FrequencyUnit.GHZ.convert(frequencyMhz, FrequencyUnit.MHZ), DELTA);
        assertEquals(frequencyGhz, FrequencyUnit.GHZ.convert(frequencyGhz, FrequencyUnit.GHZ), DELTA);
    }
}