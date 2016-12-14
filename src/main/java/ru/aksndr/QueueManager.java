package ru.aksndr;//Created by Arzamastsev on 09.11.2016.

import com.opentext.livelink.oml.OScriptObject;
import ru.aksndr.common.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class QueueManager {


    private TaskFactory taskFactory = null;
    private static final Logger logger = LoggerFactory.getLogger(QueueManager.class.getSimpleName());

    public QueueManager(OScriptObject prgCtx) {
        this.taskFactory = new TaskFactory(prgCtx);
        logger.info("Started QueueManager "+ prgCtx.toString());
    }

    public Map runTask(Map<String, Object> taskParams) {
        logger.info("Started runTask");
        try {
            Map result = Utils.validateTaskParams(taskParams);
            if (!(boolean)result.get("ok"))
                return result;

            Task t = taskFactory.createTask(taskParams);
            t.run();
            result = t.getResult();
            return result;
        } catch (Exception e) {
            logger.error("Failed runTask: " + e.toString());
            return Utils.error("Failed runTask: "+ e.toString());
        }
    }

}
