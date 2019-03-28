package util;

import java.awt.Image;
import java.awt.Toolkit;

/**
 * 游戏开发中常用的工具类（比如加载图片等方法）
 * @author linshixuan
 *
 */
public class GameUtil {
	private GameUtil() {} //工具类最好将构造器私有了
	public static Image getImage(String path) {
		return Toolkit.getDefaultToolkit().getImage(GameUtil.class.getClassLoader().getResource(path));
	}
}