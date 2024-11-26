package pe.edu.i202221471.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "countrylanguage")
public class CountryLanguage {

    @EmbeddedId
    private LanguagePk id; // Clave compuesta

    @Column(name = "IsOfficial")
    private Boolean isOfficial;

    @Column(name = "Percentage")
    private Double percentage;

    @ManyToOne
    @JoinColumn(name = "CountryCode", insertable = false, updatable = false)
    private Country country;

    // Constructor sin argumentos
    public CountryLanguage() {
    }

    // Constructor con argumentos
    public CountryLanguage(LanguagePk id, Boolean isOfficial, Double percentage, Country country) {
        this.id = id;
        this.isOfficial = isOfficial;
        this.percentage = percentage;
        this.country = country;
    }

    @Override
    public String toString() {
        return "CountryLanguage{" +
                "id=" + id +
                ", isOfficial=" + isOfficial +
                ", percentage=" + percentage +
                ", country=" + country +
                '}';
    }

    // Getters y Setters
    public LanguagePk getId() {
        return id;
    }

    public void setId(LanguagePk id) {
        this.id = id;
    }

    public Boolean getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(Boolean isOfficial) {
        this.isOfficial = isOfficial;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }


}