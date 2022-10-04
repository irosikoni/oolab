package agh.ics.oop;
import static java.lang.System.out;

public class World {
    static void run(String[] args) {
        out.println("Zwierzak idzie do przodu");
        String newList = String.join(", ", args);
        out.println(newList);
    }
    public static void main(String[] args) {
        out.println("Start");
        run(args);
        out.println("Stop");
    }
}
