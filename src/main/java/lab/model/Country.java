package lab.model;

public interface Country extends DbEntity {
    Country id(long id);
    String name();
    Country name(String name);
    String codeName();
}
