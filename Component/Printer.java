package Component;

import Memory.Partition;
import Memory.Process;

import java.util.Vector;

public class Printer {
    public static void printMemoryInfo(Vector<Partition> partitions, Vector<Process> unallocatedProcesses2) {
        System.out.println("----------------------------------");
        System.out.println("Partitions:");
        for (Partition p : partitions) {
            System.out.print("- " + p.name + "(" + p.size + " KB): => ");
            if (p.getProcess() != null)
                System.out.println(p.getProcess().name);
            else
                System.out.println("External Fregmentation");
        }
        if (unallocatedProcesses2.size() > 0) {
            System.out.print(">>> UnAllocated Processes => ");
            for (Process p : unallocatedProcesses2)
                System.out.print(p.name + ", ");
        } else System.out.print(">>> All Processes have been Allocated ✅");

        System.out.println("\n----------------------------------");
    }
}
