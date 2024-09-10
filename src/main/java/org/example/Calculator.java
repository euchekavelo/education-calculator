package org.example;

import java.util.Scanner;

public class Calculator {

    private static double result = 0.0d;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Калькулятор начал свою работу ---");

        System.out.println("Введите первое число: ");
        result = castToDouble(scanner.nextLine());

        System.out.println("Укажите оператор в виде символа: ");
        String operator = scanner.nextLine();

        System.out.println("Укажите второе число: ");
        double operand = castToDouble(scanner.nextLine());

        System.out.println("Финальный результат: " + executeCalculation(operator, operand));

        System.out.println("--- Калькулятор завершил свою работу ---");
        scanner.close();
    }

    private static double executeCalculation(String operator, double operand) throws UnsupportedOperationException {
        return switch (operator) {
            case "+" -> executeAddition(operand);
            case "-" -> executeSubtraction(operand);
            case "*" -> executeMultiplication(operand);
            case "/" -> executeDivision(operand);
            default -> throw new UnsupportedOperationException("Указанная операция не поддерживается.");
        };
    }

    private static double executeDivision(double operand) {
        return result /= operand;
    }

    private static double executeMultiplication(double operand) {
        return result *= operand;
    }

    private static double executeSubtraction(double operand) {
        return result -= operand;
    }

    private static double executeAddition(double operand) {
        return result += operand;
    }

    private static double castToDouble(String input) throws Exception {
        try {
            return Double.parseDouble(input);
        } catch (Exception exception) {
            throw new Exception("Не удалось привести операнд к нужному типу данных для последующих вычислений.");
        }
    }
}