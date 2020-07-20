#Unit Conversion
## A unit conversion library for Java
Follows Java's TimeUnit pattern of using enums for each unit
and conversion methods in the unit enum.  All conversions deal with primitive values - no class instances
need to be created in order to do a conversion.

Currently only frequency types are supported but this will be expanded.
##Usage

Use the enumeration that corresponds to the units of the parameter being converted.
Then use the appropriate toXXX method to convert to the desired units.

```java
double frequencyMhz = FrequencyUnit.HZ.toMhz(1_234_567.8);
```

Note that when converting to hz, there is a method variant called toHzRounded that returns a rounded long value.
This is to support the common usage of hz as a long value in our applications.
```java
long frequencyHz = FrequencyUnit.MHZ.toHzRounded(1_234.5678);
```
Alternatively, there is an API that allows the source value's unit to be passed in as a parameter.
```java
double frequencyGhz = FrequencyUnit.GHZ.convert(1_234.5678, FrequencyUnit.KHZ);
```