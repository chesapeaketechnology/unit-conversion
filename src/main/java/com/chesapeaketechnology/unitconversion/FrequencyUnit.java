package com.chesapeaketechnology.unitconversion;

/**
 * Supports frequency unit conversions.  Provides utility methods to convert from one frequency unit type to another.
 */
public enum FrequencyUnit
{
    HZ
            {
                public long toHzRounded(double hz)
                {
                    return Math.round(hz);
                }

                public double toHz(double hz)
                {
                    return hz;
                }

                public double toKhz(double hz)
                {
                    return hz / 1_000;
                }

                public double toMhz(double hz)
                {
                    return hz / 1_000_000;
                }

                public double toGhz(double hz)
                {
                    return hz / 1_000_000_000;
                }

                public double convert(double frequency, FrequencyUnit frequencyUnit)
                {
                    return frequencyUnit.toHz(frequency);
                }
            },
    KHZ
            {
                public long toHzRounded(double khz)
                {
                    return Math.round(toHz(khz));
                }

                public double toHz(double khz)
                {
                    return khz * 1_000;
                }

                public double toKhz(double khz)
                {
                    return khz;
                }

                public double toMhz(double khz)
                {
                    return khz / 1_000;
                }

                public double toGhz(double khz)
                {
                    return khz / 1_000_000;
                }

                public double convert(double frequency, FrequencyUnit frequencyUnit)
                {
                    return frequencyUnit.toKhz(frequency);
                }
            },
    MHZ
            {
                public long toHzRounded(double mhz)
                {
                    return Math.round(toHz(mhz));
                }

                public double toHz(double mhz)
                {
                    return mhz * 1_000_000;
                }

                public double toKhz(double mhz)
                {
                    return mhz * 1_000;
                }

                public double toMhz(double mhz)
                {
                    return mhz;
                }

                public double toGhz(double mhz)
                {
                    return mhz / 1_000;
                }

                public double convert(double frequency, FrequencyUnit frequencyUnit)
                {
                    return frequencyUnit.toMhz(frequency);
                }
            },
    GHZ
            {
                public long toHzRounded(double ghz)
                {
                    return Math.round(toHz(ghz));
                }

                public double toHz(double ghz)
                {
                    return ghz * 1_000_000_000;
                }

                public double toKhz(double ghz)
                {
                    return ghz * 1_000_000;
                }

                public double toMhz(double ghz)
                {
                    return ghz * 1_000;
                }

                public double toGhz(double ghz)
                {
                    return ghz;
                }

                public double convert(double frequency, FrequencyUnit frequencyUnit)
                {
                    return frequencyUnit.toGhz(frequency);
                }
            };

    /**
     * Convert a frequency to a rounded Hz value
     *
     * @param frequency the frequency to convert
     * @return The frequency in rounded Hz
     */
    public long toHzRounded(double frequency)
    {
        throw new AbstractMethodError();
    }

    /**
     * Convert a frequency to Hz
     *
     * @param frequency the frequency to convert
     * @return The frequency in Hz
     */
    public double toHz(double frequency)
    {
        throw new AbstractMethodError();
    }

    /**
     * Convert a frequency to kHz
     *
     * @param frequency the frequency to convert
     * @return The frequency in kHz
     */
    public double toKhz(double frequency)
    {
        throw new AbstractMethodError();
    }

    /**
     * Convert a frequency to MHz
     *
     * @param frequency the frequency to convert
     * @return The frequency in MHz
     */
    public double toMhz(double frequency)
    {
        throw new AbstractMethodError();
    }

    /**
     * Convert a frequency to GHz
     *
     * @param frequency the frequency to convert
     * @return The frequency in GHz
     */
    public double toGhz(double frequency)
    {
        throw new AbstractMethodError();
    }

    /**
     * Convert a frequency given a source frequency and units
     *
     * @param frequency     the frequency to convert
     * @param frequencyUnit the unit of the frequency
     * @return The frequency in the units associated with the enum that convert is invoked on
     */
    public double convert(double frequency, FrequencyUnit frequencyUnit)
    {
        throw new AbstractMethodError();
    }
}