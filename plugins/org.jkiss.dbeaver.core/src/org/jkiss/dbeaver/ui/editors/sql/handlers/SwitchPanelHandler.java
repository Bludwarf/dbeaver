/*
 * DBeaver - Universal Database Manager
 * Copyright (C) 2010-2017 Serge Rider (serge@jkiss.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jkiss.dbeaver.ui.editors.sql.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.handlers.HandlerUtil;
import org.jkiss.dbeaver.Log;
import org.jkiss.dbeaver.core.CoreCommands;
import org.jkiss.dbeaver.ui.editors.sql.SQLEditor;
import org.jkiss.dbeaver.utils.RuntimeUtils;

public class SwitchPanelHandler extends AbstractHandler {

    private static final Log log = Log.getLog(SwitchPanelHandler.class);

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        SQLEditor editor = RuntimeUtils.getObjectAdapter(HandlerUtil.getActiveEditor(event), SQLEditor.class);
        if (editor == null) {
            return null;
        }

        String actionId = event.getCommand().getId();

        switch (actionId) {
            case CoreCommands.CMD_SQL_SWITCH_PANEL:
                editor.toggleActivePanel();
                break;
            case CoreCommands.CMD_SQL_SHOW_OUTPUT:
                editor.showOutputPanel();
                break;
            case CoreCommands.CMD_SQL_SHOW_LOG:
                editor.showExecutionLogPanel();
                break;
        }
        return null;
    }

}