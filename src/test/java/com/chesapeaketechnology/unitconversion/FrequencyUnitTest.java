package com.chesapeaketechnology.unitconversion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FrequencyUnitTest
{
    private static final double DELTA = 1e-16;
    private static final double TEST_FREQUENCY_HZ = 1_234_567.89;
    private static final double TEST_FREQUENCY_KHZ = TEST_FREQUENCY_HZ / 1_000;
    private static final double TEST_FREQUENCY_MHZ = TEST_FREQUENCY_KHZ / 1_000;
    private static final double TEST_FREQUENCY_GHZ = TEST_FREQUENCY_MHZ / 1_000;

    private static final long TEST_FREQUENCY_HZ_ROUNDED = Math.round(TEST_FREQUENCY_HZ);

    @Test
    public void testHz()
    {
        assertEquals(TEST_FREQUENCY_HZ_ROUNDED, FrequencyUnit.HZ.toHzRounded(TEST_FREQUENCY_HZ));
        assertEquals(TEST_FREQUENCY_HZ, FrequencyUnit.HZ.toHz(TEST_FREQUENCY_HZ), DELTA);
        assertEquals(TEST_FREQUENCY_KHZ, FrequencyUnit.HZ.toKhz(TEST_FREQUENCY_HZ), DELTA);
        assertEquals(TEST_FREQUENCY_MHZ, FrequencyUnit.HZ.toMhz(TEST_FREQUENCY_HZ), DELTA);
        assertEquals(TEST_FREQUENCY_GHZ, FrequencyUnit.HZ.toGhz(TEST_FREQUENCY_HZ), DELTA);
    }

    @Test
    public void testKhz()
    {
        assertEquals(TEST_FREQUENCY_HZ_ROUNDED, FrequencyUnit.KHZ.toHzRounded(TEST_FREQUENCY_KHZ));
        assertEquals(TEST_FREQUENCY_HZ, FrequencyUnit.KHZ.toHz(TEST_FREQUENCY_KHZ), DELTA);
        assertEquals(TEST_FREQUENCY_KHZ, FrequencyUnit.KHZ.toKhz(TEST_FREQUENCY_KHZ), DELTA);
        assertEquals(TEST_FREQUENCY_MHZ, FrequencyUnit.KHZ.toMhz(TEST_FREQUENCY_KHZ), DELTA);
        assertEquals(TEST_FREQUENCY_GHZ, FrequencyUnit.KHZ.toGhz(TEST_FREQUENCY_KHZ), DELTA);
    }

    @Test
    public void testMhz()
    {
        assertEquals(TEST_FREQUENCY_HZ_ROUNDED, FrequencyUnit.MHZ.toHzRounded(TEST_FREQUENCY_MHZ));
        assertEquals(TEST_FREQUENCY_HZ, FrequencyUnit.MHZ.toHz(TEST_FREQUENCY_MHZ), DELTA);
        assertEquals(TEST_FREQUENCY_KHZ, FrequencyUnit.MHZ.toKhz(TEST_FREQUENCY_MHZ), DELTA);
        assertEquals(TEST_FREQUENCY_MHZ, FrequencyUnit.MHZ.toMhz(TEST_FREQUENCY_MHZ), DELTA);
        assertEquals(TEST_FREQUENCY_GHZ, FrequencyUnit.MHZ.toGhz(TEST_FREQUENCY_MHZ), DELTA);
    }

    @Test
    public void testGhz()
    {
        assertEquals(TEST_FREQUENCY_HZ_ROUNDED, FrequencyUnit.GHZ.toHzRounded(TEST_FREQUENCY_GHZ));
        assertEquals(TEST_FREQUENCY_HZ, FrequencyUnit.GHZ.toHz(TEST_FREQUENCY_GHZ), DELTA);
        assertEquals(TEST_FREQUENCY_KHZ, FrequencyUnit.GHZ.toKhz(TEST_FREQUENCY_GHZ), DELTA);
        assertEquals(TEST_FREQUENCY_MHZ, FrequencyUnit.GHZ.toMhz(TEST_FREQUENCY_GHZ), DELTA);
        assertEquals(TEST_FREQUENCY_GHZ, FrequencyUnit.GHZ.toGhz(TEST_FREQUENCY_GHZ), DELTA);
    }

    @Test
    public void testRoundingDown()
    {
        // The other unit tests used a value that was rounded up.  Verify rounding down is working.
        final double freqHz = 1_234_567.4;
        final double freqKhz = freqHz / 1_000;
        final double freqMhz = freqKhz / 1_000;
        final double freqGhz = freqMhz / 1_000;
        final long freqHzRounded = Math.round(freqHz);

        assertEquals(freqHzRounded, FrequencyUnit.HZ.toHzRounded(freqHz));
        assertEquals(freqHzRounded, FrequencyUnit.KHZ.toHzRounded(freqKhz));
        assertEquals(freqHzRounded, FrequencyUnit.MHZ.toHzRounded(freqMhz));
        assertEquals(freqHzRounded, FrequencyUnit.GHZ.toHzRounded(freqGhz));
    }

    @Test
    public void testSourceUnitParameters()
    {
        assertEquals(TEST_FREQUENCY_HZ, FrequencyUnit.HZ.convert(TEST_FREQUENCY_HZ, FrequencyUnit.HZ), DELTA);
        assertEquals(TEST_FREQUENCY_HZ, FrequencyUnit.HZ.convert(TEST_FREQUENCY_KHZ, FrequencyUnit.KHZ), DELTA);
        assertEquals(TEST_FREQUENCY_HZ, FrequencyUnit.HZ.convert(TEST_FREQUENCY_MHZ, FrequencyUnit.MHZ), DELTA);
        assertEquals(TEST_FREQUENCY_HZ, FrequencyUnit.HZ.convert(TEST_FREQUENCY_GHZ, FrequencyUnit.GHZ), DELTA);

        assertEquals(TEST_FREQUENCY_KHZ, FrequencyUnit.KHZ.convert(TEST_FREQUENCY_HZ, FrequencyUnit.HZ), DELTA);
        assertEquals(TEST_FREQUENCY_KHZ, FrequencyUnit.KHZ.convert(TEST_FREQUENCY_KHZ, FrequencyUnit.KHZ), DELTA);
        assertEquals(TEST_FREQUENCY_KHZ, FrequencyUnit.KHZ.convert(TEST_FREQUENCY_MHZ, FrequencyUnit.MHZ), DELTA);
        assertEquals(TEST_FREQUENCY_KHZ, FrequencyUnit.KHZ.convert(TEST_FREQUENCY_GHZ, FrequencyUnit.GHZ), DELTA);

        assertEquals(TEST_FREQUENCY_MHZ, FrequencyUnit.MHZ.convert(TEST_FREQUENCY_HZ, FrequencyUnit.HZ), DELTA);
        assertEquals(TEST_FREQUENCY_MHZ, FrequencyUnit.MHZ.convert(TEST_FREQUENCY_KHZ, FrequencyUnit.KHZ), DELTA);
        assertEquals(TEST_FREQUENCY_MHZ, FrequencyUnit.MHZ.convert(TEST_FREQUENCY_MHZ, FrequencyUnit.MHZ), DELTA);
        assertEquals(TEST_FREQUENCY_MHZ, FrequencyUnit.MHZ.convert(TEST_FREQUENCY_GHZ, FrequencyUnit.GHZ), DELTA);

        assertEquals(TEST_FREQUENCY_GHZ, FrequencyUnit.GHZ.convert(TEST_FREQUENCY_HZ, FrequencyUnit.HZ), DELTA);
        assertEquals(TEST_FREQUENCY_GHZ, FrequencyUnit.GHZ.convert(TEST_FREQUENCY_KHZ, FrequencyUnit.KHZ), DELTA);
        assertEquals(TEST_FREQUENCY_GHZ, FrequencyUnit.GHZ.convert(TEST_FREQUENCY_MHZ, FrequencyUnit.MHZ), DELTA);
        assertEquals(TEST_FREQUENCY_GHZ, FrequencyUnit.GHZ.convert(TEST_FREQUENCY_GHZ, FrequencyUnit.GHZ), DELTA);
    }
}