package uk.me.eddies.gradleplugins.tidalapp;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

import uk.me.eddies.gradleplugins.tidalapp.dsl.TidalExtension;

public abstract class SerialConnectionTestTask extends DefaultTask {

	@TaskAction
	public void run() {
		System.out.println(getProject().getExtensions().findByType(TidalExtension.class).getAppName().get());
	}
}
