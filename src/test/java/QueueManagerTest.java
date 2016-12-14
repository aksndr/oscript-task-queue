import ru.aksndr.QueueManager;

import java.util.HashMap;
import java.util.Map;

public class QueueManagerTest {
    @org.junit.Test
    public void test3() throws Exception {

        QueueManager qm = new QueueManager(null);

        Map params = new HashMap<String,Object>();
        params.put("script", "test");
        params.put("params", new HashMap<>());

        Map m = qm.runTask(params);

    }
}
