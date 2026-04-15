package CarForMe_demo.Cars;

public enum CarBrand {
    // Populares e Consolidadas
    FIAT("Fiat"),
    VOLKSWAGEN("Volkswagen"),
    CHEVROLET("Chevrolet"),
    TOYOTA("Toyota"),
    HYUNDAI("Hyundai"),
    HONDA("Honda"),
    NISSAN("Nissan"),
    RENAULT("Renault"),
    FORD("Ford"),
    JEEP("Jeep"),
    MITSUBISHI("Mitsubishi"),
    CAOA_CHERY("Caoa Chery"),

    // Elétricos/Híbridos em ascensão
    BYD("BYD"),
    GWM("GWM"),

    // Luxo / Premium
    BMW("BMW"),
    MERCEDES_BENZ("Mercedes-Benz"),
    AUDI("Audi"),
    PORSCHE("Porsche"),
    LAND_ROVER("Land Rover"),
    VOLVO("Volvo"),
    LEXUS("Lexus"),
    FERRARI("Ferrari"),
    LAMBORGHINI("Lamborghini");

    private final String nomeExibicao;

    CarBrand(String nomeExibicao) {
        this.nomeExibicao = nomeExibicao;
    }

    public String getNomeExibicao() {
        return nomeExibicao;
    }
}
