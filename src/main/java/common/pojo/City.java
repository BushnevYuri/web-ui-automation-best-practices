package common.pojo;


public enum City {
    NewYork("New York"),
    Boston("Boston"),
    Paris("Paris"),
    Rome("Rome"),
    Berlin("Berlin"),
    Portland("Portland");

    private String fullName;

    City(String fullName){
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public static City fromString(String fullName) {
        for (City city : City.values()) {
            if (city.fullName.equalsIgnoreCase(fullName)) {
                return city;
            }
        }
        return null;
    }
}
