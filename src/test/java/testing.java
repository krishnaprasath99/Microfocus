
import org.apache.http.examples.client.parser;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.junit.Assert.assertEquals;

public class testing
{
    String correct="",test="";
    @Test
    public void testfn()
    {
            File reader = new File("src/test/resources/realfile.json");
            parser p=new parser();
            correct=p.parsefnfile(reader);
            //test=p.outputfn();


        System.out.println("correct = "+ correct);
        assertEquals("https://vpp.itunes.apple.com/mdm/getVPPUsersSrv",correct);


    }

}
