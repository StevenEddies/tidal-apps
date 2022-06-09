package uk.me.eddies.gradleplugins.tidalapp;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

public abstract class SerialConnectionTestTask extends DefaultTask {

	@TaskAction
	public void run() {
		System.out.println("Hello world.");
	}
}
