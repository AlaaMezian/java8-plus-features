import java.time.Duration;
import java.time.Instant;
import java.util.Optional;
import java.util.stream.Stream;

public class ProcessApiImprovmentTest {


    public static void main(String[] argss){

        ProcessHandle self = ProcessHandle.current();
        long PID = self.pid();
        System.out.println("the pid " + PID);
        ProcessHandle.Info procInfo = self.info();
        System.out.println("process info " + procInfo);

        Optional<String[]> args = procInfo.arguments();
        System.out.println("process arguments  " + args);

        Optional<String> cmd =  procInfo.commandLine();
        System.out.println("command line  " + cmd);

        Optional<Instant> startTime = procInfo.startInstant();
        System.out.println("when the process started  " + startTime);

        Optional<Duration> cpuUsage = procInfo.totalCpuDuration();
        System.out.println("cpu usage by the process  " + cpuUsage);

        //all child process for current process
        Stream<ProcessHandle> childProc = ProcessHandle.current().children();
        childProc.forEach(System.out::println);

        System.out.println("Class name: "+self.getClass());       // Class name
        System.out.println("All processes: "+ProcessHandle.allProcesses()); // All current processes
        System.out.println("Is process alive: "+self.isAlive());
        System.out.println("Process's parent "+self.parent());  // Parent of the process

    }
}
