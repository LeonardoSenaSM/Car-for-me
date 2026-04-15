package CarForMe_demo.Cars;

public enum CarBody {
    HATCH("Hatchback"),
    SEDAN("Sedan"),
    SUV("Utilitário Esportivo"),
    PICKUPTRUCK ("Picape / Caminhonete"),
    COUPE("Cupê"),
    CONVERTIBLE("Convertible"),
    VAN("Minivan / Van"),
    SPORTCAR("Sport Car"),
    SUPER("Super Car");

    private final String nameBody;
        CarBody(String nameBody){
            this.nameBody = nameBody;
        }
        public String getNameBody(){
            return nameBody;
        }
}
