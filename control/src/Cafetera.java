class Cafetera {
    protected String marca;
    protected boolean encendida;
    protected int capacidadAgua;
     protected int capacidadLeche;
     protected int capacidadCafe;
     protected int aguaActual;
     protected int lecheActual;
     protected int cafeActual;

    public Cafetera(String marca, int capacidadAgua, int capacidadLeche, int capacidadCafe) {
        this.marca = marca;
        this.capacidadAgua = capacidadAgua;
        this.capacidadLeche = capacidadLeche;
        this.capacidadCafe = capacidadCafe;
        this.aguaActual = 0;
        this.lecheActual = 0;
        this.cafeActual = 0;
        this.encendida = false;
    }

    public void encender() {
         if (this.encendida) {
             System.out.println("La cafetera ya esta encendida");
         }
         else {
             this.encendida = true;
             System.out.println("La cafetera está encendida.");
             System.out.println("---------------------------");
         }
    }

    public void apagar() {
        if (!this.encendida) {
            System.out.println("La cafetera ya está apagada.");
        } else {
            this.encendida = false;
            System.out.println("La cafetera esta apagada");
        }
    }

    public void cargarAgua(int cantidad) {
        if (!encendida) {
            aguaActual = Math.min(aguaActual + cantidad, capacidadAgua);
            System.out.println("Se cargó agua: " + cantidad + " ml (Actual: " + aguaActual + "/" + capacidadAgua + ")");
            System.out.println("---------------------------");
        }
        else {
            System.out.println("No se puede cargar agua con la cafetera encendida.");
            System.out.println("--------------------------------------------------");
        }
        if (aguaActual+ cantidad> capacidadAgua) {
            System.out.println("La cafetera esta llena de agua");
        }
    }

    public void cargarLeche(int cantidad) {
        if (lecheActual+ cantidad> capacidadLeche) {
            System.out.println("La cafetera esta llena de leche");
        }
        else {
            aguaActual+=cantidad;
            System.out.println("Se cargó leche: " + cantidad + " ml (Actual: " + lecheActual + "/" + capacidadLeche + ")");
            System.out.println("---------------------------");
            return;
        }
        System.out.println("No se puede cargar leche con la cafetera encendida.");
        System.out.println("---------------------------------------------------");
    }
    public void cargarCafe(int cantidad) {
        if (!encendida) {
            cafeActual = Math.min(cafeActual + cantidad, capacidadCafe);
            System.out.println("Se cargó café: " + cantidad + " g (Actual: " + cafeActual + "/" + capacidadCafe + ")");
            System.out.println("---------------------------");
        } else {
            System.out.println("No se puede cargar café con la cafetera encendida.");
            System.out.println("--------------------------------------------------");
        }
         if (cafeActual + cantidad > capacidadCafe) {
            System.out.println("La cafetera esta llena de cafe");
        }
    }

    public void prepararCafe() {
        prepararBebida(200, 0, 15, "Café");
    }

    public void prepararCapuchino() {
        prepararBebida(150, 100, 20, "Capuchino");
    }

    public void prepararLatte() {
        prepararBebida(100, 150, 18, "Latte");
    }
    private void prepararBebida(int aguaNecesaria, int lecheNecesaria, int cafeNecesario, String nombreBebida) {
        if (!encendida) {
            System.out.println("La cafetera está apagada. No se puede preparar " + nombreBebida);
            System.out.println("-----------------------------------------------");
            return;
        }

        if (aguaActual >= aguaNecesaria && lecheActual >= lecheNecesaria && cafeActual >= cafeNecesario) {
            aguaActual -= aguaNecesaria;
            lecheActual -= lecheNecesaria;
            cafeActual -= cafeNecesario;
            System.out.println( nombreBebida + " preparado con éxito.");
            System.out.println("-------------------------------------");
        } else {
            System.out.println("No hay suficientes insumos para preparar " + nombreBebida);
            System.out.println("-----------------------------------------");
        }
    }
}