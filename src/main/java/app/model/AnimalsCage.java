package app.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AnimalsCage {

    private Animal firstAnimal;
    private Animal secondAnimal;
    public Timer time;

    @Autowired
    public AnimalsCage(@Qualifier("cat") Animal firstAnimal, @Qualifier("dog") Animal secondAnimal, Timer time) {
        this.firstAnimal = firstAnimal;
        this.secondAnimal = secondAnimal;
        this.time = time;
    }

    public void whatAnimalSay() {
        System.out.println("Say:");
        System.out.println(firstAnimal.toString()+ ", "+secondAnimal.toString());
        System.out.println("At:");
        System.out.println(time.getTime());
        System.out.println("________________________");
    }

    public Timer getTimer() {
        return time;

    }
}
