package pizzashop.Observers;

import java.util.List;

public interface Observer {
    void addObservables(List<Observable> observables);
    boolean chekObservables();
}
