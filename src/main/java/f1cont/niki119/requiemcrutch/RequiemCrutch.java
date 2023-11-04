package f1cont.niki119.requiemcrutch;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequiemCrutch implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("RequiemCrutch");
	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("Oh shit... {}!", mod.metadata().name());
	}
}
