import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Calculate24 {

    public static String calculate(final int a, final int b, final int c, final int d) {
        final List<Value> input = Arrays.asList(new Value(a), new Value(b), new Value(c), new Value(d));
        final Set<Value> allCalcs = new HashSet<>(getAllCalculations(input));
        final StringBuilder result = new StringBuilder();
        for (final Value calc : allCalcs) {
            if (calc.getValue() > 23.99 && calc.getValue() < 24.01) {
                result.append(calc.getFormula()).append("\n");
            }
        }
        return result.toString();
    }

    private static List<Value> getAllCalculations(final List<Value> list) {
        final List<Value> result = new ArrayList<>();
        final int size = list.size();
        if (size == 1) {
            return list;
        } else if (size == 2) {
            return getAllCalculations(list.subList(0, 1), list.subList(1, 2));
        } else {
            for (int i = 0; i < size / 2; i++) {
                final List<Value> temp = new ArrayList<Value>(list);
                for (int j = i; j < size; j++) {
                    Collections.swap(temp, i, j);
                    result.addAll(getAllCalculations(getAllCalculations(temp.subList(0, i + 1)), getAllCalculations(temp.subList(i + 1, size))));
                }
            }
        }
        return result;
    }

    private static List<Value> getAllCalculations(final List<Value> aList, final List<Value> bList) {
        final List<Value> values = new ArrayList<Value>();
        for (final Value a : aList) {
            final double aValue = a.getValue();
            final String aFormula = a.getFormula();
            for (final Value b : bList) {
                final double bValue = b.getValue();
                final String bFormula = b.getFormula();
                values.add(new Value(aValue + bValue, "(" + aFormula + "+" + bFormula + ")"));
                values.add(new Value(aValue - bValue, "(" + aFormula + "-" + bFormula + ")"));
                values.add(new Value(aValue * bValue, "(" + aFormula + "*" + bFormula + ")"));
                values.add(new Value(aValue / bValue, "(" + aFormula + "/" + bFormula + ")"));
                values.add(new Value(bValue - aValue, "(" + bFormula + "-" + aFormula + ")"));
                values.add(new Value(bValue / aValue, "(" + bFormula + "/" + aFormula + ")"));
            }
        }
        return values;
    }

    public static void main(final String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                final int a = scanner.nextInt();
                final int b = scanner.nextInt();
                final int c = scanner.nextInt();
                final int d = scanner.nextInt();
                System.out.println(calculate(a, b, c, d));
            }
        }
    }
}

class Value {

    String formula;
    double value;

    Value(final double value) {
        this.value = value;
        formula = String.valueOf(value);
    }

    Value(final double value, final String formula) {
        this.value = value;
        this.formula = formula;
    }

    double getValue() {
        return value;
    }

    String getFormula() {
        return formula;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (formula == null ? 0 : formula.hashCode());
        long temp;
        temp = Double.doubleToLongBits(value);
        result = prime * result + (int) (temp ^ temp >>> 32);
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Value other = (Value) obj;
        if (formula == null) {
            if (other.formula != null) {
                return false;
            }
        } else if (!formula.equals(other.formula)) {
            return false;
        }
        if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value)) {
            return false;
        }
        return true;
    }

}
