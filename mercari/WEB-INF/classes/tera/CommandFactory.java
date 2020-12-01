package tera;
import java.util.ResourceBundle;


public abstract class CommandFactory {
	public static AbstractCommand getCommand(RequestContext rc) {
		System.out.println("CommandFactory");

		AbstractCommand command = null;

		try {
			// プロパティファイルを読み込む
			ResourceBundle rb = ResourceBundle.getBundle("property\\commands");


			// パスに対応した文字列を取得します
			String name = rb.getString(rc.getCommandPath());

			// 指定された名前のクラスに対応したClassクラスの
			// インスタンスを取得する（名前は完全限定名であること）
			Class c = Class.forName(name);

			// Classクラスのインスタンスを利用して
			// 対応するクラスのインスタンス化を行う
			command = (AbstractCommand) c.newInstance();

		} catch (ClassNotFoundException e) {
			// 実際には独自例外にラップしてスローする
			throw new RuntimeException(e.getMessage(), e);
		} catch (InstantiationException e) {
			// 実際には独自例外にラップしてスローする
			throw new RuntimeException(e.getMessage(), e);
		} catch (IllegalAccessException e) {
			// 実際には独自例外にラップしてスローする
			throw new RuntimeException(e.getMessage(), e);
		}

		return command;
	}
}
