package NumberSystem;

import java.util.Scanner;

/**
 * DecimalToBinary
 */
public class DecimalToBinary {
    //Decimal to binary
    Scanner scanner = new Scanner(System.in);

    public int toDecimal(int binary) {
        int result = 0;
        int index = 0;
        while (binary != 0) {
            int lastDigit = binary % 10;
            if(lastDigit == 1) {
                result += (int) Math.pow(2, index);
            }
            index++;
            binary /= 10;
        }
        return result;
    }


    public String toBinary(int decimal) {
        String result = "";
        while (decimal != 0) {
            int lastBit = decimal & 1;
            result = lastBit + result;
            decimal = decimal >> 1;
        }
        return result;
    }

    public void toBinary() {
        System.out.println("Enter a decimal number: ");
        int number = scanner.nextInt();
        convertNumber(number);
    }

    private void convertNumber(int number) {
        String result = "";
        while (number > 0) {
            int remainder = number % 2;
            number /= 2;
            result = remainder + result;
        }

        System.out.println(result);

    }
    
}