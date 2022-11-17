import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import st2e3.SimpleLinkedList;
import static org.assertj.core.api.Assertions.*;

public class SimpleLinkedListTest {

    private SimpleLinkedList<String> testList;

    @Test
    public void addElement(){
        testList = new SimpleLinkedList<>();
        String testString = "Hello Test!";
        testList.add(testString);
        assertThat(testList.contains(testString)).isTrue();
    }

}
