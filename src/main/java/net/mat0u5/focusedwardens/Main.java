package net.mat0u5.focusedwardens;

import net.mat0u5.focusedwardens.config.ConfigManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

	public static final String MOD_ID = "focusedwardens";
	public static final String MOD_VERSION = "1.1.0";
	public static final String MOD_FRIENDLY_NAME = "Focused Wardens";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	public static ConfigManager config;

	public static void onInitialize() {
		config = new ConfigManager("./config/"+MOD_ID+".properties");
		LOGGER.info("Initializing {}", MOD_ID);
		LOGGER.info("{}: { version: {}; friendly_name: {} }", MOD_ID, MOD_VERSION, MOD_FRIENDLY_NAME);
	}
}
