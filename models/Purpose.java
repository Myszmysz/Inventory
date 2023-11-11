package models;

public enum Purpose {

    HELMET("helmet"), CHEST("chest"), LEGS("legs"), BOOTS("boots"), WEAPON("weapon");

    private final String value;

    Purpose(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
