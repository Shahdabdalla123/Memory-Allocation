package AllocationPolicy;

import Memory.Partition;

import java.util.Collections;
import java.util.Vector;

public class BestFit extends IAllocator {
    @Override
    public void sort(Vector<Partition> partitions) {
        // Sort The Vector in Ascending Order for Best Fit
        Collections.sort(partitions);
    }
}
