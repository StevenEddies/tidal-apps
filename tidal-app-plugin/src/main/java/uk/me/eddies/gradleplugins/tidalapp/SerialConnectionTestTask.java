package uk.me.eddies.gradleplugins.tidalapp;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

import uk.me.eddies.gradleplugins.tidalapp.badge.SerialBadgeConnection;

public abstract class SerialConnectionTestTask extends DefaultTask {

	@TaskAction
	public void run() {
		new SerialBadgeConnection(getProject()).test();
	}
}
