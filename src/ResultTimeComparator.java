import java.util.Comparator;

public class ResultTimeComparator implements Comparator<Result> {

    @Override
    public int compare(Result first, Result second) {
        return Double.compare(first.getTime(), second.getTime());
    }
}