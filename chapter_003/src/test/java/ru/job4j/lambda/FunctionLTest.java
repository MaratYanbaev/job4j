package ru.job4j.lambda;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import java.util.Arrays;
import java.util.List;

public class FunctionLTest {

    @Test
    public void buildLineFrom8To10() {
        FunctionL line = new FunctionL();
        List<Double> buffer;
        buffer = line.diapason(8, 10,
                x -> x - 4
        );
        assertThat(buffer, is(Arrays.asList(4d, 5d, 6d)));
    }

    @Test
    public void buildLineFromMinus8ToMinus10() {
        FunctionL line = new FunctionL();
        List<Double> buffer;
        buffer = line.diapason(-8, -10,
                x -> x - 4
        );
        assertThat(buffer, is(Arrays.asList(-14d, -13d, -12d)));
    }

    @Test
    public void whenRangeFrom40To45ThenBuildLn() {
        FunctionL line = new FunctionL();
        List<Double> buffer;
        buffer = line.diapason(40, 45,
                Math::log
        );
        assertThat(buffer, is(Arrays.asList(
                3.6888794541139363,
                3.713572066704308,
                3.7376696182833684,
                3.7612001156935624,
                3.784189633918261,
                3.8066624897703196)
                )
        );
    }
}