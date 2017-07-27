public class Fraction {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0 || denominator == 0) {
            return "0";
        }

        StringBuilder s = new StringBuilder();

        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            s.append('-');
        }

        long n = Math.abs((long) numerator);
        long d = Math.abs((long) denominator);

        if (d == 1) {
            s.append(n);
            return s.toString();
        }

        s.append(n / d);

        int currentIndex = 0;
        long current = n % d * 10;

        StringBuilder sub = new StringBuilder();
        Map<Long, Integer> map = new HashMap<>();

        while (current > 0) {
            map.put(current, currentIndex);

            sub.append(current / d);
            current = current % d;
            current *= 10;

            currentIndex += 1;
            if (map.containsKey(current)) {
                int index = map.get(current);
                sub.insert(index, "(");
                sub.append(")");
                break;
            }
        }

        String fraction = sub.toString();
        if (fraction != null && fraction.length() > 0) {
            s.append(".");
            s.append(fraction);
        }
        return s.toString();

    }

}