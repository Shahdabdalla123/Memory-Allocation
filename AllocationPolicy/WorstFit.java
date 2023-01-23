package AllocationPolicy;

import Memory.Partition;

import java.util.Collections;
import java.util.Vector;

public class WorstFit extends IAllocator {
    @Override
    public void sort(Vector<Partition> partitions) {
        // Sort Vector in Descending Order for Worst Fit
        Collections.sort(partitions);
        Collections.reverse(partitions);
    }
}
