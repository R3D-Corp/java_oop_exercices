package labo3;

public class TemperaturesSystemeSolaire {

    /**
     * Calcuate the theorical temperature of a planet from it's distance and it's albedo.
     * 
     * @param distance the distance between the SUN and the planet in AU (Astronomical unit).
     * @param albedo the albedo of the planet.
     * @return
     */
    public static double temperatureTheorique(double distance, double albedo) {
        double temperatureKelvin, math;
        math = (1 - albedo) / Math.pow(distance, 2);
        math = Math.pow(math, (0.25));
        temperatureKelvin = 280 * math;

        System.out.printf("Température en (K) : %f\n", temperatureKelvin);
        System.out.printf("Température en (C) : %f\n", enCelsius(temperatureKelvin));
        return temperatureKelvin;
    }

    /**
     * Convert in Celsius's degrees a temperautre in Kelvin's degrees.
     * 
     * @param enKelvin The temperature to convert in Celsius's degrees.
     * @return The specified temperature converted in Celsius's degrees.
     */
    public static double enCelsius(double enKelvin) {
        return enKelvin - 273.15;
    }

    public static void main(String[] args) {
        final double DIST_MERCURE = 0.38, ALBEDO_MERCURE = 0.068; 
        final double DIST_VENUS = 0.72, ALBEDO_VENUS = 0.770; 
        final double DIST_TERRE = 1.00, ALBEDO_TERRE = 0.294; 
        final double DIST_MARS = 1.52, ALBEDO_MARS = 0.250; 
        final double DIST_JUPITER = 5.21, ALBEDO_JUPITER = 0.343; 
        final double DIST_SATURNE = 9.54, ALBEDO_SATURNE = 0.342; 
        final double DIST_URANUS = 19.18, ALBEDO_URANUS = 0.300; 
        final double DIST_NEPTUNE = 30.11, ALBEDO_NEPTUNE = 0.290;

        temperatureTheorique(DIST_MERCURE, ALBEDO_MERCURE);
        temperatureTheorique(DIST_VENUS, ALBEDO_VENUS);
        temperatureTheorique(DIST_TERRE, ALBEDO_TERRE);
        temperatureTheorique(DIST_MARS, ALBEDO_MARS);
        temperatureTheorique(DIST_JUPITER, ALBEDO_JUPITER);
        temperatureTheorique(DIST_SATURNE, ALBEDO_SATURNE);
        temperatureTheorique(DIST_URANUS, ALBEDO_URANUS);
        temperatureTheorique(DIST_NEPTUNE, ALBEDO_NEPTUNE);

    }
}
