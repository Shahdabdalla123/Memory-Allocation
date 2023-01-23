package AllocationPolicy;

import Memory.Partition;
import Memory.Process;

import java.util.Vector;

public abstract class IAllocator {
    abstract void sort(Vector<Partition> partitions);

    public Vector<Process> allocate(Vector<Partition> partitions, Vector<Process> jobProcesses) {
        /* This Function returns the unallocated Processes, because they didn't find a suitable partition */

        // 1. Sort the array based on the policy
        sort(partitions);

        // 2. Allocate Processes into The Partitions
        Vector<Process> unallocProcess = new Vector<>();
        for (Process process : jobProcesses) {
            boolean isAllocated = false;
            for (int j = 0; j < partitions.size(); j++) {
                Partition partition = partitions.get(j);
                if (partition.isEmpty() && partition.size >= process.size) {
                    int extraSpace = partition.size - process.size;
                    partition.setProcess(process);
                    if (extraSpace > 0)
                        partitions.insertElementAt(new Partition("External Partition", extraSpace), j + 1);
                    isAllocated = true;
                    break;
                }
            }
            if (!isAllocated)
                unallocProcess.add(process);
        }
        return unallocProcess;
    }

}
