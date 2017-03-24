import java.util.*;

public class Calculate24 {

    final static Scanner scanner = new Scanner(System.in);

    private static List<Value> init() {
        final List<Value> nums = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            nums.add(new Value(scanner.nextFloat()));
        }
        return nums;
    }

    private static List<Value> values(final List<Value> list) {

        final List<Value> values = new ArrayList<>();

        if (list.size() == 1) {
            values.add(list.get(0));
        } else {
            for (int i = 0; i < list.size(); i++) {
                final List<Value> temp = new ArrayList<>(list);
                temp.remove(i);
                final List<Value> aList = values(temp);
                final Float bValue = list.get(i).getValue();
                final String bFormula = list.get(i).getFormula();
                for (final Value a : aList) {
                    final Float aValue = a.getValue();
                    final String aFormula = a.getFormula();
                    values.add(new Value(aValue + bValue, "(" + aFormula + "+" + bFormula + ")"));
                    values.add(new Value(aValue - bValue, "(" + aFormula + "-" + bFormula + ")"));
                    values.add(new Value(aValue * bValue, "(" + aFormula + "*" + bFormula + ")"));
                    values.add(new Value(aValue / bValue, "(" + aFormula + "/" + bFormula + ")"));
                    values.add(new Value(bValue + aValue, "(" + bFormula + "+" + aFormula + ")"));
                    values.add(new Value(bValue - aValue, "(" + bFormula + "-" + aFormula + ")"));
                    values.add(new Value(bValue * aValue, "(" + bFormula + "*" + aFormula + ")"));
                    values.add(new Value(bValue / aValue, "(" + bFormula + "/" + aFormula + ")"));
                }
            }
        }
        return values;
    }

    public static void main(final String[] args) {

        while (true) {
            final List<Value> nums = init();
            final List<Value> result = values(nums);

            final Set<Value> uniquResult = new HashSet<>();
            for (final Value value : result) {
                //            System.out.println(value.getFormula() + "  " + value.getValue());
                uniquResult.add(value);
            }

            //        System.out.println("Total Possibility: " + values(nums).size());

            //        System.out.println("\n=========== 24 ============");
            for (final Value value : uniquResult) {
                if (value.getValue().floatValue() > 23.9 && value.getValue().floatValue() < 24.1) {
                    System.out.println(value.getFormula() + "  " + value.getValue());
                }
            }
        }

    }
}

class Value {
    String formula;

    Float value;

    Value(final Float value) {
        this.value = value;
        this.formula = String.valueOf(value);
    }

    Value(final Float value, final String formula) {
        this.value = value;
        this.formula = formula;
    }

    Float getValue() {
        return value;
    }

    String getFormula() {
        return formula;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((formula == null) ? 0 : formula.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Value other = (Value) obj;
        if (formula == null) {
            if (other.formula != null)
                return false;
        } else if (!formula.equals(other.formula))
            return false;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
}
