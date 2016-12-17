package ru.aksndr;//Created by Arzamastsev on 09.11.2016.

import com.opentext.livelink.oml.OScriptObject;
import ru.aksndr.common.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class QueueManager {


    private TaskFactory taskFactory = null;
    private static final Logger logger = LoggerFactory.getLogger(QueueManager.class.getSimpleName());

    public QueueManager() {
        this.taskFactory = new TaskFactory();
        logger.info("Started QueueManager ");
    }

    public Map runTask(OScriptObject prgCtx, Map<String, Object> taskParams) {
        logger.info("Started runTask");
        try {
            Map result = Utils.validateTaskParams(taskParams);
            if (!(boolean)result.get("ok"))
                return result;

            Task t = taskFactory.createTask(prgCtx, taskParams);

            t.run();

            return Utils.error("Task started.");
        } catch (Exception e) {
            logger.error("Failed runTask: " + e.toString());
            return Utils.error("Failed runTask: "+ e.toString());
        }
    }

}
