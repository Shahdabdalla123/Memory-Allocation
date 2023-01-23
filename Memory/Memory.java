package Memory;

import AllocationPolicy.BestFit;
import AllocationPolicy.IAllocator;

import java.util.Vector;

public class Memory {
    IAllocator allocationPolicy;
    public Vector<Partition> partitions;

    public Memory(Vector<Partition> partitions) {
        this.partitions = partitions;
        this.allocationPolicy = new BestFit(); // Default
    }

    public void setAllocationPolicy(IAllocator allocationPolicy) {
        this.allocationPolicy = allocationPolicy;
    }

    public Vector<Process> allocate(Vector<Process> jobProcesses) {
        return allocationPolicy.allocate(partitions, jobProcesses);
    }

    public void compact() {
        // Calculate the free space
        int total = 0;
        for (Partition p : partitions)
            if (p.getProcess() == null)
                total += p.size;

        if (total > 0) {
            // Remove all empty Partitions
            partitions.removeIf(p -> p.getProcess() == null);
            // Add the new Compacted Space
            partitions.add(new Partition("Compaction Partition", total));
        }
    }
}
