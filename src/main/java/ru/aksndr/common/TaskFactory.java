package ru.aksndr.common;//Created by Arzamastsev on 10.11.2016.

import com.opentext.livelink.oml.OScriptObject;

import java.util.Map;

public class TaskFactory {

    private OScriptObject prgCtx = null;

    public TaskFactory(OScriptObject prgCtx) {
        this.prgCtx = prgCtx;
    }

    public Task createTask(Map<String, Object> taskParams) {

        String script = (String) taskParams.get("script");
        Map params = (taskParams.containsKey("params")) ? (Map) taskParams.get("params") : null;

        Task t = new Task(prgCtx, script, params);
        return t;
    }
}
