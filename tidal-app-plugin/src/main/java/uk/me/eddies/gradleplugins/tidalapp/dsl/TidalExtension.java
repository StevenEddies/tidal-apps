package uk.me.eddies.gradleplugins.tidalapp.dsl;

import org.gradle.api.Project;
import org.gradle.api.provider.Property;

public abstract class TidalExtension {
	
	public TidalExtension(Project project) {
		getAppName().convention(project.getName());
	}

	public abstract Property<String> getAppName();
	
	public abstract Property<String> getBadgePort();
}
