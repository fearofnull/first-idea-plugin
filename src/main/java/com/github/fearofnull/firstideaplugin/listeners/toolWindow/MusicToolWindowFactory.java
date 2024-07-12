package com.github.fearofnull.firstideaplugin.listeners.toolWindow;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import com.intellij.ui.jcef.JBCefApp;
import com.intellij.ui.jcef.JBCefBrowser;
import com.intellij.ui.jcef.JBCefBrowserBase;
import org.jetbrains.annotations.NotNull;

/**
 * @author xiezj2
 * @date 2024-07-11 18:22
 */
public class MusicToolWindowFactory implements ToolWindowFactory {
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        if (!JBCefApp.isSupported()) {
            // JCEF is not supported on this platform
            return;
        }

        JBCefBrowserBase browser = new JBCefBrowser();
        String playlist = "86656538";
        browser.loadHTML("<html><body><iframe frameborder=\"no\" border=\"0\" marginwidth=\"0\" marginheight=\"0\" width=330 height=450 " +
                "src=\"http://music.163.com/outchain/player?type=0&id=" +
                playlist +
                "&auto=1&height=430\"></iframe></body></html>");


        Content content = ContentFactory.getInstance().createContent(browser.getComponent(), "", false);
        toolWindow.getContentManager().addContent(content);
    }
}
