class SpaceAge {

    private final double seconds;
    
    SpaceAge(double seconds) {
        this.seconds = seconds;
    }

    double getSeconds() {
        return seconds;
    }

    double onEarth() {
        return getAge(1.0);
    }

    double onMercury() {
        return getAge(0.2408467);
    }

    double onVenus() {
        return getAge(0.61519726);
    }

    double onMars() {
        return getAge(1.8808158);
    }

    double onJupiter() {
        return getAge(11.862615);
    }

    double onSaturn() {
        return getAge(29.447498);
    }

    double onUranus() {
        return getAge(84.016846);
    }

    double onNeptune() {
        return getAge(164.79132);
    }

    private double getAge(double factor) {
        return seconds / (31557600 * factor);
    }
}