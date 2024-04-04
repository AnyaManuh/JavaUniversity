/*Бинарное дерево, ключи, сет, посчитать сумму уникальных чисел прочтённых из файла */


package aisd_1;

import java.io.File;
import java.io.FileWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {

        try {

            ArrayList<Long> BTreeKeys = new ArrayList<Long>();
            Scanner scanner = new Scanner(new File("input.txt"));

            while (scanner.hasNext())
            {
                BTreeKeys.add(scanner.nextLong());
            }

            Set<Long> Unique = new HashSet<>(BTreeKeys);
            BTreeKeys.clear();
            BTreeKeys.addAll(Unique);

            Long SumOfKeys = 0L;
            for (Long item: BTreeKeys)
            {
                SumOfKeys = SumOfKeys+item;
            }

            FileWriter output = new FileWriter("output.txt");
            output.write(SumOfKeys.toString());

            scanner.close();
            output.close();

        } catch (Exception e) {

        }
    }

}
