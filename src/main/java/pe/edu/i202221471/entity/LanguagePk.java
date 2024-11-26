package pe.edu.i202221471.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class LanguagePk {
    private String countryCode;
    private  String language;

    public LanguagePk(String countryCode, String language) {
        this.countryCode = countryCode;
        this.language = language;
    }
}
