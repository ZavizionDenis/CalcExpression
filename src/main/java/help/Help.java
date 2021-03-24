package help;

public enum Help {
    EXPRESSION_FORMAT ("Вводимое выражение может содержать цифры и " +
            Operations.getOperationSymbolsWithOutBrakets().replaceAll("\\\\", " ") +
            Operations.getBrakets().replaceAll("\\\\", " ") +  "\n" +
            "Пример: 3 + 4 * 2 / (1 - 5)\n");

    private String description;

    Help(String description) {
        this.description = description;
    }

    public String getDescription () {
        return description;
    }
}
