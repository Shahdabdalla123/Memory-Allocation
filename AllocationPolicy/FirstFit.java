package AllocationPolicy;

import Memory.Partition;
import java.util.Vector;

public class FirstFit extends IAllocator {
    @Override
    public void sort(Vector<Partition> partitions) {
        // Don't Sort the array for First Fit
    }
}
