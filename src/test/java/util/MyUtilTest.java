package util;

import App.util.MyUtil;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyUtilTest {
    @Test
    public void testTrim() {
        String val = "\n\n\t      sku\n101   ";
        String esperado = "sku101";
        String obtenido = MyUtil.trim( val );
        assertEquals( esperado, obtenido );
    }
}