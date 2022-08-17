import java.util.HashSet;
import java.util.Set;

/**
 * Coding exercise 52: Sets
 * Modify the previous HeavenlyBody example so that the HeavenlyBody class also has a "bodyType" field. This field will store the type of HeavenlyBody (PLANET, DWARF_PLANET, MOON).
 *
 * For each of the three types that is supported, subclass the HeavenlyBody class so that your program can create objects of the appropriate type.
 *
 * There is a restriction that the only satellites that planets can have must be moons.
 *
 *
 * Implement the following:
 *
 * 1.  HeavenlyBody (abstract class)
 *
 *     -  It has three private final fields. A Key called key, a double called orbitalPeriod and a Set of type HeavenlyBody called satellites.
 *     -  A constructor that takes a String (name of the HeavenlyBody), a double (its orbital period) and a BodyType. key is initialised with a new Key object and satellites is initialised with a new HashSet.
 *
 *     -  Eight methods:
 *
 *            -   getOrbitalPeriod(), getter for orbitalPeriod.
 *            -   getKey(), getter for key.
 *            -   addSatellite(), it takes a HeavenlyBody as a parameter and returns true if it was added successfully, false otherwise.
 *            -   getSatellites(), return a new HashSet populated with satellites.
 *            -   equals(), override method declared as public final. Two HeavenlyBody objects are equal if their keys are equal.
 *            -   hashCode(), override method declared as public final. Return the hash code of key.
 *            -   makeKey(), declared as public static and returns a new Key object.
 *            -   toString(), override method. Return the string representation as: name: bodyType, orbitalPeriod.
 *
 *     -  A nested enum named BodyTypes declared as public.
 *
 *     -  And a nested class declared as public static final named Key.
 *
 * 2.  BodyTypes (nested enum)
 *
 *     -  It has three constants: PLANET, DWARF_PLANET and MOON.
 *
 * 3.  Key (nested class)
 *
 *     -  It has two fields. A String called name and a BodyTypes called bodyType.
 *
 *     -  A constructor declared as private that takes a String and a BodyTypes and initialises the fields with it.
 *
 *     -  And five methods:
 *
 *            -   getName(), getter for name.
 *            -   getBodyType(), getter for bodyType.
 *            -   equals(), override method. Two Key objects are equal if they have the same name and bodyType.
 *            -   hashCode(), override method. Return the hash code for name, plus the hash code for bodyType, plus an arbitrary number (random).
 *            -   toString(), override method. Return the string representation as: name: bodyType.
 *
 * 4.  Planet
 *
 *     -  A constructor that takes a String (name of the planet) and a double (its orbital period) and calls its parent class with its arguments.
 *
 *     -  And one method
 *           -  addSatellite(), override method. Add the satellite if its body type is a moon.
 *
 * 5.  DwarfPlanet
 *
 *     -  A constructor that takes a String (name of the dwarf planet) and a double (its orbital period) and calls its parent class with its arguments.
 *
 * 6.  Moon
 *
 *     -  A constructor that takes a String (name of the moon) and a double (its orbital period) and calls its parent class with its arguments.
 *
 *
 * TIP:  Be extremely careful with the spelling of the names of the fields, constructors and methods.
 * TIP:  Be extremely careful about spaces/spelling/format in the returned String by toString().
 *
 * NOTE:  All fields are private (unless stated otherwise).
 * NOTE:  All constructors are public (unless stated otherwise).
 * NOTE:  All methods are public (unless stated otherwise).
 * NOTE:  Do not add a main method to the solution code.
 * */
public abstract class HeavenlyBody {
    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public enum BodyTypes {
        PLANET,
        DWARF_PLANET,
        MOON
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {

        this.key = new Key(name, bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Key getKey() {
        return key;
    }

    public boolean addSatellite(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }


    @Override
    public final boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if(obj instanceof HeavenlyBody) {
            HeavenlyBody theObject = (HeavenlyBody) obj;
            return this.key.equals(theObject.getKey());
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.key.hashCode();
    }

    public static Key makeKey(String name, BodyTypes bodyType) {
        return new Key(name, bodyType);
    }

    @Override
    public String toString() {
        return this.key.name + ": " + this.key.bodyType + ", " + this.orbitalPeriod;
    }

    public static final class Key {
        private String name;
        private BodyTypes bodyType;

        private Key(String name, BodyTypes bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + 57 + this.bodyType.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Key key = (Key) obj;
            if(this.name.equals(key.getName())) {
                return(this.bodyType == key.getBodyType());
            }
            return false;
        }

        @Override
        public String toString() {
            return this.name + ": " + this.bodyType;
        }
    }


}