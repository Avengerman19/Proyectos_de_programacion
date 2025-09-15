public class Main {
    public static void main(String[] args) {
        Cafetera cafetera = new Cafetera("Melita", 1000, 500, 200);

        System.out.println("//Estado inicial//:");
        cafetera.cargarAgua(500);
        cafetera.cargarCafe(100);
        cafetera.cargarLeche(200);

        cafetera.encender();
        cafetera.prepararCafe();
        cafetera.prepararCapuchino();
        cafetera.prepararLatte();

        cafetera.apagar();
    }
}

