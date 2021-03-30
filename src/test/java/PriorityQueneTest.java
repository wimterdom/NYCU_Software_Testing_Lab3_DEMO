import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.PriorityQueue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class PriorityQueneTest {
    private static Stream<Arguments> param_input(){
        return Stream.of(
                arguments(new int[]{1,4,3,2}, new int[]{1,2,3,4}),
                arguments(new int[]{3,7,4,2}, new int[]{2,3,4,7}),
                arguments(new int[]{5,8,6,7}, new int[]{5,6,7,8})
        );
    }

    @ParameterizedTest(name="#{index} - Test with Argument={0},{1}")
    @MethodSource("param_input")
    public void Parameter_Quene_Test(int[] randomInput, int[] correct_array){
        PriorityQueue<Integer> test = new PriorityQueue<Integer>();
        Integer s;
        int result[] = new int[randomInput.length];
        for (int i = 0; i < randomInput.length; i++){
            test.offer(randomInput[i]);
        }
        for (int i=0;i< randomInput.length;i++){
            result[i] = test.poll();
        }

        assertArrayEquals(correct_array,result);
    }

    @Test
    public void IllegalException(){
        Exception exception = assertThrows(IllegalArgumentException.class, () ->{
            new PriorityQueue(0, null);
        });
    }

    @Test
    public void nullException(){
        Exception exception = assertThrows(NullPointerException.class, () ->{
            new PriorityQueue().add(null);
        });
    }

    @Test
    public void nullexception(){
        Exception exception = assertThrows(NullPointerException.class, () ->{
            new PriorityQueue().removeIf(null);
        });
    }
}
