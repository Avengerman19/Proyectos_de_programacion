public class Main {
    public static void main(String[] args) {
        Perro bobi = new Perro("Perro", "Cunumi");
        Cocodrilo cocodrilo = new Cocodrilo("Coco", 200);
        Pollo pollo = new Pollo("Llopo", "Boloviana");
        cocodrilo.hacerSonido();
        bobi.hacerSonido();
        pollo.hacerSonido();
       if(bobi instanceof Perro){
           System.out.println("Bobi es un perro");
       }
    }
}