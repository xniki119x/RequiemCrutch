package f1cont.niki119.requiemcrutch.mixin;

import f1cont.niki119.requiemcrutch.RequiemCrutch;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Identifier.class)
public class IdentifierMixin {

	@Inject(method = "split", at = @At("RETURN"), cancellable = true)
	private static void split(String id, char delimiter, CallbackInfoReturnable<String[]> cir) {
		String[] ss = cir.getReturnValue();
		String namespace = ss[0];
		String path = ss[1];
		if(namespace.contains("/")){
			RequiemCrutch.LOGGER.info("Detect invalid identifier ["+ss[0]+":"+ss[1]+"] fixing...");
			String new_namespace = namespace.substring(namespace.lastIndexOf("/")+1);
			String new_path = namespace.substring(0, namespace.lastIndexOf("/")) + "/" + path;
			ss[0] = new_namespace;
			ss[1] = new_path;
			RequiemCrutch.LOGGER.info("Fixed, new identifier ["+ss[0]+":"+ss[1]+"].");
			cir.setReturnValue(ss);
		}
	}
}
