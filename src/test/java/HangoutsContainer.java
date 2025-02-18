import com.application.catchup.CatchUpApplication;
import com.application.catchup.ContainerConfig;
import org.springframework.boot.SpringApplication;

/**
 * Just for testing
 *
 */
public class HangoutsContainer {

    //Hiar lassen die Applikation mit dem Testcontainer aus ContainerConfig.class laufen, damit wir nicht immer Docker starten müssen.
    public static void main(String[] args) {
        SpringApplication.from(CatchUpApplication::main).with(ContainerConfig.class).run(args);
    }
}
