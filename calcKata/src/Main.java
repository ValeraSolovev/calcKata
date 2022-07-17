import java.util.HashMap;
import java.util.Scanner;
import static java.lang.Integer.parseInt;


public class Main {

    public static void integerToRoman(int num) {

        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanLiterals = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder roman = new StringBuilder();

        for(int i=0;i<values.length;i++) {
            while(num >= values[i]) {
                num -= values[i];
                roman.append(romanLiterals[i]);
            }
        }

        System.out.println("Результат: " + roman);
    }

    public static void main(String[] args) {

        System.out.println("Введите операцию");
        int firstInt = 0, lastInt = 0, res = 0;
        HashMap<Integer, String> romeHashMap = new HashMap<>();
        romeHashMap.put(1, "I");
        romeHashMap.put(2, "II");
        romeHashMap.put(3, "III");
        romeHashMap.put(4, "IV");
        romeHashMap.put(5, "V");
        romeHashMap.put(6, "VI");
        romeHashMap.put(7, "VII");
        romeHashMap.put(8, "VIII");
        romeHashMap.put(9, "IX");
        romeHashMap.put(10, "X");


        Scanner in = new Scanner(System.in);
        String inputString = in.nextLine().replaceAll("\\s", "");
        String[] numbers = inputString.split("[-+/*]");


        if (inputString.charAt(0) == 'I' || inputString.charAt(0) == 'V' || inputString.charAt(0) == 'X') {

            for (HashMap.Entry<Integer, String> item : romeHashMap.entrySet()) {

                if (numbers[0].equals(item.getValue())) firstInt = item.getKey();
                if (numbers[1].equals(item.getValue())) lastInt = item.getKey();
            }
            String countChars = firstInt + Integer.toString(lastInt);

            if (countChars.length() == 2) {
                try {
                    if (firstInt > 0 && lastInt > 0) {

                        if (inputString.contains("+")) res = firstInt + lastInt;
                        else if (inputString.contains("-")) res = firstInt - lastInt;
                        else if (inputString.contains("/")) res = firstInt / lastInt;
                        else if (inputString.contains("*")) res = firstInt * lastInt;
                        else System.out.println("Доступен только один из операторов (+, -, /, *)");

                        if (res <= 0) System.out.print("Ошибка, ответ меньше или равен 0");

                        else {
                            integerToRoman(res);
                        }

                    } else System.out.println("Числа не должны быть отрицательными, равными нулю или больше 10");
                } catch (Exception ex) {
                    System.out.print("Формат математической операции не удовлетворяет условию - два целых операнда от 1 до 10 и один оператор (+, -, /, *), а также не смешивайте арабские и римские цифры");
                }
            }

            else if (countChars.length() == 3) {
                try {
                    if (firstInt > 0 && lastInt > 0) {
                        if (firstInt <= 10 && lastInt <= 10) {

                            if (inputString.contains("+")) res = firstInt + lastInt;
                            else if (inputString.contains("-")) res = firstInt - lastInt;
                            else if (inputString.contains("/")) res = firstInt / lastInt;
                            else if (inputString.contains("*")) res = firstInt * lastInt;

                            if (lastInt == 0) System.out.print("Ошибка, не совмещайте римские и арабские числа, а также пишите римские числа большими буквами");
                            else if (res <= 0) System.out.print("Ошибка, ответ меньше или равен 0");
                            else {
                                integerToRoman(res);
                            }

                        } else System.out.print("Числа не должны быть больше 10");
                    } else System.out.print("Числа не должны быть отрицательными, равными нулю или больше 10");

                } catch (Exception ex) {
                    System.out.print("Формат математической операции не удовлетворяет условию - два целых операнда от 1 до 10 и один оператор (+, -, /, *), а также не смешивайте арабские и римские цифры");
                }
            }


            else if (countChars.length() == 4) {
                try {

                    if (firstInt == 10 && lastInt == 10) {
                        if (inputString.contains("+")) res = firstInt + lastInt;
                        else if (inputString.contains("-")) res = firstInt - lastInt;
                        else if (inputString.contains("/")) res = firstInt / lastInt;
                        else if (inputString.contains("*")) res = firstInt * lastInt;

                        if (res <= 0) System.out.print("Ошибка, ответ меньше или равен 0");
                        else {
                            integerToRoman(res);
                        }
                    } else System.out.print("Числа не должны быть отрицательными, равными нулю или больше 10");

                } catch (Exception ex) {
                    System.out.print("Формат математической операции не удовлетворяет условию - два целых операнда от 1 до 10 и один оператор (+, -, /, *), а также не смешивайте арабские и римские цифры");
                }
            }
        }




        else if (inputString.length() == 3) {
            try {
                firstInt = parseInt(numbers[0]);
                lastInt = parseInt(numbers[1]);

                if (firstInt > 0 && lastInt > 0) {
                    if (inputString.contains("+")) res = firstInt + lastInt;
                    else if (inputString.contains("-")) res = firstInt - lastInt;
                    else if (inputString.contains("/")) res = firstInt / lastInt;
                    else if (inputString.contains("*")) res = firstInt * lastInt;
                    System.out.printf("Результат = %d", res);
                } else System.out.print("Числа не должны быть равны нулю");
            } catch (Exception ex) {
                System.out.print("Формат математической операции не удовлетворяет условию - два целых операнда от 1 до 10 и один оператор (+, -, /, *), а также не смешивайте арабские и римские цифры");
            }
        }

        else if (inputString.length() == 4) {
            try {
                firstInt = parseInt(numbers[0]);
                lastInt = parseInt(numbers[1]);

                if (firstInt > 0 && lastInt > 0) {
                    if (firstInt <= 10 && lastInt <= 10) {
                        if (inputString.contains("+")) res = firstInt + lastInt;
                        else if (inputString.contains("-")) res = firstInt - lastInt;
                        else if (inputString.contains("/")) res = firstInt / lastInt;
                        else if (inputString.contains("*")) res = firstInt * lastInt;
                        System.out.printf("Результат = %d", res);
                    } else System.out.print("Числа не должны быть больше 10");
                } else System.out.print("Числа не должны быть отрицательными или равны нулю");

            } catch (Exception ex) {
                System.out.print("Формат математической операции не удовлетворяет условию - два целых операнда от 1 до 10 и один оператор (+, -, /, *), а также не смешивайте арабские и римские цифры");
            }
        }


        else if (inputString.length() == 5) {
            try {
                firstInt = parseInt(numbers[0]);
                lastInt = parseInt(numbers[1]);


                if (firstInt == 10 && lastInt == 10) {
                    if (inputString.contains("+")) res = firstInt + lastInt;
                    else if (inputString.contains("-")) res = firstInt - lastInt;
                    else if (inputString.contains("/")) res = firstInt / lastInt;
                    else if (inputString.contains("*")) res = firstInt * lastInt;
                    System.out.printf("Результат = %d", res);
                } else System.out.print("Числа не должны быть отрицательными, равны нулю или быть больше 10");

            } catch (Exception ex) {
                System.out.print("Формат математической операции не удовлетворяет условию - два целых операнда от 1 до 10 и один оператор (+, -, /, *), а также не смешивайте арабские и римские цифры");
            }
        }

        else System.out.print("Формат математической операции не удовлетворяет условию - два целых операнда от 1 до 10 и один оператор (+, -, /, *), а также не смешивайте арабские и римские цифры");
    }
}