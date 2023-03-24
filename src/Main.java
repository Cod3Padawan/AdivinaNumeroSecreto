import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Adivina el numero secreto del 1 al 100");

        int numeroSecreto = (int) (Math.random() * 101);
        boolean numOk = false;
        int contadorFallos = 1;
        ArrayList<Integer> intentosLista = new ArrayList<>(); // Inicializar el ArrayList vacío

        while (numOk == false) {

            int num;
            while (true) {
                try {
                    num = sc.nextInt();
                    break;//Si se ingresa un int sale del bucle
                } catch (InputMismatchException e) {
                    sc.nextLine();
                    System.out.println("Esto no es un número, introduce un número del 1 al 100");
                }
            }

            intentosLista.add(num); // Agregar cada intento al ArrayList

            if (numeroSecreto == num) {
                System.out.println("FELICIDADES HAS ACERTADO EL NUMERO SECRETO EN " + contadorFallos + " INTENTOS !!!");
                numOk = true;
            } else if (num > numeroSecreto) {
                System.out.println("El numero secreto es menor que " + num);
                System.out.println("Introcuce un numero menor que " + num);
                contadorFallos++;
            } else if (num < numeroSecreto) {
                System.out.println("El número secreto es mayor que " + num);
                System.out.println("Introcuce un numero mayor que " + num);
                contadorFallos++;
            }
        }
        System.out.println("Lista de intentos: ");
        for (int i = 0; i < intentosLista.size(); i++) {
            System.out.println((i + 1) + ". Has introducido el número " + intentosLista.get(i) + " y la desviacion con el número secreto es " + (intentosLista.get(i)-numeroSecreto));
        }
    }
}