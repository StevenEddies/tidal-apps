package uk.me.eddies.gradleplugins.tidalapp.badge;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.gradle.api.GradleException;
import org.gradle.api.Project;
import org.gradle.api.UncheckedIOException;

import com.fazecast.jSerialComm.SerialPort;

import uk.me.eddies.gradleplugins.tidalapp.dsl.TidalExtension;

public class SerialBadgeConnection {

	private final String port;

	@FunctionalInterface
	private interface SerialAction {
		void run(BufferedInputStream in, BufferedOutputStream out) throws IOException;
	}

	public SerialBadgeConnection(Project project) {
		port = project.getExtensions().findByType(TidalExtension.class).getBadgePort().get();
	}

	public void test() {
		withConnection((in, out) -> {
			var textOut = new OutputStreamWriter(out);
			var textIn = new BufferedReader(new InputStreamReader(in));

			textOut.append("print('test')\r\n");
			textOut.flush();

			textIn.readLine(); // Discard echo of input
			if (!"test".equals(textIn.readLine())) {
				throw new GradleException("Failed to connect to TiDAL badge on " + port
						+ "; serial connection established but funky response.");
			}
		});
	}

	private void withConnection(SerialAction action) {
		var connection = SerialPort.getCommPort(port);
		connection.setBaudRate(115200);
		connection.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING | SerialPort.TIMEOUT_WRITE_BLOCKING, 10000,
				10000);

		try {
			if (!connection.openPort())
				throw new UncheckedIOException("Failed to open serial port " + port);

			try (var inputStream = new BufferedInputStream(connection.getInputStream());
					var outputStream = new BufferedOutputStream(connection.getOutputStream());) {
				action.run(inputStream, outputStream);
			} catch (IOException ex) {
				throw new UncheckedIOException(ex);
			}

		} finally {
			if (!connection.closePort())
				throw new UncheckedIOException("Failed to close serial port " + port);
		}
	}
}
