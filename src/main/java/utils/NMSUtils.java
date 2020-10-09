package utils;

import com.github.dec4234.decsloginsecurity2.DecsLoginSecurity2Main;
import com.nesaak.noreflection.NoReflection;

import java.lang.reflect.Constructor;

public class NMSUtils {

	public static Class<?> getNMSClass(String name) {
		try {
			return Class.forName("net.minecraft.server." + DecsLoginSecurity2Main.getInstance().getVersion() + "." + name);
		} catch (ClassNotFoundException exception) {
			exception.printStackTrace();
			return null;
		}
	}

	public static void setField(Object obj, String fieldName, Object value) {
		try {
			NoReflection.shared().get(obj.getClass().getDeclaredField(fieldName)).set(obj, value);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
	}
	
}
