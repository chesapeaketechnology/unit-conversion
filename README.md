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
// Returns 1.2345678
double frequencyMhz = FrequencyUnit.HZ.toMhz(1234567.8);
```

Note that when converting to hz, there is a method variant called toHzRounded that returns a rounded long value.
This is to support the common usage of hz as a long value in our applications.
```java
// Returns 1234568
long frequencyHz = FrequencyUnit.MHZ.toHzRounded(1.2345678); 

// Returns 1234567
long frequencyHz = FrequencyUnit.MHZ.toHzRounded(1.2345674); 
```
Alternatively, there is an API that allows the source value's unit to be passed in as a parameter.
In this example, we are converting from kHz to MHz.
```java
// Returns 1.2345678
double frequencyMhz = FrequencyUnit.MHZ.convert(1234.5678, FrequencyUnit.KHZ);
```
##Build Instructions
Building unit-conversion requires JDK 8 or above.

After checking out the project, go into a command prompt in the root of the project and run
```
gradlew build
```
The unit-conversion build artifact can then be found under build/libs.