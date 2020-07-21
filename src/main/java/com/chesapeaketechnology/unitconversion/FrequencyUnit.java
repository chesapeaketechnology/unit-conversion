package com.chesapeaketechnology.unitconversion;

/**
 * Supports frequency unit conversions.  Provides utility methods to convert from one frequency unit type to another.
 *
 * @since 0.0.1
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
                    return hz / ONE_THOUSAND;
                }

                public double toMhz(double hz)
                {
                    return hz / ONE_MILLION;
                }

                public double toGhz(double hz)
                {
                    return hz / ONE_BILLION;
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
                    return khz * ONE_THOUSAND;
                }

                public double toKhz(double khz)
                {
                    return khz;
                }

                public double toMhz(double khz)
                {
                    return khz / ONE_THOUSAND;
                }

                public double toGhz(double khz)
                {
                    return khz / ONE_MILLION;
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
                    return mhz * ONE_MILLION;
                }

                public double toKhz(double mhz)
                {
                    return mhz * ONE_THOUSAND;
                }

                public double toMhz(double mhz)
                {
                    return mhz;
                }

                public double toGhz(double mhz)
                {
                    return mhz / ONE_THOUSAND;
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
                    return ghz * ONE_BILLION;
                }

                public double toKhz(double ghz)
                {
                    return ghz * ONE_MILLION;
                }

                public double toMhz(double ghz)
                {
                    return ghz * ONE_THOUSAND;
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

    // Constants for conversions
    private static final int ONE_THOUSAND = 1_000;
    private static final int ONE_MILLION = 1_000_000;
    private static final int ONE_BILLION = 1_000_000_000;

    /**
     * Convert a frequency to a rounded Hz value.
     *
     * @param frequency the frequency to convert
     * @return The frequency in rounded Hz
     */
    public abstract long toHzRounded(double frequency);

    /**
     * Convert a frequency to Hz.
     *
     * @param frequency the frequency to convert.  The unit is defined by the FrequencyUnit enum that the method is called from.
     * @return The frequency in Hz
     */
    public abstract double toHz(double frequency);

    /**
     * Convert a frequency to kHz.
     *
     * @param frequency the frequency to convert.  The unit is defined by the FrequencyUnit enum that the method is called from.
     * @return The frequency in kHz
     */
    public abstract double toKhz(double frequency);

    /**
     * Convert a frequency to MHz.
     *
     * @param frequency the frequency to convert.  The unit is defined by the FrequencyUnit enum that the method is called from.
     * @return The frequency in MHz
     */
    public abstract double toMhz(double frequency);

    /**
     * Convert a frequency to GHz.
     *
     * @param frequency the frequency to convert.  The unit is defined by the FrequencyUnit enum that the method is called from.
     * @return The frequency in GHz
     */
    public abstract double toGhz(double frequency);

    /**
     * Convert a frequency given a source frequency and units.
     *
     * @param frequency     the frequency to convert
     * @param frequencyUnit the unit of the frequency
     * @return The frequency in the units defined by the FrequencyUnit enum that the method is called from
     */
    public abstract double convert(double frequency, FrequencyUnit frequencyUnit);
}