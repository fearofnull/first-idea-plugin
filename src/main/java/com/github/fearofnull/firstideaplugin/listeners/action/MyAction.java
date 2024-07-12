package com.github.fearofnull.firstideaplugin.listeners.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.psi.PsiFile;

/**
 * @author xiezj2
 * @date 2024-07-11 11:13
 */
public class MyAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        Project project = e.getData(PlatformDataKeys.PROJECT);
        PsiFile psiFile = e.getData(CommonDataKeys.PSI_FILE);
        String classPath = psiFile.getVirtualFile().getPath();

        Messages.showMessageDialog(project, classPath, "What's Up??", Messages.getInformationIcon());
    }
}
