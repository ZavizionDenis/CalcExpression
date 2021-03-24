package help;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum Operations {
    PLUS ("+", 2),
    MINUS ("-", 2),
    MULTIPLIER ("*", 3),
    DIVISION ("/", 3),
    OPEN_BRAKET ("(", 1),
    CLOSE_BRAKET (")", 1),
    EXTENT ("^",4);

    private static Map<String, Operations> operationsPerSymbols = new HashMap<>();
    private String operationSymbol;
    private int priority;

    static {
        for (Operations operation : Operations.values()) {
            operationsPerSymbols.put(operation.getOperationSymbol(), operation);
        }
    }

    Operations(String operationSymbol, int priority) {
        this.operationSymbol = operationSymbol;
        this.priority = priority;
    }

    public String getOperationSymbol() {
        return operationSymbol;
    }

    public int getPriority() {
        return priority;
    }

    public static String getBrakets() {
        StringBuilder stringBuilder = new StringBuilder();

        Arrays.stream(Operations.values())
                .filter(operation -> operation.equals(OPEN_BRAKET) || operation.equals(CLOSE_BRAKET))
                .forEach(operation -> stringBuilder.append("\\").append(operation.getOperationSymbol()));
        return stringBuilder.toString();
    }

    public static String getOperationSymbolsWithOutBrakets() {
        StringBuilder stringBuilder = new StringBuilder();

        Arrays.stream(Operations.values())
                .filter(operation -> !operation.equals(OPEN_BRAKET))
                .filter(operation -> !operation.equals(CLOSE_BRAKET))
                .forEach(operation -> stringBuilder.append("\\").append(operation.getOperationSymbol()));
        return stringBuilder.toString();
    }

    public static String getAllOperationSymbols() {
        StringBuilder stringBuilder = new StringBuilder();

        Arrays.stream(Operations.values())
                .forEach(operation -> stringBuilder.append("\\").append(operation.getOperationSymbol()));
        return stringBuilder.toString();
    }

    public static Operations getOperationPerSymbol (String operationSymbol) {
        return operationsPerSymbols.get(operationSymbol);
    }

}