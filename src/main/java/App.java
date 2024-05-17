import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
/*
Прочитайте про виды бинов.

Создайте POJO-класс Cat.

В классе AppConfig, по аналогии, создайте бин с именем “cat”.

Настройте этот бин так, чтобы он создавался новым при каждом запросе.

В классе App, по аналогии, вызовите еще раз бин HelloWorld, затем 2 раза вызовите бин cat. Сравните 2 пары бинов по ссылке и выведите результат в консоль. Для пары HelloWorld должно вернуться true, для cat - false. Так вы можете увидеть результат того, как работает наш контейнер.

Раскомментируйте тестовый класс и проверьте своё решение.
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorld hw1 = (HelloWorld) applicationContext.getBean("helloworld");
        System.out.println(hw1.getMessage());
        HelloWorld hw2 = (HelloWorld) applicationContext.getBean("helloworld");
        System.out.println(hw2.getMessage());
        Cat cat1 = (Cat) applicationContext.getBean("cat");
        System.out.println(cat1.getMessage());
        Cat cat2 = (Cat) applicationContext.getBean("cat");
        System.out.println(cat2.getMessage());
        System.out.println("Для хеллоу ворлд - " + (hw1.equals(hw2)));
        System.out.println("Для котов(скоуп - прототип) - " + (cat1.equals(cat2)));
        System.out.println("ХВ1 = " + hw1);
        System.out.println("ХВ2 = " + hw2);
        System.out.println("кот1 = " + cat1);
        System.out.println("кот2 = " + cat2);
    }
}