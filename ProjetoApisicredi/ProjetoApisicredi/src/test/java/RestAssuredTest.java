import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import static io.restassured.RestAssured.get;
import static org.hamcrest.core.IsEqual.equalTo;


public class RestAssuredTest {

    String url = "http://5b847b30db24a100142dce1b.mockapi.io/api/v1/simulador";

    @Test
    public void getId(){

        get(url).then().body("id", equalTo(1));

    }

    @Test
    public void getMeses(){

        List<String> list1 = Arrays.asList("112", "124", "136", "148");
        get(url).then().body("meses", equalTo(list1));

    }

    @Test
    public void getValor(){

        List<String> valor = Arrays.asList("2.802","3.174","3.564","3.971");
        get(url).then().body("valor", equalTo(valor));

    }
}