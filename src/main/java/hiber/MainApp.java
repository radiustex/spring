package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User one = new User("User1", "User11", "user1@mail.ru");
      User two = new User("User2", "User22", "user2@mail.ru");
      User three = new User("User3", "User33", "user3@mail.ru");
      User four = new User("User4", "User44", "user4@mail.ru");

      Car toyota = new Car("Car1", 123);
      Car honda = new Car("Car2", 456);
      Car bmw = new Car("Car3", 789);
      Car lada = new Car("Car4", 101);

      userService.add(one.setCar(toyota).setUser(one));
      userService.add(two.setCar(honda).setUser(two));
      userService.add(three.setCar(bmw).setUser(three));
      userService.add(four.setCar(lada).setUser(four));

      for (User user : userService.listUsers()){
         System.out.println(user+" "+ user.getCar());
      }

      System.out.println(userService.getUserByCar("Car3", 789));

      context.close();
   }
}
