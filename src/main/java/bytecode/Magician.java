package bytecode;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;

import java.io.File;
import java.io.IOException;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class Magician {

    public static void main(String[] args) {
        try {
            new ByteBuddy().redefine(Hat.class)
                    .method(named("pullOut"))
                    .intercept(FixedValue.value("Rabbit~!")).make().saveIn(new File("/Users/kakaobank1/Desktop/z/code/java-more/java-more/target/classes"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(new Hat().pullOut());
    }

}
