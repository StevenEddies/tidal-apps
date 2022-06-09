package uk.me.eddies.gradleplugins.tidalapp;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

import uk.me.eddies.gradleplugins.tidalapp.dsl.TidalExtension;

public class TidalAppPlugin implements Plugin<Project> {

	@Override
	public void apply(Project project) {
		project.getExtensions().create("tidal", TidalExtension.class);
		var testConnectionTask = project.getTasks().register("testBadgeConnection", SerialConnectionTestTask.class, task -> {
			task.setGroup("Deployment");
			task.setDescription("Checks that a connection can be established to the TiDAL badge, for test deployment.");
		});
	}
}
