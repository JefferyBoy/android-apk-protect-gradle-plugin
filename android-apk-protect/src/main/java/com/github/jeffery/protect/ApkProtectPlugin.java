package com.github.jeffery.protect;

import com.android.build.gradle.AppExtension;
import com.android.build.gradle.AppPlugin;
import com.android.builder.model.SigningConfig;

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;
import org.gradle.api.logging.Logger;
import org.gradle.api.logging.Logging;

import java.io.File;

/**
 * @author mxlei
 * @date 2022/9/21
 */
public class ApkProtectPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        final Logger log = Logging.getLogger(getClass());
        if (!project.getPlugins().hasPlugin(AppPlugin.class)) {
            log.error("The plugin can only used to a android application module");
            return;
        }
        ApkProtectExtension apkProtectExtension = project.getExtensions().create("apkprotect", ApkProtectExtension.class);
        project.afterEvaluate(new Action<Project>() {
            @Override
            public void execute(Project project) {
                AppExtension appExtension = project.getExtensions().getByType(AppExtension.class);
                appExtension.getApplicationVariants().all(variant -> {
                    if (variant.getBuildType().isDebuggable()) {
                        return;
                    }
                    SigningConfig signingConfig = variant.getSigningConfig();
                    if (signingConfig == null) {
                        log.error("apk protect: signingConfig not found");
                        return;
                    }
                    variant.getOutputs().all(baseVariantOutput -> {
                        File outputFile = baseVariantOutput.getOutputFile();
                        Task assembleTask = variant.getAssemble();
                        project.getTasks()
                            .create(
                                "protect-" + assembleTask.getName(),
                                ApkProtectTask.class,
                                outputFile.getAbsolutePath(),
                                apkProtectExtension,
                                signingConfig
                            )
                            .dependsOn(assembleTask)
                            .setGroup("apk-protect");
                    });
                });
            }
        });
    }
}
