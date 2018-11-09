import javax.swing.*;

/**
 * @author Miguel Monteiro Claveri
 * @email miguelmonteiroclaveri@gmail.com
 * @project Pactica prueba
 * Creation date: 5/11/18
 */
public class prueba {
    public static void main(String[] args) {
        String[] options = {"Number to words","Words to numbers", "Exit"};


        while(true){
            int x = JOptionPane.showOptionDialog(null, "What do you wanna do now?",
                    "Choose an option",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (x){
                case 0: JOptionPane.showMessageDialog(null, Numbers.say(Long.parseLong(JOptionPane.showInputDialog("Introduce a number\nExemple: 2003"))));
                        break;
                case 1: JOptionPane.showMessageDialog(null, Numbers.words(JOptionPane.showInputDialog("Introduce a sentence of numbers" +
                        "\nExemple: Two thousand and three\n" +
                        "Exemple: Two thousand three")));
                        break;
                case 2:System.exit(0);
            }
        }
    }
}