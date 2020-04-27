package ro.uaic.info.myapp.app;

import com.github.javafaker.Faker;
import ro.uaic.info.myapp.dao.ArtistController;

public class Artist {
    //private int id; //might be useful later
    private String name;
    private String country;

    public Artist(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public Artist() {
    }

    public void generate() {
        Faker faker = new Faker();
        do {
            this.name = faker.name().fullName();
            this.country = faker.country().name();
        } while (this.name.contains("'") || this.country.contains("'"));
    }

    public void insertIntoDatabase() {
        new ArtistController().create(this.name, this.country);
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
