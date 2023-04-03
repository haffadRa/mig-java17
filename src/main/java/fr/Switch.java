package fr;

import fr.sealedclasses.Rectangle;
import fr.sealedclasses.Shape;

public class Switch {

    public static void main(String[] args) {
        System.out.println("**************** return value && using yield && multiple values *******************************");
        switchReturnValue(1);
        switchReturnValue(6);
        System.out.println("**************** //////////////////// *******************************");


        System.out.println("**************** instance of using if *******************************");
        System.out.println(formatter(2l));
        System.out.println(formatter(2));
        System.out.println(formatter(2.0));
        System.out.println(formatter("String"));
        System.out.println("**************** //////////////////// *******************************");


        // PREVIEW
        System.out.println("**************** using pattern matchin instance of *******************************");
        System.out.println(formatterPatternSwitch(2l));
        System.out.println(formatterPatternSwitch(2));
        System.out.println(formatterPatternSwitch(2.0));
        System.out.println(formatterPatternSwitch("String"));
        System.out.println("**************** //////////////////// *******************************");

        System.out.println("**************** null case switch *******************************");
        testFooBar("foo");
        testFooBar(null);
        System.out.println("**************** //////////////////// *******************************");

        System.out.println("**************** boolean expression case  *******************************");
        testRectangle(new Rectangle());
        System.out.println("**************** //////////////////// *******************************");

    }


    private static void switchReturnValue(int dayOfWeek) {
        String dayName = switch (dayOfWeek) {
            case 1, 2, 3, 4, 5 -> "weekday";
            case 6, 7 -> {
                String str = "week";
                yield str + "end";
            }
            default -> "unknown";
        };
        System.out.println("The day is a " + dayName);
    }

    static String formatterPatternSwitch(Object o) {
        return switch (o) {
            case Integer i -> String.format("int %d", i);
            case Long l -> String.format("long %d", l);
            case Double d -> String.format("double %f", d);
            case String s -> String.format("String %s", s);
            default -> o.toString();
        };
    }

    static String formatter(Object o) {
        String formatted = "unknown";
        if (o instanceof Integer i) {
            formatted = String.format("int %d", i);
        } else if (o instanceof Long l) {
            formatted = String.format("long %d", l);
        } else if (o instanceof Double d) {
            formatted = String.format("double %f", d);
        } else if (o instanceof String s) {
            formatted = String.format("String %s", s);
        }
        return formatted;
    }

    static void testFooBar(String s) {
        switch (s) {
            case null -> System.out.println("Oops");
            case "Foo", "Bar" -> System.out.println("Great");
            default -> System.out.println("Ok");
        }
    }

    static void testRectangle(Shape s) {
        switch (s) {
            case Rectangle t && (t.calculateArea() > 100) -> System.out.println("Large Rectangle");
            case Rectangle t -> System.out.println("Small Rectangle");
            default -> System.out.println("Non-Rectangle");
        }
    }
}
