import java.io.*;
import java.util.Scanner;

public class Problema {
    public static void main(String[] args) {

        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new FileReader("mensaje.txt"));
            bw = new BufferedWriter(new FileWriter("mensaje_cifrado.txt"));

            String linea = null;
            String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

            /* Lectura y validación  de clave */

            String clave = leerClave();
            int cont = 0;

            while ((linea = br.readLine()) != null) {
                StringBuilder sb = new StringBuilder(linea.length());

                /* Aquí vendría la lógica del programa */
                int index = 0;

                /*
                for (char c1 : linea.toUpperCase().toCharArray()) {
                    for (char c2 : clave.toUpperCase().toCharArray()) {
                        if (Character.isLetter(c1)) {
                            index = alpha.indexOf(c2) + alpha.indexOf(c2);
                        }
                    }
                }

                 */



                for (int i = 0; i < linea.length(); i++) {
                    char c1 = linea.toUpperCase().charAt(i);

                    if (Character.isLetter(c1)) {
                        for (int j = cont, len = clave.length(); j < len; j++) {
                        char c2 = clave.charAt(cont);

                            index = (alpha.indexOf(c1) + alpha.indexOf(c2)) % 26;
                            System.out.print(alpha.charAt(index));
                            break;
                        }
                        if (cont == clave.length() - 1){
                            cont = 0;
                        }else {
                            cont++;
                        }
                    } else {
                        System.out.print(c1);
                    }
                }


                bw.write(sb.toString()); /* Escribe la cadena de caracteres en el fichero*/
                bw.newLine(); /* escribe nueva línea en el fichero */
                System.out.println();
            }
            System.out.println("El mensaje ha sido cifrado correctamente");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (bw != null)
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

    public static String leerClave() {
        Scanner input = new Scanner(System.in);
        String clave;

        do {
            System.out.print("Introduce clave: ");
            clave = input.nextLine();
        } while (clave.isBlank());

        return clave.toUpperCase();
    }
}
