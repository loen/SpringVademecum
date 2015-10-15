import com.andrzejpe.spring.concert.Performance;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by jedrek on 2015-10-15.
 */
public class AopXmlMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Performance performance = context.getBean(Performance.class);
        performance.perform();

        System.out.println("---------------------------");
        System.out.println("Intermission");
        System.out.println("---------------------------");
        performance.singSong("Something from Nothing");
    }
}
