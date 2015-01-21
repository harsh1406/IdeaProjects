package classesandobjects;

/**
 * Created by harshkumar on 1/21/15.
 */
public enum ModifiedCountry {
    FRANCE("French","Paris"),
    ITALY("Italian","Rome"),
    GERMANY("Berlin","German"),
    UK("English","London");

    private String language;
    private String capital;

    public String getLanguage(){
        return language;
    }
        public String getCapital(){
            return capital;
        }
    ModifiedCountry(final String language, final String capital) {
        this.language = language;
        this.capital = capital;
    }
}
