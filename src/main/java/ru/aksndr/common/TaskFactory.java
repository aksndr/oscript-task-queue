package ru.aksndr.common;//Created by Arzamastsev on 10.11.2016.

import com.opentext.livelink.oml.OScriptObject;

import java.util.Map;

public class TaskFactory {

    public Task createTask(OScriptObject prgCtx, Map<String, Object> taskParams) {

        String script = (String) taskParams.get("script");
        Map params = (taskParams.containsKey("params")) ? (Map) taskParams.get("params") : null;

        Task t = new Task(prgCtx, script, params);
        return t;
    }
}
